<!DOCTYPE html>
<html>
<head>
    <title>Реєстрація</title>
    <%@ include file="include_resources.jsp" %>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="../">
                <span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;Навчальна система - Мова Сі
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="${pageContext.request.contextPath}/page/login">
                        <span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Увійти
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="center-block" style="width: 650px">
            <div class="well" style="margin-top: 60px">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/user/registration"
                      method="post">
                    <fieldset>
                        <div class="form-group">
                            <label for="login" class="col-lg-3 control-label">Логін</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" id="login" placeholder="Логін" type="text">
                            </div>
                        </div>
                        <legend><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<b>Реєстрація</b></legend>
                        <div class="form-group">
                            <label for="firstName" class="col-lg-3 control-label">Ім'я</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" id="firstName" placeholder="Ім'я" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-lg-3 control-label">Прізвище</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" id="lastName" placeholder="Прізвище" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-lg-3 control-label">Пароль</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" id="password" placeholder="Пароль" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-3">
                                <button type="reset" class="btn btn-default">Стерти</button>
                                <button type="submit" class="btn btn-primary">Підтвердити</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
