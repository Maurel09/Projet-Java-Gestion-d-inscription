package java_fx.entities;



public class Inscription {

    int id;
    String dateInscription;

    public String getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }
    // Mani to One
    private Classe classe;
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    private Etudiant etudiant;
    
   

    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
