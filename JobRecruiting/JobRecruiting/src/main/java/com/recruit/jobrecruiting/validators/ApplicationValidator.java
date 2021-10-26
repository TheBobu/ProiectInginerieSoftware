/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.validators;

import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import com.recruit.jobrecruiting.util.Util;

/**
 *
 * @author DENISA
 */
public class ApplicationValidator extends Validator {

    private JobPostBean jobPostBean;

    private String jobid;

    public ApplicationValidator(String jobid, JobPostBean jobPostBean) {
        this.jobid = jobid;
        this.jobPostBean = jobPostBean;
    }

    @Override
    protected void validate() {
        jobpost();
    }

    private void jobpost() {
        Integer jobid = Util.number(this.jobid);

        if (jobPostBean.getJobPostEntity(jobid) == null) {
            messageBag.put("jobpost", "Job post does not exist");
        }
    }

}
