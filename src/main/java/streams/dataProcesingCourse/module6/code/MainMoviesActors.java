package streams.dataProcesingCourse.module6.code;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import streams.dataProcesingCourse.module6.code.model.Actor;
import streams.dataProcesingCourse.module6.code.model.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;

public class MainMoviesActors {

    public static void main(String... args) throws IOException {

        Set<Movie> movies = new HashSet<>();
        String url="src/main/java/streams/dataProcesingCourse/module6/";
        Stream<String> lines
                = Files.lines(
                Paths.get(url+"files", "movies-mpaa.txt")
        );

        //we'll analyses file
        lines.forEach(
                (String line) ->{
                    String[] elements = line.split("/");
                    String title =
                            elements[0].substring( 0, elements[0].indexOf("(")).trim();
                    String releaseYear =
                            elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));

                    if (releaseYear.contains(",")) {
                        // with skip movies with a coma in their title
                        return;
                    }

                    Movie movie=new Movie(title, Integer.valueOf(releaseYear));

                    for (int i = 0; i < elements.length; i++){
                        String[] name= elements[i].split(", ");
                        String lastName = name[0].trim();
                        String firstName = "";

                        if (name.length>1){
                            firstName = name[1].trim();
                        }

                        Actor actor = new Actor(lastName,firstName);
                        movie.addActor(actor);

                    }

                    movies.add(movie);

                }


        );

        System.out.println("# total movies "+movies.size());


        // # of actors  remember the actors are in the same file

        long numberOfActors=movies.stream(). //map( movie -> movie.getActors() //Stream<Set<Actors>> how can count this stream
                           //                 .stream() )//Stream<Stream<Actors>> this i can flat map
                    flatMap(movie -> movie.actors().stream()) //Stream<Actors>
                    //.collect(Collectors.toSet()).size(); // this is a cost for get the count
                    .distinct()
                    .count(); // this you need save in long variable

        System.out.println("# actors "+ numberOfActors);


        // you know some many actors has in several movies, but who i can specify the total actors without repeat the name

        //Map<Actor, Long> actorsCollecte=
        Map.Entry<Actor,Long> mostViewActor=
        movies.stream()
                .flatMap(movie -> movie.actors().stream())
                .collect(
                        Collectors.groupingBy(
                                //actor -> actor,
                                Function.identity(), //this better way
                                Collectors.counting()
                        )
                )
                .entrySet().stream()  //Stream<Map.entry<actors, long>>  get the max
                .max(
                        //Comparator.comparing(entry-> entry.getValue())
                        Map.Entry.comparingByValue() //change
                ).get();

        System.out.println("vthe most view actor is " + mostViewActor);

        // actor that played in the greatest # of movies during a year
        // we create Map<release< years, Map<Actor, # of movies during that year>>

        Map<Integer, HashMap<Actor, AtomicLong>>  yearsActorsPerMovie=
        movies.stream()
                .collect(
                        Collectors.groupingBy(
                                movie -> movie.getReleaseYear(),
                                        Collector.of( //downstream collector
                                        //supplier we'll be built the muntable container
                                        () -> new HashMap<Actor , AtomicLong>(),
                                        //acomulator take an elemente from the stream( down stream)
                                        (map, movie) ->{ // the map is HashMap<Actor , AtomicLong>(), and adds movie to this map
                                            movie.actors().forEach( // we are analize the actor to that movie and add to one by one to the map
                                                    actor -> map.computeIfAbsent(actor,  a -> new AtomicLong()).incrementAndGet()//put(actor, new AtomicLong(1))
                                            );
                                        },
                                        //combiner this is merging 2 maps
                                                (map1, map2 ) -> {
                                                        map2.entrySet().forEach(
                                                                entry2 -> map1.merge(
                                                                        entry2.getKey(), entry2.getValue(),
                                                                        (al1 , al2) -> {
                                                                            al1.addAndGet(al2.get());
                                                                            return al1;
                                                                        }
                                                                )
                                                        );
                                                        return  map1;

                                                },
                                                Collector.Characteristics.IDENTITY_FINISH) // this the four parameter

                                )
                        );

        System.out.println("Actors per movie per year "+ yearsActorsPerMovie.size());


        //now we extract the max we need transform the Map<Integer, HashMap<Actor, AtomicLong>> the hashMap actor key in entrys

        Entry<Integer, Entry<Actor, AtomicLong>> get=
        movies.stream()
                .collect(
                        Collectors.groupingBy(
                                movie -> movie.getReleaseYear(),
                                Collector.of( //downstream collector
                                        //supplier we'll be built the muntable container
                                        () -> new HashMap<Actor , AtomicLong>(),
                                        //acomulator take an elemente from the stream( down stream)
                                        (map, movie) ->{ // the map is HashMap<Actor , AtomicLong>(), and adds movie to this map
                                            movie.actors().forEach( // we are analize the actor to that movie and add to one by one to the map
                                                    actor -> map.computeIfAbsent(actor,  a -> new AtomicLong()).incrementAndGet()//put(actor, new AtomicLong(1))
                                            );
                                        },
                                        //combiner this is merging 2 maps
                                        (map1, map2 ) -> {
                                            map2.entrySet().forEach(
                                                    entry2 -> map1.merge(
                                                            entry2.getKey(), entry2.getValue(),
                                                            (al1 , al2) -> {
                                                                al1.addAndGet(al2.get());
                                                                return al1;
                                                            }
                                                    )
                                            );
                                            return  map1;

                                        },
                                        Collector.Characteristics.IDENTITY_FINISH) // this the four parameter

                        )
                ).entrySet().stream()
                .collect(
                        Collectors.toMap(
                                entry -> entry.getKey() ,
                                entry -> entry.getValue().entrySet().stream()
                                            .max(
                                                    Map.Entry.comparingByValue(Comparator.comparing(atomicLong -> atomicLong.get()))
                                            ) //return optional
                                            .get()
                        )
                ) //here i have Map<Integer , HashMap<Actor, AtomicLong>>
                .entrySet().stream()
                .max(
                        Map.Entry.comparingByValue(
                                Comparator.comparing(
                                        entry -> entry.getValue().get()
                                )
                        )
                )
                .get();

        System.out.println(get);
    }


}
