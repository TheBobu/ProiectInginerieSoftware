<%-- 
    Document   : editjobpost
    Created on : Jan 7, 2021, 5:16:41 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Edit Job Post">

    <t:formTemplate >
        <t:jobPostForm action="${pageContext.request.contextPath}/JobPost/Edit">
            <h3 class="register-heading"><fmt:message key="label.editJobPost.editOffer" /></h3>
        </t:jobPostForm>
    </t:formTemplate>
    <t:formValidate/>
</t:pageTemplate>
