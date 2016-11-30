<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>New Blog Post</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>

</head>
<body>

<%@ include file="/WEB-INF/pages/header.jsp" %>

<div class="container">
    <h1><spring:message code="new.post.text"/></h1>

    <c:if test="${not empty message}">
        ${message}
        <br/>
        <a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a>
    </c:if>

    <form action="${pageContext.request.contextPath}/saveBlogPost"
          accept-charset="utf-8"
          method="post">
        <table style="width: 650px" class="table table-stripped">
            <tr>
                <td><spring:message code="title.text"/></td>
                <td><input type="text" name="title" required autofocus></td>
            </tr>
            <tr>
                <td><spring:message code="content.text"/></td>
                <td><textarea style="width: 400px" rows="10" name="content" maxlength="4000"></textarea></td>
            </tr>
            <tr>
                <td><spring:message code="draft.text"/></td>
                <td><input type="checkbox" name="draft"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>


    <button onclick="goBack()"><spring:message code="back.button"/></button>
    <script>
        function goBack() {
            window.history.go(-1);
        }
    </script>
    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/newblogpost.html"><spring:message code="new.post.text"/></a>
</div>

<%@ include file="/WEB-INF/pages/footer.jsp" %>

</body>
</html>
