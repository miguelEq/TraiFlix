package ApiREST;

import Model.Visualizable;

import java.util.List;
import java.util.stream.Collectors;

public class VisualizableInfo {
    private String titulo;
    private String tipo;
    private List<String> categorias;
    private List<String> clasificacion;
    private List<ContenidoRelacionadoInfo> contenidoRelacionado;
    public VisualizableInfo(){

    }
    public VisualizableInfo(Visualizable v){
        this.titulo = v.getTitulo();
        this.tipo = v.tipo();
        this.categorias = v.getCategorias().stream().map(categoria -> categoria.toString()).collect(Collectors.toList());
        this.clasificacion = v.getClasificacion().stream().map(clas->clas.toString()).collect(Collectors.toList());
        this.contenidoRelacionado = v.getContenidoRelacionado().stream().map(contenido-> new ContenidoRelacionadoInfo(contenido)).collect(Collectors.toList());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getClasificacion() {
        return clasificacion;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public List<ContenidoRelacionadoInfo> getContenidoRelacionado() {
        return contenidoRelacionado;
    }
}
