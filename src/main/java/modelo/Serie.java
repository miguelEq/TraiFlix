package modelo;

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private List<String> categorias;
    private List<String> contenidoRelacionado;
    private List<String> creadores;
    private String clasificacion;
    private List<Temporada> temporadas;

    public Serie(){
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
        this.agregarTemporada(t);
    }

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
