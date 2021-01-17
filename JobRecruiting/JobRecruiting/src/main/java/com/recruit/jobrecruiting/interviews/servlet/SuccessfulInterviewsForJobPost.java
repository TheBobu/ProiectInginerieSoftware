/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.servlet;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for accessing the successful interviews (candidates already accepted by Recruiter/Interviewer) 
 * for a specific Jobpost. Servlet can only be accessed by users who are Department Directors. 
 *
 * @author robert
 */
@DeclareRoles({"DepartmentDirectorRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"DepartmentDirectorRole"}))
@WebServlet(name = "SuccessfulInterviews", urlPatterns = {"/SuccessfulInterviewsForJobPost"})
public class SuccessfulInterviewsForJobPost extends HttpServlet {

    @Inject
    private InterviewBean interviewBean;
    
    @Inject JobPostBean jobPostBean;
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
        Integer jobPostId = Integer.parseInt(request.getParameter("id"));
        
        List<InterviewDetails> interviews = interviewBean.getAllSuccessfulInterviewsForJobPost(jobPostId);
        request.setAttribute("interviews", interviews);
        
        String jobPostTitle = jobPostBean.getJobPost(jobPostId).getTitle();
        request.setAttribute("jobPostTitle", jobPostTitle);
                
        request.getRequestDispatcher("/WEB-INF/pages/interview/successfulInterviewsForJobPost.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Successful interviews for the a specific jobpost";
    }
}
