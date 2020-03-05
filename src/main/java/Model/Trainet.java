package Model;

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
        if(peli != null && user != null){
            user.addContenidoVisto(peli);
        }else {
            throw new RuntimeException("pelicula o usuario no encontrado");
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
        List<Usuario> usersearched=this.usuarios.stream().filter(user->user.getNombreUsuario()==nameUser).collect(Collectors.toList());
        if(usersearched.isEmpty()){
            return null;
        }
        else {
            return usersearched.get(0);
        }
    }
    public Pelicula buscar_pelicula(String titulo){
        return (Pelicula) this.buscar(titulo);
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



}
