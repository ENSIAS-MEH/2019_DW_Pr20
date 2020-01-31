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

<div class="row">

    <div class="container">
        <h3 class="text-center">La Liste des Donnations</h3>
        <hr>
        <div class="row">
            <div class="input-group mb-3 col-lg-5">
                <input type="text" id="donnation" class="form-control border-danger" placeholder="Chercher une donnation">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>
            <div class="col-lg-7 float-left mb-3 row justify-content-end">
                <a class="btn btn-outline-dark font-weight-bold " data-toggle="modal" href="#AjouterDonnation">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une Donnation</a>
            </div>
        </div>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>N° donnateur</th>
                <th>Nom & Prenom</th>
                <th>Groupe sanguin</th>
                <th>Date de donnation</th>
                <th>Banque sanguin</th>
                <th>Téléphone</th>
                <th>Ville</th>
                <th class="align-content-center">Actions</th>
            </tr>
            </thead>

            <tbody id = "dnt">

            <c:forEach var="donnation" items="${donnationList}">
                <tr>
                    <td><c:out value="${donnation.idDonnateur}" /></td>

                    <c:forEach var="donnateur" items="${donnateurs}">
                        <c:if test="${donnateur.idDonnateur eq donnation.idDonnateur}">
                            <td data-toggle="tooltip" data-placement="right" title="Email: <c:out value="${donnateur.emailD}"/>
                           Tel: <c:out value="${donnateur.teleD}"/>
                           <c:out value="${donnateur.teleD}"/>">
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

                    <td><c:out value="${donnation.dateDonnation}" /></td>

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
<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="right" title="Tooltip on right">
    Tooltip on right
</button>

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
