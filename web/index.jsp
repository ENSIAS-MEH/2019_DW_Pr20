
<%--
  Created by IntelliJ IDEA.
  User: Mohamed Amine
  Date: 20/01/2020
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>

    <link rel="shortcut icon" type="image/x-icon" href="ressources/img/back.png" />
    <link rel="stylesheet" href="ressources/css/style.css">
    <script type="text/javascript" src="ressources/js/jquery.js"></script>


    <title>Blood Donation</title>
</head>

<body>




<!--************-->
<!-- Slides -->
<!--************-->
<section id="slide">
    <div id="monSlide" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#monSlide" data-slide-to="0" class="active"></li>
            <li data-target="#monSlide" data-slide-to="1"></li>
            <li data-target="#monSlide" data-slide-to="2"></li>
            <li  class="active"></li>
            <li ></li>
            <li></li>
        </ol>
        <div class="carousel-inner">

            <!--Slide 1 avec la possibilite de s'identifier-->
            <div class="carousel-item carousel-image-1   active">
                <div class="container">
                    <div class="carousel-caption d-non d-sm-block text-left">
                        <div class="row" >

                            <!--TEXT-->
                            <div class="col bienvenu">
                                <h2 class="display-4 d-inline mylead">Bienvenue à notre plateforme de don du sang!</h2>
                                    <p></p>
                                    <p class="lead textbg"> Si vous voulez avoir plus d'informations, vous pouvez poser vos questions au <b>ChatBot. </b></p>
                            </div>
                            <div class="col">


                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Slide 2-->
            <div class="carousel-item carousel-image-2 ">
                <div class="container">
                    <div class="carousel-caption d-non d-sm-block text-right mb-5">
                        <div class="row" style="margin-bottom: 55px;">
                            <div class="col"></div>
                            <div class="col">
                                <h2 class="display-4 d-inline titreB text">Give Blood</h2>
                                <br>
                                <p class="lead textbg" style="font-size: 26px;"> Give life...</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Slide 3-->
            <div class="carousel-item carousel-image-3 ">
                <div class="container">
                    <div class="carousel-caption d-non d-sm-block text-right mb-5">
                    </div>
                </div>
            </div>
        </div>
        <!--Suivant & Precedant-->
        <a href="#monSlide" data-slide="prev" class="carousel-control-prev">
            <span class="carousel-control-prev-icon"></span>
        </a>

        <a href="#monSlide" data-slide="next" class="carousel-control-next">
            <span class="carousel-control-next-icon"></span>
        </a>

    </div>
</section>





<!--************-->
<!--Nos services -->
<!--************-->
<section id="Services" class="py-5">
    <div class="container">
        <div class="row">
            <!--Icon1-->
            <div class="col-md-4 mb-4 text-center colservice0">
                <i class="fa fa-users fa-3x mb-2" ></i>
                <h3>+50 Donateurs</h3>
                <p>On compte sur votre adhésion pour augmenter ce chiffre!</p>
            </div>
            <!--Icon2-->
            <div class="col-md-4 mb-4 text-center colservice1">
                <i class="fa fa-tint fa-3x mb-2"></i>
                <h3>+20 Banques du sang</h3>
                <p>Plusieurs banques du sang sont distribués sur les différents villes de notre pays.</p>
            </div>
            <!--Icon3-->
            <div class="col-md-4 mb-4 text-center colservice2">
                <i class="fa fa-syringe fa-3x mb-2"></i>
                <h3>+100 Donations</h3>
                <p>Votre donations peut sauver une vie..<br> Que'est ce que vous attendez!</p>
            </div>
        </div>
    </div>
</section>






<!--************-->
<!--Section milieu -->
<!--************-->
<section id="sectionMilieu" class="p-5">
    <div class="dark-overlay">
        <div class="row">
            <div class="col">
                <div class="container pt-5 textmilieu">
                    <h1>Sign In </h1>
                    <br>
                    <br>
                    <a id="btn" href="SignIn"></a>
                </div>
            </div>
        </div>
    </div>
</section>








<!--************-->
<!--Information -->
<!--************-->
<section id="info" class="py-3 mb-5">
    <div class="container">
        <div class="row">
            <div class="col-md-6 mymarginlefttext mypaddingtop mypaddingbottom propo1">
                <h3>Nos Tweets</h3>
                <a class="twitter-timeline" href="https://twitter.com/Donation_Sang" data-height="600">Tweets by @Donation_Sang</a>
            </div>

        </div>
    </div>
</section>















<!-- Citations -->
<div class="section-container">
    <div class="row ">
    </div>
</div>





<!--************-->
<!--Foter -->
<!--************-->

<footer>
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-3 colfooter0">
                    <p>
                        Notre banques du sang travaillent  pour vous offrir des conseilles fidèles.
                    </p>

                </div>
                <div class="col-md-4 offset-md-1 colfooter1">
                    <h3>Contact</h3>
                    <p><i class="fas fa-map-marker-alt"></i> Avune de france, Agdal, Rabat</p>
                    <p><i class="fas fa-phone" ></i> Téléphone: O5 36 22 67 11</p>
                    <p><i class="fas fa-envelope"></i> Email: <a href="mailto:hello@domain.com" class="a">support@esurte.com</a></p>
                </div>

            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <div class="row rowfooter">
                <div class="col-md-6 footer-copyright">
                    Copyright &copy; <span id="year"></span>, powered by ENSIAS
                </div>
                <div class="col-md-6 footer-social">
                    <a href="#"><i class="fab fa-facebook-f"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-google-plus-g"></i></a>
                </div>
            </div>
        </div>
    </div>
</footer>


<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>


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


</body>

</html>