<%--
  Created by IntelliJ IDEA.
  banque: Berlin
  Date: 1/25/2020
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Test On BanqueSang CRUD</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #af111c">
        <div>
            <a href="https://www.github.com/MejdaouiSoufiane" class="navbar-brand"> Platforme de Don du Sang</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="/LesBaqnuesDuSang" class="nav-link">Les Banques du Sang</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">Liste des Banques du Sang</h3>
        <hr>
        <div class="container text-left">
                <a href="/nouveauBanqueForm" class="btn btn-success">Nouveau banque du sang</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Numéro</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Téléhone</th>
                <th>Adresse</th>
                <th>Ville</th>
                <!--<th>Mot de passe</th>-->
                <th class="align-content-center">Actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="banque" items="${banqueSangList}">

                <tr>
                    <td>
                        <c:out value="${banque.idBS}" />
                    </td>
                    <td>
                        <c:out value="${banque.nomBS}" />
                    </td>
                    <td>
                        <c:out value="${banque.emailBS}" />
                    </td>
                    <td>
                        <c:out value="${banque.teleBS}" />
                    </td>
                    <td>
                        <c:out value="${banque.adresseBS}" />
                    </td>
                    <td>
                        <c:forEach var="ville" items="${villes}">
                            <c:if test="${banque.idVille eq ville.idVille}">
                                <c:out value="${ville.nomVille}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td >
                        <a style="color: orangered" href="edit?idBanque=<c:out value='${banque.idBS}' />">Modifier</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a style="color: orangered" href="delete?idBanque=<c:out value='${banque.idBS}' />">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>