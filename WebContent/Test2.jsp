<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
    <!--//end-animate-->
    <style>
        #div1{margin: 0;
            padding: 0;}
    </style>
</head>
<body>
<div class="header head">
    <div class="container">
        <div class="heder-top">
            <div class="logo">
                <h1><a href="index.html">Online Judge</a></h1>
            </div>
            <div class="nav-icon">
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
        <div class="container" id="con">

            <h2>代码测试</h2>
            <div class="packt">
                <ul class="nav nav-tabs">
                    <li class="active" id="c">
                        <a href="#">
                            <span class="glyphicon glyphicon-pencil"></span> C语言
                        </a>
                    </li>
                    <li id="c++">
                        <a href="#">
                            <span class="glyphicon glyphicon-book"></span> C++
                        </a>
                    </li>
                    <li id="java">
                        <a href="#">
                            <span class="glyphicon glyphicon-edit"></span> Java
                        </a>
                    </li>
                </ul>
                <div class="contact-grids" id="div2">
                    <div class="col-md-6 contact-grid wow fadeInLeft animated animated" data-wow-delay="0.4s">
                            <div class="row1">
                                <label>代码：</label>
                                <textarea placeholder="请输入你的代码" id="code"></textarea>
                            </div>
                            <button class="btn btn-success" id="subCode">确定</button>
                    </div>
                    <div class="col-md-6 contact-grid  wow fadeInRight animated animated" data-wow-delay="0.4s">
                        <div class="row1">
                            <label>运行结果：</label>
                            <textarea id="result" disabled="true"></textarea>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div id="div1" style="float: right">
                    <button class="btn btn-success" style="margin-right: 1ex">搜索错误信息</button>
                    <button class="btn btn-success">分享到QQ</button>
                </div>
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
<script type="text/javascript">
	
	var preCode = "class Main { \n" + "\n\n\n\n\n" + "}"
    var lis=document.getElementsByTagName('li');
    for(var i=0;i<lis.length;i++)
    {
    	if (i == 2){
    		lis[i].onclick=function () {
                for(var j=0;j<lis.length;j++)
                {
                    lis[j].className='';
                }
                this.className='active';
               	document.getElementById('result').value='';
                document.getElementById('code').value=preCode;
            }
    	}else {
    		lis[i].onclick=function () {
                for(var j=0;j<lis.length;j++)
                {
                    lis[j].className='';
                }
                this.className='active';
               	document.getElementById('result').value='';
                document.getElementById('code').value='';
            }
    	}
        
    }
</script>
</html>