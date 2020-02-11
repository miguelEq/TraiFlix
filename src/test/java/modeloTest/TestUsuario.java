package modeloTest;

import modelo.Errores.MismoUsuario;
import modelo.Pelicula;
import modelo.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TestUsuario {
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;

    @Before
    public void setUp(){
        usuario1 = new Usuario("miguel","miguel@unq", LocalDate.of(1998,12,18),LocalDate.now());
        usuario2 = new Usuario("pedro","pedro@unq",LocalDate.of(1995,10,15),LocalDate.now());
        usuario3 = new Usuario("zara","zara@hotmail.com",LocalDate.of(2000,11,20),LocalDate.now());
    }

    @Test
    public void agrego_2_amigos_a_usuario_1(){
        this.usuario1.agregarAmigo(usuario2);
        this.usuario1.agregarAmigo(usuario3);
        this.usuario1.agregarAmigo(usuario2);
        this.usuario1.agregarAmigo(usuario3);
        this.usuario1.agregarAmigo(new Usuario("zara","zara@hotmail.com",LocalDate.of(2000,11,20),LocalDate.now()));
        this.usuario1.agregarAmigo(new Usuario("zara","zara@hotmail.com",LocalDate.of(2000,11,20),LocalDate.now()));
        this.usuario1.agregarAmigo(new Usuario("zara","zara@hotmail.com",LocalDate.of(2000,11,20),LocalDate.now()));

        Assert.assertEquals(this.usuario1.getAmigos().size(),2);
    }

    @Test(expected = MismoUsuario.class)
    public void me_agrego_a_mi_mismo_como_usuario(){
        this.usuario1.agregarAmigo(usuario1);
    }

    @Test
    public void agrego_una_misma_peli_varias_veces(){
        Pelicula peli = new Pelicula("Parasyte",LocalDate.of(2019,12,10),100);
        usuario1.agregarPeliculaVista(peli);
        Pelicula copia = new Pelicula("Parasyte",LocalDate.of(2019,12,10),100);
        usuario1.agregarPeliculaVista(copia);
        usuario1.agregarPeliculaVista(copia);

        Assert.assertEquals(usuario1.getPeliculasVistas().size(),1);
    }
}
