package ApiREST;

import io.javalin.Javalin;

import java.util.Arrays;

public class Api {


    public static void main(String[] args){
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.json(Arrays.asList("Hola mundo","adios")));
    }
}
