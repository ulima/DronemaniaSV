<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Dronemania</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/dronemania.css">
    </head>
    <body>
        <div class="container">

            <form class="form-signin">
              <h2 class="form-signin-heading">Login de usuario</h2>
              <label for="inputUsuario" class="sr-only">Usuario</label>
              <input type="text" id="inputUsuario" class="form-control" placeholder="Ingrese usuario" required autofocus>
              <label for="inputPassword" class="sr-only">Password</label>
              <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
              <button id="butLogin" class="btn btn-lg btn-primary btn-block" type="button">Ingresar</button>
              <button id="butLoginFacebook" class="btn btn-lg btn-primary btn-block" type="button">Login Facebook</button>
              <button id="butLoginTwitter" class="btn btn-lg btn-primary btn-block" type="button">Login Twitter</button>
            </form>

        </div>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="js/login.js"></script>
    </body>
</html>
