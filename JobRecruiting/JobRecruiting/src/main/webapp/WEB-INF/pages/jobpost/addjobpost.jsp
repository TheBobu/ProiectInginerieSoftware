<%-- 
    Document   : addjobposting
    Created on : Jan 3, 2021, 9:57:36 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add job post">

    <t:jobPostForm action="${pageContext.request.contextPath}/JobPost/Create">
        <h2 class="mb-3">Add job post</h2> 
    </t:jobPostForm>

</t:pageTemplate>
