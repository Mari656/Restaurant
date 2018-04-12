<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariam
  Date: 12/04/2018
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Restaurants</h2>
<c:forEach items="${allRestaurants}" var="restaurants">
    <c:forEach items="${allMenus}"var="menu"></c:forEach>
    <h4 class="panel-title"><a href="#">${restaurants.name}</a></h4></c:forEach>

    <img src="/menu/image?fileName=${menu.picUrl}" alt=""/>
    <h2>$${menu.price}</h2>
    <p>${menu.name}</p>

</body>
</html>
