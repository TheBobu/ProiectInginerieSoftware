<%-- 
    Document   : ifHasRole
    Created on : Jan 14, 2021, 9:42:42 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@attribute name="role"%>

<c:if test="${pageContext.request.isUserInRole(role)}" >
    <jsp:doBody />
</c:if>