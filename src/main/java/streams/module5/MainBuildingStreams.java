package streams.module5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {
    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);

        Stream<Integer> stream1 = ints.stream(); //
        stream1.forEach(System.out::println);
        Stream<Integer> stream2 =Stream.of(5,4,3,2,1);//

        stream2.forEach(System.out::println);

        System.out.println("Method generate intefaz");
        Stream<String> streamOfStrings = Stream.generate(() -> "one");

        streamOfStrings.limit(5).forEach(System.out::println); //generate five times the word one if you don't put the limit this generate infinite times

        System.out.println("Method interate intefaz");
        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+"); //looks similar to generate this don't take supplier this take 2 elements

        streamOfStrings2.limit(5).forEach(System.out::println);

        System.out.println("Method Thread local ramdom");
        IntStream streamOfInt = ThreadLocalRandom.current().ints();
        streamOfInt.limit(5).forEach(System.out::println);

    }
}
