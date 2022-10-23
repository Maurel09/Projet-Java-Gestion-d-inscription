package java_fx.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Column;

import java_fx.core.Mysql;
import java_fx.core.RoleUsers;
import java_fx.entities.Classe;
import java_fx.entities.UsersAdmin;

public class UsersAdminRepository extends Mysql implements IUsersAdminRepository {

    private final String SQL_CONNECT="SELECT * FROM admin WHERE login LIKE ? AND password LIKE ?";


    @Override
    public UsersAdmin findUserAdminByLoginAndPassword(String login, String password) {
        UsersAdmin usersAdmin=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_CONNECT);
            ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                usersAdmin=new UsersAdmin(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("nomcomplet"),
                    rs.getString("role").compareTo("RP")==0? RoleUsers.RP:RoleUsers.AC);
                
                
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return usersAdmin;
    }
    }

    
  
    
    

