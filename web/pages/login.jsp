<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container">
    <div class="row">
        <div class="center-block" style="width: 650px">
            <div class="well" style="margin-top: 60px">
                <form name="loginForm" class="form-horizontal" action="<c:url value='/j_spring_security_check'/>"
                      method="POST">
                    <fieldset>
                        <legend><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;<b>Вхід</b></legend>
                        <div class="form-group">
                            <label for="login" class="col-lg-3 control-label">Логін</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" name="login" id="login"
                                       placeholder="Логін"
                                       type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-lg-3 control-label">Пароль</label>
                            <div class="col-lg-8">
                                <input required="required" class="form-control" name="password" id="password"
                                       placeholder="Пароль"
                                       type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-3">
                                <input value="Стерти" name="reset" type="reset" class="btn btn-default"/>
                                <input value="Підтвердити" name="submit" type="submit" class="btn btn-primary"/>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <c:if test="${error.equals(\"true\")}">
                <div class="alert alert-dismissible alert-danger" align="center">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Не вірно введений логін чи пароль!</strong>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
