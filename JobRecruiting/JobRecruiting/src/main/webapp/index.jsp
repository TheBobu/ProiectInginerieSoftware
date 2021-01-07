<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Home">
    <h1>Job Recruiting</h1>
    <a href="${pageContext.request.contextPath}/Login"><button>Log in</button></a><br><br><br>
    <p>You don't have an account yet?</p>
    <button>Register</button>
</t:pageTemplate>