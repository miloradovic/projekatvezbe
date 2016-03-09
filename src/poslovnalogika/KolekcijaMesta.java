/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package poslovnalogika;

import domen.Mesto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darko
 */
public class KolekcijaMesta {
    private List<Mesto> listaMesta;

    public KolekcijaMesta() {
        listaMesta = new ArrayList<>();
    }
    
    public void dodajMesto(Mesto m) {
        listaMesta.add(m);
    }
    
    public List<Mesto> vratiMesta() {
        return listaMesta;
    }
}
