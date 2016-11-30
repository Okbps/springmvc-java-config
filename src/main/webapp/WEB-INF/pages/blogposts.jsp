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
    <title>Blog Posts</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>

</head>
<body>

<%@ include file="/WEB-INF/pages/header.jsp"%>

<div class="container">
    <h1><spring:message code="blogs.text"/></h1>

    <c:if test="$(empty blogposts)">
        <spring:message code="no.blogs.text"/><br/>
    </c:if>

    <form action="${pageContext.request.contextPath}/searchByTitle" method="post">
        <table>
            <tr>
                <td><spring:message code="title.text"/>:</td><td><input name="title" type="text"></td>
                <td colspan="2"><input type="submit" value="Search"></td>
            </tr>
        </table>

    </form>

    <a href="${pageContext.request.contextPath}draftBlogPosts"><spring:message code="drafts.text"/></a>
    <br/>
    <br/>

    <table style="width: 650px" class="table table-stripped">
        <c:forEach var="blogpost" items="${blogposts}">
            <tr>
                <td>Blog post id</td>
                <td><c:out value="${blogpost.id}"/></td>
            </tr>

            <tr>
                <td><spring:message code="title.text"/></td>
                <td><c:out value="${blogpost.title}"/></td>
            </tr>

            <tr>
                <td><spring:message code="content.text"/></td>
                <td>
                    <div class="text-justify">
                        <c:out value="${blogpost.content}"/>
                    </div>
                </td>
            </tr>

            <tr>
                <td><spring:message code="draft.text"/></td>
                <td><c:out value="${blogpost.draft}"/></td>
            </tr>

            <tr><td colspan="2"></td></tr>
            <tr><td colspan="2"></td></tr>
        </c:forEach>
    </table>

    <%--<a href="${pageContext.request.contextPath}/"><spring:message code="back.button"/></a>--%>
    <button onclick="goBack()"><spring:message code="back.button"/></button>

    <script>
        function goBack() {
            window.history.go(-1);
        }
    </script>
</div>

<%@ include file="/WEB-INF/pages/footer.jsp"%>

</body>
</html>
