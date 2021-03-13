<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>servlet</title>
</head>
<body>
    <h1><strong>Hello!</strong></h1>
    <form method = 'get'>
                   <%=session.getAttribute("client").toString()%><br>
/*cannot get any field from object in session even after cast to User*/
                   <%=request.getParameter("login")%><br>
                   <%=request.getParameter("password")%><br>
                   <%=request.getParameter("name")%><br>
                   <%=request.getParameter("familyName")%><br>
                   <%=request.getParameter("email")%><br>
                   <%=request.getParameter("address")%><br>
                   <%=request.getParameter("phoneNumber")%><br>
            </form>
    <a href="/login" class="btn btn-primary" role="button">LOG IN</a>
</body>
</html>