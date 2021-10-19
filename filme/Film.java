package cinemaCity.filme;

import java.util.List;

public abstract class Film {
    protected String titluFilm;
    protected List<String> listaSubtitrari;
    protected EfecteSpecialeFilm tag;
    //protected String tag;
    protected int pretBilet;


    public Film(String titluFilm, List<String> listaSubtitrari, String tag) {
        this.titluFilm = titluFilm;
        this.listaSubtitrari = listaSubtitrari;
        this.tag = EfecteSpecialeFilm.valueOf(tag);

    }


    public String getTitluFilm() {
        return titluFilm;
    }

    public int getPretBilet() {
        return pretBilet;
    }

    public List<String> getListaSubtitrari() {
        return listaSubtitrari;
    }

    public void setPretBilet() {
        this.pretBilet = calculeazaPretBilet();
    }

    public int calculeazaPretBilet() {

        return (int) ((Math.random() * (25 - 10)) + 10);
    }

}