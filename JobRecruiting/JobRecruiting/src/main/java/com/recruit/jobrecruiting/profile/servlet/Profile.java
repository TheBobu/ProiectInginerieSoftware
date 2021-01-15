package com.recruit.jobrecruiting.profile.servlet;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"}))
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {


    @Inject UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                String username = request.getRemoteUser();
                User user = userBean.getUserByUsername(username);
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