<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title>Access denied</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>

</head>
<body>

<%@ include file="/WEB-INF/pages/header.jsp"%>

<div class="container">
    <h1><spring:message code="access.denied"/></h1>
</div>

<%@ include file="/WEB-INF/pages/footer.jsp"%>

</body>
</html>
