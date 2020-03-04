package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Capitulo {
    private double id;
    private String titulo;
    private Integer nroCapitulo;
    private Integer nroTemporada;
    private LocalDate fechaDeEstreno;
    private String duracion;
    private List<String> directores;
    private List<String> actoresPrincipales;
    private List<Integer> puntuaciones;
    private String linkYoutube;

    public Capitulo(double id,String titulo,Integer nroTemporada,Integer nroCapitulo,
                    LocalDate fechaEstreno,String duracion,String link){
        this.id = id;
        this.titulo = titulo;
        this.nroTemporada = nroTemporada;
        this.nroCapitulo = nroCapitulo;
        this.fechaDeEstreno = fechaEstreno;
        this.duracion = duracion;
        this.linkYoutube = link;
        this.actoresPrincipales = new ArrayList<>();
        this.directores = new ArrayList<>();
        this.puntuaciones = new ArrayList<>();
    }

    public void addActor(String actor){
        this.actoresPrincipales.add(actor);
    }
    public void addDirector(String director){
        this.directores.add(director);
    }
    public void addPuntuacion(Integer puntuacion){
        this.puntuaciones.add(puntuacion);
    }

    //GETTERS

    public LocalDate getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public Integer getNroTemporada() {
        return nroTemporada;
    }

    public Integer getNroCapitulo() {
        return nroCapitulo;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public List<String> getDirectores() {
        return directores;
    }

    public List<String> getActoresPrincipales() {
        return actoresPrincipales;
    }

    public double raiting() {
      return this.puntuaciones.stream().reduce(0,(total,elem)->total+elem) / this.puntuaciones.size();
    }
}
