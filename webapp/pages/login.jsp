<!DOCTYPE html>
<html>
<head>
    <title>Вхід до системи</title>
    <%@ include file="include_resources.jsp" %>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;Навчальна система - Мова Сі
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="${pageContext.request.contextPath}/page/registration">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Зареєструватися
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="position: fixed; margin-left: 28%">
    <div class="row">
        <div class="col-lg-6">
            <div class="well" style="margin-top: 50px">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/user/registration"
                      method="post">
                    <fieldset>
                        <legend><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;<b>Вхід</b></legend>
                        <div class="form-group">
                            <label for="email" class="col-lg-3 control-label">Пошта</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" id="email" placeholder="Пошта" type="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-lg-3 control-label">Пароль</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" id="password" placeholder="Пароль" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-8 col-lg-offset-6">
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
