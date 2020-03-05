package Model;

import java.util.*;

public class LogTemporada {
    private int nroTemporada;
    private Set<Integer> capitulos;

    public LogTemporada(int nroTemporada){
        this.nroTemporada = nroTemporada;
        this.capitulos = new HashSet<>();
    }
    public void addCapitulo(int nroCap){
        this.capitulos.add(nroCap);
    }

    public int getNroTemporada() {
        return nroTemporada;
    }


    public Set<Integer> getCapitulos() {
        return this.capitulos;
    }
}
