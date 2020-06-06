package estructurales.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponentes {

    String nombre;
    String url;
    List<MenuComponentes> menuCompoenetes=new ArrayList();

    public MenuComponentes agregar(MenuComponentes menuComponentes){
        throw new UnsupportedOperationException("idiota");
    }

    public MenuComponentes remover(MenuComponentes menuComponentes){
        throw new UnsupportedOperationException("idiota");
    }

    public String getNombre(){return nombre;}

    public String getUrl(){return url;}

    public abstract  String toString();

    String imprimir(MenuComponentes menuComponentes){
        StringBuilder builder=new StringBuilder(nombre);
        builder.append(":");
        builder.append(url);
        builder.append("\n");
        return builder.toString();
    }
}
