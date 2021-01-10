<%-- 
    Document   : addskillform
    Created on : Jan 10, 2021, 4:44:55 PM
    Author     : DENISA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Skill">

    <t:formTemplate >
        <t:skillForm action="${pageContext.request.contextPath}/JobPost/Create">
            <h3 class="register-heading">Add a Skill</h3>
        </t:skillForm>
    </t:formTemplate>
    <t:formValidate/>
</t:pageTemplate>

