package java_fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import java_fx.core.Fabrique;
import java_fx.entities.Classe;
import java_fx.entities.Professeur;
import java_fx.entities.Utilisateurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProfesseurController implements Initializable {

    @FXML
    private Pane paneClasse;

    @FXML
    private Pane paneProf;

    @FXML
    private TableColumn<?, ?> tblcGrade;

    @FXML
    private TableColumn<?, ?> tblcId;

    @FXML
    private TableColumn<Classe, Integer> tblcIdClasse;

    @FXML
    private TableColumn<?, ?> tblcIdProf;

    @FXML
    private TableColumn<?, ?> tblcNCI;

    @FXML
    TableView <Classe> tblvClasseProf;

    @FXML
    private TableColumn<Classe, Integer> tblcNomClasse;

    @FXML
    private TableColumn<?, ?> tblcNomComplet;

    @FXML
    private TableColumn<?, ?> tblcNomProf;

    @FXML
    private TableView<?> tblvProf;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtIdProf;

    @FXML
    private TextField txtIdClasse;

    @FXML
    private TextField txtNCI;

    @FXML
    private TextField txtNomClasse;

    @FXML
    private TextField txtNomComplet;

    @FXML
    private TextField txtNomProf;

    @FXML
    void buttonCreerProf(ActionEvent event) {

    }





    ObservableList obprof=FXCollections.observableList(Fabrique.getService().selectAllProfesseur());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblcNCI.setCellValueFactory(new PropertyValueFactory<>("nci"));

        tblvProf.setItems(obprof);
        
    }

    public void filtrerProf(int id){
        ObservableList obprof=FXCollections.observableList(Fabrique.getService().filtrerProfesseurClasse(id));

        // tblcIdProf.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcIdClasse.setCellValueFactory(new PropertyValueFactory<>("id"));
        // tblcNomProf.setCellValueFactory(new PropertyValueFactory<>("NomProf"));
        tblcNomClasse.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        tblvClasseProf.setItems(obprof);

    } 

    public void buttonCreerProf(){
        String nomcomplet=txtNomComplet.getText().trim();
        String grade=txtGrade.getText().trim();
        String nci=txtNCI.getText().trim();
        Utilisateurs professeur =  Fabrique.getService().insertProfesseur(new Professeur(nomcomplet,grade,nci));
        
        
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion d'inscription");
        alert.setContentText("Un nouveau Professeur a été créer avec succès");
        alert.show();
        obprof.add(professeur);
        txtNomComplet.clear();
        txtGrade.clear();
        txtNCI.clear();
    }

        // AFFECTER CLASSE
        
        public void buttonrechercherprof(){ 
            String rechercheid =txtIdProf.getText().trim();

            // convertion id
            int resultatid = Integer.parseInt(rechercheid);
            Utilisateurs prof =Fabrique.getService().selectProfesseurByID(resultatid);
           if(prof!=null){
            filtrerProf(resultatid);
              paneProf.setDisable(true);
              txtNomProf.setText(prof.getNomcomplet());
    

    
            //   apres recuperation de id prof
            //   loadTableCompte(id);
           }else{
              paneProf.setDisable(false);
              Alert alert=new Alert(AlertType.INFORMATION);
              alert.setTitle("Gestion d'inscription");
              alert.setContentText("Erreur: votre ID saisi est invalide");
              alert.show();
           }
       }
    
    
        
    
    
        public void buttonrechercherclasse(){
            String rechercheclasseid =txtIdClasse.getText().trim();
    
    
            // convertion id
            int resultatclasseid = Integer.parseInt(rechercheclasseid);
            Classe cl =Fabrique.getService().selectClasseByID(resultatclasseid);
           if(cl!=null){
              paneClasse.setDisable(true);
              txtNomClasse.setText(cl.getLibelle());
           }else{
              
            paneClasse.setDisable(false);
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion d'inscription");
            alert.setContentText("Erreur: votre ID saisi est invalide");
            alert.show();
           }
       }
    
    
    
    
    //    affecter prof
    
    public void buttonaffect(){
        String classe_id =txtIdClasse.getText().trim();
        String prof_id =txtIdProf.getText().trim();
    
        // convertion id
        int resultatclasseid = Integer.parseInt(classe_id);
        // convertion id
        int resultatprofid = Integer.parseInt(prof_id);
        Utilisateurs prof=Fabrique.getService().selectProfesseurByID(resultatprofid);
        Classe classe=Fabrique.getService().selectClasseByID(resultatclasseid);
        Fabrique.getService().affectation(prof,classe);
        
    
        // Alert: affectation d'une classe à un Professeur
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion d'inscription");
        alert.setContentText("La classe "+classe_id+" a été affecter au prof "+prof_id);
        alert.show();
        
        txtIdClasse.clear();
        txtIdProf.clear();


  
         }
    
    
    }
    

    

