package java_fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java_fx.App;
import java_fx.core.Fabrique;
import java_fx.entities.UsersAdmin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {

    @FXML
    Text lblerror;
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField txtPassword;

    public static UsersAdmin usersadmin;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
            lblerror.setVisible(false);
        
    }

    public void buttonConnexion() throws IOException{
        //lblerror.setVisible(true);
        String login =txtLogin.getText().trim();
        String password =txtPassword.getText().trim();
         usersadmin=Fabrique.getService().seConnecter(login, password);
        if(usersadmin==null){
            lblerror.setVisible(true);
        }else{
            lblerror.setVisible(false);

            App.setRoot("accueil");
        }
    }
}