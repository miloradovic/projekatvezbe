/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package forme.partner;

import domen.Mesto;
import domen.PoslovniPartner;
import forme.partner.model.PartnerTableModel;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Darko
 */
public class FrmUnosPartnera extends javax.swing.JFrame {

    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Creates new form FrmUnosPartnera
     */
    public FrmUnosPartnera() {
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtPartnerID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtNaziv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtPib = new javax.swing.JTextField();
        jtxtMaticni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDatum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtZiroRacun = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtUlica = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtBroj = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbMesto = new javax.swing.JComboBox();
        jbtnSacuvaj = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();
        jbtnDodajRed = new javax.swing.JButton();
        jbtnIzbrisiRed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPartner = new javax.swing.JTable();
        jbtnSacuvajListuPartnera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unos partnera");

        jLabel1.setText("Partner ID:");

        jLabel2.setText("Naziv:");

        jLabel3.setText("PIB:");

        jLabel4.setText("Maticni broj:");

        jLabel5.setText("Datum (dd.MM.yyyy):");

        jLabel6.setText("Ziro racun:");

        jLabel7.setText("Ulica:");

        jLabel8.setText("Broj:");

        jLabel9.setText("Mesto:");

        jcbMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2" }));

        jbtnSacuvaj.setText("Sacuvaj");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        jbtnIzmeni.setText("Izmeni");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        jbtnDodajRed.setText("Dodaj red");
        jbtnDodajRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajRedActionPerformed(evt);
            }
        });

        jbtnIzbrisiRed.setText("Obrisi red");
        jbtnIzbrisiRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzbrisiRedActionPerformed(evt);
            }
        });

        jtblPartner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblPartner);

        jbtnSacuvajListuPartnera.setText("Sacuvaj listu partnera ");
        jbtnSacuvajListuPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajListuPartneraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtPartnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtPib, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtMaticni, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtZiroRacun, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbMesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtBroj, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbtnDodajRed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbtnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jbtnIzbrisiRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jbtnSacuvajListuPartnera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtPartnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtPib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtMaticni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtZiroRacun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSacuvaj)
                    .addComponent(jbtnIzmeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDodajRed)
                    .addComponent(jbtnIzbrisiRed))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jbtnSacuvajListuPartnera)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        try {
            int partnerID = Integer.parseInt(jtxtPartnerID.getText().trim());
            String naziv = jtxtNaziv.getText().trim();
            int pib = Integer.parseInt(jtxtPib.getText().trim());
            int maticni = Integer.parseInt(jtxtMaticni.getText().trim());
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = df.parse(jtxtDatum.getText().trim());
            String ziroRacun = jtxtZiroRacun.getText().trim();
            String ulica = jtxtUlica.getText().trim();
            String broj = jtxtBroj.getText().trim();
            Mesto mesto = (Mesto) jcbMesto.getSelectedItem();
            PoslovniPartner pp = new PoslovniPartner(partnerID, naziv, pib, maticni, datum, ziroRacun, ulica, broj, mesto);

            //Kontroler.getInstance().dodajPartnera(pp);
            JOptionPane.showMessageDialog(this, "Partner je sacuvan.");
        } catch (NumberFormatException | ParseException | HeadlessException e) {
            System.out.println("Greska: " + e.toString());
        } catch (Exception ex) {
            Logger.getLogger(FrmUnosPartnera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        //Todo
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jbtnDodajRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajRedActionPerformed
        PartnerTableModel model = (PartnerTableModel) jtblPartner.getModel();
        model.dodajRed();
    }//GEN-LAST:event_jbtnDodajRedActionPerformed

    private void jbtnSacuvajListuPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajListuPartneraActionPerformed
        try {
            PartnerTableModel model = (PartnerTableModel) jtblPartner.getModel();
            List<PoslovniPartner> lp = model.vratiPartnere();
            //Kontroler.getInstance().sacuvajPartnere(lp);
            JOptionPane.showMessageDialog(this, "Partneri su sacuvani.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Partneri nisu sacuvani.");
        }
    }//GEN-LAST:event_jbtnSacuvajListuPartneraActionPerformed

    private void jbtnIzbrisiRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzbrisiRedActionPerformed
        int red = jtblPartner.getSelectedRow();

        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate odabrati red.");
        } else {
            PartnerTableModel model = (PartnerTableModel) jtblPartner.getModel();
            model.obrisiRed(red);
        }
    }//GEN-LAST:event_jbtnIzbrisiRedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUnosPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUnosPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUnosPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUnosPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUnosPartnera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDodajRed;
    private javax.swing.JButton jbtnIzbrisiRed;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JButton jbtnSacuvajListuPartnera;
    private javax.swing.JComboBox jcbMesto;
    private javax.swing.JTable jtblPartner;
    private javax.swing.JTextField jtxtBroj;
    private javax.swing.JTextField jtxtDatum;
    private javax.swing.JTextField jtxtMaticni;
    private javax.swing.JTextField jtxtNaziv;
    private javax.swing.JTextField jtxtPartnerID;
    private javax.swing.JTextField jtxtPib;
    private javax.swing.JTextField jtxtUlica;
    private javax.swing.JTextField jtxtZiroRacun;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
//        try {
//            List<Mesto> listaMesta = Kontroler.getInstance().vratiMesta();
//            jcbMesto.removeAllItems();
//            for (Mesto m : listaMesta) {
//                jcbMesto.addItem(m);
//            }
//
//            PoslovniPartner pp = (PoslovniPartner) Kontroler.getInstance().get("izabrani_partner");
//            if (pp != null) {
//                // Operacija je izmena
//                jbtnSacuvaj.setVisible(false);
//                jtxtPartnerID.setText(String.valueOf(pp.getPartnerID()));
//                jtxtNaziv.setText(pp.getNaziv());
//                jtxtPib.setText(String.valueOf(pp.getPib()));
//                jtxtMaticni.setText(String.valueOf(pp.getMaticniBroj()));
//                //jtxtDatum.setText(pp.getDatumOsnivanja().toString());
//                jtxtDatum.setText(DATE_FORMAT.format(pp.getDatumOsnivanja()));
//                jtxtZiroRacun.setText(pp.getZiroRacun());
//                jtxtUlica.setText(pp.getUlica());
//                jtxtBroj.setText(pp.getBroj());
//                jcbMesto.setSelectedItem(pp.getMesto());
//                Kontroler.getInstance().remove("izabrani_partner");
//            } else {
//                // Operacija je unos
//                jbtnIzmeni.setVisible(false);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }
    }
}
