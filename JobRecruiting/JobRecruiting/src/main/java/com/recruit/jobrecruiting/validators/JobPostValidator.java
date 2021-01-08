/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.util.Rules;
import java.util.HashMap;

/**
 *
 * @author DENISA
 */
public class JobPostValidator implements Validator {

    private String title;
    private String description;
    private int noOfPositionsAvailable;
    private int noOfPositionsFilled;
    private String department;
    private String status;

    private HashMap<String, String> messageBag;

    public JobPostValidator(String title, String description, int noOfPositionsAvailable, int noOfPositionsFilled, String department, String status) {
        this.title = title;
        this.description = description;
        this.noOfPositionsAvailable = noOfPositionsAvailable;
        this.noOfPositionsFilled = noOfPositionsFilled;
        this.department = department;
        this.status = status;
    }

    public Boolean passes(HashMap<String, String> messageBag) {
        this.messageBag = messageBag;

        return title() && description() && noOfPositionsAvailable() && noOfPositionsFilled()
                && status() && department();
    }

    private Boolean title() {
        Boolean result = Rules.lengthGreaterThan(title, 5);

        if (result == false) {
            messageBag.put("title", "Please provide a valid title");
        }

        return result;
    }

    private Boolean description() {

        Boolean result = Rules.lengthGreaterThan(description, 20);

        if (result == false) {
            messageBag.put("description", "Please provide a valid description");
        }

        return result;
    }

    private Boolean noOfPositionsAvailable() {

        Boolean result = Rules.greaterThan(noOfPositionsAvailable, 0);

        if (result == false) {
            messageBag.put("noOfPositionsAvailable", "Please provide a valid number of position available");
        }

        return result;
    }

    private Boolean noOfPositionsFilled() {

        Boolean result = Rules.greaterThan(noOfPositionsFilled, -1);

        if (result == false) {
            messageBag.put("noOfPositionsFilled", "Please provide a valid number of positions filled");
        }

        return result;
    }

    private Boolean status() {

        Boolean result = Rules.isStatus(status);

        if (result == false) {
            messageBag.put("status", "Please provide a valid status");
        }

        return result;
    }

    private Boolean department() {

        Boolean result = Rules.isDepartment(department);

        if (result == false) {
            messageBag.put("department", "Please provide a valid department");
        }

        return result;
    }

}
