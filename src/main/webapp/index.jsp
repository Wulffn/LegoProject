<%-- 
    Document   : index
    Created on : 08-10-2018, 20:45:40
    Author     : mwn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="Res/Style.css">
        <script src="Res/Js.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Lego House Shop</h2>
        <br>
        <hr>
        <br>
        <div class="padding-top: 90px">
        <div class="body-login">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="panel panel-login">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a href="#" class="active" id="login-form-link">Login</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a href="#" id="register-form-link">Register</a>
                                    </div>
                                </div>
                                <hr>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <form id="login-form" action="Control" method="post" style="display: block;">
                                            <div class="form-group">
                                                <input type="text" name="email" id="username" tabindex="1" class="form-control" placeholder="Email" value="">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" value="">
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-sm-6 col-sm-offset-3">
                                                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Login">
                                                    </div>
                                                </div>
                                            </div>
                                            <input type="hidden" name="command" value="login">
                                        </form>
                                        <form id="register-form" action="Control" method="post" role="form" style="display: none;">
                                            <input type="hidden" name="command" value="register">
                                            <div class="form-group">
                                                <input type="text" name="firstName" id="username" tabindex="1" class="form-control" placeholder="Firstname" value="">
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="lastName" id="username" tabindex="1" class="form-control" placeholder="Lastname" value="">
                                            </div>
                                            <div class="form-group">
                                                <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="password1" id="password" tabindex="2" class="form-control" placeholder="Password" value="">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="password2" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" value="">
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-sm-6 col-sm-offset-3">
                                                        <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
            <div>
                <% String error = (String) request.getAttribute("error");
                    if (error != null) {
                        out.println("<H2>Error!!</h2>");
                        out.println(error);
                    }
                %>
            </div>
        </div>
    </body>
</html>
