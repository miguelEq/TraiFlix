package modelo;

import java.time.LocalDate;
import java.util.ArrayList;


import java.util.List;
import java.util.Objects;

public abstract  class InfoContenido {
    private Long id;
    private String titulo;
    private LocalDate fechaDeEstreno;
    private Integer duracion;
    private List<String> directores;
    private List<String> actoresPrincipales;
    private List<Integer>valoracionesDeUsuario;
    private String linkYoutube;

    public InfoContenido(String titulo,LocalDate fechaDeEstreno,Integer duracion){
        this.titulo= titulo;
        this.duracion= duracion;
        this.fechaDeEstreno=fechaDeEstreno;
        this.directores= new ArrayList<String>();
        this.actoresPrincipales= new ArrayList<String>();
        this.valoracionesDeUsuario= new ArrayList<Integer>();
        this.linkYoutube = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoContenido that = (InfoContenido) o;
        return Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    public void agregarDirector(String director){
        this.directores.add(director);
    }

    public void agregarActor(String actor){
        this.actoresPrincipales.add(actor);
    }

    public void agregarValoracion(Integer calificacion){
        this.valoracionesDeUsuario.add(calificacion);
    }

    public void setLinkYoutube(String link){
        this.linkYoutube=link;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public LocalDate getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Integer> getValoracionesDeUsuario() {
        return valoracionesDeUsuario;
    }

    public List<String> getActoresPrincipales() {
        return actoresPrincipales;
    }

    public List<String> getDirectores() {
        return directores;
    }

    public Integer raiting(){
        if(this.valoracionesDeUsuario.size()>0) {
            return (int) this.valoracionesDeUsuario.stream().reduce(0, (acumulador, elemList) -> acumulador + elemList) / this.valoracionesDeUsuario.size();
        }
        return 0;
    }
}
