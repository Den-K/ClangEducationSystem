<!DOCTYPE html>
<html>
<head>
    <title>Головна - Навчальна система - Мова Сі</title>
    <%@ include file="include_resources.jsp" %>
</head>
<body>
<%--Navigation bar--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;Навчальна система - Мова Сі
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<%=request.getParameter("login")%>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="col-lg-2">
    <div class="bs-component">
        <div class="list-group">
            <span class="list-group-item active"><b>Розділи</b></span>
            <a href="#" class="list-group-item">Розділ 1. Вступ</a>
            <a href="#" class="list-group-item">Розділ 2. Дані</a>
        </div>
    </div>
</div>

</body>
</html>
