package ModelTest;

import Model.Capitulo;
import Model.Errores.TemporadaIncorrecta;
import Model.Errores.TemporadaInvalida;
import Model.LogSerie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class TestLogSerie {

    private LogSerie logSerie;

    @Before
    public void setUp(){
        this.logSerie = new LogSerie("miguelEq");
    }

    @Test
    public  void info_de_log(){
        Assert.assertEquals(this.logSerie.getUsername(),"miguelEq");
        Assert.assertEquals(this.logSerie.getTemporadas(), Arrays.asList());
    }

    @Test
    public void veo_un_cap_de_la_primera_temporada(){
        this.logSerie.verCapDeTemporada(1,new Capitulo(1.0,"El Comienzo",1,1, LocalDate.of(2005,10,20),"40minutos","www.algo"));
        Assert.assertEquals(this.logSerie.getTemporadas().size(), 1);
        Assert.assertEquals(this.logSerie.getTemporadas().get(0).getCapitulos().get(0).getTitulo(),"El Comienzo");

    }
    @Test(expected = TemporadaIncorrecta.class)
    public void veo_un_de_una_temporada_distinta(){
        this.logSerie.verCapDeTemporada(1,new Capitulo(1.0,"El Comienzo",2,1, LocalDate.of(2005,10,20),"40minutos","www.algo"));
    }

    @Test(expected = TemporadaInvalida.class)
    public void veo_un_cap_de_una_temporada_negativa(){
        this.logSerie.verCapDeTemporada(-1,new Capitulo(1.0,"El Comienzo",2,1, LocalDate.of(2005,10,20),"40minutos","www.algo"));
    }

}
