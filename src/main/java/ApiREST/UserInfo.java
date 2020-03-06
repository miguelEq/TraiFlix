package ApiREST;

import Model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UserInfo {
    private String nombre;
    private String username;
    private int edad;
    private List<VisualizableInfo> contenidoVisto;
   public UserInfo(){

    }
    public UserInfo(Usuario usuario){
        this.username = usuario.getNombreUsuario();
        this.edad= usuario.getEdad();
        this.nombre = usuario.getNombre();
        this.contenidoVisto = usuario.getVistas().stream().map(contenido->new VisualizableInfo(contenido)).collect(Collectors.toList());
    }

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<VisualizableInfo> getContenidoVisto() {
        return contenidoVisto;
    }
}
