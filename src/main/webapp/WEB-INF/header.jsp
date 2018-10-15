<%-- 
    Document   : headerEmp
    Created on : 11-10-2018, 00:48:58
    Author     : mwn
--%>

<%@page import="functionlayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <script src="Res/Js.js"></script>
        <link rel="stylesheet" href="Res/Style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% User u = (User) request.getSession().getAttribute("user"); %>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand">Lego House</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <%
                    if (u.getRole().equals("employee")) {
                %>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="Control?command=employee">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Control?command=order">Orders</a>
                    </li>
                </ul>
                <%
                    } else {
                %>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="Control?command=customer">Order house</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Control?command=customerorders">Orders</a>
                    </li>
                </ul>
                
                <%
                    }
                %>
                
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link">Logged in as <%=u.getFirstName()%> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Control?command=logout"><button type="button" class="btn btn-info">Logout</button></a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>
