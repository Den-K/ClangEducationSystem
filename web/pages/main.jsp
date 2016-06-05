<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="dal.entities.PartEntity" %>
<%@ page import="org.hibernate.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<div class="col-lg-3">
    <div class="well well-lg">
        <ul class="nav">
            <c:forEach items="${parts}" var="part">
                <c:if test="${part.getParentId() == null}">

                    <c:if test="${part.getPartId() != 1}">

                            </ul>
                        </li>
                        <li class="nav-divider"></li>

                    </c:if>
                    <li>
                        <label class="tree-toggler nav-header">
                            <c:out value="${part.getName()}"/>
                        </label>
                        <ul class="nav tree active-trial" style="display: none;">
                </c:if>

                    <c:if test="${part.getParentId() != null}">
                        <li><c:out value="${part.getName()}"/></li>
                    </c:if>


        </c:forEach>
                </ul>
            </li>
        </ul>
    </div>
</div>

<script>
    $('label.tree-toggler').click(function () {
        $(this).parent().children('ul.tree').toggle(300);
    });
</script>

<div class="col-lg-9">
    <c:forEach items="${paragraphs}" var="paragraph">
        <p>
            <c:out value="${paragraph.getText()}"/>
        </p>
    </c:forEach>
</div>

</body>
</html>
