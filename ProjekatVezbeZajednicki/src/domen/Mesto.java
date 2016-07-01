/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package domen;

/**
 *
 * @author Darko
 */
public class Mesto {

    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return ptt + " - " + naziv;
    }

}
