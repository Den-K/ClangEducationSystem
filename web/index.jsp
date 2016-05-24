<!DOCTYPE html>
<html>
<head>
    <title>Навчальна система - Мова Сі</title>
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css"/>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<%--Navigation bar--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;Навчальна система - Мова Сі
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="${pageContext.request.contextPath}/page/login">
                        <span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Увійти
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/page/registration">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Зареєструватися
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <div align="center">
        <h2>Навчальна система по книзі</h2>
        <img src="resources/img/cbook.png"/>
        <br/>
        <b>Практикум з мови програмування Сі</b>
        <br/>
        Автори: Глибовець М.М., Глибовець А.М., Проценко В.С.
    </div>
</body>
</html>
