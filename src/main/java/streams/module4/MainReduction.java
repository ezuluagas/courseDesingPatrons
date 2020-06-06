package streams.module4;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;


public class MainReduction {
    public static void main(String[] args) {

        List<Integer> intsPositive = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8,9);


        BinaryOperator<Integer> opSum=(i1,i2)->i1+i2;

        int reduction = reduce(intsPositive, 0, opSum);

        System.out.println(reduction);// i'm sum the list int positive

        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(-1, -2, -3, -4);

        int reduction1=reduce(ints1,0,opSum);
        int reduction2=reduce(ints2,0,opSum);

        System.out.println(reduction1);
        System.out.println(reduction2);

        BinaryOperator<Integer> opMax=(i1,i2)->Integer.max(i1,i2);
        int reduction3=reduce(Arrays.asList(reduction1,reduction2),0,opMax); // be carefull with the no associate operation because here is a paralell
        System.out.println(reduction3);



    }

    /**
     *
     * @param values to reduce
     * @param valueIfEmpty if the reduce is empty
     * @param reduction this the reduction operation
     * @return
     */
    public static int reduce(List<Integer> values, int valueIfEmpty,   BinaryOperator<Integer> reduction ){

        int result=valueIfEmpty;
        for (int value:values){
            result=reduction.apply(result,value);
        }
        return result;
    }
}
