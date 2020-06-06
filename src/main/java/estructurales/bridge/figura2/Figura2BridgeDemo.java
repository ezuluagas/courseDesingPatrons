package estructurales.bridge.figura2;

import estructurales.bridge.figura1.CirculoAzul;
import estructurales.bridge.figura1.CuadradoRojo;

public class Figura2BridgeDemo {

    public static void main(String args[]){

        Color azul=new Azul();

        Figura cuadrado=new Cuadrado(azul); // composicion

        Color rojo =new Rojo();

        Figura circulo=new Circulo(rojo);

        cuadrado.aplicarColor();
        circulo.aplicarColor();

        Color verde=new Verde();
        Figura cuadradoVerde=new Cuadrado(verde);
        Figura circuloVerde=new Circulo(verde);

        cuadradoVerde.aplicarColor();
        circuloVerde.aplicarColor();


    }
}
