package com.hendisantika.springbootsocialloginoauth2.repository;

import com.hendisantika.springbootsocialloginoauth2.entity.UserConnection;
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
 * Time: 18.46
 */
@Repository
@Transactional
public class UserConnectionDAO {

    @Autowired
    private EntityManager entityManager;

    public UserConnection findUserConnectionByUserProviderId(String userProviderId) {
        try {
            String sql = "Select e from " + UserConnection.class.getName() + " e " //
                    + " Where e.userProviderId = :userProviderId ";

            Query query = entityManager.createQuery(sql, UserConnection.class);
            query.setParameter("userProviderId", userProviderId);

            @SuppressWarnings("unchecked")
            List<UserConnection> list = query.getResultList();

            return list.isEmpty() ? null : list.get(0);
        } catch (NoResultException e) {
            return null;
        }
    }

}
