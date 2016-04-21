/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package domen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Racun {
    private int racunID;
    private Date datum;
    private double ukupanIznos;
    private PoslovniPartner partner;
    private List<StavkaRacuna> listaStavki;

    public Racun() {
        listaStavki = new ArrayList<>();
    }

    public Racun(int racunID, Date datum, double ukupanIznos, PoslovniPartner partner, List<StavkaRacuna> listaStavki) {
        this.racunID = racunID;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.partner = partner;
        this.listaStavki = new ArrayList<>();
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public PoslovniPartner getPartner() {
        return partner;
    }

    public void setPartner(PoslovniPartner partner) {
        this.partner = partner;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
    public void dodajStavku() {
        listaStavki.add(new StavkaRacuna());
    }
    
    public void obrisiStavku(int rb) {
        listaStavki.remove(rb);
    }
    
    public void pripremiRacun() {
        double ukupanIznos = 0;
        int rb = 0;
        for (StavkaRacuna stavka : listaStavki) {
            rb++;
            stavka.setRb(rb);
            ukupanIznos += stavka.getIznos();
        }
        this.ukupanIznos = ukupanIznos;
    }
}
