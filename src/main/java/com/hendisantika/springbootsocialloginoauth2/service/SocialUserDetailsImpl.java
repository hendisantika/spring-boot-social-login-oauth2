package com.hendisantika.springbootsocialloginoauth2.service;

import com.hendisantika.springbootsocialloginoauth2.entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.49
 */
public class SocialUserDetailsImpl implements SocialUserDetails {

    private static final long serialVersionUID = 1L;
    private final List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
    private final AppUser appUser;

    public SocialUserDetailsImpl(AppUser appUser, List<String> roleNames) {
        this.appUser = appUser;

        for (String roleName : roleNames) {

            GrantedAuthority grant = new SimpleGrantedAuthority(roleName);
            this.list.add(grant);
        }
    }
}
