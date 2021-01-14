<%-- 
    Document   : register.jsp
    Created on : Jan 9, 2021, 4:01:21 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<t:pageTemplate pageTitle="Register">
    <h1>Create a new account</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Create" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="${param.firstName}" required>
                <t:displayError error="firstName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required>
                <t:displayError error="lastName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="birthDate">Date of Birth</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate" placeholder="" value="" required>
                <t:displayError error="birthDate"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="" value="" required>
                <div class="invalid-feedback">
                    <t:displayError error="address"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="" value="" required>
                <t:displayError error="email"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                <t:displayError error="username"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                <t:displayError error="password"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="profilePhoto">Profile Photo</label>
                <br>
                <input type="file" name="profilePhoto" required>
                <div class="invalid-feedback">
                    Profile Picture is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cv">CV</label>
                <br>
                <input type="file" name="cv" required>
                <div class="invalid-feedback">
                    CV is required
                </div>
            </div>
        </div>
        <hr>
        <input type="submit" value = "Save" class="btn btn-primary btn-lg btn-block" />
    </form>
    <t:formValidate/>
</t:pageTemplate>
