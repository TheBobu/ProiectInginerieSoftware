<%-- 
    Document   : skills
    Created on : Jan 14, 2021, 8:08:26 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>


<t:pageTemplate pageTitle="Skills">
    <h1>Skills</h1>

    <a class="btn btn-primary w-25" href="${pageContext.request.contextPath}/Skills/Create" role="button">Add new skill</a>
    <br><br>

    <c:forEach var="skill" items="${skills}">
        <div class="card w-25">
            <div class="card-body">
                <div class="row">
                    <div class="col"> ${skill.name}</div>
                    <div class="col"><a class="btn btn-secondary" href="${pageContext.request.contextPath}/Skills/Update?id=${skill.id}" role="button">Edit Skill</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</t:pageTemplate>
