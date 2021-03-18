package ApiREST;

import Model.Pelicula;
import Model.Visualizable;

import java.time.LocalDate;
import java.util.List;

public class PeliculaInfo extends VisualizableInfo{
    private List<String> actores;
    private List<String> directores;
    private LocalDate fechaDeEstreno;
    public PeliculaInfo(){}
    public PeliculaInfo(Visualizable visualizable) {
        super(visualizable);
        this.actores = ((Pelicula) visualizable).getActoresPrincipales();
        this.directores =((Pelicula) visualizable).getDirectores();
    }


    public List<String> getDirectores() {
        return directores;
    }


    public List<String> getActores() {
        return actores;
    }
}
