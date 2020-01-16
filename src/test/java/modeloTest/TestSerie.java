package modeloTest;

import modelo.Capitulo;
import modelo.Errores.TemporadaInvalida;
import modelo.Errores.TemporadaYaExiste;
import modelo.Serie;
import modelo.Temporada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.TabExpander;
import java.time.LocalDate;

public class TestSerie {

    private Serie TWD;
    private Temporada temporada1;
    private Temporada temporada2;
    private Capitulo capitulo1T1;
    private Capitulo capitulo2T1;
    private Capitulo capitulo1T2;
    private Capitulo capitulo2T2;

    @Before
    public void setUp(){
        this.capitulo1T1 = new Capitulo("El virus", LocalDate.of(2010,10,6),60,1,1);
        this.capitulo2T1= new Capitulo("Los Zombies", LocalDate.of(2010,10,6),60,2,1);
        this.capitulo1T2 = new Capitulo("La granja", LocalDate.of(2011,10,6),60,1,2);
        this.capitulo2T2 = new Capitulo("El corral", LocalDate.of(2011,10,6),60,2,2);

        this.temporada1= new Temporada(1);
        this.temporada2 = new Temporada(2);

        this.temporada1.agregarCapitulo(capitulo1T1);
        this.temporada1.agregarCapitulo(capitulo2T1);
        this.temporada2.agregarCapitulo(capitulo1T2);
        this.temporada2.agregarCapitulo(capitulo2T2);

        this.TWD = new Serie("The Walking Dead");
        this.TWD.agregarTemporada(temporada1);
        this.TWD.agregarTemporada(temporada2);
    }

    @Test
    public void temporadas_de_TWD(){
        Assert.assertEquals(this.TWD.getTemporadas().size(),2);
        Assert.assertEquals(this.TWD.getTemporadas().get(0).getNroTemporada(),this.temporada1.getNroTemporada());
        Assert.assertEquals(this.TWD.getTemporadas().get(1).getNroTemporada(),this.temporada2.getNroTemporada());

    }
    @Test(expected = TemporadaYaExiste.class)
    public void agrego_una_temporada_que_ya_existe(){
        this.TWD.agregarTemporada(this.temporada1);
    }
    @Test(expected = TemporadaInvalida.class)
    public void agrego_una_temporada_invalida(){
        this.TWD.agregarTemporada(new Temporada(-1));


    }
}
