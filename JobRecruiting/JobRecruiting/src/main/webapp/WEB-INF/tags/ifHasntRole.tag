<%-- 
    Document   : ifHasntRole
    Created on : Jan 16, 2021, 3:32:00 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="role"%>

<%-- any content can be specified here e.g.: --%>
<c:if test="${pageContext.request.remoteUser !=null && !pageContext.request.isUserInRole(role)}" >
    <jsp:doBody />
</c:if>