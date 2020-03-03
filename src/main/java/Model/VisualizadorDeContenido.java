package Model;

public class VisualizadorDeContenido {
        public VisualizadorDeContenido(){

        }

        public void verPelicula(Pelicula peli,Usuario user){
            user.addContenidoVisto(peli);
        }


        public void verCapituloDeSerie(Serie serie,Integer nroTemporada,Capitulo cap, Usuario user){
             serie.logDeUsuario(user).verCapDeTemporada(nroTemporada,cap);
        }

}

