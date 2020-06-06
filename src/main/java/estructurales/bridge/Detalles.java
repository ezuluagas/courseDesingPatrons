package estructurales.bridge;

import lombok.Data;

@Data
public class Detalles {

    private String label;
    private String valor;

    public Detalles(String label, String valor){
        this.label=label;
        this.valor=valor;
    }
}
