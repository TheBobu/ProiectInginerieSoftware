<%-- 
    Document   : displayError
    Created on : Jan 8, 2021, 10:49:15 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="error"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>

<c:if test="${errors.get(error)!=''}">
    <div class="text-danger">
        ${errors.get(error)}
    </div>
</c:if>