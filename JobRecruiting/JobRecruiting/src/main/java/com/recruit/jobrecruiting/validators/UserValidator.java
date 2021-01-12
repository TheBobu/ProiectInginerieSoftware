/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.util.Rules;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Validator class, useful when creating a new User. It checks the fields and
 * displays custom error messages (if needed).
 *
 * @author robert
 */
public class UserValidator extends Validator {

    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String address;
    private UserBean userBean;

    public UserValidator(String username, String email, String password, LocalDate birthDate, String firstName, String lastName, String address, UserBean userBean) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.userBean = userBean;
    }

    @Override
    protected void validate() {
        username();
        email();
        password();
        birthDate();
        firstName();
        lastName();
        address();
    }

    /**
     * Validator for username field
     */
    private void username() {
        if (username.equals(" ")) {
            messageBag.put("username", "Please choose a valid username");
        } else if (userBean.getAllUsernames().contains(this.username)) {
            messageBag.put("username", "Please choose another username. This one is already taken");
        }
    }

    /**
     * Validator for email field
     */
    private void email() {
        if (email.equals(" ")) {
            messageBag.put("email", "Please choose a valid username");
        } else if (userBean.getAllEmails().contains(this.email)) {
            messageBag.put("email", "There is already an account associated with this email address");
        }
    }

    /**
     * Validator for password
     */
    private void password() {
        if (!Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$", password)) {
            messageBag.put("password", "Password must have length greater than 5 and should contain lowercase letter, uppercase letter, digit, special character");
        }
    }

    /**
     * Validator for birthDate
     */
    private void birthDate() {
        if (birthDate.isAfter(LocalDate.now())) {
            messageBag.put("birthDate", "Please enter a valid date");
        }
    }

    /**
     * Validator for firstName
     */
    private void firstName() {
        if (firstName.equals(" ")) {
            messageBag.put("firstName", "Please enter a valid username");
        }
    }

    /**
     * Validator for lastName
     */
    private void lastName() {
        if (lastName.equals(" ")) {
            messageBag.put("lastName", "Please enter a valid lastName");
        }
    }
    
    /**
     * Validator for address
     */
    private void address() {
        if(!Rules.lengthGreaterThan(address, 1)){
            messageBag.put("address", "Please enter a valid address");
        }
    }
}
