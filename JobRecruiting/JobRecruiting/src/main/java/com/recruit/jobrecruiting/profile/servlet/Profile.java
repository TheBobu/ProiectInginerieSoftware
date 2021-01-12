package com.recruit.jobrecruiting.profile.servlet;

import com.recruit.jobrecruiting.common.UserDetails;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {


    @Inject UserBean userBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Integer id = Integer.parseInt(request.getParameter("id"));
                User user = userBean.getUserById(id);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/pages/profile/profile.jsp").forward(request, response);
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
