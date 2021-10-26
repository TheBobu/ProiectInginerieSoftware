/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.jobPost.servlet;

import com.recruit.jobrecruiting.common.JobPostDetails;
import com.recruit.jobrecruiting.entity.Position;
import com.recruit.jobrecruiting.entity.Status;
import com.recruit.jobrecruiting.entity.Type;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import com.recruit.jobrecruiting.jobPost.ejb.JobPostBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
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

    @Inject
    private InterviewBean interviewBean;

    @Inject
    private UserBean userBean;

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
        String status = request.getParameter("status");

        if (!request.isUserInRole("RecruiterRole")) {
            status = Status.ACTIVE.toString();
        }

        List<JobPostDetails> jobPosts = jobPostBean.filterJobPosts(
                keyword,
                type,
                salary,
                status
        );

        request.setAttribute("keyword", keyword);
        request.setAttribute("salary", salary);
        request.setAttribute("type", type);
        request.setAttribute("status", status);


        try {
            User user = userBean.getUserByUsername(request.getRemoteUser());
            boolean roleOk = Position.canApplyToJobs().contains(user.getPosition());
            request.setAttribute("showApplyButton", roleOk);

            List<Integer> jobPostsAppliedToIds = interviewBean.getAllJobPostsAsCandidate(user.getId());
            request.setAttribute("jobPostsAppliedToIds", jobPostsAppliedToIds);

        } catch (Exception e) {
            request.setAttribute("showApplyButton", true);
            System.out.println("user not logged in");
        }

        request.setAttribute("statuses", Status.values());
        request.setAttribute("jobPosts", jobPosts);
        request.getRequestDispatcher("/WEB-INF/pages/jobpost/jobposts.jsp").forward(request, response);
    }

}
