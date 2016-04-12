/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package poslovnalogika;

import db.DbKomunikacija;
import domen.Mesto;
import domen.PoslovniPartner;
import java.util.*;

/**
 *
 * @author Darko
 */
public class Kontroler {

    private KolekcijaMesta kolekcijaMesta;
    private KolekcijaPartnera kolekcijaPartnera;
    private DbKomunikacija db;
    private static Kontroler instance;
    private Map<String, Object> map;

    private Kontroler() {
        kolekcijaMesta = new KolekcijaMesta();
        kolekcijaPartnera = new KolekcijaPartnera();
        db = new DbKomunikacija();
        map = new HashMap<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public void dodajPartnera(PoslovniPartner pp) throws Exception {
        //kolekcijaPartnera.dodajPartnera(pp);
        db.ucitajDriver();
        db.otvoriKonekciju();
        db.sacuvajPartnera(pp);
        db.commitTransakcije();
        db.zatvoriKonekciju();
    }

    public List<PoslovniPartner> vratiPartnere() {
        return kolekcijaPartnera.vratiPartnere();
    }

    public void dodajMesto(Mesto m) {
        kolekcijaMesta.dodajMesto(m);
    }

    public List<Mesto> vratiMesta() throws Exception {
        //return kolekcijaMesta.vratiMesta();
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Mesto> lm = db.vratiMesta();
        db.commitTransakcije();
        db.zatvoriKonekciju();

        return lm;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }

    public void sacuvajPartnere(List<PoslovniPartner> lp) throws Exception {
        try {
            db.ucitajDriver();
            db.otvoriKonekciju();
            for (PoslovniPartner p : lp) {
                db.sacuvajPartnera(p);
                System.out.println("Sacuvao parnterID = " + p.getPartnerID());
            }
            db.commitTransakcije();
        } catch (Exception ex) {
            db.rollbackTransakcije();
        } finally {
            db.zatvoriKonekciju();
        }
    }
}
