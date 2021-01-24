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
              <title>Login Page</title>
        </head>
        <body>
              <font size = '4' color = 'blue'>
       Security information:
              </font><br>
  <form action = 'login' method = 'post' class="form-inline">
     <div class="form-group">
      <label for="username">Login</label>
      <input type="text" class="form-control" id="username" name = "username" placeholder="admin">
    </div>
    <div class="form-group">
     <label for="password">Password</label>
     <input type="password" class="form-control" id="password" name = "password" placeholder="admin1">
    </div>

       <form action="/login">
          <button type="submit" class="btn btn-primary">Login</button>
       </form>
            <a href="/user_form" class="btn btn-primary" role="button">Registration</a>
   </form>
       </body>
       </html>