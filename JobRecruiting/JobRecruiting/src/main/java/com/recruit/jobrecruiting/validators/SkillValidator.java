/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.util.Rules;

/**
 *
 * @author DENISA
 */
public class SkillValidator extends Validator {

    private String name;

    public SkillValidator(String name) {
        this.name = name;
    }

    @Override
    protected void validate() {
        name();
    }

    /**
     * Validator for skill name
     */
    private void name() {
        if (!Rules.lengthGreaterThan(name, 2)) {
            messageBag.put("name", "Please provide a valid name");
        }
    }

}
