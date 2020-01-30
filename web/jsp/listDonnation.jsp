<%--
  Created by IntelliJ IDEA.
  User: Mossati-Oussama
  Date: 24/01/2020
  Time: 02:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>DONNATION</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">
</head>

<body>

<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>


</body>

<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(function(){
        $('[data-toggle="tooltip"]').tooltip();
        $('#banque').on("keyup",function(){
            var value=$(this).val().toLowerCase();
            $('#bnq tr').filter(function(){
                $(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
            });
        });
    });
</script>

</html>
