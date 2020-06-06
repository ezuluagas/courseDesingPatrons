package estructurales.bridge;

import java.util.List;

public class HttmlFormato implements Formato {

    @Override
    public String format(String header, List<Detalles> detalles) {
        StringBuilder builder =new StringBuilder();
        builder.append("<table>");
        builder.append("<th>");
        builder.append("Clasificacion");
        builder.append("</th>");
        builder.append("<th>");
        builder.append(header);
        builder.append("</th>");

        for (Detalles detealle:detalles){
            builder.append("<tr><td>");
            builder.append(detealle.getLabel());
            builder.append("</td><td>");
            builder.append(detealle.getValor());
            builder.append("</td></tr>");
        }
        builder.append("</table>");
        return builder.toString();
    }
}
