package ApiREST;


import Model.Pelicula;
import Model.Trainet;
import Model.Usuario;
import Model.Visualizable;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerTrainet {
    private Trainet trainet= new Trainet().build();
    private int ids = 0;
    public ControllerTrainet(){

    }

    public void crearUser(Context ctx){
         UserView user = ctx.bodyAsClass(UserView.class);
         DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDate fechaDeNacimiento = null;
        try {
            fechaDeNacimiento = LocalDate.parse(user.getFechaDeNacimiento(), fmt);

        if(trainet.getUsuarios().stream().noneMatch(usuario->usuario.getNombreUsuario().equals(user.getUsername()))){
            Usuario usuarioNuevo=new Usuario((double) ids,user.getName(),user.getUsername(),LocalDate.now(),fechaDeNacimiento);
            usuarioNuevo.setPassword(user.getPassword());
            trainet.addUsuario(usuarioNuevo);
            ids ++;
            ctx.status(200);
            UserInfo userInfo = new UserInfo(usuarioNuevo);
            ctx.json(userInfo);
        }
        else{
            ctx.status(400);
        }
        }catch (DateTimeParseException e){
            ctx.status(403);

        }

    }
    public void getUser(Context context){
        String username =context.pathParam("username");
        List<Usuario> result = trainet.getUsuarios().stream().filter(user->user.getNombreUsuario().equals(username)).collect(Collectors.toList());
        if(!result.isEmpty()){
            Usuario usuario =result.get(0);
               context.json(new UserInfo(usuario));
        }else {
             context.status(404);
        }
    }
    public void login(Context context){
        UserLogin userLogin= context.bodyAsClass(UserLogin.class);
        List<Usuario> result = trainet.getUsuarios().stream().filter(user->user.getNombreUsuario().equals(userLogin.getUsername())).collect(Collectors.toList());
        if(!result.isEmpty()){
           Usuario usuario = result.get(0);
           if(usuario.getPassword().equals(userLogin.getPassword())){
               context.json(new UserInfo(usuario));
           }
           else{
               context.status(400);
           }
        }
        else {
            context.status(400);
        }
    }

    public void getPelicula(Context context) {
        String titulo = context.pathParam("titulo");
        List<Visualizable> result = this.trainet.getVisualizables().stream().filter(v->v.getTitulo().equals(titulo)).collect(Collectors.toList());
        if(result.isEmpty()){
            context.status(400);
        }
        else {
            PeliculaInfo peli=new PeliculaInfo(result.get(0));
          context.json(peli);
        }
    }

    public void allContent(Context context) {
         List<VisualizableInfo> maps = this.trainet.getVisualizables().stream().map(v->new VisualizableInfo(v)).collect(Collectors.toList());
         context.json(maps);
    }

    public void verPelicula(Context context){
        try {
           String titulo =context.pathParam("titulo");
           String username =context.pathParam("username");
           trainet.verPelicula(titulo,username);
           Usuario usuario = trainet.getUsuarios().stream().filter(user->user.getNombreUsuario().equals(username)).collect(Collectors.toList()).get(0);
           context.json(new UserInfo(usuario));
           context.status(200);
        }catch (RuntimeException r){
           context.status(400);
       }

    }


}
