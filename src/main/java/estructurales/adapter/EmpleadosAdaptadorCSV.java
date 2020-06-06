package estructurales.adapter;

public class EmpleadosAdaptadorCSV implements Empleados {

    private EmpleadosCSV instacia;

    public EmpleadosAdaptadorCSV(EmpleadosCSV instacia) {
        this.instacia = instacia;
    }

    @Override
    public String getId() {
        return instacia.getId()+"";
    }

    @Override
    public String getNombre() {
        return instacia.getNombre();
    }

    @Override
    public String getAppellido() {
        return instacia.getApellido();
    }

    @Override
    public String getEmail() {
        return instacia.getCorreoElectronico();
    }

    public String toString(){
        return "ID: "+instacia.getId()+", Nombre: "+instacia.getNombre()+", Apellido: "+instacia.getApellido()+", Email: "+instacia.getCorreoElectronico();
    }
}
