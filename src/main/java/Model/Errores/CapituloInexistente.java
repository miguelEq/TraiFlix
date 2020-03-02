package Model.Errores;

public class CapituloInexistente extends RuntimeException {
    public CapituloInexistente(String msg){
        super(msg);
    }
}
