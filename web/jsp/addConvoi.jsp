
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/solid.min.css">
    <title>Title</title>
</head>
<body>
<header>
    <%@ include file="navbar.jsp"%>
</header>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <h1> ADD CONVOI</h1>
            <form method="post" action="/AjouterConvoi">
                <div class="form-row">
                    <div>
                        <label for="titreConvoi">Titre du Convoi</label>
                        <input type="text" class="form-control" id="titreConvoi" name="titreConvoi" placeholder="Titre">
                    </div>
                </div>
                <div class="form-row">
                    <div>
                        <label for="description">Description</label>
                        <i class="fas fa-pencil-alt prefix"></i>
                        <textarea id="description" name="description" class="md-textarea form-control" rows="10"></textarea>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Créer le Convoi</button>
            </form>
        </div>
    </div>
</div>

</body>
<script src="frameworks/jquery/jquery.js"></script>
<script src="frameworks/bootstap4/dist/js/bootstrap.min.js"></script>
</html>
