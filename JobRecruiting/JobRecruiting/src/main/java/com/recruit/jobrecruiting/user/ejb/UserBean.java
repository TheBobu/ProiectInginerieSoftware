/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.user.ejb;

import com.recruit.jobrecruiting.entity.User;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Bean for the {@link User} entity. 
 * 
 * @author robert
 */
@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    /**
     * Gets all users from the database. 
     * TODO: replace User class with UserDetails class. 
     * 
     * @return Returns a complete list of users.
     */
    public List<User> getAllUsers() {
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return users;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
