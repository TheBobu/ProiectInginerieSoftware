/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.skills;

import com.recruit.jobrecruiting.skill.ejb.SkillBean;
import com.recruit.jobrecruiting.validators.SkillValidator;
import java.io.IOException;
import java.util.HashMap;
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
 * @author DENISA
 */
@DeclareRoles({"RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"RecruiterRole"}))
@WebServlet(name = "AddSkillServlet", urlPatterns = {"/Skills/Create"})
public class AddSkillServlet extends HttpServlet {

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
        request.getSession().setAttribute("previous", request.getHeader("referer"));
        request.getRequestDispatcher("/WEB-INF/pages/skills/addskill.jsp").forward(request, response);
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

        String name = request.getParameter("name");

        if (new SkillValidator(name).passes(messageBag)) {
            skillBean.createSkill(name);
            response.sendRedirect(request.getParameter("previous"));
        } else {
            request.getSession().setAttribute("errors", messageBag);
            request.getRequestDispatcher("/WEB-INF/pages/skills/addskill.jsp").forward(request, response);
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
