/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package forme.partner;

import domen.PoslovniPartner;
import forme.partner.model.PartnerTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import util.Util;

/**
 *
 * @author Darko
 */
public class FrmPrikazPartnera extends javax.swing.JPanel {

    /**
     * Creates new form FrmPrikazPartnera
     */
    public FrmPrikazPartnera() {
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
        jcbPartner = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPartner = new javax.swing.JTable();
        jbtnDetalji = new javax.swing.JButton();

        jLabel1.setText("Partneri:");

        jcbPartner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtblPartner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PartnerID", "Naziv", "PIB", "Maticni broj", "Datum", "Ziro racun", "Ulica", "Broj", "Mesto"
            }
        ));
        jScrollPane1.setViewportView(jtblPartner);

        jbtnDetalji.setText("Detalji");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jcbPartner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnDetalji)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jbtnDetalji)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        int red = jtblPartner.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate odabrati partnera.");
        } else {
            PartnerTableModel model = (PartnerTableModel) jtblPartner.getModel();
            PoslovniPartner pp = model.getPartner(red);
            Util.getInstance().put("izabrani_partner", pp);
            FrmUnosPartnera formaUnos = new FrmUnosPartnera();
            JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
            dialog.dispose();
            formaUnos.setVisible(true);
        }
    }//GEN-LAST:event_jbtnDetaljiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JComboBox<String> jcbPartner;
    private javax.swing.JTable jtblPartner;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            List<PoslovniPartner> listaPartnera = new ArrayList<>();
            jcbPartner.setModel(new DefaultComboBoxModel(listaPartnera.toArray()));

            PartnerTableModel model = new PartnerTableModel(listaPartnera);
            jtblPartner.setModel(model);

            /* --Prevazidjena implementacija--
            DefaultTableModel model = (DefaultTableModel) jtblPartner.getModel();
            for (PoslovniPartner pp : listaPartnera) {
            Object[] red = new Object[9];
            red[0] = pp.getPartnerID();
            red[1] = pp.getNaziv();
            red[2] = pp.getPib();
            red[3] = pp.getMaticniBroj();
            red[4] = pp.getDatumOsnivanja();
            red[5] = pp.getZiroRacun();
            red[6] = pp.getUlica();
            red[7] = pp.getBroj();
            red[8] = pp.getMesto();
            model.addRow(red);
        }
             */
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
