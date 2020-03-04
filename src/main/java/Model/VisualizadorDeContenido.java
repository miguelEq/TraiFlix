package Model;

public class VisualizadorDeContenido {
        public VisualizadorDeContenido(){

        }

        public void verPelicula(Pelicula peli,Usuario user){
            user.addContenidoVisto(peli);
        }


        public void verCapituloDeSerie(Serie serie,Integer nroTemporada,Capitulo cap, Usuario user){
            LogSerie logSerie = serie.logDeUsuario(user);
            if(logSerie ==null){
                 LogSerie log = new LogSerie(user.getNombreUsuario());
                 log.verCapDeTemporada(nroTemporada,cap);
                 serie.addLogSerie(log);
             }
             else{
                 logSerie.verCapDeTemporada(nroTemporada,cap);
            }
            user.addContenidoVisto(serie);
        }

}

