package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainet {
    private List<Visualizable> pelisYseries;
    private List<Usuario> usuarios;

    public Trainet(){
        this.pelisYseries = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void addVisualizable(Visualizable v){
        this.pelisYseries.add(v);
    }
    public void addUsuario(Usuario user){
        this.usuarios.add(user);
    }
    public void verPelicula(String namepeli,String username){
        Pelicula peli=this.buscar_pelicula(namepeli);
        Usuario user=this.buscarUsuario(username);
        if(peli.equals(null) || user.equals(null)){
            throw new RuntimeException("pelicula o usuario no encontrado");

        }else {
            user.addContenidoVisto(peli);
        }
    }
    public void verSerie(String username,String serie,int nroCapitulo,int nroTemporada){
        Usuario user=this.buscarUsuario(username);
        Serie serieResearched = this.bucar_serie(serie);
        new VisualizadorDeSerie().verCapituloDeSerie(serieResearched,nroTemporada,nroCapitulo,user);
    }

    public List<Serie> seriesVistasCompletamente(String username){
        Usuario user=this.buscarUsuario(username);
        VisualizadorDeSerie visualizadorDeSerie = new VisualizadorDeSerie();
        return user.getSeriesVistas().stream().filter(serie -> visualizadorDeSerie.vioLaSerieCompleta(serie,username)).collect(Collectors.toList());

    }
    public List<Pelicula> getPeliculas(){
        List<Pelicula> pelis= new ArrayList<>();
        for(Visualizable v:this.pelisYseries){
            if(v.tipo()=="Pelicula"){
                pelis.add((Pelicula) v);
            }
        }
        return pelis;
    }
    public List<Serie> getSeries(){
        List<Serie> pelis= new ArrayList<>();
        for(Visualizable v:this.pelisYseries){
            if(v.tipo()=="Serie"){
                pelis.add((Serie) v);
            }
        }
        return pelis;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public Usuario buscarUsuario(String nameUser){
        List<Usuario> usersearched=this.usuarios.stream().filter(user->user.getNombreUsuario().equals(nameUser)).collect(Collectors.toList());
        if(usersearched.isEmpty()){
            return null;
        }
        else {
            return usersearched.get(0);
        }
    }
    public Pelicula buscar_pelicula(String titulo){
        List<Visualizable> result = this.getVisualizables().stream().filter(v->v.getTitulo().equals(titulo)).collect(Collectors.toList());
        if(result.isEmpty()) {
          return null;
        }
        else {
            return (Pelicula) result.get(0);
        }
    }
    public Serie bucar_serie(String titulo){
        return (Serie) this.buscar(titulo);
    }

    private Visualizable buscar(String titulo) {
        int n=0;
        while(this.pelisYseries.size()>n && this.pelisYseries.get(n).getTitulo()!= titulo){
            n++;
        }
        if(this.pelisYseries.size()>n){
            return this.pelisYseries.get(n);
        }
        else {
            return null;
        }
    }

    public List<Visualizable> getContentBy(Categoria c){
        return new FilterCategoria().findByCategoria(c,this.pelisYseries);
    }

    public List<Visualizable> getContentBy(Clasificacion c){
        return new FilterClasificacion().findbyClasificacion(c,this.pelisYseries);
    }


    public List<Pelicula> peliculasViewedByUser(String username){
        return this.buscarUsuario(username).getVistas().stream().filter(v->v.tipo()=="Pelicula").map(pelicula->(Pelicula) pelicula).collect(Collectors.toList());
    }


    public Trainet build() {
        Pelicula titanic =new Pelicula(1.0,"Titanic", LocalDate.of(1998,12,05),"170minutos","www.youtube/titanic");
        Pelicula godzilla =new Pelicula(2.0,"Godzilla", LocalDate.of(1998,12,20),"120minutos","www.youtube/godzilla");
        Pelicula kingkong =new Pelicula(3.0,"KingKong", LocalDate.of(2003,06,05),"180minutos","www.youtube/kingkong");
        Pelicula madagascar = new Pelicula(4.0,"Madagascar",LocalDate.of(2005,06,05),"95minutos","www/algo");
        Pelicula avenger = new Pelicula(5.0,"Los vengadores",LocalDate.of(2011,10,15),"140 minutos","algo");
        Pelicula dragonBallSuper = new Pelicula(6.0,"Dragon Ball Super Broly",LocalDate.of(2018,12,18),"100minutos","algo");

        titanic.addClasificacion(Clasificacion.MAS13);
        titanic.addCategoria(Categoria.ROMANCE);
        titanic.addCategoria(Categoria.ACCION);
        titanic.addActor("Leonardo DiCaprio");
        titanic.addActor("Kate Winslet");
        titanic.addActor("Billy Zane");
        titanic.addDirector("James Cameron");
        titanic.addContenidoRelacionado(godzilla);
        titanic.addContenidoRelacionado(madagascar);

        godzilla.addClasificacion(Clasificacion.ATP);
        godzilla.addCategoria(Categoria.ACCION);
        godzilla.addActor("Matthew Broderick");
        godzilla.addActor("Juan Moreno");
        godzilla.addActor("Maria Pitillo");
        godzilla.addDirector("David Callam");
        godzilla.addContenidoRelacionado(kingkong);
        godzilla.addContenidoRelacionado(dragonBallSuper);

        kingkong.addClasificacion(Clasificacion.MAS13);
        kingkong.addCategoria(Categoria.ACCION);
        kingkong.addCategoria(Categoria.ROMANCE);
        kingkong.addActor("Naomi Watts");
        kingkong.addActor("Jack Black");
        kingkong.addActor("Adrien Brody");
        kingkong.addDirector("Peter Jackson");
        kingkong.addContenidoRelacionado(dragonBallSuper);
        kingkong.addContenidoRelacionado(godzilla);

        madagascar.addClasificacion(Clasificacion.ATP);
        madagascar.addCategoria(Categoria.ACCION);
        madagascar.addCategoria(Categoria.COMEDIA);
        madagascar.addActor("Ben Stiller");
        madagascar.addActor("Chris Rock");
        madagascar.addActor("David Schwimmer");
        madagascar.addDirector("Eric Darnell");
        madagascar.addContenidoRelacionado(dragonBallSuper);

        avenger.addClasificacion(Clasificacion.ATP);
        avenger.addCategoria(Categoria.COMEDIA);
        avenger.addCategoria(Categoria.ACCION);
        avenger.addActor("Chris Evans");
        avenger.addActor("Scarlett Johansson");
        avenger.addActor("Chris Hemsworth");
        avenger.addDirector("Joss Whedon");
        avenger.addContenidoRelacionado(titanic);
        avenger.addContenidoRelacionado(kingkong);

        dragonBallSuper.addClasificacion(Clasificacion.ATP);
        dragonBallSuper.addCategoria(Categoria.COMEDIA);
        dragonBallSuper.addCategoria(Categoria.ACCION);
        dragonBallSuper.addActor("Masako Nozawa");
        dragonBallSuper.addActor("Ryo Horikawa");
        dragonBallSuper.addActor("Bin Shimada");
        dragonBallSuper.addDirector("Akira Toriyama");
        dragonBallSuper.addContenidoRelacionado(madagascar);
        this.pelisYseries.add(titanic);
        this.pelisYseries.add(godzilla);
        this.pelisYseries.add(kingkong);
        this.pelisYseries.add(dragonBallSuper);
        this.pelisYseries.add(avenger);
        this.pelisYseries.add(madagascar);

        Usuario miguel = new Usuario(1.0,"miguel","miguel10", LocalDate.now(),LocalDate.now());
        Usuario lucia = new Usuario(2.0,"lucia","luciana12", LocalDate.now(),LocalDate.now());
        Usuario jorge = new Usuario(3.0,"jorge","jorgito", LocalDate.now(),LocalDate.now());
        this.addUsuario(miguel);
        this.addUsuario(lucia);
        this.addUsuario(jorge);

        return this;
    }

    public List<Visualizable> getVisualizables() {
            return this.pelisYseries;
    }
}
