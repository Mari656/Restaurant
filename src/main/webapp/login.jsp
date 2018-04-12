<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/04/2018
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login to your account</h2>
<form action="<c:url value="/loginPage"/> " method="post" name="loginForm">
    <input type="text" placeholder="email" name="j_email"/>
    <input type="password" placeholder="password" name="j_password"/>
    <span>
								<input type="checkbox" class="checkbox">
								Keep me signed in
							</span>
    <button type="submit" class="btn btn-default">Login</button>
</form>

<h2>New User Signup!</h2>
<form action="/register" method="post">
    <spring:input path="name" placeholder="Name"/>
    <spring:input path="surname" placeholder="Surname"/>
    <spring:input path="age" placeholder = "Age"/>
     <spring:input path="email" placeholder="Email Address"/>
    <spring:input path="password" placeholder="Password"/>
    <spring:select path="userType" items="${userType}"/>
    <button type="submit" class="btn btn-default">Signup</button>
</form>


</body>
</html>
