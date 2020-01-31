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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>DONNATION</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">

    <link rel="stylesheet" type="text/css" href="../css/donnation.css">
</head>

<body>

<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">La Liste des Donnations</h3>
        <hr>
        <div class="row">
            <div class="input-group mb-3 col-lg-4" style="background-color: burlywood;">
                <input type="text" id="donnation" class="form-control border-danger" placeholder="Chercher par nom du donnateur">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>
            <div class="col-lg-3 mb-3" style="background-color: grey;">
                Groupe sanguin:
                <select name="GrpSng" id="gs_select">
                    <option value="all">-- All --</option>
                    <option value="A-">A-</option>
                    <option value="A+">A+</option>
                    <option value="B+">B+</option>
                    <option value="B-">B-</option>
                    <option value="AB+">AB+</option>
                    <option value="AB-">AB-</option>
                    <option value="O+">O+</option>
                    <option value="O-">O-</option>
                </select>
            </div>

            <div class="col-lg-1 mb-3"></div>

            <div class="col-lg-2 mb-3" style="background-color: darkolivegreen;">
                Ville:
                <select name="villes" id="ville_select">
                    <option value="all">-- All --</option>
                    <c:forEach var="ville" items="${villes}">
                        <option value="<c:out value="${ville.nomVille}"/>"><c:out value="${ville.nomVille}"/></option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-lg-3 float-left mb-3 row justify-content-end" style="background-color: royalblue;">
                <a class="btn btn-outline-dark font-weight-bold " data-toggle="modal" href="#AjouterDonnation">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une Donnation</a>
            </div>
        </div>

        <br>
        <table class="table table-bordered" id="dnt_table">
            <thead>
            <tr>
                <th onclick='sortTable(1)'>N° donnateur</th>
                <th onclick='sortTable(2)'>Nom & Prenom</th>
                <th onclick='sortTable(3)'>Groupe sanguin</th>
                <th onclick='sortTable(4)'>Date de donnation</th>
                <th onclick='sortTable(5)'>Banque sanguin</th>
                <th onclick='sortTable(6)'>Téléphone</th>
                <th onclick='sortTable(7)'>Ville</th>
                <th class="align-content-center">Actions</th>
            </tr>
            </thead>

            <tbody id = "dnt">

            <c:forEach var="donnation" items="${donnationList}">
                <tr>
                    <td><c:out value="${donnation.idDonnateur}" /></td>

                    <c:forEach var="donnateur" items="${donnateurs}">
                        <c:if test="${donnateur.idDonnateur eq donnation.idDonnateur}">
                            <td data-toggle="tooltip" data-placement="right" title="Email:<br>Tel:<br>Adresse:">
                                <c:out value="${donnateur.nomD}"/> <c:out value="${donnateur.prenomD}"/>
                            </td>
                            <td>
                                <c:forEach var="gs" items="${gsList}">
                                    <c:if test="${gs.idGS eq donnateur.idGS}">
                                        <c:out value="${gs.nomGS}"/>
                                    </c:if>
                                </c:forEach>
                            </td>
                        </c:if>
                    </c:forEach>

                    <td><fmt:formatDate value="${donnation.dateDonnation}" pattern="dd/MM/yyyy HH:mm"/></td>

                    <c:forEach var="banque" items="${banqueSangList}">
                        <c:if test="${banque.idBS eq donnation.idBS}">
                            <td><c:out value="${banque.nomBS}" /></td>
                            <td><c:out value="${banque.teleBS}" /></td>

                            <c:forEach var="ville" items="${villes}">
                                <c:if test="${banque.idVille eq ville.idVille}">
                                    <td><c:out value="${ville.nomVille}"/></td>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>

                    <td >
                        <a data-toggle="modal" href="#AjouterBanque">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-pen" aria-hidden="true"></span>
                                </span>
                        </a>
                        <a data-toggle="modal" href="#sup${banque.idBS}">
                                <span class="shadow text-danger p-2 " data-toggle="tooltip" title="Supprimer" data-placement="right">
                                    <span class="fa fa-trash" aria-hidden="true"></span>
                                </span>
                        </a>
                    </td>
                </tr>
                <!-- Fin Table -->

            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

</body>

<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

<script src="../js/donnation.js" type="text/javascript"></script>

</html>
