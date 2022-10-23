package java_fx.entities;

import java_fx.core.RoleUsers;

public class Ac extends UsersAdmin{

    public Ac(String login, String password, String nomcomplet) {
        super(login, password, nomcomplet);
    }

    public Ac() {
        roleUsers=RoleUsers.AC;
    }
    
}
