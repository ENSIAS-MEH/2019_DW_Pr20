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
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">
</head>

<body>

<header>
    <%@ include file="navbar.jsp"%>

    <!--<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #af111c">
        <div>
            <a href="https://www.github.com/MejdaouiSoufiane" class="navbar-brand"> Platforme de Don du Sang</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="/LesBaqnuesDuSang" class="nav-link">Les Banques du Sang</a></li>
        </ul>
    </nav>-->
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">La Liste des Banques du Sang</h3>
        <hr>
        <div class="row">
            <div class="input-group mb-3 col-lg-5">
                <input type="text" id="banque" class="form-control border-danger" placeholder="Chercher une Banque">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>
            <div class="col-lg-7 float-left mb-3 row justify-content-end">
                <a class="btn btn-outline-dark font-weight-bold " data-toggle="modal" href="#AjouterBanque">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une Banque Du Sang</a>
            </div>
        </div>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Numéro</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Téléphone</th>
                <th>Adresse</th>
                <th>Ville</th>
                <!--<th>Mot de passe</th>-->
                <th class="align-content-center">Actions</th>
            </tr>
            </thead>
            <tbody id = "bnq">
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
                <div class="modal mt-lg-5" id="sup${banque.idBS}">
                    <div class="modal-dialog">
                        <div class="modal-content rounded">
                            <div class="modal-body alert-dark">
                                <p class="font-weight-bold text-center">Voulez vous vraiment supprimer cette Banque du sang ? </p>
                                <div>
                                    <button class="btn btn-outline-dark float-left" data-dismiss="modal" type="button">
                                        Annuler
                                    </button>
                                    <a class="btn btn-outline-danger float-right" type="button" href="SupprimerBanque?s=${banque.idBS}">
                                        Supprimer
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin Modal Supprimer -->

            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>

<!-- Les Modals-->
<div class="modal mt-lg-5" id="AjouterBanque">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-header alert-danger text-center">
                <h5 class="font-weight-bold modal-title">Remplire les informations de Banque</h5>
                <button type="button" class="close" data-dismiss="modal">X</button>
            </div>
            <div class="modal-body">
                <c:if test="${banqueSangExist != null}">
                <form action="/LesBaqnuesDuSang" method="post">
                    </c:if>
                    <c:if test="${banqueSangExist == null}">
                    <form action="/LesBaqnuesDuSang" method="post">
                        </c:if>
                        <caption>
                            <h2>
                                <c:if test="${banqueSangExist != null}">
                                    <p class="align-content-md-center">
                                        Modifier un Banque Du Sang
                                    </p>
                                </c:if>
                                <c:if test="${banqueSangExist == null}">
                                    <p class="align-content-md-center">
                                        Ajouter un nouveau Banque Du Sang
                                    </p>
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${banqueSangExist != null}">
                            <input type="hidden" name="idBS" value="<c:out value='${banqueSangExist.idBS}' />" />
                        </c:if>

                        <c:if test="${banqueSangExist == null}">
                            <input type="hidden" name="idBS" value="<c:out value='${nombreBanque+1}' />" />
                        </c:if>

                        <c:if test="${banqueSangExist != null}">
                            <input type="hidden" name="passwordBS" value="<c:out value='${banqueSangExist.passwordBS}' />" />
                        </c:if>

                        <c:if test="${banqueSangExist == null}">
                            <input type="hidden" name="passwordBS" value="azerty123" />
                        </c:if>
                        <fieldset class="form-group">
                            <label>Nom du Banque</label>
                            <input type="text" value="<c:out value='${banqueSangExist.nomBS}' />" class="form-control" name="nomBS" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Banque Email</label>
                            <input type="text" value="<c:out value='${banqueSangExist.emailBS}' />" class="form-control" name="emailBS">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Téléphone</label>
                            <input type="text" value="<c:out value='${banqueSangExist.teleBS}' />" class="form-control" name="teleBS">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Adresse</label>
                            <input type="text" value="<c:out value='${banqueSangExist.adresseBS}' />" class="form-control" name="adresseBS">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Adresse</label>
                            <select class="browser-default custom-select form-control" name="idVille">
                                <option selected value="">La ville du Banque</option>
                                <c:forEach items="${villes}" var="ville">
                                    <option value="<c:out value="${ville.idVille}"/>" ><c:out value="${ville.nomVille}"/></option>
                                </c:forEach>
                            </select>
                        </fieldset>

                        <button type="submit" class="btn btn-success">
                            <c:if test="${banqueSangExist != null}">Modifier la Banque</c:if>
                            <c:if test="${banqueSangExist == null}">Ajouter la Banque</c:if>
                        </button>
                    </form>
            </div>
        </div>
    </div>
</div>
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