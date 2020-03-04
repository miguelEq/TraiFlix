package Model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterCategoria {
    public FilterCategoria(){}

    public List<Visualizable> findByCategoria(Categoria categoria,List<Visualizable> contenidos){
        return contenidos.stream().filter(c->c.getCategorias().contains(categoria)).collect(Collectors.toList());
    }
}
