/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.comment.servlet;

import com.recruit.jobrecruiting.comment.ejb.CommentBean;
import com.recruit.jobrecruiting.common.CommentDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Date;
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

/**
 *
 * @author Deea
 */
@DeclareRoles({"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"}))
@WebServlet(name = "Comment", urlPatterns = {"/Comment"})
public class Comment extends HttpServlet {

    @Inject
    CommentBean commentBean;

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
        List<CommentDetails> comments = commentBean.getAllComments(id);
        request.getSession().setAttribute("comments", comments);
        request.getSession().setAttribute("id", id);
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
        String username = request.getRemoteUser();
        String comment = request.getParameter("comment");
        Integer id = Integer.parseInt(request.getParameter("id"));
        commentBean.createComment(username, comment, id);
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
