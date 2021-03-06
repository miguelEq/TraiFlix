package ApiREST;

import Model.Trainet;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;



import static io.javalin.apibuilder.ApiBuilder.*;

public class Api {


    public static void main(String[] args){
        ControllerTrainet controller =new ControllerTrainet();

        Javalin app = Javalin.create(javalinConfig ->
        {
            javalinConfig.defaultContentType = "application/json";
            javalinConfig.registerPlugin(new RouteOverviewPlugin("/routes"));
            javalinConfig.enableCorsForAllOrigins();
        });
        app.start(7000);
        app.routes(()->{
            path("users",()-> {
            post(controller::crearUser);
              path("/login",()->{
                  get(controller::login);
              });
              path("/:username",()->{
                get(controller::getUser);
              });
            });
            path("peliculas",()-> {
                get(controller::allContent);
                path("/:titulo", () -> {
                    get(controller::getPelicula);
                    path("/:username", () -> {
                        post(controller::verPelicula);
                    });
                });
            });

        });
    }


}
