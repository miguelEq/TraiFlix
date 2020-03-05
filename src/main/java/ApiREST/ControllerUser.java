package ApiREST;


import Model.Trainet;
import Model.Usuario;
import io.javalin.http.Context;

import java.time.LocalDate;

public class ControllerUser {
    private Trainet trainet= new Trainet();
    public ControllerUser(){ }

    public void crearUser(Context ctx ){
         UserView user = ctx.bodyAsClass(UserView.class);
        if(trainet.getUsuarios().stream().noneMatch(usuario->usuario.getNombreUsuario().equals(user.getUsername()))){
            Usuario usuarioNuevo=new Usuario(1.0,user.getName(),user.getUsername(), LocalDate.now(),LocalDate.now());
            trainet.addUsuario(usuarioNuevo);
            ctx.status(200);
            ctx.json(usuarioNuevo);
        }
        else{
            ctx.status(401);
        }

    }

    public Context allUsers(Context context) {
        return context.json(this.trainet.getUsuarios());
    }
}
