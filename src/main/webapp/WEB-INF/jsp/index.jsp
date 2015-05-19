<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<h1>Productos:</h1>
<br/>
<ul>
    <c:forEach var="producto" items="${productos}">
        <li>${producto.id}-${producto.nombre}</li>
    </c:forEach>
</ul>
</body>
</html>