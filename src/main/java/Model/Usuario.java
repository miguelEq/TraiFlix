package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private double id;
    private String nombre;
    private String nombreUsuario;
    private LocalDate fechaDeRegistro;
    private LocalDate fechaDeNacimiento;
    private List<Usuario> amigos;
    private List<Visualizable> vistas;
    private List<Visualizable> favoritas;
    private List<Visualizable> recomendadas;


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
    public void addContenidoRecomendado(Visualizable v){
        this.recomendadas.add(v);
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

    public List<Visualizable> getRecomendadas() {
        return recomendadas;
    }
}
