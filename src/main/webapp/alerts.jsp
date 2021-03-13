<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Подключаем библиотеку JSTL-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>servlet</title>
</head>
<body>
    <h1><strong>Alerts!</strong></h1>

<!-- JSTL tags -->
    <c:forEach items="${alerts}" var="element">
      <tr>
        <td>${element.getValue()}</td><br>
      </tr>
    </c:forEach><br>

    <a href="/registration" class="btn btn-primary" role="button">BACK</a>
</body>
</html>