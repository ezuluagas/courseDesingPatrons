package estructurales.composite;

public class MenuItems extends MenuComponentes {

    public MenuItems (String nombre, String url) {
        this.nombre=nombre;
        this.url=url;
    }



    @Override
    public String toString() {
        return imprimir(this);
    }
}
