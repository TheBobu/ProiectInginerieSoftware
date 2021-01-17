/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.jobpost;

import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.ejb.SkillBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.mail.EmailBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.util.Util;
import com.recruit.jobrecruiting.validators.JobPostValidator;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"RecruiterRole"}))
@WebServlet(name = "AddJobPost", urlPatterns = {"/JobPost/Create"})
public class AddJobPost extends HttpServlet {

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private SkillBean skillBean;

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

        request.setAttribute("departments", Department.values());
        request.setAttribute("skills", skillBean.getAllSkills());
        request.setAttribute("types", Type.values());
        request.setAttribute("errors", request.getSession().getAttribute("errors"));
        request.getSession().removeAttribute("errors");
        request.getRequestDispatcher("/WEB-INF/pages/jobpost/addjobpost.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getRemoteUser();
        HashMap<String, String> messageBag = new HashMap<>();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String department = request.getParameter("department");
        String[] skills = request.getParameterValues("skills");

        String status = Status.WAITING_FOR_APPROVAL.toString();
        if (request.isUserInRole("GeneralDirectorRole")) {
            status = Status.ACTIVE.toString();
        }

        String nopositionsAvailable = request.getParameter("noOfPositionsAvailable");
        String noOfPositionsFilled = request.getParameter("noOfPositionsFilled");
        String type = request.getParameter("type");
        String salary = request.getParameter("salary");

        User user = userBean.getUserByUsername(username);
        int poster = user.getId();

        JobPostValidator validator = new JobPostValidator(title, description, nopositionsAvailable, noOfPositionsFilled, department, status, skills, type, salary);

        if (validator.passes(messageBag)) {
            int jobpost_id = jobPostBean.createJobPost(title, description, noOfPositionsFilled, nopositionsAvailable, skills, department, poster, status, type, salary).getId();
            if (!request.isUserInRole("GeneralDirectorRole")) {
                sendEmail(request, jobpost_id);
            }
            response.sendRedirect(request.getContextPath() + "/JobPosts");
        } else {
            request.getSession().setAttribute("errors", messageBag);
            response.sendRedirect(request.getHeader("Referer"));
        }

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

    protected void sendEmail(HttpServletRequest request, int jobpost_id) {
        new Thread(() -> {
            String email = userBean.getGeneralDirectorEmail();
            String url = Util.getBaseUrl(request) + "/JobPost?id=" + jobpost_id;
            emailBean.sendEmail(email, "New jobpost created", url);
        }).start();
    }

}
