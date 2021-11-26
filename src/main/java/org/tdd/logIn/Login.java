package org.tdd.logIn;

import org.tdd.logIn.enums.Permissions;
import org.tdd.logIn.models.User;
import org.tdd.logIn.utils.JwtUtil;
import org.tdd.logIn.utils.PermissionsUtils;

import java.util.HashMap;

public class Login {

    public HashMap<String, User> users = new HashMap<>();




    public String loginUser(String userName, String password) throws LoginFailExeption {


        if (users.containsKey(userName) &&  users.get(userName).getPassWord().equals(password)) {
           return JwtUtil.generateToken(userName);
        }
         throw new LoginFailExeption("failed login");

    }

    public void addUser(String userName, String password, Permissions accountPermissions ,Permissions provisionsCalcPermissions) {


        users.put(userName, new User(userName, password,accountPermissions,provisionsCalcPermissions));
    }

    public void setTokenToAllUsers(){
       users.forEach((userName,user)-> {
           user.setToken(JwtUtil.generateToken(userName));
       });

    }

    public void uppdateUserPermissionList (){

        PermissionsUtils.setUsers(users);
    }
}






