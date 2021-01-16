/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.admin.servlet;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.entity.JobPost;
import com.recruit.jobrecruiting.entity.Position;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"AdminRole"}))
@WebServlet(name = "JobManager", urlPatterns = {"/JobManager"})
public class JobManager extends HttpServlet {
    @Inject JobPostBean jobPostBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Integer id = Integer.parseInt(request.getParameter("id"));
            JobPostDetails job = jobPostBean.getJobPost(id);
            request.getSession().setAttribute("job", job);
            request.getRequestDispatcher("/WEB-INF/pages/administration/jobManager.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
