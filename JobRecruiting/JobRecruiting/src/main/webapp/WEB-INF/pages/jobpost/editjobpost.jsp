<%-- 
    Document   : editjobpost
    Created on : Jan 7, 2021, 5:16:41 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Edit job post">

    <t:jobPostForm action="${pageContext.request.contextPath}/JobPost/Edit">
        <h2 class="mb-3">Edit job post</h2> 
    </t:jobPostForm>
    
</t:pageTemplate>
