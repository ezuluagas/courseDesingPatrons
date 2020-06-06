package estructurales.bridge;

import estructurales.bridge.figura2.ImprimirFormato;

public class BridgeDemo {

    public static void main(String args[]){
        Pelicula peli=new Pelicula();
        peli.setClasificacion("accion");
        peli.setTitulo("John wick3");
        peli.setDuracion("2:30");
        peli.setAno("2019");

        Formato imprimirFormato=new ImprimirFormato();

        Imprimir imprimirPelicula=new ImprimirPelicula(peli);

        String imprimiendoMaterial=imprimirPelicula.imprimir(imprimirFormato);

        System.out.println(imprimiendoMaterial);

        Formato imprimirHtml=new HttmlFormato();

        String imprimiendoHtml=imprimirPelicula.imprimir(imprimirHtml);

        System.out.println(imprimiendoHtml);




    }
}
