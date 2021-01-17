<%-- 
    Document   : userManager
    Created on : Jan 13, 2021, 8:09:38 PM
    Author     : Deea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<style><%@include file="/WEB-INF/css/management.css"%></style>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="User">

    <div class="container-management">
        <div class="row">
           <h3>${username}</h3>
            <div class="col-md-3"> 
           <form method="POST" action="${pageContext.request.contextPath}/UserManager">
                <select name="position" id="position">
                    <c:forEach var="position" items="${positions}" varStatus="status">
                        <option value="${position}" ${user.position eq position? 'selected':''}>${position}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit">
            </form>
                </div>
            <div class="col-md-3">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/UserActivator?id=${user.id}" role="button"><fmt:message key="label.userManager.activate" /></a></div>
            <div class="col-md-3">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/UserDeactivator?id=${user.id}" role="button"><fmt:message key="label.userManager.deactivate" /></a>
            </div>
            <div class="col-md-3">
            <form method="POST" action="${pageContext.request.contextPath}/PasswordReseter">
                <input type="hidden" name="id" value="${user.id}">
                <input class="btn btn-secondary" type="submit" value="<fmt:message key="label.userManager.passreset" />">
            </form>
            </div>
        </div>
    </div>
</t:pageTemplate>
