/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

/**
 *
 * @author DENISA
 */
public enum Skill {
    JAVA("Java"),
    CS("C#"),
    CPP("C++");

    public final String label;

    private Skill(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
