package com.hendisantika.springbootsocialloginoauth2.service;

import com.hendisantika.springbootsocialloginoauth2.entity.AppUser;
import com.hendisantika.springbootsocialloginoauth2.repository.AppUserDAO;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.49
 */
public class ConnectionSignUpImpl implements ConnectionSignUp {

    private final AppUserDAO appUserDAO;

    public ConnectionSignUpImpl(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    // After logging in social networking.
    // This method will be called to create a corresponding App_User record
    // if it does not already exist.
    @Override
    public String execute(Connection<?> connection) {

        AppUser account = appUserDAO.createAppUser(connection);
        return account.getUserName();
    }

}
