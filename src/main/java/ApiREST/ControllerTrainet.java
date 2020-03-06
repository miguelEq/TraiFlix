package ApiREST;


import Model.Trainet;
import Model.Usuario;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ControllerTrainet {
    private Trainet trainet= new Trainet();
    private int ids = 0;
    public ControllerTrainet(){

    }

    public void crearUser(Context ctx){
         UserView user = ctx.bodyAsClass(UserView.class);
        System.out.println(user.getFechaDeNacimiento());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDeNacimiento = null;
        try {
            fechaDeNacimiento = LocalDate.parse(user.getFechaDeNacimiento(), fmt);

        if(trainet.getUsuarios().stream().noneMatch(usuario->usuario.getNombreUsuario().equals(user.getUsername()))){
            Usuario usuarioNuevo=new Usuario((double) ids,user.getName(),user.getUsername(),LocalDate.now(),fechaDeNacimiento);
            trainet.addUsuario(usuarioNuevo);
            ids ++;
            ctx.status(200);
            UserInfo userInfo = new UserInfo(usuarioNuevo);
            ctx.json(userInfo);
        }
        else{
            ctx.status(401);
        }
        }catch (DateTimeParseException e){
            ctx.status(403);

        }

    }
    public Context getUser(Context context){
        String username =context.pathParam("username");
        List<Usuario> result = trainet.getUsuarios().stream().filter(user->user.getNombreUsuario().equals(username)).collect(Collectors.toList());
        if(!result.isEmpty()){
            Usuario usuario =result.get(0);
              return context.json(new UserInfo(usuario));
        }else {
            return context.status(401);
        }
    }
    public Context allUsers(Context context) {
        return context.json(this.trainet.getUsuarios());
    }
}
