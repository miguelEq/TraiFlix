package modelo;

import modelo.Errores.TemporadaInexistente;
import modelo.Errores.TemporadaInvalida;
import modelo.Errores.TemporadaYaExiste;

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private String titulo;
    private List<String> categorias;
    private List<String> contenidoRelacionado;
    private List<String> creadores;
    private String clasificacion;
    private List<Temporada> temporadas;

    public Serie(String titulo){
        this.titulo= titulo;
        this.categorias = new ArrayList<>();
        this.contenidoRelacionado = new ArrayList<>();
        this.creadores = new ArrayList<>();
        this.temporadas = new ArrayList<>();
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void agregarContenidoRelacionado(String c){
        this.contenidoRelacionado.add(c);
    }

    public void agregarCategoria(String c){
        this.categorias.add(c);
    }

    public void agregarCreador(String c){
        this.creadores.add(c);
    }

    public void agregarTemporada(Temporada t){
        if( !existeTemporada(t.getNroTemporada()) && t.getNroTemporada() >0){
            this.temporadas.add(t);
        }
        else if(!(t.getNroTemporada() < 1)){
            throw new TemporadaYaExiste("ya existe la temporada ");
        }
        else {
            throw new TemporadaInvalida("el nro de temporada es menor a 1");
        }
    }

    private boolean existeTemporada(Integer nroTemporada){
        return temporadas.stream().anyMatch((x)->x.getNroTemporada() == nroTemporada);
    }

    public void agregarCapituloATemporada(Capitulo cap,Integer nroTemporada){
        if(existeTemporada(nroTemporada)){
            this.temporadas.get(nroTemporada-1).agregarCapitulo(cap);
        }
        else{
           throw new TemporadaInexistente("la temporada no existe");

        }
    }


    public String getTitulo() { return titulo; }

    public String getClasificacion() {
        return clasificacion;
    }

    public List<String> getContenidoRelacionado() {
        return contenidoRelacionado;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public List<String> getCreadores() {
        return creadores;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }
}
