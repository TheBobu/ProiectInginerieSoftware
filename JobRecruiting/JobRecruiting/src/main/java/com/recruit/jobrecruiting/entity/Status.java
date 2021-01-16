/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

/**
 * An enum with 3 possible states: INACTIVE, ACTIVE.
 * 
 * @author robert
 */
public enum Status {
    INACTIVE("Inactive"),
    ACTIVE("Active"),
    WAITING_FOR_APPROVAL("Waiting for approval");

    public final String label;

    private Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Status[] getJobPostChoosable() {
        Status[] accepted = {ACTIVE, INACTIVE};
        return accepted;
    }
}
