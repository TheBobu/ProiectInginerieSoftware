/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.jobposting;

import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.ejb.SkillBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.validators.JobPostValidator;
import java.io.IOException;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DENISA
 */
@WebServlet(name = "AddJobPost", urlPatterns = {"/JobPost/Create"})
public class AddJobPost extends HttpServlet {

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private SkillBean skillBean;

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
        request.setAttribute("statuses", Status.values());
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

        HashMap<String, String> messageBag = new HashMap<>();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String department = request.getParameter("department");
        String[] skills = request.getParameterValues("skills");

        String status = request.getParameter("status");
        String nopositionsAvailable = request.getParameter("noOfPositionsAvailable");
        String noOfPositionsFilled = request.getParameter("noOfPositionsFilled");

        int poster = 1;

        JobPostValidator validator = new JobPostValidator(title, description, nopositionsAvailable, noOfPositionsFilled, department, status, skills);

        if (validator.passes(messageBag)) {
            jobPostBean.createJobPost(title, description, noOfPositionsFilled, nopositionsAvailable, skills, department, poster, status);
            response.sendRedirect(request.getContextPath() + "/JobPosts");
        }

        request.setAttribute("errors", messageBag);

        response.sendRedirect(request.getContextPath() + "/JobPost/Create");

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
