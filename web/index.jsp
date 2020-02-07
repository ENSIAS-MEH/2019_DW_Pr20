
<%--
  Created by IntelliJ IDEA.
  User: Mohamed Amine
  Date: 20/01/2020
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!--link rel="stylesheet" href="css/style.css"-->
    <style>
        .carousel-caption{
        background-color: rgba(255,255,255,0.6);
        }
    </style>
</head>
<body>
<%@ include file="jsp/navbar.jsp"%>
<div class="container">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" height="550" src="img/img_s1.jpg" alt="First slide">
                <div class="carousel-caption d-none d-md-block text-dark">
                    <h5>Bienvenue à notre plateforme de don du sang</h5>
                    <p>Si vous voulez avoir plus d'informations, vous pouvez poser vos questions au ChatBot.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" height="550" src="img/img_s2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" height="550" src="img/img_s3.jpg" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

</body>
<script src="frameworks/jquery/jquery.js"></script>
<script src="frameworks/bootstap4/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>


<!--CODE JAVASCRIPT-->
<script>



    /*MOVEMENT LORS LE SITE SE LANCE*/

    //navbar
    ScrollReveal().reveal('.navmov',{
        origin:'top',
        duration:2000,
        distance:'60px'
    });
    //slide
    ScrollReveal().reveal('.slideactive',{
        origin:'left',
        duration:2000,
        distance:'60px'
    });

    ScrollReveal().reveal('.bienvenu',{
        origin:'buttom',
        duration:2000,
        distance:'60px'
    });

    //Services
    ScrollReveal().reveal('.colservice0',{
        origin:'right',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.colservice1',{
        origin:'top',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.colservice2',{
        origin:'left',
        duration:2000,
        distance:'60px'
    });
    //Text milieur
    ScrollReveal().reveal('.textmilieu',{
        origin:'bottom',
        duration:2000,
        distance:'60px'
    });
    //Propos de nous
    ScrollReveal().reveal('.propo1',{
        origin:'left',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.propo2',{
        origin:'right',
        duration:2000,
        distance:'60px'
    });

    //Video
    ScrollReveal().reveal('.video',{
        origin:'left',
        duration:2000,
        distance:'60px'
    });

    //Citations
    ScrollReveal().reveal('.h2',{
        origin:'left',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('. slidecitation',{
        origin:'bottom',
        duration:2000,
        distance:'60px'
    });



    //footer
    ScrollReveal().reveal('.colfooter0',{
        origin:'bottom',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.colfooter1',{
        origin:'bottom',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.colfooter2',{
        origin:'bottom',
        duration:2000,
        distance:'60px'
    });
    ScrollReveal().reveal('.rowfooter',{
        origin:'right',
        duration:2000,
        distance:'60px'
    });


    // Get the current year for the copyright
    $('#year').text(new Date().getFullYear());




    // Configure Slider
    $('.carousel').carousel({
        interval: 6000,
        pause: 'hover'
    });

    // Lightbox Init
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
        event.preventDefault();
        $(this).ekkoLightbox();
    });

    // Video Play
    $(function () {
        // Auto play modal video
        $(".video").click(function () {
            var theModal = $(this).data("target"),
                videoSRC = $(this).attr("data-video"),
                videoSRCauto = videoSRC + "?modestbranding=1&rel=0&controls=0&showinfo=0&html5=1&autoplay=1";
            $(theModal + ' iframe').attr('src', videoSRCauto);
            $(theModal + ' button.close').click(function () {
                $(theModal + ' iframe').attr('src', videoSRC);
            });
        });
    });






    /*POUR LA NAVIGATION*/
    var open = document.getElementById('hamburger');
    var changeIcon = true;

    open.addEventListener("click", function(){

        var overlay = document.querySelector('.overlay');
        var nav = document.querySelector('nav');
        var icon = document.querySelector('.menu-toggle i');

        overlay.classList.toggle("menu-open");
        nav.classList.toggle("menu-open");

        if (changeIcon) {
            icon.classList.remove("fa-bars");
            icon.classList.add("fa-times");

            changeIcon = false;
        }
        else {
            icon.classList.remove("fa-times");
            icon.classList.add("fa-bars");
            changeIcon = true;
        }
    });
</script>
<script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>
</html>
