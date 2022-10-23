package java_fx.repositories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java_fx.core.Mysql;
import java_fx.entities.Classe;

public class ClasseRepository extends Mysql implements IClasseRepository{

    IProfesseurRepository professeurRepository;
      //Injection de Dependance
      public ClasseRepository(IProfesseurRepository professeurRepository) {
          this.professeurRepository = professeurRepository;
      }

    //creer une classe
    //1--sql

    private static final String SQL_INSERT="insert into classe(niveau,filiere,libelle) values(?,?,?)";
    
    



    
    // private static final String SQL_INSERT="insert into gloire.classe(niveau,filiere,libelle) values(?,?,?)";  
    private static final String SQL_SELECT="select * from classe";
    // private static final String SQL_SELECT="select * from gloire.classe";
    private static final String SQL_SELECT_BY_ID="select * from classe where id=? ";
    private static final String SQL_DELETE="delete from classse where id = ?";
    private static final String SQL_FILTERPROFCLASSE="select c.* from classe c,prof_classe cp  where c.id=cp.idclasse and cp.idprof=?";

    @Override
    public Classe ajouterUneClasse(Classe classe) {
        this.ouvertureConnexion();
      
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);

           
            ps.setString(1,classe.getNiveau());
            ps.setString(2,classe.getFiliere());
            ps.setString(3,classe.getLibelle());


            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){


// sur Mysql
                classe.setId(rs.getInt(1));
            }

            //Sur Postgresql
                // classe.setId(rs.getInt(3));
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
        return classe;
    }
    //la select

    List<Classe> listeClasse=new ArrayList<>();
    @Override
    public List<Classe> listerClasses() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Classe classe=new Classe(rs.getInt("id"), 
                rs.getString("niveau"),
                 rs.getString("filiere"),
                  rs.getString("libelle"));
                  listeClasse.add(classe);
            }
        } catch (SQLException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listeClasse;
    }




    
    // @Override
    // public Boolean supprimerClasse(Classe classe) {
    //     Boolean isDeleted = false ;
	// 	this.ouvertureConnexion();
	// 	try {
    //         ps=conn.prepareStatement(SQL_DELETE);
          
	// 		// Remplacer les ? par leur valeur
			
	// 		int result = ps.executeUpdate();
			
	// 		if(result == 1) 
	// 			isDeleted = true ; 
			
	// 	} catch(SQLException e) {
	// 		e.printStackTrace();
	// 	}
    //     this.fermetureConnexion();
	// 	return isDeleted;
	// }

    



    // Rechercher
    // @Override
   
        public Classe rechercherClassebyid(int id){
            Classe classe=null;
            this.ouvertureConnexion();
          
             try {
                ps=conn.prepareStatement(SQL_SELECT_BY_ID);
                ps.setInt(1, id);
              
                ResultSet  rs=ps.executeQuery();

               if (rs.next()) {
                                     classe= new Classe(rs.getInt("id"),
                                                            rs.getString("niveau"),
                                                            rs.getString("filiere"),
                                                            rs.getString("libelle"));
                                    }
          
                } catch (SQLException e) {
               
                e.printStackTrace();
            }
            this.fermetureConnexion();
            return classe;
        }





        @Override
        public List<Classe> filtrerProfClasse(int id) {
            // TODO Auto-generated method stub
            List<Classe>  listclasse=new ArrayList<>();
            this.ouvertureConnexion();
        try {
              ps= conn.prepareStatement(SQL_FILTERPROFCLASSE) ;
              ps.setInt(1, id); 
              
              
              ResultSet rs=ps.executeQuery();
              Classe classe;
              while(rs.next()){

                
                    classe=new Classe(rs.getInt("id"),rs.getString("niveau"),rs.getString("filiere"),rs.getString("libelle"));
                    listclasse.add(classe);
                       
                 }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return listclasse;
        
    }

}
       
        
 
    //java.sql.Connection 
    
   