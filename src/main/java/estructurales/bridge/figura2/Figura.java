package estructurales.bridge.figura2;

public abstract class Figura {

    protected Color color;

    public Figura (Color color){  //constructor q utiliza composicion
        this.color=color;
    }

    abstract public void aplicarColor();
}
