package estructurales.adapter;

import lombok.Data;

@Data
public class EmpleadoDB implements Empleados {

    private String id;
    private String nombre;
    private String appellido;
    private String email;

    public EmpleadoDB(String id, String nombre, String appellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.appellido = appellido;
        this.email = email;
    }

    public String toString(){
        return "ID: "+id+", Nombre: "+nombre+", Apellido: "+appellido+", Email: "+email;
    }
}
