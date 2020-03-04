package Model;



import Model.Errores.TemporadaInexistente;
import Model.Errores.TemporadaInvalida;
import Model.Errores.TemporadaYaExiste;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Visualizable{
    private List<String> creadores;
    private List<Temporada> temporadas;
    private List<LogSerie> logs;

    public Serie(Double id,String titulo){
        super(id,titulo);
        this.creadores = new ArrayList<>();
        this.temporadas = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    public void addCreador(String creador){
        this.creadores.add(creador);
    }

    public void addTemporada(Temporada temp){
        if(temp.getNroTemporada()<1){
            throw new TemporadaInvalida("el nro de temporada es menor a 1");

        }
        if(this.temporadas.stream().noneMatch(temporada -> temporada.getNroTemporada() == temp.getNroTemporada())){
          this.temporadas.add(temp);
        }
        else{
            throw new TemporadaYaExiste("ya existe la temporada");
        }
    }

    public void addCapituloATemporada(Integer nroTemporada,Capitulo cap){
         Temporada t = this.buscarTemporada(nroTemporada);
         t.addCapitulo(cap);
    }

    private Temporada buscarTemporada(Integer nroTemporada) {
        int contador =0;
        int size= this.temporadas.size();
        while( size > contador && this.temporadas.get(contador).getNroTemporada() != nroTemporada ){
            contador++;
        }
        if(size>contador){
            return this.temporadas.get(contador);
        }
        else{
            throw new TemporadaInexistente("la temporada no existe");
        }
    }

    public LogSerie logDeUsuario(Usuario user){
        int n=0;
        while(this.getLogs().size()>n && this.getLogs().get(n).getUsername() != user.getNombreUsuario()){
            n++;
        }
        if(this.getLogs().size()>n){
            return this.getLogs().get(n);
        }
        else {
               return null;
        }
    }

    //GETTERS
    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public List<String> getCreadores() {
        return creadores;
    }

    public List<LogSerie> getLogs() {
        return logs;
    }

    @Override
    public String tipo() {
        return "Serie";
    }

    @Override
    public int raiting() {
        if(this.temporadas.size()==0){
            return 0;
        }
        else {
        return this.temporadas.stream().map(elem->elem.raiting()).reduce(0,(total,elem)->total+elem)
                / this.temporadas.size();
        }
    }

    public void addLogSerie(LogSerie log) {
        this.logs.add(log);
    }
}
