package com.recruit.jobrecruiting.profile.servlet;

import com.recruit.jobrecruiting.entity.Department;
import com.recruit.jobrecruiting.entity.Photo;
import com.recruit.jobrecruiting.entity.User;
import com.recruit.jobrecruiting.user.ejb.UserBean;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Andreea Purta
 */
@DeclareRoles({"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed={"AdminRole", "CandidateRole", "DepartmentDirectorRole", "GeneralDirectorRole", "HRDirectorRole", "RecruiterRole"}))
@MultipartConfig
@WebServlet(name = "UpdateProfile", urlPatterns = {"/Profile/Update"})
public class UpdateProfile extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userBean.getUserById(id);
        Photo photo =userBean.findProfilePictureById(id);
        request.setAttribute("user", user);
        List<Department> listOfDepartments = new ArrayList<Department>(EnumSet.allOf(Department.class));
        request.setAttribute("departments", listOfDepartments);
        request.getRequestDispatcher("/WEB-INF/pages/profile/updateProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        Department department = Department.valueOf(request.getParameter("department"));
        Integer id = Integer.parseInt(request.getParameter("id"));

        Integer photoId = Integer.parseInt(request.getParameter("photoId"));
        String shortBio = request.getParameter("shortBio");
        String userExperience = request.getParameter("userExperience");
        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);
        
         if (fileName != "") {
        userBean.updateProfilePhoto(photoId,id, fileName, fileType, fileContent);
         }
        filePart = request.getPart("cv");
        fileName = filePart.getSubmittedFileName();
        fileType = filePart.getContentType();
        fileSize = filePart.getSize();
        fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);
        if (fileName != "") {
        userBean.updateCV(photoId, id, fileName, fileType, fileContent);
        }
        userBean.updateUser(id, email, department, birthDate, firstName, lastName, address, shortBio,userExperience);
        
       response.sendRedirect(request.getContextPath() + "/Profile?id="+id.toString());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}