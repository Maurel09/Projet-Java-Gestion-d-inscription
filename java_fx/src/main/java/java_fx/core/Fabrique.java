package java_fx.core;

import java_fx.repositories.ClasseRepository;
import java_fx.repositories.EtudiantRepository;
import java_fx.repositories.IClasseRepository;
import java_fx.repositories.IEtudiantRepository;
import java_fx.repositories.IProfesseurRepository;
import java_fx.repositories.IUsersAdminRepository;
import java_fx.repositories.ProfesseursRepository;
import java_fx.repositories.UsersAdminRepository;
import java_fx.services.IService;
import java_fx.services.Service;

public class Fabrique {
       public static IService getService(){ 
        IProfesseurRepository professeurRepository=new  ProfesseursRepository();
        IClasseRepository classeRepository=new ClasseRepository(professeurRepository);  
        IEtudiantRepository etudiantRepository=new  EtudiantRepository();
        IUsersAdminRepository usersAdminRepository=new UsersAdminRepository();
       return new Service(classeRepository,professeurRepository,etudiantRepository,usersAdminRepository);
    
}
}
