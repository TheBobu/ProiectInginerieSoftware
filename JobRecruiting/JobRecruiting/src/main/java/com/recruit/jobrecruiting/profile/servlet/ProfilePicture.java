/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.profile.servlet;

import com.recruit.jobrecruiting.entity.Photo;
import com.recruit.jobrecruiting.user.ejb.UserBean;
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
 *
 * @author Andreea Purta
 */
@DeclareRoles({"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"}))
@WebServlet(name = "ProfilePicture", urlPatterns = {"/ProfilePicture"})
public class ProfilePicture extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        Photo photo = new Photo();
        if (typeId == 1) {
            photo = userBean.findCvById(id);

        } else if (typeId == 0) {
            photo = userBean.findProfilePictureById(id);
        }

        if (photo != null) {
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

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
