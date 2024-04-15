/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

import static biblio.EmployeService.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class AbonneService implements AbonneDAOInterface,CommunInterface{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    @Override
    public Ouvrage getOuvrage(int id) {
        Connection con=getConnection();
        String sql="select * from ouvrages where ouvrage_id=?";
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	pstm.setInt(1,id);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                case "livre" :
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return o;
    }

    public Vector<Ouvrage> getOuvrageByLangue(String titre) {
        Connection con=getConnection();
        String sql="select * from ouvrages where langue =? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,titre);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
              case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;
    }
    @Override
    public Vector<Ouvrage> getAllOuvrages() {
        Connection con=getConnection();
        String sql="select * from ouvrages ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;
    }

    @Override
    public Vector<Ouvrage> getAllOuvragesByType(String type) {
        Connection con=getConnection();
        String sql="select * from ouvrages where type_ouvrage=? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,type);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
               case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;
    }
    @Override
    public Vector<Ouvrage> getAllOuvragesByGenre(String genre) {
        Connection con=getConnection();
        String sql="select * from ouvrages where genre=? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,genre);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;
    }

    @Override
    public Vector<Ouvrage> getOuvrageByTitle(String titre) {
        Connection con=getConnection();
        String sql="select * from ouvrages where titre like ? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,"%"+titre+"%");
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                 case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;
    }

    public String emprunter(Emprunt e) {
        Connection con=getConnection();
        String x="";
        int id_abonne_prio=0;
        Boolean verif=true;
        String sql3="select abonne_id from ouvrage_reserve where ordre_attente=1 and ouvrage_id=?";
        String sql1="insert into emprunt (ouvrage_id,abonne_id,date_debut,date_fin_prevu,date_fin_effective,etat,retard,amende)values(?,?,?,?,?,?,0,0)";
        String sql2="update ouvrages set etat='emprunté',disponibilite=false where ouvrage_id=?";
        ResultSet rs1;
        int rowCount1=0;
        int rowCount2=0;
        if(verifier_abonne(e.getAbonne().getId()))
        {
        try{
            if((!e.getOuvrage().getEtat().equalsIgnoreCase("disponible"))){
            PreparedStatement pstm3=con.prepareStatement(sql3);
            pstm3.setInt(1, e.getOuvrage().getId());
            rs1=pstm3.executeQuery();
            if(rs1.next()){
            id_abonne_prio=rs1.getInt("abonne_id");
            if(e.getAbonne().getId()!=id_abonne_prio){
                verif=false;
                x="cet ouvrage est déjà emprunté ou réservé";
            }}
            }
            if(verif){
            PreparedStatement pstm1=con.prepareStatement(sql1);
            pstm1.setInt(1, e.getOuvrage().getId());
            pstm1.setInt(2, e.getAbonne().getId());
            pstm1.setObject(3, e.getDate_debut());
            pstm1.setObject(4, e.getDate_fin_prevue());
            pstm1.setObject(5, e.getDate_fin_effective());
            pstm1.setString(6, e.getEtat());
            rowCount1=pstm1.executeUpdate();
            PreparedStatement pstm2=con.prepareStatement(sql2);
            pstm2.setInt(1, e.getOuvrage().getId());
            rowCount2=pstm2.executeUpdate();
            if(rowCount1 >0 && rowCount2 >0){
                x="Emprunt effectué avec succès";
            }
        }}
        catch(SQLException ex){
            ex.printStackTrace();
        }}
        else{
            x="vous avez des emprunts retardés vous devez les retourner avant d'emprunter de nouveau";
        }
        return x;
    }
    public boolean verifier_abonne(int id){
        update_emprunts();
        Connection con=getConnection();
        int z=0;
        String sql="select count(emprunt_id) as delayed_count from emprunt where abonne_id=? and etat='retardé'";
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs=pstm.executeQuery();
            if(rs.next()){
            z=rs.getInt("delayed_count");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
        if(z==0){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String retourner(Emprunt e) {
        Connection con=getConnection();
        String sql1="update emprunt set etat='retourne', date_fin_effective=? where emprunt_id=?";
        String sql2="update ouvrages set etat='disponible' where ouvrage_id=?";
        String sql3="select * from ouvrage_reserve where ouvrage_id=? and ordre_attente=1";
        String sql4="insert into emprunt (ouvrage_id,abonne_id,date_debut,date_fin_prevue,etat)values(?,?,?,?,?)";
        String x="Il y a une erreur veuillez refaire la procédure";
        ResultSet rs;
        int rowCount1=0;
        int rowCount2=0;
        int rowCount3=0;
        Reservation r=null;
        try{
            PreparedStatement pstm1=con.prepareStatement(sql1);
            pstm1.setObject(1, LocalDateTime.now().format(formatter));
            pstm1.setInt(2, e.getId());
            rowCount1=pstm1.executeUpdate();
            PreparedStatement pstm3=con.prepareStatement(sql3);
            pstm3.setInt(1, e.getOuvrage().getId());
            rs=pstm3.executeQuery();
            while(rs.next()){
             r=new Reservation(rs.getInt("reservation_id"),getOuvrage(rs.getInt("ouvrage_id")),getAbonne(rs.getInt("abonne_id")),rs.getTimestamp("date_reservation").toString(),rs.getInt("ordre_attente"),rs.getString("etat"));
            }
            if(r==null){
            PreparedStatement pstm2=con.prepareStatement(sql2);
            pstm2.setInt(1, e.getOuvrage().getId());
            rowCount2=pstm2.executeUpdate();
            if(rowCount1 >0 && rowCount2 >0){
                x="Ouvrage retourné avec succès";
            }
            else{
                PreparedStatement pstm4=con.prepareStatement(sql4);
                pstm4.setInt(1,r.getOuvrage().getId());
                pstm4.setInt(2,r.getAbonne().getId());
                pstm4.setObject(3,e.getDate_fin_effective());
                pstm4.setObject(4,e.getDate_fin_effective().plusDays(7));
                pstm4.setString(5, "normal");
                rowCount3=pstm4.executeUpdate();
            }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return x;
    }

    /**
     *
     * @return
     */
    @Override
    public Vector<Ouvrage> getAllOuvragesByDispo() {
      Connection con=getConnection();
        String sql="select * from ouvrages where disponibilite=true ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                 case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;  
    }


    @Override
    public boolean updateAbonnePhone(Abonne a) {
        Connection con=getConnection();
        String sql="update abonnes set num_tel=? where abonne_id=? ";
        Boolean x=false;
        int rowCount=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, a.getNum_tel());
            pstm.setInt(2, a.getId());
            rowCount=pstm.executeUpdate();
            if(rowCount >0){
                x=true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public boolean changermdp(String nouveau_mdp,Personne p) {
        Connection con=getConnection();
        String sql="";
        if(p instanceof Employe){
        sql="update connexion_employes set mot_de_passe=? where employe_id=? ";
        }
        else if(p instanceof Abonne){
        sql="update connexion_abonne set mot_de_passe=? where abonne_id=? ";
        }
        Boolean x=false;
        int rowCount=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(2, nouveau_mdp);
            pstm.setInt(2, p.getId());
            rowCount=pstm.executeUpdate();
            if(rowCount >0){
                x=true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public String prolonger(Emprunt e) {
        Connection con=getConnection();
        String sql="update emprunts set date_fin_prevue=?,date_fin_effective=?,etat='prolongé' where emprunt_id=? ";
        String sql3="select * from ouvrage_reserve where ouvrage_id=? and ordre_attente=1";
        String x="";
        ResultSet rs;
        Reservation r=null;
        int rowCount=0;
        try{
            PreparedStatement pstm3=con.prepareStatement(sql3);
            pstm3.setInt(1, e.getOuvrage().getId());
            rs=pstm3.executeQuery();
            while(rs.next()){
             r=new Reservation(rs.getInt("reservation_id"),getOuvrage(rs.getInt("ouvrage_id")),getAbonne(rs.getInt("abonne_id")),rs.getTimestamp("date_reservation").toString(),rs.getInt("ordre_attente"),rs.getString("etat"));
            }
            if(r==null){
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setObject(1, e.getDate_fin_prevue());
            pstm.setObject(2, e.getDate_fin_effective());
            pstm.setInt(3, e.getId());
            rowCount=pstm.executeUpdate();
            if(rowCount >0){
                x="Emprunt prolongé de 3 jours";
            }else{
                x="On ne peut pas prolonger votre emprunt car l'ouvrage est réservé";
            }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return x;
    }

    @Override
    public Vector<Ouvrage> getAllOuvragesRecommendés(int id) {
        Connection con=getConnection();
        String sql="select * from ouvrages where rate >= ? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setInt(1,id);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                   case "livre":
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre_ouvrage"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbre_page"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;  
    }

    @Override
    public Vector<Emprunt> getAllMesEmpruntsActuels(int id) {
        update_emprunts();
        Connection con=getConnection();
        String sql2="select * from emprunt where abonne_id=? and (etat='en cours' or etat='retardé' or etat='normal' or etat='prolongé')";
        Vector<Emprunt> ve=new Vector<>();
	Emprunt e = null;
        ResultSet rs2;
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setInt(1,id);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {
            e=new Emprunt(rs2.getInt("emprunt_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getTimestamp("date_debut").toString(),rs2.getTimestamp("date_fin_prevu").toString(),rs2.getTimestamp("date_fin_effective").toString(),rs2.getString("etat"),rs2.getInt("retard"),rs2.getDouble("amende"));
            ve.add(e);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return ve;  
    }

    @Override
    public Vector<Emprunt> getAllMesEmpruntsRetardés(int id) {
        update_emprunts();
    Connection con=getConnection();
        String sql2="select * from emprunt where abonne_id= ? and etat='retardé' ";
        Vector<Emprunt> ve=new Vector<>();
	Emprunt e = null;
        ResultSet rs2;
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setInt(1,id);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {
         
            e=new Emprunt(rs2.getInt("emprunt_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getTimestamp("date_debut").toString(),rs2.getTimestamp("date_fin_prevu").toString(),rs2.getTimestamp("date_fin_effective").toString(),rs2.getString("etat"),rs2.getInt("retard"),rs2.getDouble("amende"));
            ve.add(e);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return ve;    
    }

    @Override
    public Vector<Emprunt> getAllMonHistoriqueEmprunts(int id) {
       Connection con=getConnection();
        String sql2="select * from emprunt where abonne_id= ? ";
        Vector<Emprunt> ve=new Vector<>();
	Emprunt e = null;
        ResultSet rs2;
	
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setInt(1,id);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {
            
            e=new Emprunt(rs2.getInt("emprunt_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getTimestamp("date_debut").toString(),rs2.getTimestamp("date_fin_prevu").toString(),rs2.getTimestamp("date_fin_effective").toString(),rs2.getString("etat"),rs2.getInt("retard"),rs2.getDouble("amende"));
            ve.add(e);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return ve;    
    }

    @Override
    public Vector<Ouvrage> getAllOuvragesByTitle_part(String ch) {
       Connection con=getConnection();
        String sql="select * from ouvrages where titre_ouvrage like ? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,"%"+ch+"%");
	rs=pstm.executeQuery();
	while(rs.next()) {
                    o=getOuvrage(rs.getInt("ouvrage_id"));
                    vo.add(o);
                }
            }
        
	
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;  
    }

    @Override
    public boolean commenter(Commentaire c) {
        Connection con=getConnection();
        String sql="insert into commentaires (abonne_id,nbr_etoiles,date_commentaire,description,ouvrage_id) values(?,?,?,?,?)";
        int rowCount=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(2, c.getNbr_etoiles());
            pstm.setObject(3, c.getDate_commentaire());
            pstm.setString(4, c.getDescription());
            pstm.setInt(5, c.getOuvrage().getId());
            pstm.setInt(1, c.getAbonne().getId());
            rowCount=pstm.executeUpdate();
            update_rate(c.getOuvrage());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rowCount>0;
    }
    @Override
    public void update_rate(Ouvrage o){
        Connection con=getConnection();
        String sql1="select nbr_etoiles from commentaires where ouvrage_id=?";
        String sql2="update ouvrages set rate=? where ouvrage_id=?";
        int rowCount1=0;
        int length = 0;
        float rate=0;
        ResultSet rs;
        try{
            PreparedStatement pstm1=con.prepareStatement(sql1);
            pstm1.setInt(1, o.getId());
            rs=pstm1.executeQuery();
            while(rs.next()){
                rate=rate+rs.getInt("nbr_etoiles");
                length++;
            }
            if(length>0){
            rate=rate/length;
            }
            PreparedStatement pstm2=con.prepareStatement(sql2);
            pstm2.setFloat(1, rate);
            pstm2.setInt(2, o.getId());
            rowCount1=pstm2.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean modifier_commentaire(Commentaire c) {
        Connection con=getConnection();
        String sql="update commentaires set date_commentaire=?,nbr_etoiles=?,description=? where commentaire_id=?";
        int rowCount=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setObject(1, c.getDate_commentaire());
            pstm.setInt(2, c.getNbr_etoiles());
            pstm.setString(3, c.getDescription());
            pstm.setInt(4, c.getId());
            rowCount=pstm.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rowCount>0;
    }

    @Override
    public boolean supprimer_commentaire(int id) {
        Connection con=getConnection();
        String sql="delete from commentaires where commentaire_id=?";
        Boolean x=false;
        int rowCount=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(1, id);
            rowCount=pstm.executeUpdate();
                if(rowCount>0){
                    x=true;
                }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public Vector<Commentaire> getAllCommentaires() {
        Connection con=getConnection();
        String sql2="select * from commentaires";
        Vector<Commentaire> vc=new Vector<>();
	Commentaire c = null;
        ResultSet rs2;
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {       
          c=new Commentaire(rs2.getInt("commentaire_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getInt("nbr_etoiles"),rs2.getTimestamp("date_commentaire").toString(),rs2.getString("description"));
          vc.add(c);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return vc;     
    }

    @Override
    public Vector<Commentaire> getAllMesCommentaires(int id) {
     Connection con=getConnection();
        String sql2="select * from commentaires where abonne_id= ? ";
        Vector<Commentaire> vc=new Vector<>();
	Commentaire c = null;
        ResultSet rs2;
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setInt(1,id);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {       
          c=new Commentaire(rs2.getInt("commentaire_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getInt("nbr_etoiles"),rs2.getTimestamp("date_commentaire").toString(),rs2.getString("description"));
          vc.add(c);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return vc;      
    }

    @Override
    public Vector<Commentaire> getAllCommentairesOuvrages(int id) {
        Connection con=getConnection();
        String sql2="select * from commentaires where ouvrage_id=?";
        Vector<Commentaire> vc=new Vector<>();
	Commentaire c = null;
        ResultSet rs2;
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setInt(1,id);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {       
          c=new Commentaire(rs2.getInt("commentaire_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getInt("nbr_etoiles"),rs2.getTimestamp("date_commentaire").toString(),rs2.getString("description"));
          vc.add(c);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return vc; 
    }

    @Override
    public Commentaire getCommentaire(int id) {
       Connection con=getConnection();
        String sql2="select * from commentaires where commentaire_id=?";
	Commentaire c = null;
        ResultSet rs2;
	
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setInt(1,id);
	rs2=pstm2.executeQuery();
	while(rs2.next()) {
          c=new Commentaire(rs2.getInt("commentaire_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getInt("nbr_etoiles"),rs2.getTimestamp("date_commentaire").toString(),rs2.getString("description"));
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return c;
    }
    
    public Abonne getAbonne(int id) {
        Connection con=getConnection();
        String sql="select * from abonne where abonne_id=?";
        ResultSet rs;
	Abonne a = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	pstm.setInt(1,id);
	rs=pstm.executeQuery();
	while(rs.next()) {
            a=new Abonne(rs.getInt("abonne_id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("cin"),rs.getTimestamp("date_naissance").toString(),rs.getTimestamp("date_debut_abonnement").toString(),rs.getTimestamp("date_fin_abonnement").toString(),rs.getString("type_abonnement"),rs.getString("num_tel"));
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return a;
    }

    @Override
    public void update_emprunts() {
        Connection con=getConnection();
        String sql="update emprunt set etat='retardé' where ?>date_fin_prevu and etat !='retourne'";
        String sql1="select * from emprunt where etat='retardé'";
        ResultSet rs1;
        int rowCount=0;
        int rowCount1=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setObject(1,LocalDateTime.now());
            rowCount=pstm.executeUpdate();
            PreparedStatement pstm1=con.prepareStatement(sql1);
            rs1=pstm1.executeQuery();
            while(rs1.next()){
                String sql2="update emprunt set retard=?,amende=? where emprunt_id=?";
                PreparedStatement pstm2=con.prepareStatement(sql2);
                Long x=ChronoUnit.DAYS.between(LocalDateTime.parse(rs1.getTimestamp("date_fin_prevu").toString(),formatter), LocalDateTime.now());
                int y=Integer.parseInt(x.toString());
                pstm2.setInt(1, y);
                pstm2.setDouble(2, y*0.5);
                pstm2.setInt(3, rs1.getInt("emprunt_id"));
                rowCount=pstm2.executeUpdate();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Vector<Ouvrage> getAllOuvragesByMots_clés(String ch) {
        Connection con=getConnection();
        String sql="select * from ouvrages where MotsCle like ? ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,"%"+ch+"%");
	rs=pstm.executeQuery();
	while(rs.next()) {
                    o=getOuvrage(rs.getInt("ouvrage_id"));
                    vo.add(o);
                }
            }
        
	
	catch(SQLException e) {
            e.printStackTrace();
	}
        return vo;  
    }

    @Override
    public Emprunt getEmprunt(int id) {
        Connection con=getConnection();
        String sql="select * from emprunt where emprunt_id=?";
        ResultSet rs2;
	Emprunt e = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	pstm.setInt(1,id);
	rs2=pstm.executeQuery();
	while(rs2.next()) {
            e=new Emprunt(rs2.getInt("emprunt_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getTimestamp("date_debut").toString(),rs2.getTimestamp("date_fin_prevu").toString(),rs2.getTimestamp("date_fin_effective").toString(),rs2.getString("etat"),rs2.getInt("retard"),rs2.getDouble("amende"));
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return e;
    }

    @Override
    public Vector<Commentaire> getAllCommentairesByTitle(String titre) {
      Connection con=getConnection();
        String sql2="select * from commentaires c join ouvrages o on(c.ouvrage_id=o.ouvrage_id)where o.titre like ?";
        Vector<Commentaire> vc=new Vector<>();
	Commentaire c = null;
        ResultSet rs2;
	try {
	PreparedStatement pstm2=con.prepareStatement(sql2);
        pstm2.setString(1,"%"+titre+"%");
	rs2=pstm2.executeQuery();
	while(rs2.next()) {       
          c=new Commentaire(rs2.getInt("commentaire_id"),getAbonne(rs2.getInt("abonne_id")),getOuvrage(rs2.getInt("ouvrage_id")),rs2.getInt("nbr_etoiles"),rs2.getTimestamp("date_commentaire").toString(),rs2.getString("description"));
          vc.add(c);
        }
	}
	catch(SQLException ex) {
            ex.printStackTrace();
	}
        return vc; 
    }
    
@Override
public LocalDateTime reserverOuvrage(int id_abonne, int id_ouvrage) {
   
    LocalDateTime date_retour = null;
    try {
              Connection connection=getConnection();
        String requete = "SELECT * FROM ouvrages WHERE ouvrage_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setInt(1, id_ouvrage);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Livre réservé. Dès qu'il sera prêt, nous vous enverrons une notification : ");
            String requete1 = "SELECT * FROM emprunt WHERE ouvrage_id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(requete1);
            preparedStatement1.setInt(1,id_ouvrage);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if (resultSet1.next()) {
               System.out.println("Livre réservé. Dès qu'il sera prêt, nous vous enverrons une notification : ");
                date_retour = resultSet1.getTimestamp("date_fin_effective").toLocalDateTime();
               String requeteOrdre = "SELECT o.ordre_attente AS max_ordre, o.date_reservation AS res " +
                "FROM ouvrage_reserve o " +
                "INNER JOIN ( " +
                "    SELECT MAX(ordre_attente) AS max_ordre " +
                "    FROM ouvrage_reserve " +
                "    WHERE ouvrage_id = ? AND etat = 'RESERVE' " +
                ") mo ON o.ordre_attente = mo.max_ordre AND o.ouvrage_id = ? AND o.etat = 'RESERVE'";
                PreparedStatement preparedStatementOrdre = connection.prepareStatement(requeteOrdre);
                preparedStatementOrdre.setInt(1, id_ouvrage);
                preparedStatementOrdre.setInt(2, id_ouvrage);
                ResultSet resultSetOrdre = preparedStatementOrdre.executeQuery();
                int ordreAttente = 1;
                if (resultSetOrdre.next() && resultSetOrdre.getInt("max_ordre") != 0) {
                    ordreAttente = resultSetOrdre.getInt("max_ordre") + 1;
                    System.out.println(ordreAttente);
                    date_retour = resultSetOrdre.getTimestamp("res").toLocalDateTime().plusDays(30);
                    System.out.println(date_retour);
                }

                String requete2 = "INSERT INTO ouvrage_reserve (ouvrage_id, abonne_id, date_reservation, ordre_attente,etat) VALUES (?, ?, ?, ?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(requete2);
                preparedStatement2.setInt(1, id_ouvrage);
                preparedStatement2.setInt(2, id_abonne);
                preparedStatement2.setObject(3, date_retour);
                preparedStatement2.setInt(4, ordreAttente);
                   preparedStatement2.setString(5, "RESERVE");

                preparedStatement2.executeUpdate();
                preparedStatement2.close();
                String requeteMiseAJour = "UPDATE ouvrages SET etat =? WHERE ouvrage_id = ?";
                PreparedStatement preparedStatementMiseAJour = connection.prepareStatement(requeteMiseAJour);
                preparedStatementMiseAJour.setString(1,"reserve");
                preparedStatementMiseAJour.setInt(2, id_ouvrage);
                preparedStatementMiseAJour.executeUpdate();
                preparedStatementMiseAJour.close();
            }
            resultSet1.close();
            preparedStatement1.close();
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return date_retour;
}


@Override
public Vector<Ouvrage> AfficherOuvrageARerserver() {
    Vector<Ouvrage> ouvrages = new Vector<>();       
    try ( Connection connection=getConnection();
         PreparedStatement preparedStatementSelectionOuvrages = connection.prepareStatement("SELECT * FROM ouvrages WHERE disponibilite = false  ");
         ResultSet resultSet = preparedStatementSelectionOuvrages.executeQuery()) {
        while (resultSet.next()) {
            String typeOuvrage = resultSet.getString("type_ouvrage");
            int ouvrageId = resultSet.getInt("ouvrage_id");
            String titre = resultSet.getString("titre_ouvrage");
            LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
            double prix = resultSet.getDouble("prix");
            String genre = resultSet.getString("genre");
            boolean disponibilite = resultSet.getBoolean("disponibilite");
            String langue = resultSet.getString("langue");
            Ouvrage ouvrage = null;
            switch (typeOuvrage) {
                case "Livre":
                    int nbrePageLivre = resultSet.getInt("nbre_page");
                    ouvrage=new Livre(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                    break;
                case "Magazine":
                    int num_magazine = resultSet.getInt("num_magazine");
                    int nbrePageMagazine = resultSet.getInt("nbre_page");
                    ouvrage=new Magazine(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("num_magazine"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                    break;
                case "Dictionnaire":
                    int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                    int nbre_mots = resultSet.getInt("nbre_mots");
                    ouvrage=new Dictionnaire(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("nbre_page"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                    break;
                case "LivreAudio":
                    String format = resultSet.getString("format");
                    java.util.Date duree = resultSet.getDate("duree");
                    ouvrage=new Magazine(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("num_magazine"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                    break;
                default:
                    throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
            }

            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }
        }
    } catch (SQLException | IllegalArgumentException e) {
        e.printStackTrace();
    }

    return ouvrages;
}

@Override
public boolean recupererLivreReserve(int ouvrageId, int abonneId) {
     int affectedRows =0;
   String queryCheckReserve = "SELECT ordre_attente FROM ouvrage_reserve WHERE ouvrage_id = ? AND abonne_id = ? AND etat = 'attribué'";
    String queryDeleteReserve = "DELETE FROM ouvrage_reserve WHERE ouvrage_id = ? AND abonne_id = ?";
    String inserer = "INSERT INTO emprunt (ouvrage_id, abonne_id, date_debut, date_fin_prevu,date_fin_effective, etat) VALUES (?, ?, ?,?,?, 'en cours')";
    try (
           Connection connection=getConnection();
         PreparedStatement checkReserveStmt = connection.prepareStatement(queryCheckReserve);
         PreparedStatement deleteReserveStmt = connection.prepareStatement(queryDeleteReserve);
         PreparedStatement insertionStmt = connection.prepareStatement(inserer)) {
        checkReserveStmt.setInt(1, ouvrageId);
        checkReserveStmt.setInt(2, abonneId);
        ResultSet rs = checkReserveStmt.executeQuery();
        if (rs.next()) {
            int ordreAttente = rs.getInt("ordre_attente");
            // Insertion dans emprunt
            LocalDate today = LocalDate.now();
            LocalDate dateFinPrevu = today.plusWeeks(4); // Exemple : 4 semaines plus tard
            insertionStmt.setInt(1, ouvrageId);
            insertionStmt.setInt(2, abonneId);
            insertionStmt.setDate(3, java.sql.Date.valueOf(today));
            insertionStmt.setDate(4, java.sql.Date.valueOf(dateFinPrevu));
            insertionStmt.setDate(5, java.sql.Date.valueOf(dateFinPrevu));
            insertionStmt.executeUpdate();
            // Suppression de la réservation
            deleteReserveStmt.setInt(1, ouvrageId);
            deleteReserveStmt.setInt(2, abonneId);
             affectedRows = deleteReserveStmt.executeUpdate();
        }
        System.out.println(affectedRows);
       
    } catch (SQLException e)
    {
        e.printStackTrace();
    }
    return affectedRows>0; 
}
  @Override
    public Vector<Reservation1> afficherReservationsUtilisateur(int abonne_id) {
        Vector<Reservation1> reservations = new Vector<>();
        PreparedStatement stmt = null;
              ResultSet rs = null;
          try {
            Connection conn=getConnection();
            String query = "SELECT * FROM ouvrage_reserve WHERE abonne_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, abonne_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ouvrageId = rs.getInt("ouvrage_id");
                LocalDateTime dateReservation = rs.getTimestamp("date_reservation").toLocalDateTime();
                int ordreAttente = rs.getInt("ordre_attente");
                String etat = rs.getString("etat");
                // Créez un objet OuvrageReservation pour chaque ligne de résultat
                Reservation1 reservation = new Reservation1(ouvrageId,abonne_id, dateReservation, ordreAttente, etat);
                reservations.add(reservation);
            }
        } catch (SQLException ex) {
        Logger.getLogger(AbonneService.class.getName()).log(Level.SEVERE, null, ex);
    }
        return reservations;
    }
  
    
    
 @Override
public Vector<Integer> NotificationReservationAnnulePourRetard(int id_abonne) {
    Vector<Integer> ouvragesAnnules = new Vector<>();
    try (  Connection connection=getConnection()) {
        String selectQuery = "SELECT ouvrage_id FROM ouvrage_reserve WHERE abonne_id = ? AND etat = 'annule'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, id_abonne);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    ouvragesAnnules.add(ouvrageId);
                }
            }
        }
        String deleteQuery = "DELETE FROM ouvrage_reserve WHERE abonne_id = ? AND etat = 'annule'";
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(deleteQuery)) {
            preparedStatement1.setInt(1, id_abonne);
            preparedStatement1.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
       
    }
    return ouvragesAnnules;
}


    public Vector<Integer> NotificationReservationRetardRes(int id_abonne ) 
    {
        //ken date reservation tfout el date lyoum et , retard>0 doc nkouloulou eli el kteb amel retard desole 
        Vector<Integer> retardouvrage = new Vector<>();
            try {
                 Connection connection=getConnection();
          String requete = "SELECT * FROM ouvrage_reserve WHERE abonne_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, id_abonne);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ouvrageId = resultSet.getInt("ouvrage_id"); 
                String etat= resultSet.getString("etat"); 
                LocalDateTime date_res = resultSet.getTimestamp("date_reservation").toLocalDateTime();
                if (date_res.isBefore(LocalDateTime.now()) && !"attribué".equals(etat)) 
                {
                       retardouvrage.add(ouvrageId);
                       String requete2 = "UPDATE ouvrage_reserve  set etat='retarde'  WHERE abonne_id = ? and ouvrage_id=? ";
                         PreparedStatement preparedStatement2 = connection.prepareStatement(requete2);
                         preparedStatement2.setInt(1, id_abonne);
                        preparedStatement2.setInt(2, ouvrageId);
                        int rowsAffected = preparedStatement2.executeUpdate();
                    //nbadlou etat iwali retarde +nzidou id lel liste 
                }
                    retardouvrage.add(ouvrageId);
              }
         }
          catch (SQLException e) {
             e.printStackTrace();
            // Gérer l'exception SQL
          }
                 return retardouvrage;
    }
      @Override
        public  Ouvrage obtenir_ouvrage_par_id(int id) {
            String requete = "SELECT * FROM ouvrages WHERE ouvrage_id = ?";
            Ouvrage ouvrage = null;
            try {
                 Connection connection=getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(requete);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");  
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    int auteur_id = resultSet.getInt("auteur_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");                 
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                            ouvrage=new Livre(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                    ouvrage=new Magazine(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("num_magazine"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                    ouvrage=new Dictionnaire(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getInt("nbr_mots"),resultSet.getInt("nbre_page"),resultSet.getFloat("rate"),resultSet.getString("etat"));
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             java.util.Date duree = resultSet.getDate("duree");
                    ouvrage=new Livreaudio(resultSet.getInt("ouvrage_id"),resultSet.getString("titre_ouvrage"),resultSet.getTimestamp("date_publication").toString(),resultSet.getFloat("prix"),resultSet.getString("genre"),resultSet.getString("langue"),resultSet.getString("mots_cles"),resultSet.getString("format"),resultSet.getTime("duree").toString(),resultSet.getFloat("rate"),resultSet.getString("etat"));
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }

                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException | IllegalArgumentException e) {
                e.printStackTrace();
            }

            return ouvrage;
        }
        
        
   
        public boolean ajouter_livraison(int abonne_id,int ouvrage_id,String adresse, String instructions, int num_tel) {
        boolean test = false;
        String query = "INSERT INTO livraisonn (abonne_id,ouvrage_id,adresse, instruction, num_tel,date_livraison) VALUES (?, ?,?,?,?,?)";

        try ( Connection connection=getConnection(); ) {
             PreparedStatement ps = connection.prepareStatement(query);
             ps.setInt(1, abonne_id);
            ps.setInt(2, ouvrage_id);
            ps.setString(3, adresse);
            ps.setString(4, instructions);
            ps.setInt(5, num_tel);
            LocalDate localDate = LocalDate.now();
            Date sqlDate = Date.valueOf(localDate);
            ps.setDate(6, sqlDate);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                test = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return test;
    }
        

 
}
               