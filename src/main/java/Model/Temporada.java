package Model;



import Model.Errores.CapituloInvalido;
import Model.Errores.CapituloYaExiste;
import Model.Errores.TemporadaIncorrecta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Temporada {
    private List<Capitulo> capitulos;
    private Integer nroTemporada;

    public Temporada(Integer nroTemporada){
        this.nroTemporada=nroTemporada;
        this.capitulos = new ArrayList<>();
    }

    public void addCapitulo(Capitulo c){
        if(c.getNroCapitulo()<1){
            throw new CapituloInvalido("no se puede agregar un capitulo menor a 1");
        }


        if(c.getNroTemporada() == this.nroTemporada){
            if(this.capitulos.stream().noneMatch(capitulo -> c.getNroCapitulo() == capitulo.getNroCapitulo())){
                this.capitulos.add(c);
            }
            else{
                throw new CapituloYaExiste("el capitulo ya existe dentro de la temporada");

            }
        }else{
            throw new TemporadaIncorrecta("el nro de temporada del capitulo no coindide");

        }

    }

    //GETTERS
    public Integer getNroTemporada() {
        return nroTemporada;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public int raiting() {
        if (this.capitulos.size() == 0) {
            return 0;
        } else {
            return this.capitulos.stream().map(cap -> cap.raiting()).reduce(0, (total, elem) -> total + elem)
                    / this.capitulos.size();
        }
    }
    public int cantCapitulos(){
        return this.capitulos.size();
    }

    public boolean fuiVistaCompletamente(List<LogTemporada> temporadas) {
        LogTemporada logTemp = temporadas.stream().filter(temp->temp.getNroTemporada() == nroTemporada).collect(Collectors.toList()).get(0);
        if(logTemp == null){
            return false;
        }else {
            return this.capitulos.stream().map(cap->cap.getNroCapitulo()).collect(Collectors.toSet()).equals(logTemp.getCapitulos());
        }
    }
}
