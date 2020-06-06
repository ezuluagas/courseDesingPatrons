package estructurales.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterDemo {

    public static void main(String args[]){

        Integer[] vectorInts=new Integer[]{34,24,4};

        List<Integer> listInts= Arrays.asList(vectorInts);

        System.out.println("vector es "+vectorInts);
        System.out.println("la lista es" +listInts);


        /**
         *
         */


        EmpleadoCliente cliente=new EmpleadoCliente();

        List<Empleados> empleados =cliente.getEmpleadosList();

        System.out.println("los empleados son " +empleados);



    }
}
