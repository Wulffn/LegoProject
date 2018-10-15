<%-- 
    Document   : employeePage
    Created on : 08-10-2018, 20:45:24
    Author     : mwn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Lego House - Employee Access</title>
        <%@ include file="header.jsp" %>
        <% 
        int ordersWaiting = (Integer) request.getAttribute("orderswaiting"); 
        %>
    </head>
    <body>
        <div class="header">
            <h3>Hello <%=u.getFirstName()%></h3>
            <p>You have <%= u.getRole() %> access</p>
            <p>The total number of orders that awaits shipment: <%=ordersWaiting%></p>
        </div>
    </body>
</html>
