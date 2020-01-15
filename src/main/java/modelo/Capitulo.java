package modelo;

import java.time.LocalDate;

public class Capitulo extends InfoContenido{
    private Integer nroCapitulo;
    private Integer nroTemporada;

    public Capitulo(String titulo, LocalDate fechaDeEstreno, Integer duracion,Integer nroCapitulo,Integer nroTemporada) {
        super(titulo, fechaDeEstreno, duracion);
        this.nroCapitulo = nroCapitulo;
        this.nroTemporada = nroTemporada;
    }

    public void setNroCapitulo(Integer nroCapitulo) {
        this.nroCapitulo = nroCapitulo;
    }

    public void setNroTemporada(Integer nroTemporada) {
        this.nroTemporada = nroTemporada;
    }

    public Integer getNroCapitulo() {
        return nroCapitulo;
    }

    public Integer getNroTemporada() {
        return nroTemporada;
    }
}
