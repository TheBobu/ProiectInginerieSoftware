/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.entity;

/**
 * An enum with 3 possible state: WAITING_INTERVIEW_DATE, BEFORE_INTERVIEW,
 * AFTER_INTERVIEW, REJECTED, ACCEPTED.
 *
 * @author robert
 */
public enum InterviewStatus {
    APPLIED_FOR, WAITING_INTERVIEW_DATE, BEFORE_INTERVIEW, AFTER_INTERVIEW, ACCEPTED_BY_RECRUITER, REJECTED_BY_RECRUITER, ACCEPTED_BY_DIRECTOR, REJECTED_BY_DIRECTOR,;
}
