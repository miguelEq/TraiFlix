package ModelTest;

import Model.*;
import Model.Errores.TemporadaInexistente;
import Model.Errores.TemporadaInvalida;
import Model.Errores.TemporadaYaExiste;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSerie {
    private Serie TWD;
    private Temporada temporada1;
    private Temporada temporada2;
    private Capitulo capituloT1;
    private Capitulo capituloT2;
    private Capitulo capitulo1;
    private Capitulo capitulo2;

    @Before
    public void setUp(){
        this.capitulo1 = new Capitulo(1.0,"El Comienzo",1,1, LocalDate.of(2005,10,20),"40minutos","www.algo");
        this.capitulo2 = new Capitulo(2.0,"El Comienzo2",1,2, LocalDate.of(2005,10,20),"40minutos","www.algo");
        this.capituloT1 = new Capitulo(3.0,"El nuevo",2,1, LocalDate.of(2006,10,20),"40minutos","www.algo");
        this.capituloT2 = new Capitulo(4.0,"El Comienzo",2,2, LocalDate.of(2006,10,20),"40minutos","www.algo");
        this.temporada1 = new Temporada(1);
        this.temporada2 = new Temporada(2);
        this.TWD = new Serie(1.0,"The Walking Dead");
    }


    @Test
    public void info_de_TWD(){
        this.TWD.addCategoria(Categoria.ACCION);
        this.TWD.addCategoria(Categoria.HORROR);
        this.TWD.addClasificacion("+16");

      Assert.assertEquals(TWD.getContenidoRelacionado(),Arrays.asList());
      Assert.assertEquals(TWD.getTemporadas().size(),0);
      Assert.assertEquals(TWD.getCreadores(),(List)new ArrayList<String>());
      Assert.assertEquals(TWD.getContenidoRelacionado(),(List)new ArrayList<String>());
      Assert.assertEquals(TWD.getTitulo(),"The Walking Dead");
      Assert.assertEquals(TWD.tipo(),"Serie");
      Assert.assertEquals(TWD.getClasificacion().get(0),"+16");
      Assert.assertEquals(TWD.getCategorias(),Arrays.asList(Categoria.ACCION,Categoria.HORROR));
    }
    @Test
    public void agrego_temp1_y_2_a_TWD(){
        this.TWD.addTemporada(temporada1);
        this.TWD.addTemporada(temporada2);
        this.TWD.addCreador("YO");
        Assert.assertEquals(TWD.getCreadores().size(), 1);
        Assert.assertEquals(TWD.getCreadores().get(0),"YO");
        Assert.assertEquals(TWD.getTemporadas().size(),2);
        Assert.assertEquals(TWD.getTemporadas().get(0).getNroTemporada(),new Integer(1));
        Assert.assertEquals(TWD.getTemporadas().get(1).getNroTemporada(),new Integer(2));

    }

    @Test(expected = TemporadaInvalida.class)
    public  void agrego_una_temp_invalida(){
        this.TWD.addTemporada(new Temporada(-1));
    }

    @Test(expected = TemporadaYaExiste.class)
    public void agrego_una_temp_que_ya_existe(){
        this.TWD.addTemporada(temporada1);
        this.TWD.addTemporada(temporada1);
    }

    @Test
    public void agrego_capitulos_a_temporada1(){
        this.TWD.addTemporada(temporada1);
        this.TWD.addCapituloATemporada(1,capitulo1);
        this.TWD.addCapituloATemporada(1,capitulo2);

        Assert.assertEquals(TWD.getTemporadas().get(0).getCapitulos().size(),2);
        Assert.assertEquals(TWD.getTemporadas().get(0).getCapitulos().get(0).getTitulo(),"El Comienzo");
        Assert.assertEquals(TWD.getTemporadas().get(0).getCapitulos().get(1).getTitulo(),"El Comienzo2");
    }

    @Test(expected = TemporadaInexistente.class)
    public void agrego_capitulos_a_una_temporada_inexistente(){
        this.TWD.addCapituloATemporada(3,capitulo2);
    }

    @Test
    public void agrego_contenido_relacionado_a_TWD(){
        this.TWD.addContenidoRelacionado(new Pelicula(1.0,"Titanic", LocalDate.of(1998,12,05),"120minutos","www.youtube/titanic"));
        this.TWD.addContenidoRelacionado(new Serie(1.0,"Stranger Things"));

        Assert.assertEquals(this.TWD.getContenidoRelacionado().get(0).tipo(),"Pelicula");
        Assert.assertEquals(this.TWD.getContenidoRelacionado().get(1).tipo(),"Serie");
    }
    @Test
    public void log_de_user_pepe(){
        Usuario pepe= new Usuario(1.0,"pepe","pepe10",LocalDate.now(),LocalDate.now());

        Assert.assertEquals(this.TWD.logDeUsuario(pepe),null);

        this.TWD.addLogSerie(new LogSerie(pepe.getNombreUsuario()));

        Assert.assertEquals(this.TWD.logDeUsuario(pepe).getUsername(),"pepe10");

    }

}
