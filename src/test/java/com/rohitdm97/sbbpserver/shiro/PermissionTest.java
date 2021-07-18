package com.rohitdm97.sbbpserver.shiro;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class PermissionTest {

    @Test
    void exactMatch() {
        assertTrue(permitted("*", "*"));
        assertTrue(permitted("model:*", "model:*"));
        assertTrue(permitted("model:update:*", "model:update:*"));
        assertTrue(permitted("model:update:3", "model:update:3"));
    }

    @Test
    void userHasAllAccess() {
        assertTrue(permitted("*", "model"));
        assertTrue(permitted("*", "model:update"));
        assertTrue(permitted("model:*", "model:update"));
        assertTrue(permitted("*", "model:update:3"));
        assertTrue(permitted("model:*", "model:update:3"));
        assertTrue(permitted("model:update:*", "model:update:3"));
    }

    @Test
    void userHasSpecificAskingForWild() {
        assertFalse(permitted("model", "*"));
        assertFalse(permitted("model:update", "*"));
        assertFalse(permitted("model:update:3", "*"));

        assertFalse(permitted("model:*", "*"));
        assertFalse(permitted("model:update:*", "*"));

        assertTrue(permitted("model", "model:*"));
        assertFalse(permitted("model:update", "model:*"));
        assertFalse(permitted("model:update:3", "model:*"));

        assertTrue(permitted("model:*", "model:*"));
        assertFalse(permitted("model:update:*", "model:*"));

        assertTrue(permitted("model", "model:update:*"));
        assertTrue(permitted("model:update", "model:update:*"));
        assertFalse(permitted("model:update:3", "model:update:*"));

        assertTrue(permitted("model:*", "model:update:*"));
        assertTrue(permitted("model:update:*", "model:update:*"));
    }

    // is it permitted to do "check" if the user has permission "user"
    // i.e. service logic checks using "check"
    // and user has "user" permission
    boolean permitted(String user, String check) {
        return new WildcardPermission(user).implies(new WildcardPermission(check));
    }

}
