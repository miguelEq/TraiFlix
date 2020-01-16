package modelo.Errores;

public class TemporadaYaExiste extends RuntimeException {

    public TemporadaYaExiste(String msg){
        super(msg);
    }
}
