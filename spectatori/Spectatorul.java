package cinemaCity.spectatori;


public class Spectatorul {
    private String numeSpectator;
    private int sumaDeBaniSpectator;
    private String subtitrarePreferata;

    public Spectatorul(String numeSpectator, int sumaDeBaniSpectator, String subtitrarePreferata) {
        this.numeSpectator = numeSpectator;
        this.sumaDeBaniSpectator = sumaDeBaniSpectator;
        this.subtitrarePreferata = subtitrarePreferata;
    }

    public String getNumeSpectator() {
        return numeSpectator;
    }

    public int getSumaDeBaniSpectator() {
        return this.sumaDeBaniSpectator;
    }

    public void setActualizareSumaDeBaniSpectator(int pretBilet) {
        this.sumaDeBaniSpectator = this.sumaDeBaniSpectator - pretBilet;
    }

    public String getSubtitrarePreferata() {
        return subtitrarePreferata;
    }

    @Override
    public String toString() {
        return "Spectatorul{" +
                "numeSpectator='" + numeSpectator + '\'' +
                ", sumaDeBaniSpectator=" + sumaDeBaniSpectator +
                ", subtitrarePreferata='" + subtitrarePreferata + '\'' +
                '}';
    }
}
