package modeloTest;

import modelo.Pelicula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestPelicula {
    private Pelicula pelicula1;
    private Pelicula pelicula2;

    @Before
    public void setUp(){
        pelicula1 = new Pelicula("Rapidos y Furiosos",  LocalDate.of(2009,10,4),1200);
        pelicula2 = new Pelicula("HarryPotter y La piedra Filosofal", LocalDate.of(2006,12,5),130);
    }

    @Test
    public void raiting_de_pelicula1_y_pelicula2_0(){
        Assert.assertEquals(pelicula1.raiting(),new Integer(0));
        Assert.assertEquals(pelicula2.raiting(),new Integer(0));

    }

    @Test
    public void raiting_mayor_a_0(){
        pelicula1.agregarValoracion(2);
        pelicula1.agregarValoracion(10);
        pelicula2.agregarValoracion(8);
        pelicula2.agregarValoracion(6);
        Assert.assertEquals(pelicula1.raiting(),new Integer(6));
        Assert.assertEquals(pelicula2.raiting(),new Integer(7));
    }

    @Test
    public void info_de_pelicula1(){
        List<String> vacio = new ArrayList<>();
        Assert.assertEquals(pelicula1.getTitulo(),"Rapidos y Furiosos");
        Assert.assertEquals(pelicula1.getContenidoRelacionado(),vacio);
        Assert.assertEquals(pelicula1.getGeneros(),vacio);
        Assert.assertEquals(pelicula1.getFechaDeEstreno(),LocalDate.of(2009,10,4));
        Assert.assertEquals(pelicula1.getActoresPrincipales(),vacio);
        Assert.assertEquals(pelicula1.getDirectores(),vacio);
        Assert.assertEquals(pelicula1.getClasificacion(),"");
    }
    @Test
    public void contenido_relacionado_de_pelicula1(){
        pelicula1.agregarContenidoRelacionado("Rapido y Furiosos 2");
        pelicula1.agregarContenidoRelacionado("Rapido y Furiosos 3");
        pelicula1.agregarContenidoRelacionado("Rapido y Furiosos 4");
        pelicula1.setClasificacion("+16");

        Assert.assertEquals(pelicula1.getClasificacion(),"+16");
        Assert.assertEquals(pelicula1.getContenidoRelacionado().size(),3);
        Assert.assertEquals(pelicula1.getContenidoRelacionado().get(0),"Rapido y Furiosos 2");
    }
}
