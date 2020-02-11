package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pelicula extends  InfoContenido{
    private String clasificacion;
    private List<String> generos;
    private List<String> contenidoRelacionado;

    public Pelicula(String titulo, LocalDate fechaDeEstreno, Integer duracion){
        super(titulo,fechaDeEstreno,duracion);
        this.contenidoRelacionado= new ArrayList<String>();
        this.generos= new ArrayList<String>();
        this.clasificacion="";
    }

    public void setClasificacion(String c){
        this.clasificacion = c;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public List<String> getGeneros() {
        return generos;
    }


    public List<String> getContenidoRelacionado() {
        return contenidoRelacionado;
    }

    public void agregarGenero(String genero){
        this.generos.add(genero);
    }

    public void agregarContenidoRelacionado(String contenido){
        this.contenidoRelacionado.add(contenido);
    }
}
