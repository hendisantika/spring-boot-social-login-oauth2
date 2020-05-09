package com.hendisantika.springbootsocialloginoauth2.validator;

import com.hendisantika.springbootsocialloginoauth2.repository.AppUserDAO;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.52
 */
@Component
public class AppUserValidator implements Validator {

    private final EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private AppUserDAO appUserDAO;

}
