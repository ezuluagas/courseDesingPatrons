package streams.dataProcesingCourse.module2.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Shakespeare {
    public static void main(String[] args) throws IOException {

        String url="src/main/java/streams/dataProcesingCourse/module2/";
        Set<String> shaksperearWords =
                Files.lines(Paths.get(url+"files/words.shakespeare.txt")) // open the files
                .map(word -> word.toLowerCase()) // take every word and save in lowercase
                .collect(Collectors.toSet()); // save word in set

        Set<String> scarableWords =
                Files.lines(Paths.get(url+"files/ospd.txt"))
                .map(word->word.toLowerCase())
                .collect(Collectors.toSet());

        System.out.println(" word shasperake file "+ shaksperearWords.size());
        System.out.println(" word ospd file "+ scarableWords.size());


        //now we want compute the shasperake file if shaspearke is scrable game
        final int [] scrabbleENScore = {
                // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z
                1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10} ;

        //this is the poins scrabble

        Function<String, Integer> score =
                word -> word.chars().map(letter -> scrabbleENScore[letter-'a']).sum();

        ToIntFunction<String> intScore=
                word -> word.chars().map(letter -> scrabbleENScore[letter-'a']).sum();

        System.out.println(" score for my name "+ intScore.applyAsInt("esteban"));

        System.out.println(" score for my name "+ score.apply("esteban"));

        //now we want search the best word on shaspearke
        String bestWord=
        shaksperearWords.stream()
                .max(Comparator.comparing(score))
                .get();

        System.out.println("Best word is "+ bestWord);

        System.out.println("the record is "+ intScore.applyAsInt(bestWord));

        //we search the best word into scrabble file
        String bestWord2=
                shaksperearWords.stream()
                        .filter(word -> scarableWords.contains(word))
                        .max(Comparator.comparing(score))
                        .get();

        System.out.println("Best word is "+ bestWord2+ " the record is "+ intScore.applyAsInt(bestWord2));

        //now i want stats about file shaspereke in scrabble

        IntSummaryStatistics summaryStatistics=
                shaksperearWords.stream()
                        .parallel()
                .filter(scarableWords::contains)
                .mapToInt(intScore) // this mapping each word apply the fucntion intScore
                .summaryStatistics();

        System.out.println("the stats "+summaryStatistics);

    }
}
