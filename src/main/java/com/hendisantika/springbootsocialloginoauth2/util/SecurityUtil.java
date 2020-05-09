package com.hendisantika.springbootsocialloginoauth2.util;

import com.hendisantika.springbootsocialloginoauth2.entity.AppUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUserDetails;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.48
 */
public class SecurityUtil {
    public static void logInUser(AppUser user, List<String> roleNames) {
        SocialUserDetails userDetails = new SocialUserDetailsImpl(user, roleNames);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
