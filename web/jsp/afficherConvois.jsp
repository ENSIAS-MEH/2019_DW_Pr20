<%--
  Created by IntelliJ IDEA.
  User: ZOUHAIR
  Date: 28/01/2020
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Convois</h1>
    <c:forEach items="${convois}" var="convoi">
        <tr>
            <td>${convoi.idConvoi}</td>
            <td>${convoi.titreConvoi}</td>
            <td>${convoi.description}</td>
            <td>${convoi.idBS}</td>
        </tr>
        <br />
    </c:forEach>
</body>
</html>
