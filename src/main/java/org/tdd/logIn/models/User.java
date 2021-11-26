package org.tdd.logIn.models;

import org.tdd.logIn.enums.Permissions;

public class User {

    private String token;
    private String userName;
    private String passWord;
    private Permissions accountPermissions;
    private Permissions provisionsCalcPermissions;




    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, Permissions accountPermissions, Permissions provisionsCalcPermissions) {
        this.userName = userName;
        this.passWord = passWord;
        this.accountPermissions = accountPermissions;
        this.provisionsCalcPermissions = provisionsCalcPermissions;
    }


    public Permissions getAccountPermissions() {
        return accountPermissions;
    }

    public void setAccountPermissions(Permissions accountPermissions) {
        this.accountPermissions = accountPermissions;
    }

    public Permissions getProvisionsCalcPermissions() {
        return provisionsCalcPermissions;
    }

    public void setProvisionsCalcPermissions(Permissions provisionsCalcPermissions) {
        this.provisionsCalcPermissions = provisionsCalcPermissions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

