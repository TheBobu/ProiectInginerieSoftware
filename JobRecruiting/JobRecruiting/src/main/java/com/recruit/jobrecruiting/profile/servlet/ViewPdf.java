/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.profile.servlet;

import com.recruit.jobrecruiting.entity.Photo;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Blob;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andreea Purta
 */
@WebServlet(name = "ViewPdf", urlPatterns = {"/ViewPdf"})
public class ViewPdf extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Photo photo = userBean.findProfilePictureById(id);
        byte[] blob = photo.getFileContent();
        File file = new File("");
        OutputStream out = new FileOutputStream(file);
        out.write(blob);
        response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        //nume random pentru bara filename
        response.setHeader("Content-Disposition", "inline; filename=\"cv.pdf\"");
        Files.copy(file.toPath(), response.getOutputStream());
         
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
