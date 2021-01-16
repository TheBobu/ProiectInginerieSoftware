/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.jobpost;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.ejb.SkillBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
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
@WebServlet(name = "EditJobPost", urlPatterns = {"/JobPost/Edit"})
public class EditJobPost extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));
        JobPostDetails jobPost = jobPostBean.getJobPost(id);
        request.setAttribute("jobPost", jobPost);
        request.setAttribute("departments", Department.values());
        request.setAttribute("skills", skillBean.getAllSkills());
        request.setAttribute("statuses", Status.getJobPostChoosable());
        request.setAttribute("types", Type.values());

        request.setAttribute("isEdit", true);

        request.setAttribute("errors", request.getSession().getAttribute("errors"));
        request.getSession().removeAttribute("errors");

        request.getRequestDispatcher("/WEB-INF/pages/jobpost/editjobpost.jsp").forward(request, response);
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

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String department = request.getParameter("department");
        String[] skills = request.getParameterValues("skills");
        String status = request.getParameter("status");
        String nopositionsAvailable = request.getParameter("noOfPositionsAvailable");
        String noOfPositionsFilled = request.getParameter("noOfPositionsFilled");
        String type = request.getParameter("type");
        String salary = request.getParameter("salary");

        JobPostValidator validator = new JobPostValidator(title, description, nopositionsAvailable, noOfPositionsFilled, department, status, skills, type, salary);

        if (validator.passes(messageBag)) {
            jobPostBean.editJobPost(id, title, description, noOfPositionsFilled, nopositionsAvailable, skills, department, status, type, salary);
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

}
