<%-- 
    Document   : register.jsp
    Created on : Jan 9, 2021, 4:01:21 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<style><%@include file="/WEB-INF/css/registerAndLogin.css"%></style>

<t:pageTemplate pageTitle="Register">   
     <main role="main" class="container">
    <div class="signup-container container">
        <div class="container__child signup__thumbnail  col-md-6 ">
            <div class="thumbnail__content text-center ">
                <h1 class="heading--primary">Welcome Job Recruiting.</h1>
                <h2 class="heading--secondary">Are you ready to join the elite?</h2>
            </div>
            <div class="signup__overlay"></div>
        </div>
        <div class="container__child signup__form col-md-6">
            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Create" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="${param.firstName}" required>
                        <t:displayError error="firstName"/>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="${param.lastName}" required>
                        <t:displayError error="lastName"/>
                </div>


                <div class="form-group">
                    <label for="birthDate">Date of Birth</label>
                    <input type="date" class="form-control" id="birthDate" name="birthDate" placeholder="" value="${param.birthDate}" required>
                        <t:displayError error="birthDate"/>
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="" value="${param.address}" required>
                        <div class="invalid-feedback">
                            <t:displayError error="address"/>
                        </div>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="" value="${param.email}" required>
                        <t:displayError error="email"/>
                </div>

                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                        <t:displayError error="username"/>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                        <t:displayError error="password"/>
                </div>
                <div class="row">
                <div class="form-group col-md-6 file-input">
                    <label for="profilePhoto">Profile Photo</label>
                <br>
                <input type="file" class="file" name="profilePhoto" required>
                <div class="invalid-feedback">
                    Profile Picture is required
                </div>
                </div>
                <div class="form-group col-md-6 file-input">
                   <label for="cv">CV</label>
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
                            <input class="btn btn-dark " type="submit" value="Save" />
                        </li>
                       
                    </ul>
                </div>
            </form>  
        </div>
    </div>
     </main>
</t:pageTemplate>