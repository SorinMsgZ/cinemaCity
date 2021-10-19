package cinemaCity.filme;

import java.util.List;

public class FilmDeActiune extends Film {


    public FilmDeActiune(String titluFilm, List<String> listaSubtitrari, String tag) {
        super(titluFilm, listaSubtitrari, tag);
    }

    @Override
    public int calculeazaPretBilet() {
        return super.calculeazaPretBilet();
    }
}
