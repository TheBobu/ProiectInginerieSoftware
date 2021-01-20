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
<style><%@include file="/WEB-INF/css/management.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<!DOCTYPE html>
<t:pageTemplate pageTitle="Comment-section">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    
    <section class="content-item" id="details">
        <div class="container-management">
            <h1 class="mb-4">Interview details</h1>
            <div class="row">
                <div class="col-md-6">
                    <h3 class="mb-4">Job Post: ${interview.jobPost.title}</h3>
                    <h3 class="mb-4">Candidate: ${interview.candidate.getName()} </h3>
                    <h3 class="mb-4">Interviewer: ${interview.interviewer.getName()}</h3>
                    <h3 class="mb-4">Interview status: ${interview.status}</h3> 
                </div>
                <div class="col-md-6">
                    <c:if test="${interview.status=='WAITING_INTERVIEW_DATE'}">
                        <h3>Interview is not established yet</h3>
                        <!--${interview.dateTime}-->
                        <c:if test="${user.id==interview.interviewer.id}">
                            <form method="POST" action="${pageContext.request.contextPath}/Comment?id=${id}">
                                <h3 class="mb-4"><label> Date: </label></h3>
                                <c:if test="${interview.dateTime != null}">
                                    <input name="date" type="" value="" required>
                                </c:if>
                                                 <input name="date" type="date" value="" required>
                                                 <!--2021-01-19 22:09:55.271-->
                                <h3 class="mb-4"><label> Time: </label>
                                                 <input name="time" type="time" value="" required ></h3>
                                <h3 class="mb-4"><label> Place: </label>
                                                 <input name="place" type="text" value="${interview.place}" placeholder="Place" required></h3>
                                <button class=" btn btn-profile col-xl btn btn-primary"  type="submit">Schedule interview</button>
<!--<a href="${pageContext.request.contextPath}/Comment?id=${interview.id}" role="button" class=" btn-profile col-xl btn btn-primary">View Interview</a>-->
                            </form>
                        </c:if>
                    </c:if>
                    <c:if test="${interview.status=='BEFORE_INTERVIEW'}">
                        <h3>Interview is currently set for:</h3>
                        <h3>- date : ${interview.getDate()}</h3>
                        <h3>- time : ${interview.getTime()}</h3>
                        <h3>- place: ${interview.place}</h3>
                        <c:if test="${user.id==interview.interviewer.id}">
                            <form method="POST" action="${pageContext.request.contextPath}/Comment?id=${id}">
                                <button class=" btn btn-profile"  type="submit">Request change</button>
                            </form>
                        </c:if>
                    </c:if>
                </div>
            </div>
    </section>
                
    <section class="content-item" id="comments">
        <div class="container-management mt-0">   
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