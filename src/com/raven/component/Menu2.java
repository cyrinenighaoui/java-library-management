package com.raven.component;

import com.raven.event.EventMenuSelected;
import com.raven.main.bot;
import com.raven.modelAbonne.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu2 extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu2() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Voir tous les ouvrages", Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Emprunts", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("3", "Voir tous mes emprunts", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Emprunter Livre", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Retourner Livre", Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Mes commentaires", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("4", "Voir tous mes commentaires", Model_Menu.MenuType.MENU));
               listMenu1.addItem(new Model_Menu("4", "Commenter livre", Model_Menu.MenuType.MENU));

        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Reservation", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("10", "Reserver ouvrage", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("10", "Recuperer ouvrage réservé", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("10", "annuler  reservation", Model_Menu.MenuType.MENU));

           listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Mes notifications", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("4", "Voir notifications", Model_Menu.MenuType.MENU));
       
           listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Mon compte", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("4", "Voir Compte", Model_Menu.MenuType.MENU));
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        listMenu1 = new com.raven.swingAbonne.ListMenu<>();

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
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        bot b=new bot();
        b.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
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
    private com.raven.swingAbonne.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
