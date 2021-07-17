//package com.rohitdm97.sbbpserver.shiro;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.realm.AuthenticatingRealm;
//
//public class AuthNRealmImpl extends AuthenticatingRealm {
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        User user = User.builder().username("username").build();
//        Password password = new Password();
//        return new SimpleAuthenticationInfo(user, password, getClass().getName());
//    }
//
//}
