package cinemaCity.filme;

import java.util.List;

public class FilmDeComedie extends Film {
    public FilmDeComedie(String titluFilm, List<String> listaSubtitrari, String tag) {
        super(titluFilm, listaSubtitrari, tag);
    }

    @Override
    public int calculeazaPretBilet() {
        int pret = super.calculeazaPretBilet();
        if (EfecteSpecialeFilm.efect4DX.equals(tag) || EfecteSpecialeFilm.efect7D.equals(tag)) {
            pret += 3; //(echivalent pret=pret+3)

        }
        return pret;
    }
}
