package Model;


import Model.Errores.TemporadaInvalida;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogSerie {
    private String username;
    private List<LogTemporada> temporadas;

    public LogSerie(String user){
        this.username = user;
        this.temporadas = new ArrayList<>();
    }

    public void verCapDeTemporada(Integer nroTemporada,int cap){
        if(nroTemporada<1){
            throw new TemporadaInvalida("el numero de temporada no existe");
        }
        List<LogTemporada> temps=this.temporadas.stream().filter(temp-> temp.getNroTemporada()==nroTemporada).collect(Collectors.toList());
        if(temps.isEmpty()){
            LogTemporada log=new LogTemporada(nroTemporada);
            log.addCapitulo(cap);
            this.temporadas.add(log);
        }
        else{
            temps.get(0).addCapitulo(cap);
        }

    }

    public List<LogTemporada> getTemporadas() {
        return temporadas;
    }

    public String getUsername() {
        return username;
    }


}
