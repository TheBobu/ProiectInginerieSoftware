/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.jobpost.servlet;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
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
 * Servlet for accessing the JobPosts from the department of the user
 * (Department Director). Servlet can only be accessed by users who are
 * Department Directors.
 *
 * @author robert
 */
@DeclareRoles({"DepartmentDirectorRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DepartmentDirectorRole"}))
@WebServlet(name = "JobPostsByDepartment", urlPatterns = {"/JobPostsByDepartment"})
public class JobPostsByDepartment extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Inject
    private JobPostBean jobPostBean;

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
        String myUsername = request.getRemoteUser();
        Department myDepartment = userBean.getDepartment(myUsername);
        request.setAttribute("myDepartment", myDepartment);

        List<JobPostDetails> jobPosts = jobPostBean.JobPostsByDepartment(myDepartment);
        request.setAttribute("jobPosts", jobPosts);

        request.getRequestDispatcher("/WEB-INF/pages/jobpost/jobPostsByDepartment.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "JobPostsByDepartment Servlet";
    }

}
