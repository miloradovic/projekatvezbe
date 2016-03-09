/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package poslovnalogika;

import domen.Mesto;
import domen.PoslovniPartner;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Kontroler {

    private KolekcijaMesta kolekcijaMesta;
    private KolekcijaPartnera kolekcijaPartnera;
    private static Kontroler instance;

    private Kontroler() {
        kolekcijaMesta = new KolekcijaMesta();
        kolekcijaPartnera = new KolekcijaPartnera();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public void dodajPartnera(PoslovniPartner pp) {
        kolekcijaPartnera.dodajPartnera(pp);
    }

    public List<PoslovniPartner> vratiPartnere() {
        return kolekcijaPartnera.vratiPartnere();
    }

    public void dodajMesto(Mesto m) {
        kolekcijaMesta.dodajMesto(m);
    }

    public List<Mesto> vratiMesta() {
        return kolekcijaMesta.vratiMesta();
    }
}
