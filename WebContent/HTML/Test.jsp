<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>练习</title>
    <!---css--->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!---css--->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!---js--->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <!---js--->
    <link href="css/styles.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--web-fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Josefin+Sans:400,700italic,700,600italic,600,400italic,300italic,300,100italic,100' rel='stylesheet' type='text/css'>
    <!--//web-fonts-->
    <!--JS for animate-->
    <link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <script src="js/submitCode.js"></script>
</head>
<body>
<div class="header head">
    <div class="container">
        <div class="heder-top">
            <div class="logo">
                <h1><a href="index.html">Online Judge</a></h1>
            </div>
            <div class="nav-icon">
                <a href="#" class="navicon"></a>
                <div class="toggle">
                    <ul class="toggle-menu">
                        <li><a href="index.html">主页</a></li>
                        <li><a href="c.html">C语言</a></li>
                        <li><a  href="c++.html">c++</a></li>
                        <li><a  href="java.html">java</a></li>
                        <li><a  href="cont.html" class="active">代码测试</a></li>
                    </ul>
                </div>
                <script>
                    $('.navicon').on('click', function (e) {
                        e.preventDefault();
                        $(this).toggleClass('navicon--active');
                        $('.toggle').toggleClass('toggle--active');
                    });
                </script>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--header--->
<div class="content">
    <div class="contact">
        <div class="container">
            <h2>测试</h2>
            
            <div class="contact-grids">
                <div class="col-md-6 contact-grid wow fadeInLeft animated animated" data-wow-delay="0.4s">
                    <!-- <form action="../RunJAVA" method="post" target="nm_iframe"> -->
                        <div class="row1">
                            <label>代码：</label>
                            <textarea name="text" placeholder="请输入你的代码"></textarea>
                        </div>
                        <button id="submitCode">提交代码</button>
                   <!--  </form> -->
                </div>
                <div class="col-md-6 contact-grid wow fadeInRight animated animated" data-wow-delay="0.4s">
                    <div class="row1">
                        <label>运行结果：</label>
                       <iframe id="id_iframe" name="nm_iframe"></iframe>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<div class="footer-section wow fadeInDownBig animated animated" data-wow-delay="0.4s">
    <div class="container">
        <div class="copy">
            <p>感谢使用</p>
        </div>
    </div>
</div>
</body>
</html>