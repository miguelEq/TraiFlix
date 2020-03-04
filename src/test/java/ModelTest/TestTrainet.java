package ModelTest;

import Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class TestTrainet {

    private Usuario miguel;
    private Usuario lucia;
    private Usuario jorge;
    private Pelicula titanic;
    private Pelicula godzilla;
    private Pelicula kingkong;
    private Serie TWD;
    private Serie StrangerThings;
    private Temporada temp1Stranger;
    private Temporada temp1TWD;
    private Temporada temp2TWD;
    private Capitulo cap1Stranger;
    private Capitulo cap2Stranger;
    private Capitulo cap1TWDtemp1;
    private Capitulo cap2TWDtemp1;
    private Capitulo cap1TWDtemp2;
    private Capitulo cap2TWDtemp2;

    private Trainet trainet;

    @Before
    public void setUp(){
        //Peliculas
        titanic= new Pelicula(1.0,"Titanic", LocalDate.of(1998,12,05),"170minutos","www.youtube/titanic");
        godzilla =new Pelicula(2.0,"Godzilla", LocalDate.of(1998,12,20),"120minutos","www.youtube/godzilla");
        kingkong =new Pelicula(3.0,"KingKong", LocalDate.of(2003,06,05),"180minutos","www.youtube/kingkong");
        godzilla.addContenidoRelacionado(kingkong);
        kingkong.addContenidoRelacionado(godzilla);
        titanic.addCategoria(Categoria.ROMANCE);
        titanic.addClasificacion(Clasificacion.MAS16);
        godzilla.addCategoria(Categoria.ACCION);
        godzilla.addClasificacion(Clasificacion.ATP);
        kingkong.addCategoria(Categoria.ACCION);
        kingkong.addCategoria(Categoria.ROMANCE);
        kingkong.addClasificacion(Clasificacion.ATP);


        //Series
        //Stranger things
        StrangerThings = new Serie(2.0,"Stranger Things");
        temp1Stranger= new Temporada(1);
        cap1Stranger = new Capitulo(1.0,"El Comienzo",1,1, LocalDate.of(2005,10,20),"40minutos","www.algo");
        cap2Stranger = new Capitulo(2.0,"Amigas",1,2, LocalDate.of(2005,10,20),"40minutos","www.algo");
        temp1Stranger.addCapitulo(cap1Stranger);
        temp1Stranger.addCapitulo(cap2Stranger);
        StrangerThings.addTemporada(temp1Stranger);
        StrangerThings.addCategoria(Categoria.ROMANCE);
        StrangerThings.addCategoria(Categoria.HORROR);
        StrangerThings.addClasificacion(Clasificacion.MAS13);
        //TWD
        TWD = new Serie(1.0,"The Walking Dead");
        temp1TWD = new Temporada(1);
        temp2TWD = new Temporada(2);
        cap1TWDtemp1 = new Capitulo(1.0,"La ciudad",1,1, LocalDate.of(2005,10,20),"40minutos","www.algo");
        cap2TWDtemp1 = new Capitulo(2.0,"Los sobrevivientes",1,2, LocalDate.of(2005,10,20),"40minutos","www.algo");
        cap1TWDtemp2 = new Capitulo(3.0,"Solos",2,1, LocalDate.of(2005,10,20),"40minutos","www.algo");
        cap2TWDtemp2 = new Capitulo(4.0,"La granja",2,2, LocalDate.of(2005,10,20),"40minutos","www.algo");
        temp1TWD.addCapitulo(cap1TWDtemp1);
        temp1TWD.addCapitulo(cap2TWDtemp1);
        temp2TWD.addCapitulo(cap1TWDtemp2);
        temp2TWD.addCapitulo(cap2TWDtemp2);
        TWD.addTemporada(temp1TWD);
        TWD.addTemporada(temp2TWD);
        TWD.addCategoria(Categoria.HORROR);
        TWD.addClasificacion(Clasificacion.MAS16);
        TWD.addContenidoRelacionado(StrangerThings);
        StrangerThings.addContenidoRelacionado(TWD);

        //Usuarios
        miguel = new Usuario(1.0,"miguel","miguel10", LocalDate.now(),LocalDate.now());
        lucia = new Usuario(2.0,"lucia","luciana12", LocalDate.now(),LocalDate.now());
        jorge = new Usuario(3.0,"jorge","jorgito", LocalDate.now(),LocalDate.now());
        //Trainet
        trainet = new Trainet();
        trainet.addUsuario(miguel);
        trainet.addUsuario(lucia);
        trainet.addUsuario(jorge);
        trainet.addVisualizable(godzilla);
        trainet.addVisualizable(titanic);
        trainet.addVisualizable(kingkong);
        trainet.addVisualizable(TWD);
        trainet.addVisualizable(StrangerThings);
    }
    @Test
    public void obtengo_todas_las_peliculas(){
        List<Pelicula> pelis =trainet.getPeliculas();
        Assert.assertEquals(pelis.size(),3);
        Assert.assertEquals(pelis.get(0).getTitulo(),"Godzilla");
        Assert.assertEquals(pelis.get(1).getTitulo(),"Titanic");
        Assert.assertEquals(pelis.get(2).getTitulo(),"KingKong");
    }

    @Test
    public void obtengo_todas_las_series(){
        List<Serie> series = trainet.getSeries();
        Assert.assertEquals(series.size(),2);
        Assert.assertEquals(series.get(0).getTitulo(),"The Walking Dead");
        Assert.assertEquals(series.get(1).getTitulo(),"Stranger Things");
    }

    @Test
    public void obtengo_todos_los_usuarios(){
        Assert.assertEquals(this.trainet.getUsuarios().get(0).getNombre(),"miguel");
        Assert.assertEquals(this.trainet.getUsuarios().get(1).getNombre(),"lucia");
        Assert.assertEquals(this.trainet.getUsuarios().get(2).getNombre(),"jorge");
    }

    @Test
    public void busco_godzilla_Y_TWD(){
        Assert.assertEquals(trainet.buscar_pelicula("Godzilla").getTitulo(),"Godzilla");
        Assert.assertEquals(trainet.bucar_serie("The Walking Dead").getTitulo(),"The Walking Dead");
    }

    @Test
    public void busco_una_serie_que_no_existe(){
        Assert.assertEquals(trainet.bucar_serie("aaa"),null);
        Assert.assertEquals(trainet.buscar_pelicula("ola"),null);
    }

    @Test
    public void busco_contenido_para_mayores_de_13(){
        Assert.assertEquals(trainet.getContentBy(Clasificacion.MAS13).size(),1);
        Assert.assertEquals(trainet.getContentBy(Clasificacion.MAS13).get(0).getTitulo(),"Stranger Things");
    }

    @Test
    public void busco_contenido_romantico(){
        Assert.assertEquals(trainet.getContentBy(Categoria.ROMANCE).size(),3);
        Assert.assertEquals(trainet.getContentBy(Categoria.ROMANCE).get(0).getTitulo(),"Titanic");
        Assert.assertEquals(trainet.getContentBy(Categoria.ROMANCE).get(1).getTitulo(),"KingKong");
        Assert.assertEquals(trainet.getContentBy(Categoria.ROMANCE).get(2).getTitulo(),"Stranger Things");
    }
}
