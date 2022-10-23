package java_fx.repositories;

import java.util.List;

import java_fx.entities.Classe;
import java_fx.entities.UsersAdmin;
import java_fx.entities.Utilisateurs;

public interface IProfesseurRepository {
    public Utilisateurs ajouterProfesseur(Utilisateurs utilisateurs);
    public List<Utilisateurs> listerProfesseur();
    public Utilisateurs filterProfesseurParId(int id);
    // public Boolean supprimerProfesseur(Professeur professeur);

    public void affecterClasseProfesseur(Utilisateurs professeur, Classe classe);
}
