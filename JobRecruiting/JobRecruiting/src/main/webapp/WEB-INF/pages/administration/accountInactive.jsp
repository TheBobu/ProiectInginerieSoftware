<%-- 
    Document   : accountInactive
    Created on : Jan 17, 2021, 9:05:36 PM
    Author     : andrei
--%>

  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style><%@include file="/WEB-INF/css/main.css"%></style>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<t:pageTemplate pageTitle="Jobs">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <h2 class="main-title-homepage"><fmt:message key="label.inactive.title" /></h2>
            </div>
        </div>
    </div>
</t:pageTemplate>