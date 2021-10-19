package cinemaCity.sali;

import cinemaCity.filme.Film;
import cinemaCity.spectatori.Spectatorul;

import java.util.ArrayList;
import java.util.List;

public class SalaCinema {
    private static final int NR_MAX_LOCURI = 10;
    private List<Spectatorul> listaSpectatori;
    private List<Film> listaFilme;
    private Film filmCurent;


    public SalaCinema() {
        this.listaSpectatori = new ArrayList<>();
        this.listaFilme = new ArrayList<>();
    }

    public void cumparaBilet(Spectatorul spectatorul) {

        listaSpectatori.add(spectatorul);
        spectatorul.setActualizareSumaDeBaniSpectator(filmCurent.getPretBilet());

    }

    public void cumparaBilet(Spectatorul spectatorul, int discount) {
        //memoreaza bani spectator si pretul filmului
        int baniSpectator = spectatorul.getSumaDeBaniSpectator();

        List<String> listSubtitrariFilmActual = filmCurent.getListaSubtitrari();
        String subtitrarePreferataSpectator = spectatorul.getSubtitrarePreferata();

        //compara banii disponibili ai spectatorului cu pretul actualului film
        if (baniSpectator >= filmCurent.getPretBilet()) {
            System.out.println("1.Spectatorul <" + spectatorul.getNumeSpectator() + "> are suma : " + baniSpectator);
            System.out.println("2.Pretul filmului pentru <" + spectatorul.getNumeSpectator() + "> este: " +
                    filmCurent.getPretBilet());
            //cumpara bilet daca corespunde criteriu 1: subtitrare preferata este inclusa in lista de subtitrari a filmului
            if (listSubtitrariFilmActual.contains(subtitrarePreferataSpectator)) {
                //cumpara bilet si implicit adauga spectatorul in lista salii
                System.out.println("3.Pt " + spectatorul.getNumeSpectator() +
                        " se indeplineste criteriul <1> de cumparare a biletului: isi permite biletul si subtitrarea lui preferata coincide cu lista filmului difuzat");
                cumparaBilet(spectatorul);

            }
            //cumpara bilet daca corespunde criteriu 2: subtitrarea preferata nu se potriveste dar Spectatorul isi permite banii
            // respectiv exista sau nu discount
            //cumpara bilet cu discount si implicit adauga spectatorul in lista salii
            else {
                listaSpectatori.add(spectatorul);
                spectatorul.setActualizareSumaDeBaniSpectator(filmCurent.getPretBilet() - discount);
                System.out.println("Pt " + spectatorul.getNumeSpectator() +
                        " - Nu exista subtitrare potrivita...dar poate intra la film cu un discount = " + discount);
                System.out.println("3.Pt " + spectatorul.getNumeSpectator() +
                        " se indeplineste criteriul <2> de cumparare a biletului: isi permite biletul si se aplica discountul de pe bilet: " +
                        discount);

            }

            System.out.println("4.Suma de bani actualizata pt <" + spectatorul.getNumeSpectator() + " > este: " +
                    spectatorul.getSumaDeBaniSpectator());
        }
        //daca Spectatorul nu are suficienti bani
        else {
            System.out.println("ATENTIE ! Bani insuficienti!!!!!!!!!! " + spectatorul.getNumeSpectator() +
                    " nu isi permite sa cumpere  biletul");
        }

    }

    public void returneazaFilmeCuSubtitrareSpecifica(String subtitrare) {
        for (Film film : this.listaFilme) {
            if (film.getListaSubtitrari().contains(subtitrare)) {
                System.out.println(film.getTitluFilm() + " are subtirarea in " + subtitrare);
            }
        }
    }

    public static int getNrMaxLocuri() {
        return NR_MAX_LOCURI;
    }

    public List<Spectatorul> getListaSpectatori() {
        return listaSpectatori;
    }

    public void adaugaFilm(Film filmNou) {
        listaFilme.add(filmNou);
    }

    public void setFilmCurent(Film filmCurent) {
        this.filmCurent = filmCurent;
        filmCurent.setPretBilet();
    }
}
