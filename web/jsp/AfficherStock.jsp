<%--
  Created by IntelliJ IDEA.
  User: Berlin
  Date: 1/30/2020
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
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
<div class="container">
    <h3 class="card-title"> Les statistique sur Les Banques du sang</h3>
    <!--1st -->
    <div class="row">
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="A+.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(1).quantite}</h3>       <!--Text ghaykon fih Le nombre dyal kol Groupe-->
                            <a data-toggle="modal" href="#modifier">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="B+.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(2).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="AB+.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(4).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="O+.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(6).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <br><!--2nd Row-->
    <div class="row">
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="A-.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(0).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="B-.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(3).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="AB-.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(5).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-lg-6 col-6">
            <div class="card">
                <div class="card-body">
                    <div class="media d-flex">
                        <div class="align-self-center">
                            <img src="O-.png" width="40" height="60">
                        </div>
                        <div class="media-body text-right">
                            <h3 class="text-stat">${stockList.get(7).quantite}</h3>
                            <span class="text-stat">Requests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<br>

<div class="container">
<div class="row">
    <div class="col-12">
    <div class="card">
        <div class="card-header text-center" style="font-size: 24px">Les Statistiques</div>
        <div class="card-body">
            <div id="container1" style="margin: 0 auto"></div>
        </div>
    </div>
    </div>
</div>
</div>
</div>

<!-- Script for stat -->
<script src="../frameworks/js/chart.js"></script>
<script src="../frameworks/js/highcharts.js"></script>
<script src="../frameworks/js/exporting.js"></script>
<script src="../frameworks/js/export-data.js"></script>
<script src="../frameworks/js/series-label.js"></script>
<script src="../frameworks/js/modules/data.js"></script>
<script src="../frameworks/js/drilldown.js"></script>
<script>


    // Create the chart
    Highcharts.chart('container1', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Les Statiqtiques Actuels du Stock'
        },
        subtitle: {
            text: '${currentBanque.nomBS}' /*Nom du Banque*/
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Quantité Totale (L)'
            }

        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}L'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> L<br/>'
        },

        "series": [
            {
                "name": "Browsers",
                "colorByPoint": true,
                "data": [
                    {
                        "name": "${groupList.get(0).nomGS}",
                        "y": ${stockList.get(0).quantite},
                        "drilldown": "${groupList.get(0).nomGS}"
                    },
                    {
                        "name": "${groupList.get(1).nomGS}",
                        "y": ${stockList.get(1).quantite},
                        "drilldown": "${groupList.get(1).nomGS}"
                    },
                    {
                        "name": "${groupList.get(2).nomGS}",
                        "y": ${stockList.get(2).quantite},
                        "drilldown": "${groupList.get(2).nomGS}"
                    },
                    {
                        "name": "${groupList.get(3).nomGS}",
                        "y": ${stockList.get(3).quantite},
                        "drilldown": "${groupList.get(3).nomGS}"
                    },
                    {
                        "name": "${groupList.get(4).nomGS}",
                        "y": ${stockList.get(4).quantite},
                        "drilldown": "${groupList.get(4).nomGS}"
                    },
                    {
                        "name": "${groupList.get(5).nomGS}",
                        "y": ${stockList.get(5).quantite},
                        "drilldown": "${groupList.get(5).nomGS}"
                    },
                    {
                        "name": "${groupList.get(6).nomGS}",
                        "y": ${stockList.get(6).quantite},
                        "drilldown": "${groupList.get(6).nomGS}"
                    },
                    {
                        "name": "${groupList.get(7).nomGS}",
                        "y": ${stockList.get(7).quantite},
                        "drilldown": "${groupList.get(7).nomGS}"
                    }
                ]
            }
        ],
        "drilldown": {
            "series": [
                {
                    "name": "Chrome",
                    "id": "Chrome",
                    "data": [
                        [
                            "v65.0",
                            0.1
                        ],
                        [
                            "v64.0",
                            1.3
                        ],
                        [
                            "v63.0",
                            53.02
                        ],
                        [
                            "v62.0",
                            1.4
                        ],
                        [
                            "v61.0",
                            0.88
                        ],
                        [
                            "v60.0",
                            0.56
                        ],
                        [
                            "v59.0",
                            0.45
                        ],
                        [
                            "v58.0",
                            0.49
                        ],
                        [
                            "v57.0",
                            0.32
                        ],
                        [
                            "v56.0",
                            0.29
                        ],
                        [
                            "v55.0",
                            0.79
                        ],
                        [
                            "v54.0",
                            0.18
                        ],
                        [
                            "v51.0",
                            0.13
                        ],
                        [
                            "v49.0",
                            2.16
                        ],
                        [
                            "v48.0",
                            0.13
                        ],
                        [
                            "v47.0",
                            0.11
                        ],
                        [
                            "v43.0",
                            0.17
                        ],
                        [
                            "v29.0",
                            0.26
                        ]
                    ]
                },
                {
                    "name": "Firefox",
                    "id": "Firefox",
                    "data": [
                        [
                            "v58.0",
                            1.02
                        ],
                        [
                            "v57.0",
                            7.36
                        ],
                        [
                            "v56.0",
                            0.35
                        ],
                        [
                            "v55.0",
                            0.11
                        ],
                        [
                            "v54.0",
                            0.1
                        ],
                        [
                            "v52.0",
                            0.95
                        ],
                        [
                            "v51.0",
                            0.15
                        ],
                        [
                            "v50.0",
                            0.1
                        ],
                        [
                            "v48.0",
                            0.31
                        ],
                        [
                            "v47.0",
                            0.12
                        ]
                    ]
                },
                {
                    "name": "Internet Explorer",
                    "id": "Internet Explorer",
                    "data": [
                        [
                            "v11.0",
                            6.2
                        ],
                        [
                            "v10.0",
                            0.29
                        ],
                        [
                            "v9.0",
                            0.27
                        ],
                        [
                            "v8.0",
                            0.47
                        ]
                    ]
                },
                {
                    "name": "Safari",
                    "id": "Safari",
                    "data": [
                        [
                            "v11.0",
                            3.39
                        ],
                        [
                            "v10.1",
                            0.96
                        ],
                        [
                            "v10.0",
                            0.36
                        ],
                        [
                            "v9.1",
                            0.54
                        ],
                        [
                            "v9.0",
                            0.13
                        ],
                        [
                            "v5.1",
                            0.2
                        ]
                    ]
                },
                {
                    "name": "Edge",
                    "id": "Edge",
                    "data": [
                        [
                            "v16",
                            2.6
                        ],
                        [
                            "v15",
                            0.92
                        ],
                        [
                            "v14",
                            0.4
                        ],
                        [
                            "v13",
                            0.1
                        ]
                    ]
                },
                {
                    "name": "Opera",
                    "id": "Opera",
                    "data": [
                        [
                            "v50.0",
                            0.96
                        ],
                        [
                            "v49.0",
                            0.82
                        ],
                        [
                            "v12.1",
                            0.14
                        ]
                    ]
                }
            ]
        }
    });

</script>
<!-- End Script for Stat -->

</body>
</html>
