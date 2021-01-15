<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Home">
    <div class="row">
        <div class="col-md"></div>
        <div class="col-md">
            <h2>Welcome to</h2>
            <h1>Job Recruiting!</h1>
            <br><br><br>
            <a class="btn btn-lg btn-primary btn-block" href="${pageContext.request.contextPath}/Login" role="button">Log in</a>
            <br><br><br>

            <p>You don't have an account yet?</p>
            <a class="btn btn-lg btn-primary btn-block" href="${pageContext.request.contextPath}/Users/Create" role="button">Register</a>
        </div>
        <div class="col-md"></div>
    </div>
</t:pageTemplate>