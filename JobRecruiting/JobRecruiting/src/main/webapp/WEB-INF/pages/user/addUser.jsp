<%-- 
    Document   : register.jsp
    Created on : Jan 9, 2021, 4:01:21 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<style><%@include file="/WEB-INF/css/registerAndLogin.css"%></style>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<t:pageTemplate pageTitle="Register">   
     <main role="main" class="container">
    <div class="signup-container container">
        <div class="container__child signup__thumbnail  col-md-6 ">
            <div class="thumbnail__content text-center ">
                <h1 class="heading--primary"><fmt:message key="label.register.headingOne" /></h1>
                <h2 class="heading--secondary"><fmt:message key="label.register.headingOne" /></h2>
            </div>
            <div class="signup__overlay"></div>
        </div>
        <div class="container__child signup__form col-md-6">
            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Create" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="firstName"><fmt:message key="label.register.firstName" /></label>
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="${param.firstName}" required>
                        <t:displayError error="firstName"/>
                </div>
                <div class="form-group">
                    <label for="lastName"><fmt:message key="label.register.lastName" /></label>
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="${param.lastName}" required>
                        <t:displayError error="lastName"/>
                </div>


                <div class="form-group">
                    <label for="birthDate"><fmt:message key="label.register.date" /></label>
                    <input type="date" class="form-control" id="birthDate" name="birthDate" placeholder="" value="${param.birthDate}" required>
                        <t:displayError error="birthDate"/>
                </div>

                <div class="form-group">
                    <label for="address"><fmt:message key="label.register.address" /></label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="" value="${param.address}" required>
                        <div class="invalid-feedback">
                            <t:displayError error="address"/>
                        </div>
                </div>

                <div class="form-group">
                    <label for="email"><fmt:message key="label.register.email" /></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="" value="${param.email}" required>
                        <t:displayError error="email"/>
                </div>

                <div class="form-group">
                    <label for="username"><fmt:message key="label.register.username" /></label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                        <t:displayError error="username"/>
                </div>

                <div class="form-group">
                    <label for="password"><fmt:message key="label.register.password" /></label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                        <t:displayError error="password"/>
                </div>
                <div class="row">
                <div class="form-group col-md-6 file-input">
                    <label for="profilePhoto"><fmt:message key="label.register.profile" /></label>
                <br>
                <input type="file" class="file" name="profilePhoto" required>
                <div class="invalid-feedback">
                    Profile Picture is required
                </div>
                </div>
                <div class="form-group col-md-6 file-input">
                   <label for="cv"><fmt:message key="label.register.cv" /></label>
                <br>
                <input type="file" class="file" name="cv" required>
                <div class="invalid-feedback">
                    CV is required
                </div>
                </div>
                </div>
                <div class="m-t-lg">
                    <ul class="list-inline">
                        <li>
                            <input class="btn btn-dark " type="submit" value="<fmt:message key="label.register.submit" />" />
                        </li>
                       
                    </ul>
                </div>
            </form>  
        </div>
    </div>
     </main>
</t:pageTemplate>