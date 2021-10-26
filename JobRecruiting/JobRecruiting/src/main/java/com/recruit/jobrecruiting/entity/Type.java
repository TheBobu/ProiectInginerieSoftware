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
public enum Type {
    FULL_TIME("Full-time", "FT"),
    PART_TIME("Part-time", "PT");

    private final String label;
    private final String abbreviation;

    private Type(String label, String abbreviation) {
        this.label = label;
        this.abbreviation = abbreviation;
    }

    public String getLabel() {
        return label;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
