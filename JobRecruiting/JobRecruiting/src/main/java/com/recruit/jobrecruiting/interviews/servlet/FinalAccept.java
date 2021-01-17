package com.recruit.jobrecruiting.interviews.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.recruit.jobrecruiting.interviews.ejb.InterviewBean;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet for granting final access to a candidate already accepted by Recruiter/Interviewer.
 * Servlet can only be accessed by users who are Department Directors. 
 *
 * @author robert
 */
@DeclareRoles({"DepartmentDirectorRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"DepartmentDirectorRole"}))
@WebServlet(name = "FinalAccept", urlPatterns = {"/Interview/FinalAccept"})
public class FinalAccept extends HttpServlet {

    @Inject
    private InterviewBean interviewBean;

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
        interviewBean.finalAccept(id);
        response.sendRedirect(request.getHeader("referer"));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Department Director gives final accept to proposed candidate";
    }

}
