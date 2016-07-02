/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package forme.racun.model;

import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class RacunTableModel extends AbstractTableModel {

    private Racun racun;
    private final String[] kolone = {"Proizvod", "Kolicina", "Iznos"};

    public RacunTableModel(Racun racun) {
        this.racun = racun;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    @Override
    public int getRowCount() {
        if (racun != null && racun.getListaStavki() != null) {
            return racun.getListaStavki().size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna stavka = racun.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getProizvod();
            case 1:
                return stavka.getKolicina();
            case 3:
                return stavka.getIznos();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2) {
            return false;
        }
        return true;
    }

    public void dodajStavku() {
        racun.dodajStavku();
        fireTableDataChanged();
    }

    public void obrisiStavku(int red) {
        racun.obrisiStavku(red);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRacuna stavka = racun.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                stavka.setProizvod((Proizvod) aValue);
                stavka.setIznos(stavka.getKolicina() * stavka.getProizvod().getCena());
                fireTableCellUpdated(rowIndex, columnIndex + 2);
                break;
            case 1:
                stavka.setKolicina(Integer.parseInt((String) aValue));
                stavka.setIznos(stavka.getKolicina() * stavka.getProizvod().getCena());
                fireTableCellUpdated(rowIndex, columnIndex + 1);
            case 2:
                // Ovo ne moze da se promeni
                break;
        }
    }

}
