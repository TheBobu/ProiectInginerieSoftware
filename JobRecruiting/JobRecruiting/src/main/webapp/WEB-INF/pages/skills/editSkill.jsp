<%-- 
    Document   : editSkill
    Created on : Jan 14, 2021, 8:26:02 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Skill">
    <t:formTemplate>
        <t:skillForm action="${pageContext.request.contextPath}/Skills/Update">
            <h3 class="register-heading">Edit a Skill</h3>
        </t:skillForm>
    </t:formTemplate>
</t:pageTemplate>
