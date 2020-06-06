package estructurales.bridge.figura2;

public class Cuadrado extends Figura {


    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void aplicarColor() {
        color.aplicarColor();
    }
}
