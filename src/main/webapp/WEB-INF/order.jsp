<%-- 
    Document   : order
    Created on : 11-10-2018, 10:04:41
    Author     : mwn
--%>

<%@page import="functionlayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <h3>Orders</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Order number</th>
                    <th scope="col">Length</th>
                    <th scope="col">Width</th>
                    <th scope="col">Height</th>
                    <th scope="col">Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Order> orders = (List) request.getAttribute("orders");
                    for (Order order : orders) {

                        out.print("<tr><td>" + order.getOrderId() + "</td>" + "<td>" + order.getLength() + "</td>" + "<td>" + order.getWidth() + "</td>" + "<td>" + order.getHeight() + "</td>");
                        if (order.getStatus().equals("Waiting")) {               
                            %>  
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <%=order.getStatus()%>
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="Control?command=order&shippingstatus=Shipped&orderid=<%=order.getOrderId()%>">Shipped</a>
                                    </div>
                                </div>
                            </td>
                            <%
                        } else {
                            %>  
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <%=order.getStatus()%>
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="Control?command=order&shippingstatus=Waiting&orderid=<%=order.getOrderId()%>">Waiting</a>
                                    </div>
                                </div>
                            </td>
                            <%
                        }
                    }
            %>
        </tbody>
    </table>
</body>
</html>
