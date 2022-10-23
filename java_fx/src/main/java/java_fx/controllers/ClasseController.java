package java_fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import java_fx.core.Fabrique;
import java_fx.entities.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClasseController implements Initializable {

    @FXML
    TableView tblvClasse=new TableView<>();
    @FXML
    TableColumn <Classe,Integer> tblcId=new TableColumn<>();
    @FXML
    TableColumn <Classe,String> tblcLibellé=new TableColumn<>();
    @FXML
    TextField txtNiveau;
    @FXML
    TextField txtFilière;


    ObservableList obClasse=FXCollections.observableList(Fabrique.getService().selectAllClasses());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibellé.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        tblvClasse.setItems(obClasse);

        
        
    }

    public void buttonCreerClasse(){
        String niveau=txtNiveau.getText().trim();
        String filiere=txtFilière.getText().trim();
        Classe classe = Fabrique.getService().insertClasse(new Classe(niveau,filiere));
        
        
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion d'inscription");
        alert.setContentText("Une nouvelle classe a été créer avec succès");
        alert.show();
        obClasse.add(classe);
        txtNiveau.clear();
        txtFilière.clear();
    
}

}
