/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package domen;

/**
 *
 * @author Darko
 */
public class Proizvod {
    private int proizvodID;
    private String naziv;
    private double cena;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, String naziv, double cena) {
        this.proizvodID = proizvodID;
        this.naziv = naziv;
        this.cena = cena;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {        
        if (obj != null && obj instanceof Proizvod) {
            Proizvod p = (Proizvod) obj;
            return p.getProizvodID() == this.getProizvodID();
        }
        return false;
    }
    
    
}
