package java_fx.entities;

import java_fx.core.RoleNonAdmin;

public class Etudiant extends Utilisateurs {
    private String tuteur;
    private String matricule;


    public Etudiant(String nomcomplet, String tuteur) {
        super(nomcomplet);
        this.tuteur = tuteur;
        roles=RoleNonAdmin.ETUDIANT;
    }

    public Etudiant(int id, String nomcomplet, String tuteur, String matricule) {
        super(id, nomcomplet);
        this.tuteur = tuteur;
        roles=RoleNonAdmin.ETUDIANT;
    }

    public Etudiant() {
        roles=RoleNonAdmin.ETUDIANT;
    }
   
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = "AG"+""+id;
    }

    @Override
    public String toString() {
        return super.toString()+ "tuteur=" + tuteur + " ," + "matricule=" +matricule+"]";
    }
}
