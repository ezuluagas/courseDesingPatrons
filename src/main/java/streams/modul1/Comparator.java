package streams.modul1;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T>{

    /** this work if you want comparing for function where recive a person a return an integer, but if you want a generic method
     *  because if you create another method for comparete with string doesn't work
     *  public static Comparator<Person> comparing(Function<Person, String> f) {
     *  because this has the same name and singature
    public static Comparator<Person> comparing(Function<Person, Integer> f) {
        return (p1,p2)->f.apply(p1)-f.apply(p2);// apply the function to element 1 return string minus apply fuction to p2
        //return (p1, p2) ->  f.apply(p1).compareTo(f.apply(p2));  // apply the function
    }
    */


    //public static Comparator<Person> comparing(Function<Person, Comparable> f) {
    public static <U>Comparator<U> comparing(Function<U, Comparable> f) { // this way is more generic
        return (p1,p2)->f.apply(p1).compareTo(f.apply(p2));
    }

    public int compare(T t1, T t2);

    /**
     * Then comparator
     * return the implementation of the public in comparate(T t1, T t2)
     * retunr (p1,p2)->-1 for example but i neeed compare the both element p1,p2 according with the comparator i have
     * return (p1,p2)-> compare (p1,p2)==0?cmp.compare(p1,p2):compare(p1,p2);
     */
    public default  Comparator<T> thenComparing(Comparator<T> cmp){
        return (p1,p2)-> compare (p1,p2)==0?cmp.compare(p1,p2):compare(p1,p2);
    }

    /**
     *
     * if i need comparate with fucntion something like Comparator.comparing(Person::getLastName)
     *                 .thenComparing(Person::getFirstName)
     *                 there we can use the then comparing
     */
    public default Comparator<T> thenComparing(Function<T, Comparable> f) {

        return thenComparing(comparing(f)) ;
    }

}
