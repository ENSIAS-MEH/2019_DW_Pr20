<%--
  Created by IntelliJ IDEA.
  User: ZOUHAIR
  Date: 30/01/2020
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Planning</title>
    <link rel="stylesheet" href="frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/solid.min.css">
</head>
<body>
    <header>
        <%@ include file="navbar.jsp"%>
    </header>
    <div class="row">
        <div class="container" >
            <h3>Planning du Convois : <c:out value="${convoi.titreConvoi}"></c:out></h3>
            <hr />
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Ville</th>
                    <th scope="col">Date debut</th>
                    <th scope="col">Date Fin</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${plannings}" var="planning">
                        <tr>
                            <th scope="row">
                                <c:forEach var="ville" items="${villes}">
                                    <c:if test="${ville.idVille eq planning.idVille}">
                                        <c:out value="${ville.nomVille}"></c:out>
                                    </c:if>
                                </c:forEach>
                            </th>

                            <th scope="row">
                                <c:out value="${planning.dateConvoi_debut}"></c:out>
                            </th>

                            <th scope="row">
                                <c:out value="${planning.dateConvoi_fin}"></c:out>
                            </th>
                        </tr>
                    </c:forEach>
                </tbody> 
            </table>
        </div>


    </div>

</body>
<script src="frameworks/jquery/jquery.js"></script>
<script src="frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
</html>
