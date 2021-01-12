package com.recruit.jobrecruiting.profile.servlet;

import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Andreea Purta
 */
@WebServlet(name = "UpdateProfile", urlPatterns = {"/Profile/Update"})
public class UpdateProfile extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userBean.getUserById(id);
        request.setAttribute("user", user);
        List<Department> listOfDepartments = new ArrayList<Department>(EnumSet.allOf(Department.class));
        request.setAttribute("departments", listOfDepartments);
        request.getRequestDispatcher("/WEB-INF/pages/profile/updateProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        Department department = Department.valueOf(request.getParameter("department"));
        Integer id = Integer.parseInt(request.getParameter("id"));

        Part filePart = request.getPart("image");
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

            userBean.updateUser(id, username, email, department, password, birthDate, firstName, lastName, address);
        
       response.sendRedirect(request.getContextPath() + "/Profile?id="+id.toString());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
