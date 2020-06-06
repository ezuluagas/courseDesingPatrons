package estructurales.composite;

import java.util.Iterator;

public class Menu extends MenuComponentes {

    public Menu(String nombre, String url) {
        this.nombre=nombre;
        this.url=url;
    }

    @Override
    public MenuComponentes agregar(MenuComponentes menuComponente){
        menuCompoenetes.add(menuComponente);
        return menuComponente;
    }

    @Override
    public MenuComponentes remover(MenuComponentes menuComponentes){
        menuCompoenetes.remove(menuComponentes);
        return menuComponentes;
    }


    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();

        builder.append(imprimir(this));
        Iterator<MenuComponentes> itr=menuCompoenetes.iterator();

        while(itr.hasNext()){
            MenuComponentes menuComponentes=itr.next();
            builder.append(menuComponentes.toString());
        }

        return builder.toString();
    }
}
