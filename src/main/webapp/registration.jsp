<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>


<%@page contentType="text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
       <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
       <title>Registration Page </title>
 </head>
 <body>

       <font size = '4' color = 'green'>
Please fill the registration form:
       </font><br>

       <form action = '/registration' method = 'post'>

     <table>
       <tr><td>Name: </td><td><input type='text' name='name' size='15'></td></tr>
       <tr><td>Last Name: </td><td><input type='text' name='familyName' size='15'></td></tr>
       <tr><td>Login: </td><td><input type='text' name='login' size='15'></td></tr>
       <tr><td>Password: </td><td><input type='password' name='password' size='15'></td></tr>
       <tr><td>Email: </td><td><input type='text' name='email' size='15'></td></tr>
       <tr><td>Address: </td><td><input type='text' name='address' size='15'></td></tr>
       <tr><td>Phone Number: </td><td><input type='text' name='phoneNumber' size='15'></td></tr>
     </table>

       <button type="submit" class="btn btn-success">Login</button>

         </form>

</body>
</html>