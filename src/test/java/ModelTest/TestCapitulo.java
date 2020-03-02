package ModelTest;

import Model.Capitulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TestCapitulo {
    private Capitulo capitulo1;


    @Before
    public void setUp(){
        this.capitulo1 = new Capitulo(1.0,"El Comienzo",1,1, LocalDate.of(2005,10,20),"40minutos","www.algo");
    }

    @Test
    public void info_de_capitulo1(){
        this.capitulo1.addActor("Will Smith");
        this.capitulo1.addDirector("Jackie");
        this.capitulo1.addDirector("Yo");
        this.capitulo1.addPuntuacion(7);

        Assert.assertEquals(this.capitulo1.getNroCapitulo(),new Integer(1));
        Assert.assertEquals(this.capitulo1.getNroTemporada(),new Integer(1));
        Assert.assertEquals(this.capitulo1.getActoresPrincipales(), Arrays.asList("Will Smith"));
        Assert.assertEquals(this.capitulo1.getDirectores(),Arrays.asList("Jackie","Yo"));
        Assert.assertEquals(this.capitulo1.getDuracion(),"40minutos");
        Assert.assertEquals(this.capitulo1.getFechaDeEstreno(),LocalDate.of(2005,10,20));
        Assert.assertEquals(this.capitulo1.getLinkYoutube(),"www.algo");
        Assert.assertEquals(this.capitulo1.getTitulo(),"El Comienzo");
    }
}
