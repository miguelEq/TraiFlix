package modelo;

import modelo.Errores.CapituloInexistente;
import modelo.Errores.CapituloYaExiste;
import modelo.Errores.TemporadaIncorrecta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Temporada {
    private List<Capitulo> capitulos;
    private Integer nroTemporada;

    public Temporada(Integer nroTemporada){
        this.nroTemporada=nroTemporada;
        this.capitulos = new ArrayList<>();
    }
/*** el capitulo debe pertenecer a la temporada y no existir en la lista de capitulos  ***/
    public void agregarCapitulo(Capitulo c){
        if(c.getNroTemporada()== nroTemporada ){
            if(!this.capitulos.stream().anyMatch(cap->cap.getNroCapitulo() == c.getNroCapitulo())) {
                this.capitulos.add(c);
            }
            else {
                throw new CapituloYaExiste("el capitulo ya existe dentro de la temporada");
            }
        }
        else{
            throw new TemporadaIncorrecta("el nro de temporada del capitulo con coindide");
        }
    }


    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public Capitulo buscarCapitulo(Integer nroCapitulo){

         if(this.capitulos.stream().anyMatch(cap-> cap.getNroCapitulo() == nroCapitulo)){
            return this.capitulos.stream().filter(cap-> cap.getNroCapitulo()== nroCapitulo).collect(Collectors.toList()).get(0);
        }
        else{

            throw new CapituloInexistente("el capitulo no existe bro");
        }
    }

    public Integer getNroTemporada() {
        return nroTemporada;
    }

    public Integer raiting(){
        return (int) this.capitulos.stream().mapToInt(cap-> cap.raiting()).reduce(0,(acumulador,elemList)-> acumulador + elemList) / this.capitulos.size() ;
    }
}
