/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.admin.servlet;

import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import java.io.IOException;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
@WebServlet(name = "JobActivatorDeactivator", urlPatterns = {"/JobActivatorDeactivator"})
public class JobActivatorDeactivator extends HttpServlet {

        @Inject JobPostBean jobPostBean;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Integer id = Integer.parseInt(request.getParameter("id"));
        jobPostBean.getJobPost(id);
        jobPostBean.activateDeactivateJobPost(id);
        response.sendRedirect(request.getContextPath()+"/JobAdministration");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
