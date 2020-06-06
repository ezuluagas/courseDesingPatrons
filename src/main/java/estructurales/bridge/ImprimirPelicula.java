package estructurales.bridge;

import java.util.ArrayList;
import java.util.List;

public class ImprimirPelicula extends Imprimir {

    private Pelicula pelicula;

    public ImprimirPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    protected List<Detalles> getValor() {
        List<Detalles> detalles= new ArrayList();

        detalles.add(new Detalles("Titulo",pelicula.getTitulo()));
        detalles.add(new Detalles("Año",pelicula.getAno()));
        detalles.add(new Detalles("Duracion",pelicula.getDuracion()));
        return detalles;
    }

    @Override
    protected String getHeader() {
        return pelicula.getClasificacion();
    }
}
