/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package db;

import domen.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darko
 */
public class DbKomunikacija {

    private Connection connection;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neuspesno ucitavanje drivera!", ex);
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/poslovnipartneri",
                    "root",
                    "root");
            connection.setAutoCommit(false); // Zahteva eksplicitnu potvrdu transakcije
        } catch (SQLException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije.", ex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije.", ex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }

    public List<Mesto> vratiMesta() throws Exception {
        try {
            List<Mesto> lm = new ArrayList<>();
            String sql = "SELECT * FROM Mesto";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int ptt = rs.getInt(1);
                String naziv = rs.getString(2);
                lm.add(new Mesto(ptt, naziv));
            }
            rs.close();
            sqlStatement.close();

            return lm;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje mesta!", ex);
        }

    }

    public void sacuvajPartnera(PoslovniPartner pp) throws Exception {
        try {
            String sql = "INSERT INTO PoslovniPartner VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, pp.getPartnerID());
            sqlStatement.setString(2, pp.getNaziv());
            sqlStatement.setInt(3, pp.getPib());
            sqlStatement.setInt(4, pp.getMaticniBroj());
            sqlStatement.setDate(5, new java.sql.Date(pp.getDatumOsnivanja().getTime()));
            sqlStatement.setString(6, pp.getZiroRacun());
            sqlStatement.setString(7, pp.getUlica());
            sqlStatement.setString(8, pp.getBroj());
            sqlStatement.setInt(9, pp.getMesto().getPtt());
            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno cuvanje partnera!", ex);
        }
    }

    public List<PoslovniPartner> vratiPartnere() throws Exception {
        try {
            List<PoslovniPartner> lp = new ArrayList<>();
            String sql = "SELECT p.*, m.Naziv FROM PoslovniPartner p INNER JOIN Mesto m ON (p.ptt = m.ptt)";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int partnerID = rs.getInt("PartnerID");
                String naziv = rs.getString(2);
                int pib = rs.getInt("Pib");
                int maticniBroj = rs.getInt("MaticniBroj");
                java.util.Date datumOsnivanja = new java.util.Date(rs.getDate("DatumOsnivanja").getTime());
                String ziroRacun = rs.getString("ZiroRacun");
                String ulica = rs.getString("Ulica");
                String broj = rs.getString("Broj");
                int ptt = rs.getInt("Ptt");
                String nazivMesta = rs.getString(10);
                Mesto m = new Mesto(ptt, nazivMesta);
                PoslovniPartner p = new PoslovniPartner(partnerID, naziv, pib, maticniBroj, datumOsnivanja, ziroRacun, ulica, broj, m);
                lp.add(p);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje partnera!", ex);
        }
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        try {
            String sql = "SELECT * FROM Proizvod";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            List<Proizvod> lp = new ArrayList<>();
            while (rs.next()) {
                int proizvodID = rs.getInt("ProizvodID");
                String naziv = rs.getString(2); //Naziv iz tabele ili redni broj
                double cena = rs.getDouble("Cena");
                Proizvod p = new Proizvod(proizvodID, naziv, cena);
                lp.add(p);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje proizvoda", ex);
        }

    }

    public void sacuvajRacun(Racun racun) throws Exception {
        try {
            String sql = "INSERT INTO Racun VALUES (?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, racun.getRacunID());
            sqlStatement.setDate(2, new java.sql.Date(racun.getDatum().getTime()));
            sqlStatement.setDouble(3, racun.getUkupanIznos());
            sqlStatement.setInt(4, racun.getPartner().getPartnerID());
            sqlStatement.executeUpdate();

            String sql2 = "INSERT INTO StavkaRacuna VALUES (?,?,?,?,?)";
            PreparedStatement sqlStatement2 = connection.prepareStatement(sql2);
            for (StavkaRacuna stavka : racun.getListaStavki()) {
                sqlStatement2.setInt(1, racun.getRacunID());
                sqlStatement2.setInt(2, stavka.getRb());
                sqlStatement2.setInt(3, stavka.getKolicina());
                sqlStatement2.setDouble(4, stavka.getIznos());
                sqlStatement2.setInt(5, stavka.getProizvod().getProizvodID());
                sqlStatement2.executeUpdate();
            }
            sqlStatement.close();
            sqlStatement2.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno cuvanje racuna", ex);
        }
    }
}
