/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.user.ejb;

import com.recruit.jobrecruiting.common.UserDetails;
import com.recruit.jobrecruiting.entity.Photo;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.util.Detachable;
import com.recruit.jobrecruiting.util.Util;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
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
 * @author robert, andrei
 */
@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    /**
     * Gets all users from the database. TODO: replace User class with
     * UserDetails class.
     *
     * @return Returns a complete list of users.
     */

    public List<UserDetails> getAllUsers() {
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<Detachable> users = (List<Detachable>) query.getResultList();
            return Util.detachEntities(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public void createUser(String username, String email, String password, LocalDate birthDate, String firstName, String lastName, String address) throws NoSuchAlgorithmException {
        User user = new User();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
        String pass = hexString.toString();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(pass);
        user.setBirthDate(birthDate);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        
        em.persist(user);
    }
    
    public User getUserById(Integer id){
        return em.find(User.class, id);
    }
    
    public void activateUser(Integer id){
        User user = getUserById(id);
        user.setStatus(Status.ACTIVE);
        
        em.persist(user);
    }
    
    public void deactivateUser(Integer id){
        User user = getUserById(id);
        user.setStatus(Status.INACTIVE);
        
        em.persist(user);
    }
    
    public void updateUser(Integer id, String username, String email, String password, LocalDate birthDate, String firstName, String lastName, String address){
        User user = getUserById(id);
        user.setAddress(address);
        user.setBirthDate(birthDate);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
    }
    
    public void addCv(Integer id, String fileName, String fileType, byte[] fileContent){
        //add image type
        Photo photo = new Photo();
        photo.setFilename(fileName);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        
        User user = getUserById(id);
        user.setCv(photo);
        
        photo.setUser(user);
        em.persist(photo);
    }
    
    public void addProfilePicture(Integer id, String fileName, String fileType, byte[] fileContent){
        //add image type
        Photo photo = new Photo();
        photo.setFilename(fileName);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        
        User user = getUserById(id);
        user.setProfilePhoto(photo);
        
        photo.setUser(user);
        em.persist(photo);
    }
}
