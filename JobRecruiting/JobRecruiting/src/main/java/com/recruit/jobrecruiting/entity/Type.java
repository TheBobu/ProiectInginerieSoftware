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
    FULL_TIME("Full-time"),
    PART_TIME("Part-time");

    public final String label;

    private Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
