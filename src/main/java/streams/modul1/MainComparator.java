package streams.modul1;

import java.util.function.Function;

public class MainComparator {


    /**
     * this example is based in comparator interface
     * @param args
     */
    public static void main (String... args){

        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge() ;

        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()) ;  //lambda expression comparator
        Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()) ;

        /**
         * now provide a fuction take object person take those this object and comparete the fields
         */

        Function<Person, Integer> f1 = p -> p.getAge(); // take fuction that takes a person and return an Integer -Regular fuction
        Function<Person, String> f2 = p -> p.getLastName(); // return an String
        Function<Person, String> f3 = p -> p.getFirstName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);


        Comparator<Person> cmp = Comparator.comparing(Person::getLastName)  // Comparing is an static method from interface Comparator
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getAge);
    }
}
