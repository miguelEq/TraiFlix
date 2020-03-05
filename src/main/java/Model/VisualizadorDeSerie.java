package Model;

public class VisualizadorDeSerie {
        public VisualizadorDeSerie(){

        }

        public void verPelicula(Pelicula peli,Usuario user){
            user.addContenidoVisto(peli);
        }


        public void verCapituloDeSerie(Serie serie,Integer nroTemporada,int nrocap, Usuario user){
            LogSerie logSerie = serie.logDeUsuario(user.getNombreUsuario());
            //si la serie no tiene un log del usuario entonces le crea uno y agrega la serie como contenido visto al usuario
            if(logSerie ==null){
                 user.addContenidoVisto(serie);
                 LogSerie log = new LogSerie(user.getNombreUsuario());
                 log.verCapDeTemporada(nroTemporada,nrocap);
                 serie.addLogSerie(log);
             }
             else{
                 logSerie.verCapDeTemporada(nroTemporada,nrocap);
            }

        }

        public boolean vioLaSerieCompleta(Serie serie,String username){
            LogSerie log = serie.logDeUsuario(username);
            return serie.getTemporadas().stream().allMatch(temporada->temporada.fuiVistaCompletamente(log.getTemporadas()));

        }

}

