package ModelTest;

import Model.Categoria;
import Model.Pelicula;
import Model.Visualizable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestPelicula {
    private Pelicula pelicula1;
    private Pelicula pelicula2;
    private Pelicula pelicula3;

    @Before
    public void setUp(){
        //localdate anio/mes/dia
        this.pelicula1 = new Pelicula(1.0,"Titanic", LocalDate.of(1998,12,05),"120minutos","www.youtube/titanic");
        this.pelicula2 = new Pelicula(2.0,"Avengers", LocalDate.of(2011,05,12),"130minutos","www.youtube/avengers");
        this.pelicula3 = new Pelicula(3.0,"Jumanji", LocalDate.of(1998,10,02),"90minutos","www.youtube/jumanji");

    }
    @Test
    public void info_de_pelicula1(){
        Assert.assertEquals(pelicula1.getTitulo(),"Titanic");
        Assert.assertEquals(pelicula1.getFechaDeEstreno(),LocalDate.of(1998,12,05));
        Assert.assertEquals(pelicula1.getActoresPrincipales(),new ArrayList<String>());
        Assert.assertEquals(pelicula1.getDirectores(),new ArrayList<String>());
        Assert.assertEquals(pelicula1.getDuracion(),"120minutos");
        Assert.assertEquals(pelicula1.tipo(),"Pelicula");
        pelicula1.addCategoria(Categoria.ACCION);
        pelicula1.addCategoria(Categoria.ROMANCE);

        Categoria[] catg= {Categoria.ACCION,Categoria.ROMANCE};
        Assert.assertEquals(pelicula1.getCategorias(), Arrays.asList(catg));
        Assert.assertEquals(pelicula1.getClasificacion(),new ArrayList<Integer>());
        Assert.assertEquals(pelicula1.getContenidoRelacionado(),new ArrayList<Visualizable>());
    }

    @Test
    public void contenido_Relacionado_De_pelicula1(){
        this.pelicula1.addContenidoRelacionado(pelicula2);
        this.pelicula1.addContenidoRelacionado(pelicula3);
        Visualizable[] relacionado= {pelicula2,pelicula3};

        Assert.assertEquals(Arrays.asList(relacionado),pelicula1.getContenidoRelacionado());
        Assert.assertEquals(pelicula1.getContenidoRelacionado().get(0).getTitulo(),"Avengers");
        Assert.assertEquals(pelicula1.getContenidoRelacionado().get(1).getTitulo(),"Jumanji");
        Assert.assertEquals(pelicula1.getContenidoRelacionado().get(0).tipo(),"Pelicula");
    }
}
