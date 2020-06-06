package streams.dataProcesingCourse.modeule3;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {

       /* Stream.iterate("+",s -> s +"+")
                .limit(6)
                .forEach(System.out::println);

        System.out.println("execute in parallel ");
        Stream.iterate("+",s -> s +"+")
                .parallel()//run again
                .limit(6)
                .forEach(System.out::println); // here the execution is no in order

        System.out.println("execute with peek ");
        Stream.iterate("+",s -> s +"+")
                .parallel()//run again
                .limit(6)
                .peek(s -> System.out.println(s + " proccess used in the thread " + Thread.currentThread().getName())) //takes a consumer we are identify the current thread
                .forEach(System.out::println); // here what is the main thread and the other is in other thread

        System.out.println("limited the total thread  ");

        */
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        Stream.iterate("+",s -> s +"+")
                .parallel()//run again
                .limit(6)
                .peek(s -> System.out.println(s + " proccess used in the thread " + Thread.currentThread().getName())) //takes a consumer we are identify the current thread
                .forEach(System.out::println); // here this is limited to use only 2 thread


        List<String> strings = new ArrayList<>();

        Stream.iterate("+",s -> s +"+")
                //.parallel()// if run in parallel i get sometimes error or get less values that 1000, because arra
                .limit(1000)
                .forEach(s-> strings.add(s)); // add


        System.out.println("# size " + strings.size());

        System.out.println("for resolved the problem with the list");

        List<String> strings2 = new CopyOnWriteArrayList<>(); //this list is a concurrent list and this is thread and save

        Stream.iterate("+",s -> s +"+")
                .parallel()// if run in parallel i get sometimes error or get less values that 1000, because arra
                .limit(1000)
                .forEach(s-> strings2.add(s)); // add

        System.out.println("# size " + strings2.size());

        List<String> strings3 =
        Stream.iterate("+",s -> s +"+")
                .parallel()// if run in parallel i get sometimes error or get less values that 1000, because arra
                .limit(1000)
                .collect(Collectors.toList()); //this way is thread and save too

        System.out.println("# size " + strings3.size());
    }
}
