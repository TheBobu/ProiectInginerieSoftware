<%-- 
    Document   : comment-section
    Created on : Jan 11, 2021, 7:36:18 PM
    Author     : Deea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/comment.css"%></style>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<!DOCTYPE html>
<t:pageTemplate pageTitle="Comment-section">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <section class="content-item" id="comments">
        <div class="container">   
            <div class="row">
                <div class="col-sm-8">   
                   
                    <!-- COMMENT - START -->
                    <c:forEach var="comment" items="${comments}" varStatus="status">
                        <div class="media">
                            <div class="media-body">
                                <h4 class="media-heading">${comment.username}</h4>
                                <p>${comment.comment}</p>
                                <c:if test = "${comment.username == pageContext.request.getRemoteUser()}">
                                    <a href="${pageContext.request.contextPath}/DeleteComment?id=${comment.id}&interview=${id}"><fmt:message key="label.comment-section.deletecomment" /></a>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- COMMENT - END -->
                    
                    <form method="POST" action="${pageContext.request.contextPath}/Comment?id=${id}">
                        <h3 class="pull-left"><fmt:message key="label.comment-section.newcomment" /></h3>
                        <fieldset>
                            <div class="row">
                                <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                    <textarea name="comment" class="form-control" id="message" placeholder="<fmt:message key="label.comment-section.yourcomment" />" required=""></textarea>
                                </div>
                            </div>  	
                        </fieldset>
                        <button type="submit" class="btn btn-normal pull-right"><fmt:message key="label.comment-section.submit" /></button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</t:pageTemplate>