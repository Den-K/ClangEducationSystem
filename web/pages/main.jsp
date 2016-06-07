<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Головна - Навчальна система - Мова Сі</title>
    <%@ include file="include_resources.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/highlight/styles/color-brewer.css">
    <script src="${pageContext.request.contextPath}/resources/highlight/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
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
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<c:out value="${login}"/>
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
                <c:if test="${part.getPartId() != 1}">
                    <li class="nav-divider"></li>
                </c:if>
                <li>
                    <label class="tree-toggler nav-header">
                        <a href="#"><c:out value="${part.getName()}"/></a>
                    </label>
                    <ul class="nav tree active-trial" style="display: none;">
                        <c:forEach items="${part.getChildrenParts()}" var="childPart">
                            <li><a href="#"><c:out value="${childPart.getName()}"/></a></li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
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
    <pre>
        <code class="c++">
#include &#60;stdio.h&#62;
#include ”file1.c’’
#include ”file2.c’’
float res;
main()
{
     int a,b;
     float mida(), midg();
     printf(”введіть 2 цілих числа \n’’);
     scanf((”%d,%d’’, &a,&b);
     if (a*b>0)
     {
       midg(a,b);
       printf(”\n середнє геометричне дорівнює %5.4f’’, res);
     }
     else
     {
       mida(a,b);
       printf(”\n середнє арифметичне дорівнює %5.4f’’, res);
     }
де в файлі file1.c міститься   функція
 float mida(x,y);
  int x,y;
   {
     extern float res;
     res=(x+y)/2;
     return(res)
   }
а в файлі file2.c міститься  функція
 float midg(x,y);
  int x,y;
   {
     extern float res;
     res=sqrt(x*y);
     return(res)
   }
        </code>
    </pre>
</div>

</body>
</html>
