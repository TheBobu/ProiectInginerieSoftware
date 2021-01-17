/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.interviews.servlet;

import com.recruit.jobrecruiting.common.InterviewDetails;
import com.recruit.jobrecruiting.entity.Position;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Doly
 */
@WebServlet(name = "Interviews", urlPatterns = {"/Interviews"})
public class Interviews extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Inject
    private InterviewBean interviewBean;
    
    @Inject
    private UserBean userBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Interviews</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Interviews at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String username=request.getRemoteUser();
        User user=userBean.getUserByUsername(username);
        Integer userId=user.getId();
        //String userId=request.getParameter("id");
        //userId=request.
        //Integer userIdInt=Integer.parseInt(userId);
        //String requestedBy=request.getParameter("requestedBy");/////////////////////params
        
        List<InterviewDetails> interviews;         //!!!!!!!!schimbare light details
//        if(request.isUserInRole("CandidateRole"))
//            interviews = interviewBean.getAllInterviewsAsCandidate(userId);
//        else
//            interviews = interviewBean.getAllInterviewsAsInterviewer(userId);
        Boolean candidate=Boolean.FALSE;
        if(user.getPosition().compareTo(Position.CANDIDATE)==0)
        {
            interviews = interviewBean.getAllInterviewsAsCandidate(userId);
            candidate=Boolean.TRUE;
        }         
        else
            interviews = interviewBean.getAllInterviewsAsInterviewer(userId);
        
        //interv as candidate
         
        request.getSession().setAttribute("interviews", interviews);   
        request.getSession().setAttribute("candidate", candidate);
        request.getRequestDispatcher("/WEB-INF/pages/interview/interviews.jsp").forward(request, response);

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
//        String id=request.getParameter("id");
//        String jobpost=request.getParameter("jobpost");
//        String candidate=request.getParameter("candidate");
//        String interviewer=request.getParameter("interviewer");
//        String status=request.getParameter("status");
//        
//        request.getSession().setAttribute("id", id);   
//        request.getSession().setAttribute("jobpost", jobpost);
//        request.getSession().setAttribute("candidate", candidate);
//        request.getSession().setAttribute("interviewer", interviewer);
//        request.getSession().setAttribute("status", status);
//        request.getRequestDispatcher("/WEB-INF/pages/interview/comment-section.jsp").forward(request, response);
        
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
