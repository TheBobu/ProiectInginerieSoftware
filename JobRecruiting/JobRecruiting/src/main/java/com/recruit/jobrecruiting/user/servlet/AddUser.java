/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruit.jobrecruiting.user.servlet;

import com.recruit.jobrecruiting.mail.EmailBean;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import com.recruit.jobrecruiting.validators.UserValidator;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet Class for creating a new User.
 *
 * @author Robert
 */
@MultipartConfig
@WebServlet(name = "AddUser", urlPatterns = {"/Users/Create"})
public class AddUser extends HttpServlet {

    @Inject
    UserBean userBean;
    @Inject
    EmailBean emailBean;

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
        request.getRequestDispatcher("/WEB-INF/pages/user/addUser.jsp").forward(request, response);
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
        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
             String shortBio = request.getParameter("shortBio");
            HashMap<String, String> messageBag = new HashMap<>();
            UserValidator validator = new UserValidator(username, email, password, birthDate, firstName, lastName, address, userBean);

            if (validator.passes(messageBag)) {
                Integer id = userBean.createUser(username, email, password, birthDate, firstName, lastName, address,shortBio);

                Part filePart = request.getPart("profilePhoto");
                String fileName = filePart.getSubmittedFileName();
                String fileType = filePart.getContentType();
                long fileSize = filePart.getSize();
                byte[] fileContent = new byte[(int) fileSize];
                filePart.getInputStream().read(fileContent);
                userBean.addProfilePhoto(id, fileName, fileType, fileContent);

                filePart = request.getPart("cv");
                fileName = filePart.getSubmittedFileName();
                fileType = filePart.getContentType();
                fileSize = filePart.getSize();
                fileContent = new byte[(int) fileSize];
                filePart.getInputStream().read(fileContent);
                userBean.addCv(id, fileName, fileType, fileContent);
                
                emailBean.sendEmail(email, "Job Recruiting Platform", "Your account was succesfully created. Please wait for the administrator to activate your account. Thank you!");
                response.sendRedirect(request.getContextPath());
            } else {
                request.getSession().setAttribute("errors", messageBag);
                response.sendRedirect(request.getHeader("Referer"));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Register User";
    }
}
