package org.tdd.logIn;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login;


    @BeforeEach
    void setUp() {



        login = new Login();

        login.addUsers("anna", "losen");
        login.addUsers("berit", "123456");
        login.addUsers("kalle", "password");

    }


    @ParameterizedTest
    @CsvSource({"anna,losen", "berit,123456", "kalle,password"})
    void test_verify_users_with_token_succes(String username,String password) throws LoginFailExeption {



        assertDoesNotThrow(()-> login.loginUser(username, password));
        String token = login.loginUser(username, password);
        assertFalse(token.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({"anna,losen", "berit,123456", "kalle,password"})
    void test_verify_token_succes(String username,String password) throws LoginFailExeption {

        assertDoesNotThrow(()-> login.loginUser(username, password));
        String token = login.loginUser(username, password);
        assertTrue(JwtUtil.validateToken(username,token));
    }

    @Test
    void test_hashPassWord_succes() {


        assertTrue(PasswordUtilities.generateNewHashPassword("Hoi"));

    }
}
