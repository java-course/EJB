<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Region Manager</title>
</head>
<body>


    <ul>
        <c:forEach items="${regions}" var="r">
            <li>${r.regionName}&nbsp;<a href="?action=remove&id=${r.regionId}">remove</a></li>
        </c:forEach>
    </ul>


    <h3>Create new region: container managed</h3>
    <form action="/databaseservlet/regions" method="post">
        Enter Region name:<input type="text" name="name">
        <input type="submit" name="submit">
    </form>

    <h3>Create new region: bean managed</h3>
    <form action="/databaseservlet/regions" method="post">
        Enter Region name:<input type="text" name="name">
        <input type="submit" name="submit2">
    </form>


</body>
</html>
