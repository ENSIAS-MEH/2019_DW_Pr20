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
    <link rel="stylesheet" href="frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/solid.min.css">
    <title>List Des Convois</title>
</head>
<body>
    <header>
        <%@ include file="navbar.jsp"%>
    </header>

    <div class="container">
        <div class="row">
            <i class='fas fa-list' style='font-size:36px;color:red;margin-right: 20px'></i>
            <h2> List Convois : </h2>
        </div>
        <div class="row">
            <div class="input-group md-form form-sm form-1 pl-0">
                <div class="input-group-prepend">
                    <span class="input-group-text pink lighten-3" id="basic-text1">
                        <i class="fas fa-search text-white" aria-hidden="true"></i>
                    </span>
                </div>
                <input class="form-control my-0 py-1" type="text" placeholder="Search" aria-label="Search">
            </div>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Titre</th>
                <th scope="col">Description</th>
                <th scope="col">Banque du Sang</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${convois}" var="convoi">
                <tr>
                    <th scope="row">${convoi.idConvoi}</th>
                    <td>${convoi.titreConvoi}</td>
                    <td>${convoi.description}</td>
                    <td>${convoi.idBS}</td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
<script src="frameworks/jquery/jquery.js"></script>
<script src="frameworks/bootstap4/dist/js/bootstrap.min.js"></script>
</html>
