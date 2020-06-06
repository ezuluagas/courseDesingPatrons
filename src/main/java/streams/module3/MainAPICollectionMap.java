package streams.module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainAPICollectionMap {

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Francisco", 18);

        List<Person> people=new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
        people.forEach(person -> System.out.println(person));


        //remove if age < 25
        people.removeIf(person -> person.getAge()<25);

        //replace for upperCase remeber replaceAll
        people.replaceAll(person -> new Person(person.getName().toUpperCase(),person.getAge()));

        people.sort(Comparator.comparing(Person::getAge));// if you want can you order in reserved way
        people.forEach(System.out::println); //



        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");

        Map<City, List<Person>> map = new HashMap<>();

        System.out.println("people from paris "+ map.get(paris));

        System.out.println("people from paris "+ map.getOrDefault(paris, Collections.EMPTY_LIST));
        map.putIfAbsent(paris,new ArrayList<>());
        map.get(paris).add(p1);

        System.out.println("people from paris "+ map.getOrDefault(paris, Collections.EMPTY_LIST));
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);

        System.out.println("people from new York "+ map.getOrDefault(newYork, Collections.EMPTY_LIST));

        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3); // this not create other list, it continue add to the same list
        System.out.println("people from new York "+ map.getOrDefault(newYork, Collections.EMPTY_LIST));

        Map<City, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");

        map1.forEach((city, peoples) -> System.out.println(city + " : " + peoples));
        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

        System.out.println("Map 2");
        map2.forEach((city, peoples) -> System.out.println(city + " : " + peoples));

        //merge map1 and map2

        map2.forEach(//recorrer map2
                (city,peoples)->{  // biConsumer for Each takes key values pair
                        map1.merge(  // i want add key pairs to my map1
                            city,peoples, //if the key (city) is no present in Map1 this key'll be added
                                (peopleFromMap1, peopleFromMap2)->{ //binary Operato take
                             peopleFromMap1.addAll(peopleFromMap2); // return list
                             return  peopleFromMap1;
                        });
        });
        System.out.println("Merged ");
        map1.forEach((city, peoples) -> System.out.println(city + " : " + peoples));    }
}
