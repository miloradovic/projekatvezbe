/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package poslovnalogika;

import domen.PoslovniPartner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darko
 */
public class KolekcijaPartnera {

    private List<PoslovniPartner> listaPartnera;

    public KolekcijaPartnera() {
        listaPartnera = new ArrayList<>();
    }

    public void dodajPartnera(PoslovniPartner pp) {
        listaPartnera.add(pp);
    }

    public List<PoslovniPartner> vratiPartnere() {
        return listaPartnera;
    }
}
