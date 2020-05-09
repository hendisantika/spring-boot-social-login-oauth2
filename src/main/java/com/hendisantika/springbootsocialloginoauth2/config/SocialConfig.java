package com.hendisantika.springbootsocialloginoauth2.config;

import com.hendisantika.springbootsocialloginoauth2.repository.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.54
 */
@Configuration
@EnableSocial
@PropertySource("classpath:social-cfg.properties")
public class SocialConfig implements SocialConfigurer {

    private final boolean autoSignUp = false;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AppUserDAO appUserDAO;
}
