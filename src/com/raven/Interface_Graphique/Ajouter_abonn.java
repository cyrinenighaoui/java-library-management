/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.Interface_Graphique;

import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.raven.projet_java_s2.abonne;
import com.raven.projet_java_s2.employee_service;
import com.raven.go.Tools;
import com.raven.go_db.tools_db;
import static com.raven.go_db.tools_db.con;
import static com.raven.service.ServiceUser.userID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author saif
 */
public class Ajouter_abonn extends javax.swing.JFrame {
    public Ajouter_abonn() {
        initComponents();
                getContentPane().setBackground(Color.WHITE);

    }
     static public int last_id;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCin = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        Warning1 = new javax.swing.JLabel();
        Warning2 = new javax.swing.JLabel();
        Warning3 = new javax.swing.JLabel();
        Warning4 = new javax.swing.JLabel();
        Warning5 = new javax.swing.JLabel();
        Warning6 = new javax.swing.JLabel();
        Warning7 = new javax.swing.JLabel();
        Warning9 = new javax.swing.JLabel();
        Warning10 = new javax.swing.JLabel();
        txtType = new javax.swing.JComboBox<>();
        date1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("Ajouter Abonnee");

        jLabel3.setText("CIN");

        jLabel4.setText("Nom");

        jLabel6.setText("Prenom");

        jLabel10.setText("Date de Naissnace");

        jLabel11.setText("Type d'abonnement");

        txtCin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCinActionPerformed(evt);
            }
        });

        txtPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomActionPerformed(evt);
            }
        });

        btnAdd.setText("Ajouter");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnShow.setText("retourner");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        Warning1.setForeground(new java.awt.Color(255, 0, 0));

        Warning2.setForeground(new java.awt.Color(255, 255, 255));

        Warning3.setForeground(new java.awt.Color(255, 255, 255));

        Warning4.setForeground(new java.awt.Color(255, 0, 0));

        Warning5.setForeground(new java.awt.Color(255, 0, 0));

        Warning6.setForeground(new java.awt.Color(255, 0, 0));

        Warning7.setForeground(new java.awt.Color(255, 0, 0));

        Warning9.setForeground(new java.awt.Color(255, 0, 0));

        Warning10.setForeground(new java.awt.Color(255, 0, 0));

        txtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "normal", "premium" }));
        txtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(Warning1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Warning3)
                        .addGap(45, 45, 45)
                        .addComponent(Warning2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCin)
                                            .addComponent(txtPrenom)
                                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Warning9)
                            .addComponent(Warning5)
                            .addComponent(Warning4)
                            .addComponent(Warning7)
                            .addComponent(Warning6)
                            .addComponent(Warning10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnShow)))
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Warning2)
                    .addComponent(Warning3)
                    .addComponent(Warning1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Warning10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(Warning9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Warning4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Warning5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel10))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Warning6)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Warning7)
                .addGap(51, 51, 51)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnShow)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        abonne a = new abonne(0);
        boolean pass=true;
        
       
        if((!com.raven.go.Tools.verifNumeric(txtCin.getText())) || txtCin.getText().length()!=8)
        {
            txtCin.setText("");
            Warning10.setText("Valeur Non Valide");
            Warning10.setForeground(Color.RED);
            pass=false;
        }
        else{
            Warning10.setText("Valeur Valide");
            Warning10.setForeground(Color.GREEN);
        }
        if(!com.raven.go.Tools.verifAlpha(txtNom.getText()) || txtNom.getText().isEmpty())
        {
            txtNom.setText("");
            Warning4.setText("Valeur Non Valide");
            Warning4.setForeground(Color.RED);
            pass=false;
        }
        else{
            Warning4.setText("Valeur Valide");
            Warning4.setForeground(Color.GREEN);
        }
        if(!com.raven.go.Tools.verifAlpha(txtPrenom.getText())|| txtNom.getText().isEmpty())
        {
            txtPrenom.setText("");
            Warning9.setText("Valeur Non Valide");
            Warning9.setForeground(Color.RED);
            pass=false;
        }
        else{
            Warning9.setText("Valeur Valide");
            Warning9.setForeground(Color.GREEN);
        }
        try{
        if(date1.getDate().after(java.sql.Date.valueOf(LocalDate.now())) || null==date1.getDate())
        {
            date1.setDate(null);
            Warning5.setText("Valeur Non Valide");
            Warning5.setForeground(Color.RED);
            pass=false;
        }
        else{
            Warning5.setText("Valeur Valide");
            Warning5.setForeground(Color.GREEN);
        }
        }catch(Exception ex)
        {
            date1.setDate(null);
            Warning5.setText("Valeur Non Valide");
            Warning5.setForeground(Color.RED);
            pass=false;
        }
        String item =(String)txtType.getSelectedItem();
        String abb ;
        if(!com.raven.go.Tools.verifAbonnement(item))
        {
            Warning6.setText("Valeur Non Valide");
            Warning6.setText(item);
            Warning6.setForeground(Color.RED);
            pass=false;
        }
        else{
            switch (item) {
                case "normal":
                    abb="normal";
                    break;
                case "premium":
                    abb="premium";
                    break;
            }
            Warning6.setText("Valeur Valide");

            Warning6.setForeground(Color.GREEN);
        }
        
       
        if(pass==true)
        {
            
            LocalDate date_deb=LocalDate.now();
             LocalDate date_fin=LocalDate.now().plusYears(1);
            a.setCin(Integer.parseInt(txtCin.getText()));
            a.setDate_debut_abonnement(date_deb);
            a.setDate_fin_abonnement(date_fin);
            a.setDate_naissance(date1.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
            a.setNom(txtNom.getText());
            a.setPrenom(txtPrenom.getText());
            a.setType_abonnement(item);
            employee_service.insert_abonne(a);
            employee_service.insert_action("Insert",a.getAbonne_id(),userID);
            Mailmdp m=new Mailmdp();
          
            m.setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Fill the Form correctly");
        }
        
    
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        this.dispose();
        Consulter_Abonne form = new Consulter_Abonne();
        form.setVisible(true);
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTypeActionPerformed

    private void txtPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomActionPerformed

    private void txtCinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinActionPerformed
      
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
            java.util.logging.Logger.getLogger(Ajouter_abonn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter_abonn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter_abonn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter_abonn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajouter_abonn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Warning1;
    private javax.swing.JLabel Warning10;
    private javax.swing.JLabel Warning2;
    private javax.swing.JLabel Warning3;
    private javax.swing.JLabel Warning4;
    private javax.swing.JLabel Warning5;
    private javax.swing.JLabel Warning6;
    private javax.swing.JLabel Warning7;
    private javax.swing.JLabel Warning9;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnShow;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCin;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JComboBox<String> txtType;
    // End of variables declaration//GEN-END:variables
}
