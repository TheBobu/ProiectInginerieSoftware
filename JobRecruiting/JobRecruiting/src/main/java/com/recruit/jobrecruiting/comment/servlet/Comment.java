/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.comment.servlet;

import com.recruit.jobrecruiting.comment.ejb.CommentBean;
import com.recruit.jobrecruiting.common.CommentDetails;
import com.recruit.jobrecruiting.entity.Interview;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.validators.InterviewValidator;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**Servlet that manages comments and interview
 * Linked to comment-section.jsp
 *
 * @author Deea, Doly, Robert
 */
@DeclareRoles({"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"}))
@WebServlet(name = "Comment", urlPatterns = {"/Comment"})
public class Comment extends HttpServlet {

    @Inject
    CommentBean commentBean;
    
    @Inject
    InterviewBean interviewBean;
    
    @Inject
    UserBean userBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        Integer id = Integer.parseInt(request.getParameter("id"));
        String username=request.getRemoteUser();
        User user=userBean.getUserByUsername(username);        
        request.getSession().setAttribute("id", id);   
        request.getSession().setAttribute("user", user);
        List<CommentDetails> comments = commentBean.getAllComments(id);
        Interview interview = interviewBean.getInterviewById(id);
        request.getSession().setAttribute("comments", comments);
        request.getSession().setAttribute("interview", interview);
        request.getRequestDispatcher("/WEB-INF/pages/interview/comment-section.jsp").forward(request, response);
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        String formPosted = request.getParameter("form");
        
        if(formPosted.equals("schedule")){
            LocalDate interviewDate = LocalDate.parse(request.getParameter("date"));
            LocalTime interviewTime = LocalTime.parse(request.getParameter("time"));
            HashMap<String, String> messageBag = new HashMap<>();
            InterviewValidator validator = new InterviewValidator(interviewDate, interviewBean);
            if (validator.passes(messageBag)) {
                interviewBean.setDateTime(id, interviewDate, interviewTime);
                String interviewPlace = request.getParameter("place");
                interviewBean.setPlace(id, interviewPlace);
            }
            else{
                request.setAttribute("errors", messageBag);
                request.getRequestDispatcher("/WEB-INF/pages/interview/comment-section.jsp").include(request, response);
            }       
        }
        else{   //comment
            String username = request.getRemoteUser();
            String comment = request.getParameter("comment");
            commentBean.createComment(username, comment, id);
        }
           
        response.sendRedirect(request.getContextPath()+"/Comment?id="+id.toString());
        
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
