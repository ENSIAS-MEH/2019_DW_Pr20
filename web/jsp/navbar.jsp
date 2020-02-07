<%--
  Created by IntelliJ IDEA.
  User: Mohamed Amine
  Date: 26/01/2020
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Don du sang</title>
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">
    <style>
        .navbar{
            background: lightgray;
            text-transform: uppercase;

        }
        .nav-link{
            color: #b21f2d !important;
            font-weight: bold;
        }
        .nav-link:hover{
            letter-spacing: 2px;
            text-align: center;
            background: #b21f2d !important;
            color: #bbbbbb !important;
        }
        .navbar-collapse{
            justify-content: center;
        }
        .btn-round{border-radius:500px}
        .btn-round,.btn-round:hover,.btn-round:active{border-color:transparent}
    </style>
</head>
<body class="alert-secondary">
<div class="navbar navbar-expand-lg navbar-dark mb-3">
    <a href="#" class="navbar-brand font-weight-bold text-Danger text-lg-left float-left"><span class="fa fa-tint fa-2x"></span>&nbsp;Don du Sang</a>
    <button type="button" class="navbar-toggler btn btn-outline-danger" data-toggle="collapse" data-target="#nav">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="nav">
        <ul class="navbar-nav">
            <c:if test="${(empty sessionScope.admin)  && (empty sessionScope.banquesang) && (empty sessionScope.donnateur)}">
                <li class="nav-item">
                    <a href="#" class="nav-link p-2 mr-5 rounded">Home</a>
                </li>
                <li class="nav-item ">
                    <a href="SignIn" class="nav-link mr-5 p-2 border border-danger rounded">Sign In</a>
                </li>
            </c:if>
            <c:if test="${not empty sessionScope.banquesang}">
                <li class="nav-item">
                    <a href="Statistiques" class="nav-link mr-5 p-2 rounded">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a href="Convois" class="nav-link mr-5 p-2 rounded">Convois</a>
                </li>
                <li class="nav-item">
                    <a href="Alertes" class="nav-link mr-5 p-2 rounded">Alertes</a>
                </li>
                <li class="nav-item">
                    <a href="Donnation" class="nav-link mr-5 p-2 rounded">Donations</a>
                </li>
            </c:if>
            <c:if test="${not empty sessionScope.admin}">
                <li class="nav-item">
                    <a href="AdminStatistiques" class="nav-link mr-5 p-2 rounded">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a href="LesBanquesDuSang" class="nav-link mr-5 p-2 rounded">Banques</a>
                </li>
                <li class="nav-item">
                    <a href="Donnateur" class="nav-link mr-5 p-2 rounded">Donators</a>
                </li>
            </c:if>
            <c:if test="${not empty sessionScope.donnateur}">
                <li class="nav-item">
                    <a href="Alertes" class="nav-link mr-5 p-2 rounded">Alertes</a>
                </li>
                <li class="nav-item">
                    <a href="Donnation" class="nav-link mr-5 p-2 rounded">Donations</a>
                </li>
                <li class="nav-item">
                    <a href="Convois" class="nav-link mr-5 p-2 rounded">Convois</a>
                </li>
            </c:if>
            <c:if test="${(not empty sessionScope.admin)  || (not empty sessionScope.banquesang) || (not empty sessionScope.donnateur)}">
                <li class="nav-item">
                    <a href="LogOut" class="nav-link mr-5 p-2 border border-danger rounded">Log Out</a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class="justify-content-end">
        <!--button class="btn btn-secondary btn-round btn-block" data-toggle="modal" data-target="#help"><span class="far fa-lightbulb text-white fa-2x"></span></button-->
        <a data-toggle="modal" class="btn btn-secondary btn-round btn-block" data-target="#help">
                                        <span data-toggle="tooltip" title="ChatBot" data-placement="left">
                                            <span class="far fa-lightbulb text-white fa-2x"></span>
                                        </span>
        </a>
    </div>
</div>
<div class="modal" id="help" tabindex="-1" role="dialog"  aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content p-1">
            <iframe
                    allow="microphone;"
                    width="480"
                    height="430"
                    src="https://console.dialogflow.com/api-client/demo/embedded/7c7758be-1a47-4da6-a08f-9826f726770c">
            </iframe>
        </div>
    </div>
</div>
</body>

</html>
