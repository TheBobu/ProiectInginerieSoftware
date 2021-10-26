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
public class InterviewDetails{// implements java.io.Serializable{
    private Integer id;
    protected JobPost jobpost;
    protected User candidate;
    protected User interviewer;
    protected InterviewStatus interviewStatus;

    public InterviewDetails(Integer id, JobPost jobpost, User candidate, User interviewer, InterviewStatus interviewStatus) {
        this.id = id;
        this.jobpost = jobpost;
        this.candidate = candidate;
        this.interviewStatus = interviewStatus;
        this.interviewer = interviewer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobPost getJobpost() {
        return jobpost;
    }

    public void setJobpost(JobPost jobpost) {
        this.jobpost = jobpost;
    }

    public User getCandidate() {
        return candidate;
    }
    
    public String getCandidateFullName(){
        return candidate.getFirstName()+" "+candidate.getLastName();
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public User getInterviewer() {
        return interviewer;
    }
    
    public String getInterviewerFullName(){
        return interviewer.getFirstName()+" "+interviewer.getLastName();
    }

    public void setInterviewer(User interviewer) {
        this.interviewer = interviewer;
    }
    
    public Boolean isAppliedFor(){
        //System.out.println("DIN METODA");
        if(interviewStatus==InterviewStatus.APPLIED_FOR)
            return Boolean.TRUE;
        return Boolean.FALSE;  
    }
    
}
