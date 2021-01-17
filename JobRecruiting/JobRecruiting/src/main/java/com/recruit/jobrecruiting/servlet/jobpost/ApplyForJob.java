/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.jobpost;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import com.recruit.jobrecruiting.mail.EmailBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.util.Util;
import com.recruit.jobrecruiting.validators.ApplicationValidator;
import com.recruit.jobrecruiting.validators.Validator;
import java.io.IOException;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DENISA
 */
/**
 * Servlet used fro applying for a job. It is accesible only to logged in users
 *
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CandidateRole"}))
@WebServlet(name = "ApplyForJob", urlPatterns = {"/ApplyForJob"})
public class ApplyForJob extends HttpServlet {

    @Inject
    private InterviewBean interviewBean;

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private UserBean userBean;

    @Inject
    private EmailBean emailBean;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getRemoteUser();
        String jobPost_id = request.getParameter("jobid");

        HashMap<String, String> messageBag = new HashMap<>();
        Validator validator = new ApplicationValidator(jobPost_id, jobPostBean);

        User user = userBean.getUserByUsername(username);

        if (validator.passes(messageBag)) {
            InterviewDetails interview = interviewBean.createInterview(jobPost_id, username);

            new Thread(() -> {
                String email = interview.getInterviewer().getEmail();
                String joburl = Util.getBaseUrl(request) + "/JobPost?id=" + jobPost_id;
                String candidateurl = Util.getBaseUrl(request) + "/Profile?id=" + user.getId();
                String body = interview.getCandidateFullName() + " has applied for " + joburl;
                body += " .Here is a link to their profile: " + candidateurl;
                emailBean.sendEmail(email, "Someone has applied to a job you created!", body);
            }).start();
        }
        response.sendRedirect(request.getContextPath() + "/JobPosts");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
