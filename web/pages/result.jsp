<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Результат</title>
    <%@ include file="include_resources.jsp" %>
</head>
<body>
<div align="center">
    <h4>
        Результат: <c:out value="${resultDTO.output}"/>
    </h4>
    <a href="http://localhost:8080/CLangEducation/page/main">Повернутись</a>
</div>
</body>
</html>
