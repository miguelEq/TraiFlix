package ModelTest;

import Model.Capitulo;
import Model.Errores.CapituloInvalido;
import Model.Errores.CapituloYaExiste;
import Model.Errores.TemporadaIncorrecta;
import Model.Temporada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class TestTemporada {
    private Capitulo capitulo1;
    private Capitulo capitulo2;
    private Capitulo capitulo3;
    private Temporada temp1;

    @Before
    public void setUp(){
        this.capitulo1 = new Capitulo(1.0,"El Comienzo",1,1, LocalDate.of(2005,10,20),"40minutos","www.algo");
        this.capitulo2 = new Capitulo(2.0,"Desaparecidos",1,2, LocalDate.of(2005,10,20),"40minutos","www.algo");
        this.capitulo3 = new Capitulo(3.0,"Trampa",1,3, LocalDate.of(2005,10,20),"40minutos","www.algo");
        this.temp1 = new Temporada(1);
    }

    @Test
    public void info_de_temp1(){
        Assert.assertEquals(this.temp1.getNroTemporada(),new Integer(1));
        Assert.assertEquals(this.temp1.getCapitulos(), Arrays.asList());
    }

    @Test
    public void agrego_capitulos_a_temp1(){
        this.temp1.addCapitulo(capitulo1);
        this.temp1.addCapitulo(capitulo2);
        this.temp1.addCapitulo(capitulo3);

        Assert.assertEquals(this.temp1.getCapitulos(),Arrays.asList(capitulo1,capitulo2,capitulo3));
        Assert.assertEquals(this.temp1.getCapitulos().get(0).getTitulo(),capitulo1.getTitulo());
        Assert.assertEquals(this.temp1.getCapitulos().get(1).getTitulo(),capitulo2.getTitulo());
        Assert.assertEquals(this.temp1.getCapitulos().get(2).getTitulo(),capitulo3.getTitulo());

    }
    @Test(expected = CapituloYaExiste.class)
    public void agrego_un_capitulo_que_ya_existe(){
        this.temp1.addCapitulo(capitulo1);
        this.temp1.addCapitulo(capitulo1);
    }
    @Test(expected = TemporadaIncorrecta.class)
    public void agrego_un_capitulo_de_otra_temporada(){
        this.temp1.addCapitulo(new Capitulo(3.0,"Trampa",2,3, LocalDate.of(2005,10,20),"40minutos","www.algo"));
    }

    @Test(expected = CapituloInvalido.class)
    public  void  agrego_un_capitulo_negativo(){
        this.temp1.addCapitulo(new Capitulo(3.0,"Trampa",1,-3, LocalDate.of(2005,10,20),"40minutos","www.algo"));
    }
 }

