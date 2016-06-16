<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Головна - Навчальна система - Мова Сі</title>
    <%@ include file="include_resources.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/highlight/styles/color-brewer.css">
    <script src="${pageContext.request.contextPath}/resources/highlight/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <style type="text/css">
        .scroll-container {
            height: 85vh;
            overflow-y: scroll;
        }
    </style>
</head>
<body>
<form name="logout" action="${pageContext.request.contextPath}/page/logout" method="post"></form>
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
                <li class="dropdown">
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<c:out
                            value="${user.getLogin()}"/><span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Профіль</a></li>
                        <li><a href="javascript:document.forms['logout'].submit()">Вихід</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--page data--%>
<div>
    <div class="col-lg-12">
    <h3><c:out value="${question.text}"/></h3>
    <form action="${pageContext.request.contextPath}/page/answer" method="post">
    <c:forEach  items="${question.answers}" var="answer" >
        <div class="radio">
            <label><input type="radio" name="answerId" value="<c:out value="${answer.answerId}" />">
                <c:out value="${answer.text}"/>
            </label>
        </div>
        </c:forEach>
        <button type="submit" class="btn btn-default">Надіслати</button>
    </form>
    </div>

</div>
</body>
</html>
