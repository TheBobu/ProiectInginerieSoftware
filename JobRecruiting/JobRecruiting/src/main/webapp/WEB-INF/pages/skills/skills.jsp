<%-- 
    Document   : skills
    Created on : Jan 14, 2021, 8:08:26 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Skills">
    <h1>Skills</h1>
    
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Skills/Create" role="button">Add Skill</a>
    
    <c:forEach var="skill" items="${skills}">
        <div class="row">
            <div class="col-md-2">
                ${skill.name}
            </div>
            <div class="col-md-2">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Skills/Update?id=${skill.id}" role="button">Edit Skill</a>
            </div>
        </div>
        <br>
    </c:forEach>

</t:pageTemplate>
