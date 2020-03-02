package Model;

import modelo.Temporada;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Visualizable{
    private List<String> creadores;
    private List<Temporada> temporadas;

    public Serie(Double id,String titulo){
        super(id,titulo);
        this.creadores = new ArrayList<>();
        this.temporadas = new ArrayList<>();
    }



    @Override
    public String tipo() {
        return "Serie";
    }
}
