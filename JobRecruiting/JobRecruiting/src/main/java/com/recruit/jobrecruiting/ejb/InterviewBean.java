/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.ejb;

import com.recruit.jobrecruiting.entity.Interview;
import com.recruit.jobrecruiting.entity.InterviewStatus;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.util.Util;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DENISA
 */
@Stateless
public class InterviewBean {

    @Inject
    JobPostBean jobPostBean;

    @Inject
    UserBean userBean;

    public void addInterview(String _jobPostId, String username) {
        Interview interview = new Interview();

        interview.setStatus(InterviewStatus.WAITING_INTERVIEW_DATE);

        Integer jobPostId = Util.number(_jobPostId);
        interview.setJobPost(jobPostBean.getJobPostEntity(jobPostId));

        User user = userBean.getUserByUsername(username);
        interview.setCandidate(user);
    }
}
