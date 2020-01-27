<%--
  Created by IntelliJ IDEA.
  User: Berlin
  Date: 1/26/2020
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Le Banque du Sang</title>
    <link rel="stylesheet" href="frameworks/bootstap4/css/bootstrap.min.css"/>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #af111c">
        <div>
            <a href="https://www.github.com/MejdaouiSoufiane" class="navbar-brand"> Platforme de Don du Sang</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/LesBaqnuesDuSang" class="nav-link">Les Banques du Sang</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
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
                        <c:if test="${banqueSangExist != null}">Modifier le Banque</c:if>
                        <c:if test="${banqueSangExist == null}">Ajouter le Banque</c:if>
                    </button>
                </form>
        </div>
    </div>
</div>
</body>

</html>