package java_fx.repositories;

import java_fx.entities.UsersAdmin;

public interface IUsersAdminRepository {
    
    public UsersAdmin findUserAdminByLoginAndPassword(String login, String password);
}
