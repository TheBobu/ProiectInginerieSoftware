/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.recruit.jobrecruiting.jobPost.servlet;

import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import com.recruit.jobrecruiting.mail.EmailBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.util.Util;
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
 * @author DENISA
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"RecruiterRole"}))
@WebServlet(name="CopyJobPost", urlPatterns={"/JobPost/Copy"})
public class CopyJobPost extends HttpServlet {

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private EmailBean emailBean;

    @Inject
    private UserBean userBean;

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Status status = Status.WAITING_FOR_APPROVAL;
        if (request.isUserInRole("GeneralDirectorRole")) {
            status = Status.INACTIVE;
        }

        String username = request.getRemoteUser();
        int jobpost_id = jobPostBean.copyJobPost(id, status, username).getId();

        if (!request.isUserInRole("GeneralDirectorRole")) {
            sendEmail(request, jobpost_id);

        }
        response.sendRedirect(request.getContextPath() + "/JobPost/Edit?id=" + jobpost_id);

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void sendEmail(HttpServletRequest request, int jobpost_id) {
        new Thread(() -> {
            String email = userBean.getGeneralDirectorEmail();
            String url = Util.getBaseUrl(request) + "/JobPost?id=" + jobpost_id;
            emailBean.sendEmail(email, "New jobpost created", url);
        }).start();
    }

}
