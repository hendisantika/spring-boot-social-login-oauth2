package com.hendisantika.springbootsocialloginoauth2.controller;

import com.hendisantika.springbootsocialloginoauth2.form.AppUserForm;
import com.hendisantika.springbootsocialloginoauth2.repository.AppUserDAO;
import com.hendisantika.springbootsocialloginoauth2.validator.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.59
 */
@Controller
@Transactional
public class MainController {

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    private UsersConnectionRepository connectionRepository;

    @Autowired
    private AppUserValidator appUserValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {

        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == AppUserForm.class) {
            dataBinder.setValidator(appUserValidator);
        }
    }

    @GetMapping(value = {"/", "/welcome"})
    public String welcomePage(Model model) {
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

}
