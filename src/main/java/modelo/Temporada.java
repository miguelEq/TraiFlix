package modelo;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private List<Capitulo> capitulos;
    private Integer nroTemporada;

    public Temporada(Integer nroTemporada){
        this.nroTemporada=nroTemporada;
        this.capitulos = new ArrayList<>();
    }

    public void agregarCapitulo(Capitulo c){
        this.capitulos.add(c);
    }
}
