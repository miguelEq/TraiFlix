package modeloTest;

import modelo.Capitulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCapitulo {
    private Capitulo capitulo1;

    @Before
    public void setUp(){
        this.capitulo1= new Capitulo("El comienzo", LocalDate.of(2017,12,6),45,1,1);
    }

    @Test
    public void infoDeCapitulo1(){

        Assert.assertEquals(this.capitulo1.getTitulo(),"El comienzo");
        Assert.assertEquals(this.capitulo1.getActoresPrincipales().size(),0);
        Assert.assertEquals(this.capitulo1.getDirectores().size(),0);
        Assert.assertEquals(this.capitulo1.getValoracionesDeUsuario().size(),0);
        Assert.assertEquals(this.capitulo1.getNroCapitulo(),new Integer(1));
        Assert.assertEquals(this.capitulo1.getNroTemporada(),new Integer(1));
        Assert.assertEquals(this.capitulo1.getLinkYoutube(),"");
        Assert.assertEquals(this.capitulo1.getFechaDeEstreno(),LocalDate.of(2017,12,6));
        Assert.assertEquals(this.capitulo1.raiting(),new Integer(0));
    }

    @Test
    public void agrego_actor_director_link_y_valoracion_al_capitulo1(){
        this.capitulo1.agregarActor("Van dame");
        this.capitulo1.agregarDirector("Spilberg");
        this.capitulo1.setLinkYoutube("www.youtube.com/GTO");
        this.capitulo1.agregarValoracion(8);

        Assert.assertEquals(this.capitulo1.getActoresPrincipales().get(0),"Van dame");
        Assert.assertEquals(this.capitulo1.getDirectores().get(0),"Spilberg");
        Assert.assertEquals(this.capitulo1.getLinkYoutube(),"www.youtube.com/GTO");
        Assert.assertEquals(this.capitulo1.raiting(),new Integer(8));
    }
}
