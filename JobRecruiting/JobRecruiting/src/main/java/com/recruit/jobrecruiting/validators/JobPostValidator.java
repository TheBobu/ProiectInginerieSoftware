/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.util.Rules;
import com.recruit.jobrecruiting.util.Util;

/**
 *
 * @author DENISA
 */
public class JobPostValidator extends Validator {

    private String title;
    private String noOfPositionsAvailable;
    private String requirements;
    private String resposabilities;
    private String department;
    private String status;
    private String[] skills;
    private String type;
    private String salary;

    public JobPostValidator(String title, String requirements, String resposabilities, String noOfPositionsAvailable, String department, String status, String[] skills, String type, String salary) {
        this.title = title;
        this.resposabilities = resposabilities;
        this.requirements = requirements;
        this.noOfPositionsAvailable = noOfPositionsAvailable;
        this.department = department;
        this.status = status;
        this.skills = skills;
        this.type = type;
        this.salary = salary;
        this.messageBag = messageBag;
    }

    @Override
    protected void validate() {
        title();
        requirements();
        resposabilities();
        noOfPositionsAvailable();
        status();
        department();
        skills();
        salary();
        type();
    }

    /**
     * Validator for jobpost title
     */
    private void title() {
        if (!Rules.lengthGreaterThan(title, 5)) {
            messageBag.put("title", "Please provide a valid title");
        }
    }

    /**
     * Validator for jobpost requirements
     */
    private void requirements() {
        if (!Rules.lengthGreaterThan(requirements, 20)) {
            messageBag.put("requirements", "Please provide valid requirements");
        }
    }

    /**
     * Validator for jobpost resposabilities
     */
    private void resposabilities() {
        if (!Rules.lengthGreaterThan(resposabilities, 20)) {
            messageBag.put("resposabilities", "Please provide valid resposabilities");
        }
    }

    /**
     * Validator for jobpost number of positions available
     */
    private void noOfPositionsAvailable() {
        boolean result = Rules.isNumber(noOfPositionsAvailable)
                && Rules.greaterThan(Util.number(noOfPositionsAvailable), 0);
        if (result == false) {
            messageBag.put("noOfPositionsAvailable", "Please provide a valid number of position available");

        }
    }

    /**
     * Validator for jobpost status
     */
    private void status() {

        Boolean result = Rules.isStatus(status);

        if (result == false) {
            messageBag.put("status", "Please provide a valid status");
        }
    }

    /**
     * Validator for jobpost department
     */
    private void department() {

        Boolean result = Rules.isDepartment(department);

        if (result == false) {
            messageBag.put("department", "Please provide a valid department");
        }
    }

    /**
     * Validator for jobpost type
     */
    private void type() {

        Boolean result = Rules.isType(type);

        if (result == false) {
            messageBag.put("type", "Please provide a valid job type");
        }
    }

    /**
     * Validator for jobpost salary
     */
    private void salary() {

        Boolean result = Rules.isNumber(salary) && Rules.greaterThan(Util.number(salary), 0);

        if (result == false) {
            messageBag.put("salary", "Please provide a valid salary");
        }
    }

    /**
     * Validator for jobpost skills
     */
    private void skills() {

        if (!Rules.arrayNotEmpty(skills)) {
            messageBag.put("skills", "Please choose at least one skill");
        }
    }

}
