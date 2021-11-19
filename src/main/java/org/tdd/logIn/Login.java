package org.tdd.logIn;

public class Login {

    public boolean loginUser(String userName,String password){

         String myUserName = "hoi";
         String myPassWord = "12345";

        if (userName.equals(myUserName) && password.equals(myPassWord)){

            return true;
        }
        return false;


    }
}
