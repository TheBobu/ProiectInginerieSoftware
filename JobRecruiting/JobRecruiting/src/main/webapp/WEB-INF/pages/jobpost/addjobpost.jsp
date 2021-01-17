<%-- 
    Document   : addjobposting
    Created on : Jan 3, 2021, 9:57:36 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Add Job Post">
    <t:formTemplate >
        <t:jobPostForm action="${pageContext.request.contextPath}/JobPost/Create">
            <h3 class="register-heading"><fmt:message key="label.addJobPost.postOffer" /></h3>
        </t:jobPostForm>
    </t:formTemplate>
    <t:formValidate/>
</t:pageTemplate>
