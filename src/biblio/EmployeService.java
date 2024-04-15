/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Vector;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author pc
 */
public class EmployeService implements EmployeDAOInterface,CommunInterface {
    
        public static final String URL="jdbc:mysql://localhost/librairie";
	static String USER="root";
	static String PASS="";
       
  public static  Connection getConnection() //static : unique dans tout le projet , on peut pas la redefinir
	{
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Connection réussie...");
			} catch (SQLException e) {
			System.out.println("Connexion échouée....");
			e.printStackTrace();
			}
		return connection;	
	}
           Connection connection = EmployeService.getConnection();

    @Override
    public Abonne getAbonne(int id) {
        Connection con=getConnection();
        String sql="select * from abonnes where abonne_id=?";
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
    public Vector<Abonne> getAllAbonnes() {
                Connection con = getConnection();
		// TODO Auto-generated method stub
		Vector<Abonne> va=new Vector<>();
		String sql="select * from user";
		ResultSet rs;
		Abonne a = null;
		try {
		PreparedStatement pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while(rs.next()) {
			a=new Abonne(rs.getInt("abonne_id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("cin"),rs.getTimestamp("date_naissance").toString(),rs.getTimestamp("date_debut_abonnement").toString(),rs.getTimestamp("date_fin_abonnement").toString(),rs.getString("type_abonnement"),rs.getString("num_tel"));
			va.add(a);	
                }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return va;
    }

    @Override
    public Vector<Abonne> getAbonneByFullName(String nom, String prenom) {
       Connection con=getConnection();
       Vector<Abonne> va=new Vector<>();
       String sql="select * from abonnes where lower(prenom)=lower(?) and lower(nom)=lower(?)";
       Abonne a=null;
       ResultSet rs;
       try{
           PreparedStatement pstm=con.prepareStatement(sql);
           pstm.setString(1,prenom);
           pstm.setString(2,nom);
           rs=pstm.executeQuery();
           while(rs.next()){
               a=new Abonne(rs.getInt("abonne_id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("cin"),rs.getTimestamp("date_naissance").toString(),rs.getTimestamp("date_debut_abonnement").toString(),rs.getTimestamp("date_fin_abonnement").toString(),rs.getString("type_abonnement"),rs.getString("num_tel"));
               va.add(a);
           }
       }
       catch(SQLException e){
           e.printStackTrace();
       }
       return va;
    }

    @Override
    public boolean insertAbonne(Abonne a) {
        Connection con=getConnection();
        String sql="insert into abonnes values(NULL,?,?,?,?,?,?,?,?)";
        Boolean x=false;
        int rowCount=0;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, a.getNom());
            pstm.setString(2, a.getPrenom());
            pstm.setInt(3, a.getCin());
            pstm.setObject(4, a.getDate_naissance());
            pstm.setObject(5, a.getDate_debut_abonnement());
            pstm.setObject(6, a.getDate_fin_abonnement());
            pstm.setString(7, a.getType_abonnement());
            pstm.setString(8, a.getNum_tel());
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
    public boolean updateAbonnePhone(Abonne a) {
        Connection con=getConnection();
        String sql="update abonnes set(num_tel) values(?) where abonne_id=? ";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
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
    public boolean updateAbonneTypeAbonnement(Abonne a) {
        Connection con=getConnection();
        String sql="update abonnes set(type_abonnement) values(?) where abonne_id=? ";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, a.getType_abonnement());
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
    public boolean renouvellerAbonnement(Abonne a){
        Connection con=getConnection();
        String sql="update abonne set(date_debut_abonnement,date_fin_abonnement,type_abonnement) values(?,?,?) where abonne_id=? ";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setObject(1, a.getDate_debut_abonnement());
            pstm.setObject(2, a.getDate_fin_abonnement());
            pstm.setString(3, a.getType_abonnement());
            pstm.setInt(4, a.getId());
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
     public boolean passerpremium(int id){
        Connection con=getConnection();
        String sql="update abonne set type_abonnement=? where abonne_id=? ";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,"premium");
            pstm.setInt(2,id);
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
    public boolean deleteAbonne(int id) {
       Connection connection = getConnection();
		// TODO Auto-generated method stub
		String sql="DELETE from abonnes where abonne_id = ? ";
		int rowCount=0;
                Boolean b=false;
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setInt(1,id);
			rowCount=pstm.executeUpdate();
                        if(rowCount>0) {
                            b=true;
                        }
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		
		
		return b;
    }

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
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    break;
            }
        }
	}
	catch(SQLException e) {
            e.printStackTrace();
	}
        return o;
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
                case "livre" :
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
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
              case "livre" :
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
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
                case "livre" :
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
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
        String sql="select * from ouvrages where titre like %?% ";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,titre);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
              case "livre" :
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
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
    public boolean deleteOuvrage(int id) {
         Connection connection = getConnection();
		// TODO Auto-generated method stub
		String sql="DELETE from ouvrages where ouvrage_id = ? ";
		int rowCount=0;
                Boolean b=false;
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setInt(1,id);
			rowCount=pstm.executeUpdate();
                        if(rowCount>0) {
                            b=true;
                        }
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		
		
		return b;
    }

    @Override
    public boolean insertLivre(Livre l) {
        Connection con=getConnection();
        String sql="insert into ouvrages(ouvrage_id, titre, date_publication, prix, genre, etat, langue, mots_cles, nbr_pages) values(NULL,?,?,?,?,?,?,?,?)";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, l.getTitre());
            pstm.setObject(2, l.getDate_publication());
            pstm.setFloat(3, l.getPrix());
            pstm.setString(4, l.getGenre());
            pstm.setString(5, l.getEtat());
            pstm.setString(6, l.getLangue());
            pstm.setString(7, l.getMots_cles());
            pstm.setInt(8, l.getNbr_pages());
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
    public boolean insertLivreaudio(Livreaudio lo) {
        Connection con=getConnection();
        String sql="insert into ouvrages(ouvrage_id, titre, date_publication, prix, genre, etat, langue, mots_cles, format, duree) values(NULL,?,?,?,?,?,?,?,?,?)";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, lo.getTitre());
            pstm.setObject(2, lo.getDate_publication());
            pstm.setFloat(3, lo.getPrix());
            pstm.setString(4, lo.getGenre());
            pstm.setString(5, lo.getEtat());
            pstm.setString(6, lo.getLangue());
            pstm.setString(7, lo.getMots_cles());
            pstm.setString(8, lo.getFormat());
            pstm.setObject(9, lo.getDuree());
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
    public boolean insertMagazine(Magazine m) {
        Connection con=getConnection();
        String sql="insert into ouvrages(ouvrage_id, titre, date_publication, prix, genre, etat, langue, mots_cles, num_magazine, nbr_pages) values(NULL,?,?,?,?,?,?,?,?,?)";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, m.getTitre());
            pstm.setObject(2, m.getDate_publication());
            pstm.setFloat(3, m.getPrix());
            pstm.setString(4, m.getGenre());
            pstm.setString(5, m.getEtat());
            pstm.setString(6, m.getLangue());
            pstm.setString(7, m.getMots_cles());
            pstm.setInt(8, m.getNum_magazine());
            pstm.setInt(9, m.getNbr_pages());
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
    public boolean insertDictionnaire(Dictionnaire d) {
            Connection con=getConnection();
        String sql="insert into ouvrages(ouvrage_id, titre, date_publication, prix, genre, etat, langue, mots_cles, nbr_mots, nbr_pages) values(NULL,?,?,?,?,?,?,?,?,?)";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, d.getTitre());
            pstm.setObject(2, d.getDate_publication());
            pstm.setFloat(3, d.getPrix());
            pstm.setString(4, d.getGenre());
            pstm.setString(5, d.getEtat());
            pstm.setString(6, d.getLangue());
            pstm.setString(7, d.getMots_cles());
            pstm.setInt(8, d.getNbr_mots());
            pstm.setInt(9, d.getNbr_pages());
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
    public boolean updateOuvragePrix(Ouvrage o) {
        Connection con=getConnection();
        String sql="update ouvrages set(prix) values(?) where ouvrage_id=? ";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setFloat(1, o.getPrix());
            pstm.setInt(2, o.getId());
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
    public boolean updateOuvrageMotsCles(Ouvrage o) {
        Connection con=getConnection();
        String sql="update ouvrages set(mots_cles) values(?) where ouvrage_id=? ";
        Boolean x=false;
        int rowCount=0;
        ResultSet rs;
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, o.getMots_cles());
            pstm.setInt(2, o.getId());
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
    public Vector<Ouvrage> getAllOuvragesByDispo() {
      Connection con=getConnection();
        String sql="select * from ouvrages where etat ='disponible'";
        Vector<Ouvrage> vo=new Vector<>();
        ResultSet rs;
	Ouvrage o = null;
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeQuery();
	while(rs.next()) {
            switch (rs.getString("type_ouvrage").toLowerCase()){
                case "livre" :
                    o=new Livre(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                    
                case "magazine" :
                    o=new Magazine(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("num_magazine"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                    
                case "livreaudio" :
                    o=new Livreaudio(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getString("format"),rs.getTime("duree").toString(),rs.getFloat("rate"),rs.getString("etat"));
                    vo.add(o);
                    break;
                    
                case "dictionnaire" :
                    o=new Dictionnaire(rs.getInt("ouvrage_id"),rs.getString("titre"),rs.getTimestamp("date_publication").toString(),rs.getFloat("prix"),rs.getString("genre"),rs.getString("langue"),rs.getString("mots_cles"),rs.getInt("nbr_mots"),rs.getInt("nbr_pages"),rs.getFloat("rate"),rs.getString("etat"));
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

    }
    

