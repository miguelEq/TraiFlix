package ApiREST;

import Model.Visualizable;

public class ContenidoRelacionadoInfo {
    private String titulo;
    private String tipo;

    public ContenidoRelacionadoInfo(Visualizable v){
        this.tipo = v.tipo();
        this.titulo = v.getTitulo();
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }
}
