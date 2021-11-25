package org.tdd.logIn;

import java.util.HashMap;

public class Login {

    public HashMap<String, User> users = new HashMap<>();




    public String loginUser(String userName, String password) throws LoginFailExeption {


        if (users.containsKey(userName) &&  users.get(userName).getPassWord().equals(password)) {
           return JwtUtil.generateToken(userName);
        }
         throw new LoginFailExeption("failed login");

    }

    public void addUsers(String userName, String password) {


        users.put(userName, new User(userName, password));
    }
}






