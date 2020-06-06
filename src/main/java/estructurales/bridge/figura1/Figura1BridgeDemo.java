package estructurales.bridge.figura1;

public class Figura1BridgeDemo {

    public static void main(String args[]){

        Circulo circulo=new CirculoAzul();

        Cuadrado cuadrado=new CuadradoRojo();

        circulo.aplicarColor();
        cuadrado.aplicarColor();


    }
}
