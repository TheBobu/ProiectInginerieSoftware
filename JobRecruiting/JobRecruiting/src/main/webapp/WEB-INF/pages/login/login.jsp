<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/login.css"%></style>

<t:pageTemplate pageTitle="Login">


    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <div class="card">
                    <form class="box form" method="post" action="j_security_check">
                        <h1>Login</h1>
                        <p class="text-muted"> Please enter your login and password!</p> 
                        <input type="text" id="username" class="form-control" placeholder="Username" name="j_username" required autofocus>
                        <input type="password" id="password" class="form-control" name="j_password" placeholder="Password" required>
                        <a class="forgot text-muted" href="#">Forgot password?</a> 
                        <input type="submit" name="" value="Login" >
                    </form>
                </div>
            </div>
        </div>
    </div>

    <c:if test = "${message!=null}">
        <div class="container alert">

            <div class="alert alert-warning" role="alert">
                ${message}
            </div>
        </div>
    </c:if>
</t:pageTemplate>
