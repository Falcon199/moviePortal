<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Moviereviews</title>
    <link rel="shortcut icon" type="image/x-icon" href="../css/images/favicon.ico"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="../css/colorbox.css" type="text/css" media="all"/>

    <script src="../js/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="../js/jquery.colorbox-min.js" type="text/javascript"></script>

    <script src="../js/modernizr.custom.js"></script>
    <script src="../js/functions.js" type="text/javascript"></script>
</head>
<body>
<!-- wrapper -->
<div id="wrapper">
    <div class="light-bg">
        <!-- shell -->
        <div class="shell">
            <!-- header -->
            <div class="header">
                <!-- socials -->
                <div class="socials">
                    <a href="#" class="facebook-ico">facebook-ico</a>
                    <a href="#" class="twitter-ico">twitter-ico</a>
                    <a href="#" class="you-tube-ico">you-tube-ico</a>
                </div>
                <!-- end of socials -->
                <h1 id="logo"><a href="/home">Moviereviews</a></h1>
                <!-- navigation -->

                <!-- end of navigation -->
                <div class="cl">&nbsp;</div>
            </div>
            <!-- end of header -->
            <!-- main -->
            <div class="main">
                <!-- content -->
                <section class="content">
                    <!-- post -->

                        <div class="post">
                            <!-- post-inner -->
                            <div class="post-inner">
                                <div style="float: left;width: 40%">
                                    <img src="/getImage?picName=${movie.picUrl}">
                                </div>
                                <div style="float: left;width: 55%">
                                    Title: ${movie.title}<br>
                                    Description:${movie.description}<br>
                                    Year:${movie.year}<br>
                                    Genres:<p>
                                    <c:forEach items="${movie.genres}" var="genre">
                                        ${genre.name}
                                    </c:forEach></p><br>
                                    Date: ${movie.createdDate}<br>
                                    Director:${movie.director}<br>
                                </div>
                            </div>
                            <!-- post-inner -->
                        </div>


                </section>
                <!-- end of content -->
                <!-- sidebar -->
                <aside class="sidebar">
                    <div class="widget">
                        <h3 class="widgettitle"><a href="/home">Show All</a></h3>
                        <h3 class="widgettitle"><a href="/login">Login</a></h3>
                        <h3 class="widgettitle">Genres</h3>

                        <ul>
                            <c:forEach items="${allGenres}" var="genre">
                                <li><a href="/genreHome?id=${genre.id}">${genre.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>


                    <div class="widget socials-widget">
                        <h3 class="widgettitle">Year</h3>
                        <c:forEach items="${allMovies}" var="movie">
                            <ul>
                                <li><a href="/yearHome?year=${movie.year}">${movie.year}</a></li>
                            </ul>
                        </c:forEach>
                    </div>
                </aside>
                <!-- end of sidebar -->
                <div class="cl">&nbsp;</div>
            </div>
            <!-- end of main -->
            <div class="footer">
                <nav class="footer-nav">
                    <ul>
                        <li><a href="/home">Show All</a></li>
                    </ul>
                </nav>

            </div>
        </div>
        <!-- end of shell -->
    </div>
</div>
<!-- end of wrapper -->
</body>
</html>


