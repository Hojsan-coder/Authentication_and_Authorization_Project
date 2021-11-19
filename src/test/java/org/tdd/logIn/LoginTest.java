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
    void test_create_login_succes() {



        assertTrue(login.loginUser("hoi","12345"));
    }
}
