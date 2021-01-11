<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Login">
    <c:if test = "${message!=null}">
        <div class="alert alert-warning" role="alert">
            ${message}
        </div>
    </c:if>
    <div class="row">
        <div class="col-md"></div>
        <div class="col-md">
            <form class="form-signin" method="post" action="j_security_check">
                <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" class="form-control" placeholder="Username" name="j_username" required autofocus>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" class="form-control" name="j_password" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div>
        <div class="col-md"></div>
    </div>
</t:pageTemplate>
