<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Упс...</title>
    <%@ include file="../include_resources.jsp" %>
</head>
<body>
<div align="center">
    <img src="${pageContext.request.contextPath}/resources/img/meme_not_found.png">
    <h1>
        <br/><br/><b style="font-size: 30pt">Compilation error!</b>
    </h1>
    <c:out value="${errorMessage.toString()}"/>
</div>
</body>
</html>