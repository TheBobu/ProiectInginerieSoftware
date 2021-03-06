/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.jobposting;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.ejb.JobPostBean;
import com.recruit.jobrecruiting.entity.Type;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "JobPosts", urlPatterns = {"/JobPosts"})
public class JobPosts extends HttpServlet {

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

        request.setAttribute("types", Type.values());

        String keyword = request.getParameter("keyword");
        String type = request.getParameter("type");
        String salary = request.getParameter("salary");
        List<JobPostDetails> jobPosts = jobPostBean.filterJobPosts(
                keyword,
                type,
                salary
        );

        request.setAttribute("keyword", keyword);
        request.setAttribute("salary", salary);
        request.setAttribute("type", type);

        request.setAttribute("jobPosts", jobPosts);
        request.getRequestDispatcher("/WEB-INF/pages/jobpost/jobposts.jsp").forward(request, response);
    }

}
