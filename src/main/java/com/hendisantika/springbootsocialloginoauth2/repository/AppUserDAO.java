package com.hendisantika.springbootsocialloginoauth2.repository;

import com.hendisantika.springbootsocialloginoauth2.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.43
 */
@Transactional
public class AppUserDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AppRoleDAO appRoleDAO;

    public AppUser findAppUserByUserId(Long userId) {
        try {
            String sql = "select e from " + AppUser.class.getName() + " e where e.userId = :userId ";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userId", userId);
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
