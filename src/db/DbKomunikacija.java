/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package db;

import domen.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
        String sql = "SELECT * FROM PoslovniPartner p INNER JOIN Mesto m ON (p.ptt = m.ptt)";
        throw new Exception("Uraditi za domaci");
    }
}
