package modelo;

import modelo.Errores.MismoUsuario;

import java.time.LocalDate;
import java.util.*;

public class Usuario {
    private long id;
    private String nombre;
    private String nombreUsuario;
    private LocalDate fechaDeNacimiento;
    private LocalDate fechaDeRegisto;
    private Set<Usuario> amigos;
    private Set<Pelicula> peliculasVistas;
    private Set<Pelicula> peliculasFavoritas;
    private Set<Pelicula> peliculasRecomendadas;


    public Usuario(String nombre,String usuario,LocalDate fechaDeNacimiento,LocalDate fechaDeRegisto){
        this.nombre = nombre;
        this.nombreUsuario = usuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeRegisto = fechaDeRegisto;
        this.amigos = new HashSet<>();
        this.peliculasFavoritas = new HashSet<>();
        this.peliculasRecomendadas = new HashSet<>();
        this.peliculasVistas = new HashSet<>();
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getFechaDeRegisto() {
        return fechaDeRegisto;
    }

    public Set<Pelicula> getPeliculasFavoritas() {
        return peliculasFavoritas;
    }

    public Set<Pelicula> getPeliculasRecomendadas() {
        return peliculasRecomendadas;
    }

    public Set<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }

    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void agregarPeliculaRecomendada(Pelicula p){
        this.peliculasRecomendadas.add(p);
    }

    public void agregarPeliculaVista(Pelicula p){
        this.peliculasVistas.add(p);
    }

    public void agregarPeliculaFavorita(Pelicula p){
        this.peliculasFavoritas.add(p);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return nombreUsuario.equals(usuario1.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario);
    }

    public void agregarAmigo(Usuario usuario2) {
        if(!this.equals(usuario2)) {
            this.amigos.add(usuario2);
        }else{
            throw new MismoUsuario("no se puede agregar a uno mismo como usuario");
        }
    }
}
