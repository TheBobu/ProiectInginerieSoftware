/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.admin.servlet;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.common.UserLightDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
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
 *
 * @author Andreea Purta
 */
@DeclareRoles({"AdminRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
@WebServlet(name = "JobAdministration", urlPatterns = {"/JobAdministration"})
public class JobAdministration extends HttpServlet {

    @Inject
    private JobPostBean jobPostBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<JobPostDetails> jobs = jobPostBean.getAllJobPosts();

        request.getSession().setAttribute("jobs", jobs);
        request.getRequestDispatcher("/WEB-INF/pages/administration/jobAdministration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
