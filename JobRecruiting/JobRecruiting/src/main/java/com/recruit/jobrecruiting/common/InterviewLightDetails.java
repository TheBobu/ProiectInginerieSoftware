/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.common;

import com.recruit.jobrecruiting.entity.InterviewStatus;
import com.recruit.jobrecruiting.entity.JobPost;
import com.recruit.jobrecruiting.entity.User;

/**
 *
 * @author Doly
 */
public class InterviewLightDetails extends InterviewDetails{
//    private String jobpostName;
//    private String candidateName;
//    private String interviewerName;
//    private String statusName;

    public InterviewLightDetails(Integer id, JobPost jobpost, User candidate, User interviewer, InterviewStatus interviewStatus) {
        super(id, jobpost, candidate, interviewer, interviewStatus);
    }

    public String getJobpostName() {
        return jobpost.getTitle();
    }

    public void setJobpostName(String jobpostName) {
        jobpost.setTitle(jobpostName);
        //this.jobpostName = jobpostName;
    }

    public String getCandidateName() {
        return candidate.getFirstName()+" "+candidate.getLastName();
    }

    public void setCandidateName(String firstName, String lastName) {
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        //this.candidateName = this.getCandidateName();
    }

    public String getInterviewerName() {
        return interviewer.getFirstName()+" "+interviewer.getLastName();
    }

    public void setInterviewerName(String firstName, String lastName) {
        interviewer.setFirstName(firstName);
        interviewer.setLastName(lastName);
        //this.interviewerName = this.getInterviewerName();
    }

    public String getStatusName() {
        return interviewStatus.name();
    }

//    public void setStatusName(String statusName) {
//        //interviewStatus;
//    }
}
