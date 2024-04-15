package com.raven.formAbonne;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.xdevapi.JsonParser;
import com.raven.form.*;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.awt.image.BufferedImage;
import com.raven.formAbonne.Book;
import com.raven.main.LIBRAIRIE;
import static com.raven.service.ServiceUser.userID;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

public class Form_Home1 extends javax.swing.JPanel {

    public Form_Home1() {
        initComponents();
        recommandation();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Stock Total", "$200000", "Increased by 60%"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Total Profit", "$15000", "Increased by 25%"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Unique Visitors", "$300000", "Increased by 70%"));
        //  add row table
     
 /* Vector<Emprunt> ve=new Vector<>();
    AbonneService as=new AbonneService();
    ve=as.getAllMesEmpruntsActuels(1);
    int nbre_emprunt=ve.size();
    ve=as.getAllMesEmpruntsRetardés(1);
    int nbre_emprunt_retarde=ve.size();
     Vector<Commentaire> ve1=new Vector<>();
    ve1=as.getAllMesCommentaires(1);
    int nbre_commentaire=ve.size();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "nbre de livres empruntés",nbre_emprunt+"" , ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "nbre de livre retardé",nbre_emprunt_retarde+"" , ""));
            card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "nbre d'ouvrage que vous avez commenté",nbre_commentaire+"" , ""));
       */
    }
   public void recommandation()
   {
              connect();

        String livre_lu;
        livre_lu=livre_lu(30);
        if (livre_lu!=null)
        {
       
        System.out.println("----------------------------------------------------------------********");
        System.out.println(livre_lu);
        livrelu.setText(livre_lu);
        
       HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("http://127.0.0.1:5000/api/recommend_books"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString("{\"user_input\":\"" + livre_lu + "\"}"))
        .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + jsonResponse);

            // Désérialisation du JSON en objets Javaj=
        Gson gson = new Gson();
        Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
        List<Book> books = gson.fromJson(jsonResponse, bookListType);
            int i=0;
            for (Book book : books) {
                String titre=book.getTitle();
                String auteur = book.getAuthor();
                URL im=new URL(book.getImageUrl());
               
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Image URL: " + book.getImageUrl());
                if(i==0)
                {
                    auteur1.setText(auteur);
                    titre1.setText(titre); 
                    setImageFromUrlAsync(image1, book.getImageUrl());
                    
                }
                else if(i==1)
                {
                    auteur2.setText(auteur);
                    titre2.setText(titre);    
                                   setImageFromUrlAsync(image2, book.getImageUrl());

                }
                else if (i==2)
                {
                    auteur3.setText(auteur);
                    titre3.setText(titre);
                                   setImageFromUrlAsync(image3, book.getImageUrl());

                }
                i++;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else 
        {
            
        System.out.println("----------------------------------------------------------------********");
       jLabel1.setText("Nous vous recommendons de lire");
        
       HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("http://127.0.0.1:5000/api/recommend_books"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString("{\"user_input\":\"1st to Die: A Novel\"}"))
        .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + jsonResponse);

            // Désérialisation du JSON en objets Javaj=
        Gson gson = new Gson();
        Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
        List<Book> books = gson.fromJson(jsonResponse, bookListType);
            int i=0;
            for (Book book : books) {
                String titre=book.getTitle();
                String auteur = book.getAuthor();
                URL im=new URL(book.getImageUrl());
               
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Image URL: " + book.getImageUrl());
                if(i==0)
                {
                    auteur1.setText(auteur);
                    titre1.setText(titre); 
                    setImageFromUrlAsync(image1, book.getImageUrl());
                    
                }
                else if(i==1)
                {
                    auteur2.setText(auteur);
                    titre2.setText(titre);    
                                   setImageFromUrlAsync(image2, book.getImageUrl());

                }
                else if (i==2)
                {
                    auteur3.setText(auteur);
                    titre3.setText(titre);
                                   setImageFromUrlAsync(image3, book.getImageUrl());

                }
                i++;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
            
        }
    
       
   }
   public void connect()
   {
               HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:5000/api/recommend_books"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"user_input\":\"1st to Die: A Novel\"}"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + jsonResponse);

            // Désérialisation du JSON en objets Java
          Gson gson = new Gson();
        Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
        List<Book> books = gson.fromJson(jsonResponse, bookListType);            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Image URL: " + book.getImageUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
   
    private void setImageFromUrlAsync(JLabel label, String imageUrl) {
    new SwingWorker<ImageIcon, Void>() {
   @Override
protected ImageIcon doInBackground() throws Exception {
    try {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
        
        BufferedImage image = ImageIO.read(connection.getInputStream());
        if (image != null) {
            // Agrandir l'image
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Ajustez 500x500 à la taille désirée
            
            // Si vous voulez sauvegarder l'image agrandie localement
            BufferedImage bufferedResizedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            bufferedResizedImage.getGraphics().drawImage(resizedImage, 0, 0 , null);
            File outputFile = new File("saved_resized_image.jpg");
            ImageIO.write(bufferedResizedImage, "jpg", outputFile);
            System.out.println("Image chargée, agrandie et sauvegardée avec succès.");
            
            // Retourner l'ImageIcon agrandie
            return new ImageIcon(resizedImage);
        }
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement ou de l'agrandissement de l'image: " + e.getMessage());
        e.printStackTrace();
    }
    // Retourner null ou un ImageIcon par défaut si l'image n'a pas pu être chargée ou agrandie
    return null;
}



        @Override
        protected void done() {
            try {
                ImageIcon result = get();
                if (result != null) {
                    label.setIcon(result);
                    label.setText(""); // Enlever le texte si l'image est chargée
                } else {
                    label.setText("Image non disponible");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                label.setText("Erreur de chargement");
            }
        }
    }.execute();
}
    public String livre_lu(int abonne_id)
    {
        String sql = "SELECT o.titre_ouvrage  as titre_ouvrage  FROM emprunt e  JOIN ouvrages o ON e.ouvrage_id = o.ouvrage_id WHERE e.abonne_id = ? LIMIT 1;";
        String result=null;
        try (
           Connection conn = LIBRAIRIE.getConnection();

             PreparedStatement pstmt = conn.prepareStatement(sql)) {
              pstmt.setInt(1, abonne_id);
              ResultSet rs = pstmt.executeQuery();
              if (rs.next()) {
                result = rs.getString("titre_ouvrage");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Erreur lors de la récupération du titre du livre : " + e.getMessage();
        }
        
        return result;
    }
               
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        image2 = new javax.swing.JLabel();
        image3 = new javax.swing.JLabel();
        titre2 = new javax.swing.JLabel();
        titre3 = new javax.swing.JLabel();
        auteur1 = new javax.swing.JLabel();
        auteur2 = new javax.swing.JLabel();
        auteur3 = new javax.swing.JLabel();
        titre1 = new javax.swing.JLabel();
        livrelu = new javax.swing.JLabel();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Parceque vous avez lu");

        image1.setText("jLabel2");

        image2.setText("jLabel3");

        image3.setText("jLabel4");

        titre2.setText("livre");

        titre3.setText("livre");

        auteur1.setText("auteur");

        auteur2.setText("auteur");

        auteur3.setText("auteur");

        titre1.setText("livre");

        livrelu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(auteur1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(titre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(auteur2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titre2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(auteur3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(titre3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(93, 93, 93))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(livrelu, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(livrelu))
                .addGap(59, 59, 59)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(image1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(image3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(image2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titre2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titre3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(auteur2))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(auteur3))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(auteur1)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel auteur1;
    private javax.swing.JLabel auteur2;
    private javax.swing.JLabel auteur3;
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel image3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel livrelu;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JLabel titre1;
    private javax.swing.JLabel titre2;
    private javax.swing.JLabel titre3;
    // End of variables declaration//GEN-END:variables
}
