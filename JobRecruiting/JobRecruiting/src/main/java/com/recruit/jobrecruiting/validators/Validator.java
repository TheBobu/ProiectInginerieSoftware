/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import java.util.HashMap;

/**
 *
 * @author DENISA
 */
public abstract class Validator {

    HashMap<String, String> messageBag;

    public Boolean passes(HashMap<String, String> messageBag) {
        this.messageBag = messageBag;
        validate();
        return messageBag.size() == 0;
    }

    protected abstract void validate();

}
