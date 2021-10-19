package cinemaCity.filme;

import java.util.List;

public class FilmDeGroaza extends Film {


    public FilmDeGroaza(String titluFilm, List<String> listaSubtitrari, String tag) {
        super(titluFilm, listaSubtitrari, tag);
    }


    @Override
    public int calculeazaPretBilet() {
        int pret = super.calculeazaPretBilet();
        if (EfecteSpecialeFilm.efectIMAX.equals(tag) && listaSubtitrari.contains("Engleza")) {
            pret += 5;

        }
        return pret;
    }
}
