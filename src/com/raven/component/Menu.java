package com.raven.component;

import com.raven.event.EventMenuSelected;
import com.raven.main.bot;
import com.raven.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);

    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Tous les ouvrages", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Tous les employee", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Tous les emprunts", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Toutes  les reservations", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", "Manipuler Ouvrage", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("3", "Ajouter ouvrage ", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("4", "Supprimer ouvrage", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "Modifier Prix ouvrage", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "Signaler Vol", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", " Employee et abonne", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("6", "Manipuler abonne", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("6", "Manipuler Employe", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", "Emprunts", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("9", "Ajouter Emprunt", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("10", "Retourner Ouvrage", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("1", "Reserver ouvrage", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("10", "Recuperer Ouvrage Reserve", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", "Blackliste", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("1", "Consulter Blackliste", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "Historique", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("1", "Voir  historique", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("1", "Voir  Reclamations", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "Compte", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("1", "Voir compte", Model_Menu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.raven.swing.ListMenu<>();
        jToggleButton1 = new javax.swing.JToggleButton();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MCWS");

        jToggleButton1.setText("BOT");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(103, 103, 103))
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 624, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:ù
        bot b=new bot();
        b.setVisible(true);

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#b82853"), 0, getHeight(), Color.decode("#b82853"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;
    
    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private com.raven.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
