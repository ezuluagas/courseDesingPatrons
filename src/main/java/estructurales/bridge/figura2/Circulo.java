package estructurales.bridge.figura2;

public class Circulo extends Figura {
    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void aplicarColor() {
        color.aplicarColor();
    }
}
