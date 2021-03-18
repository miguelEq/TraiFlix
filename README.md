# TraiFlix

**status: in progress**

 1- Se modela un dominio donde se pueden  crear peliculas y series(estas estan compuestas por temporadas y capitulos) ademas de agregarle contenido relacionado a las mismas las cuales pueden ser tanto peliculas como series.Tambien se pueden crear usuarios los cuales pueden ver peliculas,series y tener sus favoritos, puntuar,etc.
 
 2- Se modela una API REST que ofrece algunas funciones para interactuar con el dominio.  

**Los tests estan en src/test/java/ModelTest**

**La api esta en src/main/java/ApiREST (solo hay que ejecutar la clase)**

## Endpoints 

Obtener todas las peliculas del sistema

#### GET /peliculas

Body

```json
[{"titulo":"Titanic","tipo":"Pelicula","categorias":["ROMANCE","ACCION"],"clasificacion":["MAS13"],"contenidoRelacionado":[{"titulo":"Godzilla","tipo":"Pelicula"},{"titulo":"Madagascar","tipo":"Pelicula"}]},
{"titulo":"Godzilla","tipo":"Pelicula","categorias":["ACCION"],"clasificacion":["ATP"],"contenidoRelacionado":[{"titulo":"KingKong","tipo":"Pelicula"},{"titulo":"Dragon Ball Super Broly","tipo":"Pelicula"}]},
{"titulo":"KingKong","tipo":"Pelicula","categorias":["ACCION","ROMANCE"],"clasificacion":["MAS13"],"contenidoRelacionado":[{"titulo":"Dragon Ball Super Broly","tipo":"Pelicula"},{"titulo":"Godzilla","tipo":"Pelicula"}]},
{"titulo":"Dragon Ball Super Broly","tipo":"Pelicula","categorias":["COMEDIA","ACCION"],"clasificacion":["ATP"],"contenidoRelacionado":[{"titulo":"Madagascar","tipo":"Pelicula"}]},
{"titulo":"Los vengadores","tipo":"Pelicula","categorias":["COMEDIA","ACCION"],"clasificacion":["ATP"],"contenidoRelacionado":[{"titulo":"Titanic","tipo":"Pelicula"},{"titulo":"KingKong","tipo":"Pelicula"}]},
{"titulo":"Madagascar","tipo":"Pelicula","categorias":["ACCION","COMEDIA"],"clasificacion":["ATP"],"contenidoRelacionado":[{"titulo":"Dragon Ball Super Broly","tipo":"Pelicula"}]}]
```

Obtener una pelicula en especial segun un titulo

#### GET /peliculas/Titanic

Body

```json
{
"titulo":"Titanic",
"tipo":"Pelicula",
"categorias":["ROMANCE","ACCION"],
"clasificacion":["MAS13"],
"contenidoRelacionado":[{"titulo":"Godzilla","tipo":"Pelicula"},{"titulo":"Madagascar","tipo":"Pelicula"}],
"actores":["Leonardo DiCaprio","Kate Winslet","Billy Zane"],
"directores":["James Cameron"]
}
```
Obtener un user en especifico

#### GET /users/miguel10

Body

```json
{"nombre":"miguel",
"username":"miguel10",
"edad":0,
"contenidoVisto":[]}
```

### Stack: Java(8), Javalin

