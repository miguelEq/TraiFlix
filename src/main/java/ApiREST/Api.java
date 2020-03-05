package ApiREST;

import Model.Trainet;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;

import java.util.Arrays;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Api {


    public static void main(String[] args){
        ControllerUser controller =new ControllerUser();
        Trainet trainet = new Trainet();
        Javalin app = Javalin.create(javalinConfig ->
        {
            javalinConfig.defaultContentType = "application/json";
            javalinConfig.registerPlugin(new RouteOverviewPlugin("/routes"));
            javalinConfig.enableCorsForAllOrigins();
        });
        app.start(7000);
        app.routes(()->{
            path("/users",()-> {
            post(controller::crearUser);
            get(controller::allUsers);
            });
        });
    }


}
