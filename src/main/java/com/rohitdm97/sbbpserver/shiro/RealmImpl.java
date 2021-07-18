package com.rohitdm97.sbbpserver.shiro;

import java.util.Collections;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * see {@link com.rohitdm97.sbbpserver.shiro.PermissionTest} for clarity
 */
@Component
public class RealmImpl extends AuthorizingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return new SimpleAuthenticationInfo(new SimplePrincipalCollection("username", getName()), "password");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        final SimpleAuthorizationInfo res = new SimpleAuthorizationInfo();
        // full access
        res.setStringPermissions(Collections.singleton("*:read:*"));
        return res;
    }

}
