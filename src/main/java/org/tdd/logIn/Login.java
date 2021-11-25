package org.tdd.logIn;

import java.util.HashMap;

public class Login {

    public HashMap<String, User> users = new HashMap<>();




    public boolean loginUser(String userName, String password) {


        if (users.containsKey(userName)) {
            return users.get(userName).getPassWord().equals(password);
        }
        return false;
    }

    public void addUsers(String userName, String password) {


        users.put(userName, new User(userName, password));
    }
}






