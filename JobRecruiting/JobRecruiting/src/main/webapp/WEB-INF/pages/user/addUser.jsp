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
                    <br>
                    <div class="form-group position-relative">
                        <label for="lastName"><fmt:message key="label.register.lastName" /></label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="${param.lastName}" required>
                        <t:displayError error="lastName"/>
                    </div>
                    <br>

                    <div class="form-group position-relative">
                        <label for="birthDate"><fmt:message key="label.register.date" /></label>
                        <input type="date" class="form-control" id="birthDate" name="birthDate" placeholder="" value="${param.birthDate}" required>
                        <t:displayError error="birthDate"/>
                    </div>
                    <br>
                    <div class="form-group position-relative">
                        <label for="address"><fmt:message key="label.register.address" /></label>
                        <input type="text" class="form-control" id="address" name="address" placeholder="" value="${param.address}" required>
                        <div class="invalid-feedback">
                            <t:displayError error="address"/>
                        </div>
                    </div>
                    <br>
                    <div class="form-group position-relative">
                        <label for="email"><fmt:message key="label.register.email" /></label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="" value="${param.email}" required>
                        <t:displayError error="email"/>
                    </div>
                    <br>
                    <div class="form-group position-relative">
                        <label for="username"><fmt:message key="label.register.username" /></label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="" value="${param.username}" required>
                        <t:displayError error="username"/>
                    </div>
                    <br>
                    <div class="form-group position-relative">
                        <label for="password"><fmt:message key="label.register.password" /></label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="" value="${param.password}" required>
                        <t:displayError error="password"/>
                    </div>
                    <br>
                    <div class="form-group position-relative mb-1">
                        <label for="passwordAgain"><fmt:message key="label.register.passwordAgain" /></label>
                        <input type="password" class="form-control" id="passwordAgain" name="passwordAgain" placeholder="" value="${param.passwordAgain}" required>
                        <t:displayError error="passwordAgain"/>
                    </div>
                    <br>
                    <div class="row">
                        <div class="form-group col-md-6 file-input position-relative">
                            <label for="profilePhoto"><fmt:message key="label.register.profile" /></label>
                            <br>
                            <input type="file" class="file" name="profilePhoto" required>
                            <div class="invalid-feedback">
                                Profile Picture is required
                            </div>
                        </div>
                        <br>
                        <div class="form-group col-md-6 file-input position-relative">
                            <label for="cv"><fmt:message key="label.register.cv" /></label>
                            <br>
                            <input type="file" class="file" name="cv" required>
                            <div class="invalid-feedback">
                                CV is required
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="m-t-lg">
                        <ul class="list-inline">
                            <li>
                                <input class="btn btn-dark " type="submit" value="<fmt:message key="label.register.submit" />" />
                            </li>

                        </ul>
                    </div>
                </form> 
                <t:formValidate/>
            </div>
        </div>
    </main>
</t:pageTemplate>