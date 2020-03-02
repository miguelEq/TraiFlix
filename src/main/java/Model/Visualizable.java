package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Visualizable {
    private double id;
    private String titulo;
    private List<Categoria> categorias;
    private List<String> clasificacion;
    private List<Visualizable> contenidoRelacionado;

    protected Visualizable(Double id,String titulo){
        this.id = id;
        this.titulo = titulo;
        this.categorias = new ArrayList<>();
        this.clasificacion = new ArrayList<>();
        this.contenidoRelacionado = new ArrayList<>();
    }

    public void addCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }
    public void addClasificacion(String clasf){
        this.clasificacion.add(clasf);
    }
    public void addContenidoRelacionado(Visualizable v){
        this.contenidoRelacionado.add(v);
    }

    //GETTERS
    public String getTitulo() {
        return titulo;
    }

    public double getId() {
        return id;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<String> getClasificacion() {
        return clasificacion;
    }

    public List<Visualizable> getContenidoRelacionado() {
        return contenidoRelacionado;
    }

    public abstract String tipo();
}
