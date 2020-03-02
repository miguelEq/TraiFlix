package Model.Errores;

public class MismoUsuario extends  RuntimeException {
    public MismoUsuario(String msg){
        super(msg);
    }
}
