<%--
  Created by IntelliJ IDEA.
  User: Mossati
  Date: 06/02/2020
  Time: 11:39 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Les Statistiques</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">
</head>

<body>
<%--
<c:if test="${empty sessionScope.banque or empty sessionScope.admin}">
    <c:redirect url="/"></c:redirect>
</c:if>
--%>
<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>


    <!-- Script for stat -->
    <script src="../frameworks/js/chart.js"></script>
    <script src="../js/stock.js"></script>
    <script src="../frameworks/js/highcharts.js"></script>
    <script src="../frameworks/js/exporting.js"></script>
    <script src="../frameworks/js/export-data.js"></script>
    <script src="../frameworks/js/series-label.js"></script>
    <script src="../frameworks/js/data.js"></script>
    <script src="../frameworks/js/drilldown.js"></script>
    <script src="../frameworks/jquery/jquery.js"></script>
    <script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Statistic Script-->
    <!-- End Script for Stat -->

</body>
</html>
