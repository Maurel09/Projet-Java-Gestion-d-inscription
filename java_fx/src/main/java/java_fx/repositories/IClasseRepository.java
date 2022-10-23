package java_fx.repositories;
import java.util.List;

import java_fx.entities.Classe;
public interface IClasseRepository {
    public Classe ajouterUneClasse(Classe classe);
    public List<Classe> listerClasses();
    // public Boolean supprimerClasse(Classe classe);
    // public Classe rechercherClassebyid(int id);
    public Classe rechercherClassebyid(int id);
    
    public List<Classe> filtrerProfClasse(int id);

    




}

