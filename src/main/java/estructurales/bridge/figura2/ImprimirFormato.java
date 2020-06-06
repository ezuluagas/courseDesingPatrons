package estructurales.bridge.figura2;

import estructurales.bridge.Detalles;
import estructurales.bridge.Formato;

import java.util.List;

public class ImprimirFormato implements Formato {
    @Override
    public String format(String header, List<Detalles> detalles) {
        StringBuilder builder=new StringBuilder();
        builder.append(header);
        builder.append("\n");

        for (Detalles detalle:detalles){
            builder.append(detalle.getLabel());
            builder.append(":");
            builder.append(detalle.getValor());
            builder.append("\n");
        }
        return builder.toString();
    }
}
