<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aspire
  Date: 21.11.2016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>

</head>
<body>

<%@ include file="/WEB-INF/pages/header.jsp"%>

<div class="container">
    <h1>Java Spring MVC (JavaConfig)</h1>
    <spring:message code="home.text"/>

    <a href="${pageContext.request.contextPath}/displayUsersMySQL">JSON: Display users with My SQL</a>
    <br/>
    <a href="${pageContext.request.contextPath}getBlogPostById/1">JSON: getBlogPostById/1</a>
    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/newblogpost.html"><spring:message code="new.post.text"/></a>
    <br/>
    <a href="${pageContext.request.contextPath}/blogposts"><spring:message code="blogs.text"/></a>
    <br/>
    <a href="${pageContext.request.contextPath}/admin.html"><spring:message code="admin.text"/></a>
    <br/>
    <br/>

    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
        <b><spring:message code="logged.text"/></b>
        <security:authentication property="principal.username"/> <security:authentication property="principal.authorities"/>
        <br/>
        <a href="<c:url value = "/logout"/>"><spring:message code="logout.button"/></a>
    </security:authorize>

</div>

<%@ include file="/WEB-INF/pages/footer.jsp"%>

</body>
</html>
