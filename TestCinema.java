package cinemaCity;

import cinemaCity.filme.*;
import cinemaCity.sali.SalaCinema;
import cinemaCity.spectatori.Spectatorul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCinema {
    private int numarSpectatori;
    private List<Spectatorul> spectatoriLaRand;
    private List<String> subtitrariFilm1, subtitrariFilm2, subtitrariFilm3;
    private Film filmInDerulare, filmInAsteptare1, filmInAsteptare2;
    private SalaCinema salaDeFilm;
    private boolean isDscountBun = true;

    public TestCinema(int numarSpectatori, int discount) throws IOException {
        //verifica daca e discount pozitiv
        if (discount >= 0) {
            System.out.println("La ghiseu sunt " + numarSpectatori + " cinefili interesati pentru filmul actual");
            System.out.println("Posibilul discount al biletului este: " + discount);
            //Citeste spectatori la rand din consola:
            int numarMaximSala = SalaCinema.getNrMaxLocuri();
            if (numarSpectatori <= numarMaximSala) {
                this.numarSpectatori = numarSpectatori;
                spectatoriLaRand = new ArrayList<>();

                for (int i = 0; i < numarSpectatori; i++) {
                    System.out.println("Scrie numele sau prenumele, banii si subtitrarea preferata, despartite de un spatiu apoi ENTER: ");
                    BufferedReader inregistreazaSpectatori = new BufferedReader(new InputStreamReader(System.in));
                    String argumenteSpectator[] = inregistreazaSpectatori.readLine().split(" ");
                    String numeSauPrenume = argumenteSpectator[0];
                    String baniSpectator = argumenteSpectator[1];
                    String subtitrarePreferata = argumenteSpectator[2];
                    //verifica daca e discount mai mic sau egal cu suma spectatorului
                    if (Integer.parseInt(baniSpectator) > discount) {
                        spectatoriLaRand.add(new Spectatorul(numeSauPrenume, Integer.parseInt(baniSpectator), subtitrarePreferata));
                    } else {
                        System.out.println("Atentie - Discountul este mult prea mare!!!");
                        isDscountBun = false;
                        break;
                    }
                }
            } else {
                System.out.println("Capacitatea salii de cinema  (maxim " + numarMaximSala + " )  e mai mica fata de numarul de spectatori interesati sa vada filmul!");
            }
        } else {
            System.out.println("Atentie - a fost introdus doscount negativ");
            isDscountBun = false;
        }
        if (isDscountBun == true) {
            adaugaSubtitrariFilm();
            pregatesteFilmePtSala();
            pregatesteSala();
            completareSalaCinema(discount);
        } else {
            System.out.println("Introdu un discount corespnzator!");
        }

    }

    //creeaza subtitrarile disponibile pt fiecare film in parte
    public void adaugaSubtitrariFilm() {
        subtitrariFilm1 = adaugaSubtitrariFilm(new String[]{"Engleza", "Germana", "Romana"});
        subtitrariFilm2 = adaugaSubtitrariFilm(new String[]{"Chineza", "Germana"});
        subtitrariFilm3 = adaugaSubtitrariFilm(new String[]{"Engleza"});
    }

    //returneaza liste cu subtitrari
    public List<String> adaugaSubtitrariFilm(String[] limbiListaSubtitrare) {
        List<String> listaSubtitrare = new ArrayList<>();

        for (int limba = 0; limba < limbiListaSubtitrare.length; limba++) {
            listaSubtitrare.add(limbiListaSubtitrare[limba]);
        }
        return listaSubtitrare;
    }

    //creeaza filmele cu caracteristicile aferente
    public void pregatesteFilmePtSala() {
        filmInDerulare = pregatesteFilmePtSala("actiune", "Terminator1", subtitrariFilm1, "4DX");
        filmInAsteptare1 = pregatesteFilmePtSala("comedie", "Terminator2", subtitrariFilm2, "7D");
        filmInAsteptare2 = pregatesteFilmePtSala("groaza", "Terminator3", subtitrariFilm3, "IMAX");
    }

    //returneaza filmul cu genul corespunzator
    public Film pregatesteFilmePtSala(String genFilm, String titluFilm, List<String> subtitrare, String efect) {
        Film film = null;
        if (genFilm == "actiune") {
            film = new FilmDeActiune(titluFilm, subtitrare, efect);
        } else if (genFilm == "comedie") {
            film = new FilmDeComedie(titluFilm, subtitrare, efect);
        } else if (genFilm == "groaza") {
            film = new FilmDeGroaza(titluFilm, subtitrare, efect);
        } else {
            System.out.println("Gen Film incorect");

        }
        return film;
    }

    //adaugare  filme la lista de filme a salii si setare film curent
    public void pregatesteSala() {
        salaDeFilm = new SalaCinema();
        salaDeFilm.adaugaFilm(filmInDerulare);
        salaDeFilm.adaugaFilm(filmInAsteptare1);
        salaDeFilm.adaugaFilm(filmInAsteptare2);
        salaDeFilm.setFilmCurent(filmInDerulare);
    }

    //creeaza lista de spectatori care isi permit biletul si au dreptul de acces in sala
    public void completareSalaCinema(int discount) {
        for (int i = 0; i < numarSpectatori; i++) {
            System.out.println("##################### " + (i + 1) + " este numarul de ordine al spectatorului: " + spectatoriLaRand.get(i));

            Spectatorul spectatorLaGhiseu = spectatoriLaRand.get(i);
            salaDeFilm.cumparaBilet(spectatorLaGhiseu, discount);
        }

        // System.out.println("Spectatorii din sala sunt :" + salaDeFilm.getListaSpectatori());
        Iterator it = salaDeFilm.getListaSpectatori().iterator();
        while (it.hasNext()) {
            System.out.println("Spectatorii din sala sunt :");
            System.out.println(it.next());
        }
        System.out.println("Filmele disponibile in limba Engleza sunt : ");
        salaDeFilm.returneazaFilmeCuSubtitrareSpecifica("Engleza");
    }

    public static void main(String[] args) throws IOException {
        //discount prin consola (nr de spectatori in functie de cati sunt introdusi de la consola)
       new TestCinema(3, 1);
        //Film x=new FilmDeActiune("titlu",null,"4DX");

    }
}

