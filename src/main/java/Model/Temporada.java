package Model;



import Model.Errores.CapituloYaExiste;
import Model.Errores.TemporadaIncorrecta;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private List<Capitulo> capitulos;
    private Integer nroTemporada;

    public Temporada(Integer nroTemporada){
        this.nroTemporada=nroTemporada;
        this.capitulos = new ArrayList<>();
    }

    public void addCapitulo(Capitulo c){
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
}
