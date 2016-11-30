<%--
  Created by IntelliJ IDEA.
  User: Aspire
  Date: 27.11.2016
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<footer class="footer">
    <div class="container">
        <%--<p class="text-muted"><b>Tuna Tore 2016 Please feel free to ask me questions sending by email</b></p>--%>
        <a href="<%=request.getContextPath()%>?language=en">EN</a>
        <a href="<%=request.getContextPath()%>?language=ru">RU</a>

        <spring:message code="language"/>
        <font color="green"><b><spring:message code="welcome.text"/></b></font>
    </div>
</footer>
