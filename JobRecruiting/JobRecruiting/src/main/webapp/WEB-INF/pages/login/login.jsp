<%-- 
    Document   : login.jsp
    Created on : Jan 16, 2021, 4:01:21 PM
    Author     : Andreea Purta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<style><%@include file="/WEB-INF/css/registerAndLogin.css"%></style>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<t:pageTemplate pageTitle="Login">   
    <main role="main" class="container">
        <div class="signup-container container">
            <div class="container__child signup__thumbnail  col-md-6 ">
                <div class="thumbnail__content text-center ">
                    <h1 class="heading--primary"><fmt:message key="label.login.headingOne" /></h1>
                    <h2 class="heading--secondary"><fmt:message key="label.login.headingTwo" /></h2>
                </div>
                <div class="signup__overlay"></div>
            </div>
            <div class="container__child signup__form col-md-6">
                <form class="needs-validation login-form" novalidate method="POST" action="j_security_check">
                    <div class="form-group">
                        <label for="username"><fmt:message key="label.login.username" /></label>
                        <input type="text" class="form-control" id="username" name="j_username" placeholder="" value="" required>
                        <t:displayError error="username"/>
                    </div>

                    <div class="form-group">
                        <label for="password"><fmt:message key="label.login.password" /></label>
                        <input type="password" class="form-control" id="password" name="j_password" placeholder="" value="" required>
                        <t:displayError error="password"/>
                    </div>

                    <input class="btn btn-dark " type="submit" value="<fmt:message key="label.login.submit" />" />
                </form>  
            </div>
        </div>
    </main>
</t:pageTemplate>
