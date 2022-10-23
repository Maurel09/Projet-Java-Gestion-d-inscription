package java_fx.entities;

import java_fx.core.RoleUsers;

public class Rp extends UsersAdmin{

    public Rp(String login, String password, String nomcomplet) {
        super(login, password, nomcomplet);
    }

    public Rp() {
        roleUsers=RoleUsers.RP;
    }
    
}
