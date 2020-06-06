package streams.dataProcesingCourse.module2.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapExamples {

    public static void main(String[] args) throws IOException {

        String url="src/main/java/streams/dataProcesingCourse/module2/";
        Stream<String> stream1 = Files.lines(Paths.get(url+"files/TomSawyer_01.txt")) ;
        Stream<String> stream2 = Files.lines(Paths.get(url+"files/TomSawyer_02.txt")) ;
        Stream<String> stream3 = Files.lines(Paths.get(url+"files/TomSawyer_03.txt")) ;
        Stream<String> stream4 = Files.lines(Paths.get(url+"files/TomSawyer_04.txt")) ;

       // System.out.println("Stream 1 : " + stream1.count());
       // System.out.println("Stream 2 : " + stream2.count());
       // System.out.println("Stream 3 : " + stream3.count());
       // System.out.println("Stream 4 : " + stream4.count());

        System.out.println("we want to merge this streams");

        Stream<Stream<String>> streamsOfStream=Stream.of(stream1,stream2,stream3,stream4);

        //System.out.println(streamsOfStream.count()); // we have 4 stream1+stream2,stream3 and stream4

        System.out.println("we need flat map this streams");

        Stream<String> streamOflines =
              //  streamsOfStream.flatMap(st -> st);
                //we can run this with identity this is a function take element and return the same element
                streamsOfStream.flatMap(Function.identity());
        // this are taking the value for every value of stream1

       // System.out.println("flatmap: "+ streamOflines.count());

        /*
        * now we want stream of words
        * */

        /**
         * we create a function that take a string and return Stream<String> and let call a name lineSplitter
         */
        Function<String, Stream<String>> lineSplitter =
                line -> Pattern.compile(" ") //parttner object compile acording a regex pattner
                            .splitAsStream(line);

        // we take the streamOfLines
       // Stream<String> streamOfWords = streamOflines.flatMap(lineSplitter);

        //System.out.println("the element words we have is: "+ streamOfWords.count());

       // Stream<String> streamOfWords = streamOflines.flatMap(lineSplitter)
        //                                .map(word -> word.toLowerCase())
         //                               .distinct();

        //System.out.println("the diferent words we have is: "+ streamOfWords.count());


        Stream<String> streamOfWords = streamOflines.flatMap(lineSplitter)
                .map(word -> word.toLowerCase())
                .filter(word->word.length()==4)
                .distinct();

        System.out.println("the diferent words the size 4  we have is: "+ streamOfWords.count());

    }
}
