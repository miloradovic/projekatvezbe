/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package forme.partner.model;

import domen.Mesto;
import domen.PoslovniPartner;
import java.text.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Darko
 */
public class PartnerTableModel extends AbstractTableModel {

    private List<PoslovniPartner> listaPartnera;
    private final String[] KOLONE = new String[]{"PartnerID", "Naziv", "PIB", "MB", "Datum", "ZR", "Ulica", "Broj", "Mesto"};
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public PartnerTableModel(List<PoslovniPartner> listaPartnera) {
        this.listaPartnera = listaPartnera;
    }

    @Override
    public int getRowCount() {
        if (listaPartnera == null) {
            return 0;
        }
        return listaPartnera.size();
    }

    @Override
    public int getColumnCount() {
        return KOLONE.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoslovniPartner pp = listaPartnera.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pp.getPartnerID();
            case 1:
                return pp.getNaziv();
            case 2:
                return pp.getPib();
            case 3:
                return pp.getMaticniBroj();
            case 4:
                return pp.getDatumOsnivanja();
            case 5:
                return pp.getZiroRacun();
            case 6:
                return pp.getUlica();
            case 7:
                return pp.getBroj();
            case 8:
                return pp.getMesto();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return KOLONE[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return true;
        }
        return super.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PoslovniPartner pp = listaPartnera.get(rowIndex);
        switch (columnIndex) {
            case 0:
                pp.setPartnerID(Integer.parseInt((String) aValue));
                break;
            case 1:
                pp.setNaziv((String) aValue);
                break;
            case 2:
                pp.setPib(Integer.parseInt((String) aValue));
                break;
            case 3:
                pp.setMaticniBroj(Integer.parseInt((String) aValue));
                break;
            case 4:
                try {
                    pp.setDatumOsnivanja(DATE_FORMAT.parse((String) aValue));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;
            case 5:
                pp.setZiroRacun((String) aValue);
                break;
            case 6:
                pp.setUlica((String) aValue);
                break;
            case 7:
                pp.setBroj((String) aValue);
                break;
            case 8:
                pp.setMesto((Mesto) aValue);
                break;
        }
    }

    public PoslovniPartner getPartner(int red) {
        return listaPartnera.get(red);
    }

    public void dodajRed() {
        listaPartnera.add(new PoslovniPartner());
        System.out.println("Dodat je novi partner.");
        fireTableDataChanged();
    }
    
    public void obrisiRed(int red) {
        listaPartnera.remove(red);
        System.out.println("Obrisan je red.");
        fireTableDataChanged();
    }
    
    public List<PoslovniPartner> vratiPartnere() {
        return listaPartnera;
    }
    
}
