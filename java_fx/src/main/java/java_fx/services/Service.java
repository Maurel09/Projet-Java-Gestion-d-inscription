package java_fx.services;

import java.util.List;

import java_fx.entities.Classe;
import java_fx.entities.UsersAdmin;
import java_fx.entities.Utilisateurs;
import java_fx.repositories.ClasseRepository;
import java_fx.repositories.IClasseRepository;
import java_fx.repositories.IEtudiantRepository;
import java_fx.repositories.IProfesseurRepository;
import java_fx.repositories.IUsersAdminRepository;
import java_fx.repositories.ProfesseursRepository;


public class Service implements IService{

    IClasseRepository classeRepository;
    IProfesseurRepository professeursRepository;
    IEtudiantRepository etudiantsRepository;
    IUsersAdminRepository usersAdminRepository;
   
    public Service(IClasseRepository classeRepository,IProfesseurRepository professeursRepository,IEtudiantRepository etudiantsRepository, IUsersAdminRepository usersAdminRepository) {
        this.classeRepository = classeRepository;
    
        this.professeursRepository = professeursRepository;
        
        this.etudiantsRepository = etudiantsRepository;
        this.usersAdminRepository=usersAdminRepository;
    }

    @Override
    public Classe insertClasse(Classe classe) {
        return classeRepository.ajouterUneClasse(classe);
    }

    @Override
    public List<Classe> selectAllClasses() {
        return classeRepository.listerClasses();
    }

    @Override
    public Classe selectClasseByID(int id) {
        return classeRepository.rechercherClassebyid(id);
    }

    @Override
    public Utilisateurs insertProfesseur(Utilisateurs utilisateurs) {
        return  professeursRepository.ajouterProfesseur(utilisateurs);
    }

    @Override
    public List<Utilisateurs> selectAllProfesseur() {
        return professeursRepository.listerProfesseur();
    }

    @Override
    public Utilisateurs selectProfesseurByID(int id) {
        return  professeursRepository.filterProfesseurParId(id);
    }



    
    @Override
    public Utilisateurs insertEtudiant(Utilisateurs utilisateurs) {
        return  etudiantsRepository.ajouterEtudiant(utilisateurs);
    }

    @Override
    public List<Utilisateurs> selectAllEtudiant() {
        return  etudiantsRepository. listerEtudiant();
    }

    @Override
    public Utilisateurs selectEtudiantByID(int id) {
        return  etudiantsRepository.filterEtudiantParId(id);
    }
    // Se Connecter
    @Override
    public UsersAdmin seConnecter(String login, String password) {
        // TODO Auto-generated method stub
        return usersAdminRepository.findUserAdminByLoginAndPassword(login, password);
    }

    @Override
    public void affectation(Utilisateurs professeur,Classe classe) {
        professeursRepository.affecterClasseProfesseur(professeur,classe);
        
    }

    @Override
    public List<Classe> filtrerProfesseurClasse(int id) {
        // TODO Auto-generated method stub
        return classeRepository.filtrerProfClasse(id);
    }

    
   
    
}
