<%-- 
    Document   : orderdetail
    Created on : 11-10-2018, 22:13:30
    Author     : mwn
--%>

<%@page import="functionlayer.Wall"%>
<%@page import="functionlayer.House"%>
<%@page import="functionlayer.Order"%>
<%@page import="functionlayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lego House</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <h3>Order Details</h3>
        <% Order order = (Order) request.getAttribute("order");
           Wall a = order.getHouse().getWalls().get(0);
           Wall b = order.getHouse().getWalls().get(1);
           Wall c = order.getHouse().getWalls().get(2);
           Wall d = order.getHouse().getWalls().get(3);
        %>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Type</th>
                    <th scope="col"><%= a.getWallName() %></th>
                    <th scope="col"><%= b.getWallName() %></th>
                    <th scope="col"><%= c.getWallName() %></th>
                    <th scope="col"><%= d.getWallName() %></th>
                    <th scope="col">Total with heigth</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">4x2</th>
                    <td><%= a.getLargeBricks() %></td>
                    <td><%= b.getLargeBricks() %></td>
                    <td><%= c.getLargeBricks() %></td>
                    <td><%= d.getLargeBricks() %></td>
                    <td><%= a.getLargeBricks() + b.getLargeBricks() + c.getLargeBricks() + d.getLargeBricks() %></td>
                </tr>
                <tr>
                    <th scope="row">2x2</th>
                    <td><%= a.getMediumBricks() %></td>
                    <td><%= b.getMediumBricks() %></td>
                    <td><%= c.getMediumBricks() %></td>
                    <td><%= d.getMediumBricks() %></td>
                    <td><%= a.getMediumBricks() + b.getMediumBricks() + c.getMediumBricks() + d.getMediumBricks() %></td>
                </tr>
                <tr>
                    <th scope="row">1x2</th>
                    <td><%= a.getSmallBricks() %></td>
                    <td><%= b.getSmallBricks() %></td>
                    <td><%= c.getSmallBricks() %></td>
                    <td><%= d.getSmallBricks() %></td>
                    <td><%= a.getSmallBricks() + b.getSmallBricks() + c.getSmallBricks() + d.getSmallBricks() %></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
