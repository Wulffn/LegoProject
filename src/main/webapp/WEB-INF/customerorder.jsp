<%-- 
    Document   : customerorder
    Created on : 11-10-2018, 13:12:41
    Author     : mwn
--%>

<%@page import="java.util.Map"%>
<%@page import="functionlayer.Wall"%>
<%@page import="functionlayer.Brick"%>
<%@page import="functionlayer.House"%>
<%@page import="java.util.List"%>
<%@page import="functionlayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lego House</title>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <h3>Orders</h3>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Order number</th>
                    <th scope="col">Length</th>
                    <th scope="col">Width</th>
                    <th scope="col">Height</th>
                    <th scope="col">Status</th>
                    <th scope="col">Detailed</th>
                </tr>
            </thead>
            <%  List<Order> orders = (List) request.getAttribute("userorders");
                for (Order order : orders) {
                    if (order.getStatus().equals("Shipped")) {
            %>
            <tbody>
                <tr class="table-success">
                    <%= "<td>" + order.getOrderId() + "</td>"%>
                    <%= "<td>" + order.getLength() + "</td>"%>
                    <%= "<td>" + order.getWidth() + "</td>"%>
                    <%= "<td>" + order.getHeight() + "</td>"%>
                    <%= "<td>" + order.getStatus() + "</td>"%>
                    <td><a href="Control?command=orderdetail&orderid=<%=order.getOrderId()%>"><button type="button" class="btn btn-info">View Bricks</button></a></td>
                </tr>            
            </tbody>
            <%
            } else {
            %>
            <tbody>
                <tr class="table-warning">
                    <%= "<td>" + order.getOrderId() + "</td>"%>
                    <%= "<td>" + order.getLength() + "</td>"%>
                    <%= "<td>" + order.getWidth() + "</td>"%>
                    <%= "<td>" + order.getHeight() + "</td>"%>
                    <%= "<td>" + order.getStatus() + "</td>"%>
                    <td><a href="Control?command=orderdetail&orderid=<%=order.getOrderId()%>"><button type="button" class="btn btn-info">View Bricks</button></a></td>
                </tr>
            </tbody>
            <%      }
                }
            %>
        </table>
    </body>
</html>
