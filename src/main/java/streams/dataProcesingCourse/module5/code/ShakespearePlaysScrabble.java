package streams.dataProcesingCourse.module5.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShakespearePlaysScrabble {

    public static void main(String... args) throws IOException {
        String url = "src/main/java/streams/dataProcesingCourse/module5/";

        Path shakespearePath = Paths.get(url+"files/words.shakespeare.txt");
        Path ospdPath = Paths.get(url+"files/ospd.txt");

        try (Stream<String> ospd = Files.lines(ospdPath);
              Stream<String> shakespare = Files.lines(shakespearePath);  )       {

            Set<String> scarableWords = ospd.collect(Collectors.toSet());
            Set<String> shakespareWords = shakespare.collect(Collectors.toSet());

            System.out.println(" scrabable words size "+ scarableWords.size());
            System.out.println(" Shaskepare words size "+ shakespareWords.size());

            int [] letterScores = {
                    // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z 
                    1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
            };
            Function<String, Integer> score =
                    word -> word.toLowerCase().chars()
                            .map(letter -> letterScores[letter - 'a'])
                            .sum();

            // List the words with score

            Map<Integer, List<String>> histoWordsByScore =
                    shakespareWords.stream()
                            .collect(
                                    Collectors.groupingBy(
                                            score  //
                                    )
                            );

            System.out.println("# histoWordsByScore = " + histoWordsByScore.size()); // this is the different scores that we have in the scrableWords file


            histoWordsByScore.entrySet() // Set<Map.Entry<Integer, List<String>>>
                    .stream()
                    .sorted(
                            Comparator.comparing(entry -> -entry.getKey())
                    )
                    .limit(3)
                    .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));


            //List the words this is a word in scrabble

            Map<Integer, List<String>> bestListWordScrabble =
                    shakespareWords.stream()
                        .filter(scarableWords::contains)
                        .collect(
                                Collectors.groupingBy(score)
                        );

            System.out.println(" the # words are in scrabble and shasperke are " + bestListWordScrabble.size());

            bestListWordScrabble.entrySet()
                    .stream()
                    .sorted(
                            Comparator.comparing(value -> -value.getKey())
                    )
                    .limit(3)
                    .forEach(v -> System.out.println("this point has "+ v.getKey()+ " these words "+v.getValue()));


            int [] scrabbleENDistribution = {
                    // a, b, c, d,  e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
                    9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1} ;

            // for example whizzing the second z is 0
            Function<String, Map<Integer, Long>>  histoWords = // compute the histogram for words
                word -> word.chars().boxed()//making stream of integers
                            .collect(Collectors.groupingBy(
                                    letters -> letters, Collectors.counting()
                            ));


            Function<String, Long> nBlank=
                    word -> histoWords.apply(word) //Map<Integer, Long> Map<letter, # of letters>
                                .entrySet()
                                .stream() //map Entry<Integer , Long> so i'll compute the number of blank
                                .mapToLong( // change to Long becasues this is the return in the file

                                        entry->
                                                Long.max(
                                                entry.getValue() -
                                                scrabbleENDistribution[entry.getKey()-'a'],0L

                                                        )

                                                ).sum();

            System.out.println("# blank " +nBlank.apply("whizzing"));

            // verify the score

            Function<String, Integer> score2=
                    word -> histoWords.apply(word)
                                .entrySet()
                                .stream()
                                .mapToInt(
                                        entry ->
                                                letterScores[entry.getKey() - 'a']*
                                                Integer.min(
                                                        entry.getValue().intValue(),
                                                        scrabbleENDistribution[entry.getKey()-'a']
                                                )
                                ).sum();

            System.out.println("# score for whizzing  : " + score.apply("whizzing"));
            System.out.println("# score2 for whizzing : " + score2.apply("whizzing"));


           // Map<Integer, List<String>> histoWordsByScore2 =
                    shakespareWords.stream()
                        .filter(scarableWords::contains)
                            .filter(word -> nBlank.apply(word)<=2)
                        .collect(Collectors.groupingBy(score2))
                            .entrySet() // Set<Map.Entry<Integer, List<String>>>
                            .stream()
                            .sorted(
                                    Comparator.comparing(entry -> -entry.getKey())
                            )
                            .limit(3)
                            .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));


        }catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
