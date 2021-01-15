<%-- 
    Document   : jobManager
    Created on : 15-Jan-2021, 19:06:03
    Author     : Andreea Purta
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:pageTemplate pageTitle="User">

    <h1 class="mb-4">Job Management</h1>

    <div class="row">
         <div class="col-md"> ${job.title}</div>
        <div class="col-md"> ${job.poster.username}</div>
        <div class="col-md">${job.status}</div>
        <div class="col-md">${job.department}</div>
        <div class="col-md">${job.noOfPositionsAvailable}</div>
        <div class="col-md">${job.type}</div>
        <div class="col-md">${job.description}</div>

    </div>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobActivatorDeactivator?id=${job.id}" role="button">Activate/Deactivate Job</a>
</t:pageTemplate>
