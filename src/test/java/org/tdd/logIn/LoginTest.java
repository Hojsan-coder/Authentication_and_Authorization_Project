package org.tdd.logIn;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tdd.logIn.enums.Permissions;
import org.tdd.logIn.enums.Resource;
import org.tdd.logIn.utils.JwtUtil;
import org.tdd.logIn.utils.PasswordUtilities;
import org.tdd.logIn.utils.PermissionsUtils;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login;


    @BeforeEach
    void setUp() {


        login = new Login();

        login.addUser("anna", "losen", Permissions.READ_WRITE_EXECUTE, Permissions.EXECUTE);
        login.addUser("berit", "123456", Permissions.READ_EXECUTE, Permissions.WRITE);
        login.addUser("kalle", "password", Permissions.READ, Permissions.READ_WRITE);

        login.updateUserPermissionList();

    }


    @ParameterizedTest
    @CsvSource({"anna,losen", "berit,123456", "kalle,password"})
    void test_verify_users_with_token_success(String username, String password) throws LoginFailExeption {


        assertDoesNotThrow(() -> login.loginUser(username, password));
        String token = login.loginUser(username, password);
        assertFalse(token.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({"anna,losen", "berit,123456", "kalle,password"})
    void test_verify_token_success(String username, String password) throws LoginFailExeption {

        assertDoesNotThrow(() -> login.loginUser(username, password));
        String token = login.loginUser(username, password);
        assertTrue(JwtUtil.validateToken(username, token));
    }

    @Test
    void test_hashPassWord_success() {


        assertTrue(PasswordUtilities.generateNewHashPassword("123456"));

    }

    @Test
    void test_user_permissions_success() {

        login.setTokenToAllUsers();
        login.users.forEach((userName, user) -> assertNotNull(PermissionsUtils.getUserPermissions(user.getToken(), Resource.ACCOUNT)));

        login.users.forEach((userName, user) -> assertNotNull(PermissionsUtils.getUserPermissions(user.getToken(), Resource.PROVISION_CALC)));

    }
}
