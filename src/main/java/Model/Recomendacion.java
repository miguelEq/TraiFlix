package Model;

import java.util.ArrayList;
import java.util.List;

public class Recomendacion {
    private Visualizable contenido;
    private List<Usuario> recomendadores;

    public Recomendacion(Visualizable v){
        this.contenido = v;
        this.recomendadores = new ArrayList<>();
    }

    public void addRecomendador(Usuario u){
        this.recomendadores.add(u);
    }

    public Visualizable getContenido() {
        return contenido;
    }

    public List<Usuario> getRecomendadores() {
        return recomendadores;
    }
}
