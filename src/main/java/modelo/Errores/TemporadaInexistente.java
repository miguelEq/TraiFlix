package modelo.Errores;

public class TemporadaInexistente extends RuntimeException {

    public TemporadaInexistente(String msg){
        super(msg);
    }
}
