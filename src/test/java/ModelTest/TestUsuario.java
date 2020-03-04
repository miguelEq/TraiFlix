package ModelTest;

import Model.Errores.NotFriend;
import Model.Pelicula;
import Model.Serie;
import Model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TestUsuario {
    private Usuario pepe;
    private Usuario lucia;

    @Before
    public  void setUp(){
         pepe = new Usuario(1.0,"pepe","pepe10", LocalDate.now(),LocalDate.now());
         lucia = new Usuario(2.0,"lucia","lucia11", LocalDate.now(),LocalDate.now());
    }

    @Test
    public void pepe_agrega_de_amigo_a_lucia(){
        pepe.addAmigo(lucia);
        Assert.assertEquals(pepe.getAmigos().get(0),lucia);
    }

    @Test
    public void lucia_le_recomienda_una_pelicula_a_pepe(){
        pepe.addAmigo(lucia);
        pepe.addContenidoRecomendado(new Pelicula(1.0,"Titanic", LocalDate.of(1998,12,05),"120minutos","www.youtube/titanic"),lucia);
        Assert.assertEquals(pepe.getRecomendadas().get(0).getContenido().tipo(),"Pelicula");
        Assert.assertEquals(pepe.getRecomendadas().get(0).getContenido().getTitulo(),"Titanic");
        Assert.assertEquals(pepe.getRecomendadas().get(0).getRecomendadores().get(0).getNombre(),"lucia");
    }

    @Test(expected = NotFriend.class)
    public void pepe_no_puede_recomendar_una_serie_a_lucia(){
        lucia.addContenidoRecomendado(new Serie(1.0,"TWD"),pepe);
    }
}
