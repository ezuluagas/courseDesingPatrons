package estructurales.bridge;

import estructurales.bridge.Detalles;
import estructurales.bridge.Formato;

import java.util.List;

public abstract class Imprimir {
    
    public String imprimir(Formato formato){
        return formato.format(getHeader(),getValor());
    }

    protected abstract List<Detalles> getValor();

    protected abstract String getHeader();
}
