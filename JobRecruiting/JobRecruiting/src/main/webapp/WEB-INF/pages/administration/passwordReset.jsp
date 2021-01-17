<%-- 
    Document   : passwordReset
    Created on : Jan 14, 2021, 6:37:30 PM
    Author     : Deea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<t:pageTemplate pageTitle="Password Reset">

    <h1 class="mb-4">Password Reset</h1>
    <form method="POST" action="${pageContext.request.contextPath}/UpdatePassword">
        <input type="password" name="password">
        <input type="password" name="confirmPassword">
        <input type="hidden" name="id" value="${id}">
        <input type="submit">
    </form>
</t:pageTemplate>

