package Model;

import Model.Errores.NotFriend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
    private double id;
    private String nombre;
    private String nombreUsuario;
    private LocalDate fechaDeRegistro;
    private LocalDate fechaDeNacimiento;
    private List<Usuario> amigos;
    private List<Visualizable> vistas;
    private List<Visualizable> favoritas;
    private List<Recomendacion> recomendadas;


    public Usuario(double id,String name,String usuario,LocalDate fechaRegistro,LocalDate fechaNacimiento){
      this.amigos = new ArrayList<>();
      this.vistas = new ArrayList<>();
      this.recomendadas = new ArrayList<>();
      this.favoritas = new ArrayList<>();
      this.id = id;
      this.nombre = name;
      this.nombreUsuario = usuario;
      this.fechaDeNacimiento = fechaNacimiento;
      this.fechaDeRegistro = fechaRegistro;
    }

    public void addAmigo(Usuario u){
        this.amigos.add(u);
    }
    public void addContenidoVisto(Visualizable v){
        this.vistas.add(v);
    }
    public void addContenidoFavorito(Visualizable v){
        this.favoritas.add(v);
    }

    //si no existe la recomendacion la crea y si existia le agrega el amigo
    public void addContenidoRecomendado(Visualizable v,Usuario amigo){
        if(this.amigos.stream().noneMatch(friend->friend.getNombreUsuario() == amigo.getNombreUsuario())){
            throw new NotFriend("no se puede recomendar si no es un amigo");
        }


        if(this.recomendadas.stream().noneMatch(r->r.getContenido().getTitulo() == v.getTitulo())){
            Recomendacion recomendacion_de_un_amigo= new Recomendacion(v);
            recomendacion_de_un_amigo.addRecomendador(amigo);
            this.recomendadas.add(recomendacion_de_un_amigo);
        }
        else{
            this.buscarRecomendacion(v.getTitulo()).addRecomendador(amigo);
        }

    }

    private Recomendacion buscarRecomendacion(String titulo) {
        int c=0;
        while(this.recomendadas.get(c).getContenido().getTitulo() != titulo){
            c++;
        }
        return this.recomendadas.get(c);
    }

    //GETTERS

    public double getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public List<Visualizable> getFavoritas() {
        return favoritas;
    }

    public List<Visualizable> getVistas() {
        return vistas;
    }

    public List<Recomendacion> getRecomendadas() {
        return recomendadas;
    }

    public List<Serie> getSeriesVistas() {
        return this.vistas.stream().filter(vista->vista.tipo()=="Serie").map(serie->(Serie) serie).collect(Collectors.toList());
    }
}
