package estructurales.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoCliente {

    public List<Empleados> getEmpleadosList(){

        List<Empleados> empleados=new ArrayList();

        Empleados empleadoBD= new EmpleadoDB("1234", "Esteban", "Zuluaga", "estezulu@correo.com");

        empleados.add(empleadoBD);

        EmpleadoLdap empleadoLdap=new EmpleadoLdap("cod", "Barbarita","Juan","juan@correo.com");

        //empleados.add(empleadoLdap);-> no funciona necesitas crear un adaptador

        empleados.add(new EmpleadoAdapterLdap(empleadoLdap));

        EmpleadosCSV empleadosCSV=new EmpleadosCSV("9876,Homero,Simpson,homerojsimpsons@corre.com");

       // empleados.add(empleadosCSV)->error necesito adaptador

        empleados.add(new EmpleadosAdaptadorCSV(empleadosCSV));


        return empleados;

    }
}
