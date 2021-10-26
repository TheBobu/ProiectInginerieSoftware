/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An enum with the possible states: CANDIDATE, RECRUITER, DEPARTMENT_DIRECTOR,
 * GENERAL_DIRECTOR, ADMIN
 *
 * @author robert
 */
public enum Position {
    CANDIDATE, RECRUITER, DEPARTMENT_DIRECTOR, GENERAL_DIRECTOR, ADMIN, HR_DIRECTOR;

    public static List<Position> canApplyToJobs() {
        return new ArrayList<>(Arrays.asList(ADMIN, RECRUITER, CANDIDATE));
    }
}
