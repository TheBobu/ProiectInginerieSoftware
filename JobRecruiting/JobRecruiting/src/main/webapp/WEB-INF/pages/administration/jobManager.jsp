<%-- 
    Document   : jobManager
    Created on : 15-Jan-2021, 19:06:03
    Author     : Andreea Purta
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<style><%@include file="/WEB-INF/css/management.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:pageTemplate pageTitle="User">

   
 <div class="container-management">
    <div class="row">
         <div class="col-md"> ${job.title}</div>
        <div class="col-md"> ${job.poster.username}</div>
        <div class="col-md">${job.status}</div>
        <div class="col-md">${job.department}</div>
        <div class="col-md">${job.noOfPositionsAvailable}</div>
        <div class="col-md">${job.type}</div>
        <div class="col-md">${job.description}</div>
            <div class="col-md"><a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobActivatorDeactivator?id=${job.id}" role="button"><fmt:message key="label.jobManager.activatedeactivate" /></a></div>
    </div>
    
 
</div>
 </t:pageTemplate>
