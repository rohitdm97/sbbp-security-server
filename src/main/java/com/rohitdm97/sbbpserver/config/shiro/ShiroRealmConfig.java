package com.rohitdm97.sbbpserver.config.shiro;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroRealmConfig {

//    @Bean
//    public Realm realm() {
//        return new AuthNRealmImpl();
//    }
//
////    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//
//        // logged in users with the 'admin' role
//        chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
//
//        // logged in users with the 'document:read' permission
//        chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
//
//        // all other paths require a logged in user
//        chainDefinition.addPathDefinition("/**", "authc");
//
//        chainDefinition.addPathDefinition("/swagger**", "anon");
//        return chainDefinition;
//    }

}
