package modeloTest;

import modelo.Capitulo;
import modelo.Errores.CapituloInexistente;
import modelo.Errores.TemporadaIncorrecta;
import modelo.Temporada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TestTemporada {
    private Temporada strangers;
    private Capitulo capitulo1;
    private Capitulo capitulo2;

    @Before
    public void setUp(){
        this.capitulo1= new Capitulo("El comienzo", LocalDate.of(2017,8,15),50,1,1);
        this.capitulo2= new Capitulo("Desaparecidos", LocalDate.of(2017,8,15),50,2,1);
        this.strangers = new Temporada(1);
        this.strangers.agregarCapitulo(capitulo1);
        this.strangers.agregarCapitulo(capitulo2);
    }

    @Test
    public void capitulos_de_strangers(){
        Assert.assertEquals(this.strangers.getCapitulos().get(0).getTitulo(),"El comienzo");
        Assert.assertEquals(this.strangers.getCapitulos().get(1).getTitulo(),"Desaparecidos");
        Assert.assertEquals(this.strangers.getCapitulos().get(0).getNroCapitulo(),new Integer(1));
        Assert.assertEquals(this.strangers.getCapitulos().get(1).getNroCapitulo(),new Integer(2));

    }

    @Test(expected = TemporadaIncorrecta.class)
    public void agrego_un_capitulo_de_otra_temporada(){
        this.strangers.agregarCapitulo(new Capitulo("El comienzo", LocalDate.of(2017,8,15),50,1,2));
    }

    @Test
    public void busco_el_capitulo2(){
        Assert.assertEquals(this.strangers.buscarCapitulo(2).getTitulo(),this.capitulo2.getTitulo());
    }

    @Test(expected = CapituloInexistente.class)
    public void busco_un_capitulo_inexistente(){
        this.strangers.buscarCapitulo(3);
    }

    @Test(expected = CapituloInexistente.class)
    public  void busco_el_capitulo_0(){
        this.strangers.buscarCapitulo(0);
    }
}
