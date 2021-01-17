/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.servlet.skills;

import com.recruit.jobrecruiting.common.SkillDetails;
import com.recruit.jobrecruiting.ejb.SkillBean;
import com.recruit.jobrecruiting.validators.SkillValidator;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet for editing a skill.
 *
 * @author robert
 */
@DeclareRoles({"RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"RecruiterRole"}))
@WebServlet(name = "EditSkill", urlPatterns = {"/Skills/Update"})
public class EditSkill extends HttpServlet {

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
        Integer id = Integer.parseInt(request.getParameter("id"));
        SkillDetails skill = skillBean.getSkill(id);
        request.setAttribute("skill", skill);
        request.getSession().removeAttribute("errors");
        request.getRequestDispatcher("/WEB-INF/pages/skills/editSkill.jsp").forward(request, response);
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
        Integer id = Integer.parseInt(request.getParameter("skill_id"));
        String updatedSkillName = request.getParameter("name");
        SkillValidator validator = new SkillValidator(updatedSkillName);
        HashMap<String, String> messageBag = new HashMap<>();
        
        if (new SkillValidator(updatedSkillName).passes(messageBag)) {
            skillBean.updateSkill(id, updatedSkillName);
            response.sendRedirect(request.getContextPath() + "/Skills");
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
        return "Edit skill";
    }// </editor-fold>
}
