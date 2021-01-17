/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.admin.servlet;

import com.recruit.jobrecruiting.common.UserLightDetails;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
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
 * @author andrei
 */
@DeclareRoles({"AdminRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"AdminRole"}))
@WebServlet(name = "Administration", urlPatterns = {"/Administration"})
public class Administration extends HttpServlet {
 
    @Inject
    private UserBean userBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserLightDetails> users = userBean.getAllUsersLight();
        
        request.getSession().setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/administration/userManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
