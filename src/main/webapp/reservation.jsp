<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/04/2018
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
<h2>Book Table</h2>
<form action="/reservation" method="post">
    <spring:select path="restaurants" items="${allRestaurants}" itemLabel="name"></spring:select><br>
    <input type="datetime-local" field="${dateTime}"/>
    <spring:label path="numberPerson">Number Person</spring:label>
    <spring:textarea path="numberPerson"/><br>
    <spring:label path="email">Email</spring:label><br>
    <spring:input path="emai"/><br>
    <spring:label path="phoneNumber">Phone Number</spring:label>
    <spring:input path="phoneNumber"/><br>
    <button type="submit" class="btn btn-default">Reservation</button>
</form>

</body>
</html>
