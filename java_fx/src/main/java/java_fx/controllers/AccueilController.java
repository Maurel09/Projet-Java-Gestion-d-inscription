package java_fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java_fx.App;
import java_fx.core.RoleUsers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AccueilController implements Initializable {

    @FXML
    AnchorPane anchorContent;

    @FXML
    private Button btnMClasses;

    @FXML
    private Button btnMEtudiants;

    @FXML
    private Button btnMProfesseurs;
    
    public void buttonDeconnexion() throws IOException{
        App.setRoot("connexion");

    }

    public void buttonLoadViewClasse() throws IOException{
       this.loadView("classe");

    }

    public void buttonLoadViewProfesseur() throws IOException{
        this.loadView("professeur");
    }

    public void buttonLoadViewEtudiant() throws IOException{
        this.loadView("etudiant");
 
     }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //TODO Auto-generated method stub
        try {
           if(ConnexionController.usersadmin.getRoleUsers()==RoleUsers.RP) {
               isRp();

            }
           isRp();
            this.loadView("classe");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    private void loadView(String fxml) throws IOException{
        AnchorPane root=(AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
    
    private void isRp(){
        btnMClasses.setDisable(false);
        btnMClasses.setDisable(false);
        btnMProfesseurs.setDisable(false);

       

    }

    private void isAc(){
        btnMEtudiants.setDisable(false);
        


    }
}
