package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pelicula extends  Visualizable{
    private LocalDate fechaDeEstreno;
    private String duracion;
    private List<String> directores;
    private List<String> actoresPrincipales;
    private List<Integer> puntuaciones;
    private String linkYoutube;

    public Pelicula(Double id,String titulo,LocalDate fechaDeEstreno,String duracion,String link){
        super(id,titulo);
        this.duracion = duracion;
        this.linkYoutube = link;
        this.fechaDeEstreno = fechaDeEstreno;
        this.directores = new ArrayList<>();
        this.puntuaciones = new ArrayList<>();
        this.actoresPrincipales= new ArrayList<>();

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

    public List<String> getDirectores() {
        return directores;
    }

    public List<String> getActoresPrincipales() {
        return actoresPrincipales;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    @Override
    public String tipo() {
        return "Pelicula";
    }

    @Override
    public double raiting() {
        return this.puntuaciones.stream().reduce(0,(total,elem)->total + elem) / this.puntuaciones.size();
    }
}
