package Model;


import Model.Errores.TemporadaInvalida;

import java.util.ArrayList;
import java.util.List;

public class LogSerie {
    private String username;
    private List<Temporada> temporadas;

    public LogSerie(String user){
        this.username = user;
        this.temporadas = new ArrayList<>();
    }

    public void verCapDeTemporada(Integer nroTemporada,Capitulo cap){
        if(nroTemporada<1){
            throw new TemporadaInvalida("el numero de temporada no existe");
        }
        if(this.temporadas.stream().noneMatch(temp->temp.getNroTemporada()==nroTemporada)){
            Temporada temporada= new Temporada(nroTemporada);
            temporada.addCapitulo(cap);
            this.temporadas.add(temporada);
        }else {
            Integer n =0;
            while (this.temporadas.get(n).getNroTemporada()!= nroTemporada){
                n++;
            }
            temporadas.get(n).addCapitulo(cap);
        }

    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public String getUsername() {
        return username;
    }
}
