package Model;



import modelo.Errores.TemporadaInexistente;
import modelo.Errores.TemporadaInvalida;
import modelo.Errores.TemporadaYaExiste;

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
        while(this.temporadas.get(contador).getNroTemporada() != nroTemporada && size > contador){
            contador++;
        }
        if(size>contador){
            return this.temporadas.get(contador);
        }
        else{
            throw new TemporadaInexistente("la temporada no existe");
        }
    }

    //GETTERS
    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public List<String> getCreadores() {
        return creadores;
    }



    @Override
    public String tipo() {
        return "Serie";
    }
}
