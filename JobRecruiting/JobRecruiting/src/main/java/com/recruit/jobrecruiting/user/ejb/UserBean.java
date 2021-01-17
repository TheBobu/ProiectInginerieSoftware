/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.user.ejb;

import com.recruit.jobrecruiting.common.UserDetails;
import com.recruit.jobrecruiting.common.UserLightDetails;
import com.recruit.jobrecruiting.skill.ejb.SkillBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Photo;
import com.recruit.jobrecruiting.entity.PhotoType;
import com.recruit.jobrecruiting.entity.Position;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.User;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Bean for the {@link User} entity.
 *
 * @author robert, andrei, Andreea Purta, DENISA
 */
@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @Inject
    private SkillBean skillBean;

    @PersistenceContext
    private EntityManager em;


    /**
     * Gets all users from the database.
     *
     * @return Returns a complete list of users.
     */
    public List<UserLightDetails> getAllUsersLight() {
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToLightDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> getAllUsers() {
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    /**
     * Gets all usernames of the users.
     *
     * @return Returns a complete list of all usernames.
     */
    public List<String> getAllUsernames() {
        return (List<String>) em.createQuery("SELECT u.username FROM User u").getResultList();
    }

    /**
     * Gets all emails of the users.
     *
     * @return Returns a complete list of all emails.
     */
    public List<String> getAllEmails() {
        return (List<String>) em.createQuery("SELECT u.email FROM User u").getResultList();
    }

    public void updatePassword(Integer id, String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros 
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        String pass = hexString.toString();
        User user = getUserById(id);
        User oldUser = getUserById(id);
        user.setPassword(pass);
        em.remove(oldUser);
        em.persist(user);
    }

    /**
     * Adds a new user entry in the database.
     *
     * @param username
     * @param email
     * @param password
     * @param birthDate
     * @param firstName
     * @param lastName
     * @param address
     * @param shortBio
     * @return Returns the id of the new user.
     * @throws NoSuchAlgorithmException when the password cannot be hashed with
     * sha256
     */
    public Integer createUser(String username, String email, String password, LocalDate birthDate, String firstName, String lastName, String address, String shortBio) throws NoSuchAlgorithmException {
        User user = new User();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros 
        while (hexString.length() < 32) {
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
        user.setShortBio(shortBio);
        user.setStatus(Status.INACTIVE);
        user.setPosition(Position.CANDIDATE);
        em.persist(user);

        return user.getId();
    }

    public User getUserById(Integer id) {
        return em.find(User.class, id);
    }

    public User getUserByUsername(String username) {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.username=:username")
                .setParameter("username", username)
                .getResultList().get(0);
    }

    public void activateUser(Integer id) {
        User user = getUserById(id);
        user.setStatus(Status.ACTIVE);

        User oldUser = getUserById(id);
        em.remove(oldUser);
        em.persist(user);
    }

    public void deactivateUser(Integer id) {
        User user = getUserById(id);
        user.setStatus(Status.INACTIVE);

        User oldUser = getUserById(id);
        em.remove(oldUser);
        em.persist(user);
    }

    public void updateUser(Integer id, String email, Department department, LocalDate birthDate, String firstName, String lastName, String address, String shortBio, String userExperience) {

        User user = getUserById(id);
        user.setAddress(address);
        user.setDepartment(department);
        user.setBirthDate(birthDate);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUserExperience(userExperience);
        user.setShortBio(shortBio);

        User oldUser = getUserById(id);
        em.remove(oldUser);
        em.persist(user);
    }

    public void updatePosition(Integer id, Position position) {

        User user = getUserById(id);
        user.setPosition(position);
        User oldUser = getUserById(id);
        em.remove(oldUser);
        em.persist(user);
    }

    /**
     * asa Adds a CV to a specific user.
     *
     * @param id the id of the user
     * @param fileName name of the file
     * @param fileType type of the file
     * @param fileContent content of the file
     */
    public void addCv(Integer id, String fileName, String fileType, byte[] fileContent) {
        Photo photo = new Photo();
        photo.setFilename(fileName);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        photo.setPhotoType(PhotoType.CV);

        User user = getUserById(id);
        user.setCv(photo);

        photo.setUser(user);
        em.persist(photo);
    }

    /**
     * Adds a profile photo to a specific user.
     *
     * @param id the id of the user
     * @param fileName name of the file
     * @param fileType type of the file
     * @param fileContent content of the file
     */
    public void addProfilePhoto(Integer id, String fileName, String fileType, byte[] fileContent) {
        Photo photo = new Photo();
        photo.setFilename(fileName);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        photo.setPhotoType(PhotoType.PROFILE_PHOTO);

        User user = getUserById(id);
        user.setProfilePhoto(photo);

        photo.setUser(user);
        em.persist(photo);
    }

    public void updateProfilePhoto(Integer id, Integer userId, String fileName, String fileType, byte[] fileContent) {
        Photo photo = findProfilePictureById(id);
        if (photo == null) {
            //daca nuu exista sa adauge una noua
            this.addProfilePhoto(userId, fileName, fileType, fileContent);
            return;
        }

        photo.setFilename(fileName);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        photo.setPhotoType(PhotoType.PROFILE_PHOTO);

        User user = getUserById(userId);
        user.setProfilePhoto(photo);

        photo.setUser(user);

        Photo oldPhoto = findProfilePictureById(id);
        em.remove(oldPhoto);

        em.persist(photo);

    }

    public void updateCV(Integer id, Integer userId, String fileName, String fileType, byte[] fileContent) {
        Photo photo = findCvById(id);
        MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
        if (photo == null) {
            //daca nuu exista sa adauge una noua
            this.addCv(id, fileName, fileType, fileContent);
            return;
        }
        photo.setFilename(fileName);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        photo.setPhotoType(PhotoType.CV);

        User user = getUserById(userId);
        user.setProfilePhoto(photo);

        photo.setUser(user);

        Photo oldCv = findCvById(id);
        em.remove(oldCv);
        em.persist(photo);

    }

    public Photo findCvById(Integer id) {
        TypedQuery<Photo> typedQuery = em.createQuery("SELECT p FROM Photo p WHERE p.user.id = :id AND p.photoType = :type", Photo.class)
                .setParameter("id", id).setParameter("type", PhotoType.CV);
        List<Photo> photos = typedQuery.getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        Photo photo = photos.get(0);
        return photo;
    }

    public Photo findProfilePictureById(Integer id) {
        TypedQuery<Photo> typedQuery = em.createQuery("SELECT p FROM Photo p WHERE p.user.id = :id AND p.photoType = :type", Photo.class)
                .setParameter("id", id).setParameter("type", PhotoType.PROFILE_PHOTO);
        List<Photo> photos = typedQuery.getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        Photo photo = photos.get(0);
        return photo;
    }

    public String getGeneralDirectorEmail() {
        Query query = em.createQuery("SELECT u.email FROM User u WHERE u.position = :position")
                .setParameter("position", Position.GENERAL_DIRECTOR);
        return (String) query.getResultList().get(0);
    }

    private List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getBirthDate(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getProfilePhoto(), user.getCv(), user.getStatus(), user.getPosition(), user.getDepartment());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

    private List<UserLightDetails> copyUsersToLightDetails(List<User> users) {
        List<UserLightDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserLightDetails userDetails = new UserLightDetails(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPosition(), user.getStatus());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

    /**
     * Gets the department of a specific user.
     * 
     * @param username the username of the user whose department you want to get
     * @return Returns the department of the user
     */
    public Department getDepartment(String username) {
        try {
            TypedQuery<Department> typedQuery = em.createQuery("SELECT u.department FROM User u WHERE u.username = :username", Department.class)
                    .setParameter("username", username);
            
            return typedQuery.getSingleResult();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
