/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.util.Rules;
import com.recruit.jobrecruiting.util.Util;
import java.util.HashMap;

/**
 *
 * @author DENISA
 */
public class JobPostValidator implements Validator {

    private String title;
    private String description;
    private String noOfPositionsAvailable;
    private String noOfPositionsFilled;
    private String department;
    private String status;
    private String[] skills;
    private String type;
    private String salary;

    private HashMap<String, String> messageBag;

    public JobPostValidator(String title, String description, String noOfPositionsAvailable, String noOfPositionsFilled, String department, String status, String[] skills, String type, String salary) {
        this.title = title;
        this.description = description;
        this.noOfPositionsAvailable = noOfPositionsAvailable;
        this.noOfPositionsFilled = noOfPositionsFilled;
        this.department = department;
        this.status = status;
        this.skills = skills;
        this.type = type;
        this.salary = salary;
        this.messageBag = messageBag;
    }


    @Override
    public Boolean passes(HashMap<String, String> messageBag) {
        this.messageBag = messageBag;

        title();
        description();
        noOfPositionsAvailable();
        noOfPositionsFilled();
        status();
        department();
        skills();
        salary();
        type();

        return messageBag.isEmpty();
    }

    private void title() {
        if (!Rules.lengthGreaterThan(title, 5)) {
            messageBag.put("title", "Please provide a valid title");
        }
    }

    private void description() {
        if (!Rules.lengthGreaterThan(description, 20)) {
            messageBag.put("description", "Please provide a valid description");
        }
    }

    private void noOfPositionsAvailable() {
        boolean result = Rules.isNumber(noOfPositionsAvailable)
                && Rules.greaterThan(Util.number(noOfPositionsAvailable), 0);
        if (result == false) {
            messageBag.put("noOfPositionsAvailable", "Please provide a valid number of position available");

        }
    }

    private void noOfPositionsFilled() {

        Boolean result = (noOfPositionsFilled.equals("")) || Rules.isNumber(noOfPositionsFilled) && Rules.greaterThan(Util.number(noOfPositionsFilled), -1);

        if (result == false) {
            messageBag.put("noOfPositionsFilled", "Please provide a valid number of positions filled");
        }
    }

    private void status() {

        Boolean result = Rules.isStatus(status);

        if (result == false) {
            messageBag.put("status", "Please provide a valid status");
        }
    }

    private void department() {

        Boolean result = Rules.isDepartment(department);

        if (result == false) {
            messageBag.put("department", "Please provide a valid department");
        }
    }

    private void type() {

        Boolean result = Rules.isType(type);

        if (result == false) {
            messageBag.put("type", "Please provide a valid job type");
        }
    }

    private void salary() {

        Boolean result = Rules.isNumber(salary) && Rules.greaterThan(Util.number(salary), 0);

        if (result == false) {
            messageBag.put("salary", "Please provide a valid salary");
        }
    }

    private void skills() {

        if (!Rules.arrayNotEmpty(skills)) {
            messageBag.put("skills", "Please choose at least one skill");
        }
    }

}
