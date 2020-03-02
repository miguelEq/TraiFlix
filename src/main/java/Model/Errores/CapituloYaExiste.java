package Model.Errores;

public class CapituloYaExiste extends  RuntimeException{
    public CapituloYaExiste(String msg){
        super(msg);

    }
}
