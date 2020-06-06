package streams.dataProcesingCourse.modeule4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainUsingOptional {

    public static void main(String... args) {
        List<Double> result = new ArrayList<>();

        ThreadLocalRandom.current()
                .doubles(10_000).boxed()// boxed convert the double to stream
                //i want to do compute for each double
                .forEach(
                        d -> NewMath.inv(d) // it's returned an optionals that will be empty if d is 0
                        .ifPresent( // if present
                                inv -> NewMath.sqrt(inv)
                                .ifPresent(
                                        sqrt-> result.add(sqrt)
                                )
                        )
                );// this code consume and consume and consume this is not a good idea
        System.out.println("# size "+result.size()); // the total doubles i add into the list was 10000 are ramdom

        System.out.println("compute in parallel");

        /**
         * there i can put onliy the parallel , because i 'll get a ramdon error
         * ThreadLocalRandom.current()
         *                 .doubles(10_000).boxed().parallel()
         *                 //i want to do compute for each double
         *                 .forEach(
         *                         d -> NewMath.inv(d) // it's returned an optionals that will be empty if d is 0
         *                         .ifPresent( // if present
         *                                 inv -> NewMath.sqrt(inv)
         *                                 .ifPresent(
         *                                         sqrt-> result.add(sqrt)
         *                                 )
         *                         )
         *                 );
         */

        // for this we can use a flatMap

        Function<Double, Stream<Double>> flatMapper =
                d -> NewMath.inv(d)
                        .flatMap(inv -> NewMath.sqrt(inv)) //instead to use ifpresent i'll use flatMap this return optional double
                        .map(sqrt -> Stream.of(sqrt)) //i want wrap optional to stream
                        .orElseGet(() -> Stream.empty()); //if the stream is empty i'll use this supply function(supply don't take any argument a return something)

        List<Double> rightResults=
        ThreadLocalRandom.current()
                .doubles(10_000).parallel()
                .boxed()
                .flatMap(flatMapper)
                .collect(Collectors.toList());

        System.out.println("# collectszº: "+rightResults.size());

    }
}
