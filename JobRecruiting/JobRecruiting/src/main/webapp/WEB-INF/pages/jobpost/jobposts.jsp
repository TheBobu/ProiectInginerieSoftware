<%-- 
    Document   : jobpostings
    Created on : Jan 3, 2021, 9:56:51 PM
    Author     : DENISA
--%>

  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Jobs">

    <h1 >Jobs posts ee</h1>
    
    <c:forEach var="jobpost" items="${jobPosts}">
        <p>${jobpost.title}</p>
    </c:forEach>
    
</t:pageTemplate>
