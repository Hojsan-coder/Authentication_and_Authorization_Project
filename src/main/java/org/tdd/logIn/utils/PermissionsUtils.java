package org.tdd.logIn.utils;

import org.tdd.logIn.enums.Permissions;
import org.tdd.logIn.enums.Resource;
import org.tdd.logIn.models.User;

import java.util.HashMap;
import java.util.List;

public class PermissionsUtils {

    private static HashMap<String, User> users;

    public static void setUsers(HashMap<String, User> users) {
        PermissionsUtils.users = users;
    }

    public static Permissions getUserPermissions(String token, Resource resource) {
        for (User user : users.values()) {
            if (user.getToken().equals(token)) {
                switch (resource) {
                    case ACCOUNT:
                        return user.getAccountPermissions();
                    case PROVISION_CALC:
                        return user.getProvisionsCalcPermissions();
                }
            }
        }
        return null;
    }
}
