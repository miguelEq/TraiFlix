package Model;

import java.util.List;
import java.util.stream.Collectors;

public class FilterClasificacion {
    public FilterClasificacion(){}

    public List<Visualizable> findbyClasificacion(Clasificacion clasificacion,List<Visualizable> contenido){
        return contenido.stream().filter(v->v.getClasificacion().contains(clasificacion)).collect(Collectors.toList());
    }
}
