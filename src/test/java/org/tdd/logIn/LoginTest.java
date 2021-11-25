package org.tdd.logIn;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    Login login;


    @BeforeEach
    void setUp() {



        login = new Login();

    }


    @Test
    void test_verify_users_succes() {

        login.addUsers("anna", "losen");
        login.addUsers("berit", "123456");
        login.addUsers("kalle", "password");

        assertTrue(login.loginUser("anna", "losen"));

    }

    @Test
    void test_hashPassWord_succes() {


        assertTrue(PasswordUtilities.generateNewHashPassword(""));

    }
}
