<%--
  Created by IntelliJ IDEA.
  User: rustemrustem
  Date: 28.03.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>


<h1 align="center">${locale}</h1>
<hr>
<table align="center">
    <tr>


    <tr>
        <th align="left">Brand</th>
        <th align="left">Model</th>
        <c:forEach items="${messagesCars}" var="car">
    <tr>
        <td>${car.model}</td>
        <td>${car.brand}</td>
    </tr>

    </c:forEach>

    </tr>
</table>
</body>
</html>
