<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/04/2018
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body bgcolor="#7fffd4">
Add Menu:<br>
<spring:form action="/addMenu" method="post" modelAttribute="menu" enctype="multipart/form-data">
    <spring:label path="name">Name:</spring:label>
    <spring:input path="name"/><br>
    <spring:label path="description">Description:</spring:label>
    <spring:textarea path="description"/><br>
    <spring:label path="price">Price:</spring:label>
    <spring:input path="price"/><br>
    <spring:select path="restaurants" items="${allRestaurants}" itemLabel="name"></spring:select><br>
    <label for="image">Image:</label>
    <input type="file" id="image" name="image"/><br>
    <input type="submit" value="ADD">
</spring:form>
<br>
Add Restaurants:<br>
<spring:form action="/addRestaurants" method="post" modelAttribute="restaurant" enctype="multipart/form-data">
    <spring:label path="name">Name</spring:label><br>
    <spring:input path="name"/><br>
    <spring:label path="address">Address</spring:label><br>
    <spring:input path="address"/>
    <spring:label path="description">Description</spring:label><br>
    <spring:textarea path="description"/><br>
    <spring:label path="availableSeats">AvailavleSeats</spring:label><br>
    <spring:input path="availableSeats"/>
    <label for="image">Image:</label>
    <input type="file" id="image" name="image"/><br>
    <input type="submit" value="ADD">

    
</spring:form>

</body>
</html>
