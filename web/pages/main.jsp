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
<form name="logout" action="${pageContext.request.contextPath}/page/logout" method="post" ></form>
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
<%--menu--%>
<div class="col-lg-3">
    <div class="well well-lg">
        <ul class="nav">
            <c:forEach items="${parts}" var="part">
                <c:if test="${part.getPartId() != 1}">
                    <li class="nav-divider"></li>
                </c:if>
                <li>
                    <label class="tree-toggler nav-header">
                        <a href="#part<c:out value="${part.getPartId()}"/>" onclick="{
                                $('.part').hide();
                                $('#part<c:out value="${part.getPartId()}"/>').show();
                                }">
                            <c:out value="${part.getName()}"/>
                        </a>
                        &nbsp;
                        <a href="#"
                           onclick="$('#menuPart<c:out value="${part.getPartId()}"/>').toggle(300);">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </a>
                    </label>
                    <ul id="menuPart<c:out value="${part.getPartId()}"/>"
                        class="nav tree active-trial"
                        style="display: none;">

                        <c:forEach items="${part.getChildrenParts()}" var="childPart">
                            <li>
                                <a href="#part<c:out value="${childPart.getPartId()}"/>" onclick="{
                                        $('.part').hide();
                                        $('#part<c:out value="${part.getPartId()}"/>').show();
                                        }">
                                    <c:out value="${childPart.getName()}"/>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<%--page data--%>
<div class="scroll-container">
    <div class="col-lg-12">

        <c:forEach items="${parts}" var="part">
            <div id="part<c:out value="${part.getPartId()}"/>" class="part" style="display: none">
                <c:forEach items="${part.getChildrenParts()}" var="childPart">
                    <h4 id="part<c:out value="${childPart.getPartId()}"/>"><c:out value="${childPart.getName()}"/></h4>
                    <c:forEach items="${childPart.getChildrenParagraphs()}" var="paragraph">
                        <p>
                            <c:if test="${paragraph.getTextTypeId() == 1}">
                                <c:out value="${paragraph.getText()}"/>
                            </c:if>
                            <c:if test="${paragraph.getTextTypeId() == 2}">
                                <pre>
                                    <code class="c++">
<c:out value="${paragraph.getText()}"/>
                                    </code>
                                </pre>
                            </c:if>

                        </p>
                    </c:forEach>
                </c:forEach>
            </div>
        </c:forEach>

    </div>
</div>
</body>
</html>
