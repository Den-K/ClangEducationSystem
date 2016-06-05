<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="dal.entities.User.PartEntity" %>
<%@ page import="org.hibernate.*" %>
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

<%
    Configuration cfg = new Configuration();
    cfg.configure("sessionFactory.xml");// populates the data of the
    // configuration file

    // creating seession factory object
    SessionFactory factory = cfg.buildSessionFactory();



    // creating session object
    Session session2 = factory.openSession();

    // creating transaction object
    Transaction t = session2.beginTransaction();

    Criteria query = session2.createCriteria(PartEntity.class);
    java.util.List<PartEntity> list = query.list();
%>


<% for (PartEntity part: list) {
   out.println(part.getName());
} %>

<!--
<div class="col-lg-3">
    <div class="well well-lg">
    <ul class="nav">
        <li>
            <label class="tree-toggler nav-header">
                Розділ 1. Вступ
            </label>
            <ul class="nav  tree active-trial" style="display: none;">
                <li>Характеристика мови Сі</li>
                <li>Історія Сі</li>
                <li>Організація програми</li>

            </ul>
        </li>
        <li class="nav-divider"></li>
        <li>
            <label class="tree-toggler nav-header">
                Розділ 2. Дані
            </label>
            <ul class="nav  tree active-trial" style="display: none;">
                <li>Типи даних</li>
                <li>Опис даних цілого типу</li>
                <li>Беззнакові цілі</li>

            </ul>
        </li>
    </ul>
        </div>
</div>
-->
<script>
    $('label.tree-toggler').click(function () {
        $(this).parent().children('ul.tree').toggle(300);
    });
</script>

</body>
</html>
