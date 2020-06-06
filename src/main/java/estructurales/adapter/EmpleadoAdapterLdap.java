package estructurales.adapter;


public class EmpleadoAdapterLdap implements Empleados {

    private EmpleadoLdap instancia;

    public EmpleadoAdapterLdap(EmpleadoLdap instancia) {
        this.instancia = instancia;
    }

    @Override
    public String getId() {
        return instancia.getCn();
    }

    @Override
    public String getNombre() {
        return instancia.getGivesName();
    }

    @Override
    public String getAppellido() {
        return instancia.getSurname();
    }

    @Override
    public String getEmail() {
        return instancia.getMail();
    }

    public String toString(){
        return "ID: "+instancia.getCn()+", Nombre: "+instancia.getGivesName()+", Apellido: "+instancia.getSurname()+", Email: "+instancia.getMail();
    }
}
