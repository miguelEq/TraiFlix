package modelo;

import modelo.Errores.CapituloInexistente;
import modelo.Errores.TemporadaIncorrecta;

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
        if(c.getNroTemporada()== nroTemporada) {
            this.capitulos.add(c);
        }
        else{
            throw new TemporadaIncorrecta("el nro de temporada del capitulo con coindide");
        }
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public Capitulo buscarCapitulo(Integer nroCapitulo){
        if(nroCapitulo> this.capitulos.size() || nroCapitulo == 0){
            throw new CapituloInexistente("el capitulo no existe bro");
        }
        else{
            return this.capitulos.get(nroCapitulo-1);
        }
    }

    public Integer getNroTemporada() {
        return nroTemporada;
    }
}
