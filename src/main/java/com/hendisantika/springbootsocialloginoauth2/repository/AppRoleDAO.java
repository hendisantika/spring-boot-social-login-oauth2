package com.hendisantika.springbootsocialloginoauth2.repository;

import com.hendisantika.springbootsocialloginoauth2.entity.AppRole;
import com.hendisantika.springbootsocialloginoauth2.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-social-login-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/20
 * Time: 18.41
 */
@Repository
@Transactional
public class AppRoleDAO {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<String> getRoleNames(Long userId) {
        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur "
                + " where ur.appUser.userId = :userId ";
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public AppRole findAppRoleByName(String roleName) {
        try {
            String sql = "Select e from " + AppRole.class.getName() + " e "
                    + " where e.roleName = :roleName ";

            Query query = this.entityManager.createQuery(sql, AppRole.class);
            query.setParameter("roleName", roleName);
            return (AppRole) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
