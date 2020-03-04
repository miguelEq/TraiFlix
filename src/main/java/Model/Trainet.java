package Model;

import java.util.ArrayList;
import java.util.List;

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

    public double raitingDePelicula(String titulo){
        int n=0;
        while(this.pelisYseries.size()>n && this.pelisYseries.get(n).getTitulo() != titulo){
            n++;
        }
        if(this.pelisYseries.size()>n){
            return this.pelisYseries.get(n).raiting();
        }
        else {
            throw new RuntimeException("la pelicula no existe");
        }
    }
}
