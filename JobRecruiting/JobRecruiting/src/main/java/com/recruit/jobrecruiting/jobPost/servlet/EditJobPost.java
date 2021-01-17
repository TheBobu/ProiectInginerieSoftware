/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.jobpost.servlet;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import com.recruit.jobrecruiting.skill.ejb.SkillBean;
import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
import com.recruit.jobrecruiting.interviews.ejb.ViewCandidatesBean;
import com.recruit.jobrecruiting.mail.EmailBean;
import com.recruit.jobrecruiting.util.Util;
import com.recruit.jobrecruiting.validators.JobPostValidator;
import java.io.IOException;
import java.util.HashMap;
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
 * @author DENISA
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"RecruiterRole"}))
@WebServlet(name = "EditJobPost", urlPatterns = {"/JobPost/Edit"})
public class EditJobPost extends HttpServlet {

    @Inject
    private JobPostBean jobPostBean;

    @Inject
    private SkillBean skillBean;

    @Inject
    ViewCandidatesBean viewCandidateBean;

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
        request.getSession().setAttribute("previous", request.getHeader("referer"));

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
        String requirements = request.getParameter("requirements");
        String resposabilities = request.getParameter("resposabilities");
        String department = request.getParameter("department");
        String[] skills = request.getParameterValues("skills");
        String status = request.getParameter("status");
        String nopositionsAvailable = request.getParameter("noOfPositionsAvailable");
        String type = request.getParameter("type");
        String salary = request.getParameter("salary");

        JobPostValidator validator = new JobPostValidator(title, requirements, resposabilities, nopositionsAvailable, department, status, skills, type, salary);

        if (validator.passes(messageBag)) {
            JobPostDetails jobPost = jobPostBean.editJobPost(id, title, requirements, resposabilities, nopositionsAvailable, skills, department, status, type, salary);
            List<String> emails = viewCandidateBean.getAllCandidateEmail(id);
            if (jobPost.getStatus() == Status.INACTIVE) {
                sendModifiedJobPostEmail(request, emails, id, "Job Post closed");
            } else {
                sendModifiedJobPostEmail(request, emails, id, "Job Post modified");
            }
            response.sendRedirect(request.getParameter("previous"));
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

    protected void sendModifiedJobPostEmail(HttpServletRequest request, List<String> emails, int jobpost_id, String subject) {
        new Thread(() -> {
            String url = Util.getBaseUrl(request) + "/JobPost?id=" + jobpost_id;
            emails.forEach((String email) -> {
                emailBean.sendEmail(email, subject, url);
            });
        }).start();
    }

}
