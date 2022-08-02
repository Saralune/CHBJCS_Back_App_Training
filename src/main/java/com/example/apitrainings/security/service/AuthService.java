package com.example.apitrainings.security.service;

import com.example.apitrainings.security.entities.Rrole;
import com.example.apitrainings.security.entities.Uuser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthService {

    /********Uuser*******************************/
    /**
     *
     * @param username
     * @return
     */
    public Uuser findUuserByUserName(String username);

    /**
     *
     * @param user
     * @return
     */
    public Uuser saveUuser(Uuser user);

    /*******Rrole*******************************/

    /**
     *
     * @param role
     * @return
     */
    public Rrole saveRrole(Rrole role);

    /**
     *
     * @param string
     * @return
     */
    public Rrole getRoleByRoleName(String string);

    public List<Uuser>  getAllUsers();

    public Uuser addRoleToUser(String user, String role);
}