package com.hendisantika.springbootsocialloginoauth2.config;

import com.hendisantika.springbootsocialloginoauth2.repository.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
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

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        try {
            this.autoSignUp = Boolean.parseBoolean(env.getProperty("social.auto-signup"));
        } catch (Exception e) {
            this.autoSignUp = false;
        }

        FacebookConnectionFactory ffactory = new FacebookConnectionFactory(env.getProperty("facebook.app.id"),
                env.getProperty("facebook.app.secret"));
        ffactory.setScope(env.getProperty("facebook.scope"));
        cfConfig.addConnectionFactory(ffactory);

        GoogleConnectionFactory gfactory = new GoogleConnectionFactory(env.getProperty("google.client.id"),
                env.getProperty("google.client.secret"));
        gfactory.setScope(env.getProperty("google.scope"));
        cfConfig.addConnectionFactory(gfactory);

        LinkedInConnectionFactory lfactory = new LinkedInConnectionFactory(env.getProperty("linkedin.consumer.key"),
                env.getProperty("linkedin.consumer.secret"));
        lfactory.setScope(env.getProperty("linkedin.scope"));
        cfConfig.addConnectionFactory(lfactory);

        TwitterConnectionFactory tfactory = new TwitterConnectionFactory(env.getProperty("twitter.consumer.key"),
                env.getProperty("twitter.consumer.secret"));
        cfConfig.addConnectionFactory(tfactory);


    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }
}
