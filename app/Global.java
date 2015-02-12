import models.Episodio;
import models.Serie;
import models.Temporada;
import models.dao.GenericDAO;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAO();

    @Override
    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
                iniciaBanco();
                dao.flush();
            }});
    }

    public void iniciaBanco() throws Exception{

        String csvFile = Play.application().getFile("/app/seriesFinalFile.csv").getAbsolutePath();
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            String[] listFromCSV = line.split(",");
            Serie serie = new Serie("South Park");
            Temporada temporada =  new Temporada(1, serie);
            Episodio episodio = new Episodio("Cartman Gets an Anal Probe", temporada, 1);
            temporada.addEpisodio(episodio);
            serie.addTemporada(temporada);
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                listFromCSV = line.split(",");
                if (listFromCSV.length>=4) {
                    episodio = new Episodio(listFromCSV[3], serie.temporadaMaisNova(), parseInt(listFromCSV[2]));
                } else {
                    episodio = new Episodio("Sem Título", serie.temporadaMaisNova(), parseInt(listFromCSV[2]));
                }

                if (serie.getNome().replace("'", "").equals(listFromCSV[0].replace("'", ""))){

                    if (serie.getTemporadas().size()!=0 && serie.temporadaMaisNova().getNumero()==parseInt(listFromCSV[1])) {
                        serie.temporadaMaisNova().addEpisodio(episodio);
                    } else{
                        temporada = new Temporada(parseInt(listFromCSV[1]),serie);
                        temporada.addEpisodio(episodio);
                        serie.addTemporada(temporada);
                    }
                } else{
                    dao.persist(serie);
                    serie = new Serie(listFromCSV[0].replace("'", ""));
                    temporada = new Temporada(parseInt(listFromCSV[1]),serie);
                    temporada.addEpisodio(episodio);
                    serie.addTemporada(temporada);
                }
            }
            dao.persist(serie);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}