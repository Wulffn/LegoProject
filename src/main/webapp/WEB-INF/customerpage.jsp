<%-- 
    Document   : Login
    Created on : 08-10-2018, 20:35:13
    Author     : mwn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lego House</title>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <div class="header">
            <h3>Order your Lego House</h3>
            <p>Enter length, width and height in the form below</p>
        </div>
        <div class="form">
            <form action="Control?command=orderconf" method="post">
                <div class="form-group">
                    <label>Length</label>
                    <input type="text" class="form-control" name="length" value="" placeholder="length">
                    <br>
                    <label>Width</label>
                    <input type="text" class="form-control" name="width" value="" placeholder="width">
                    <br>
                    <label>Height</label>
                    <input type="text" class="form-control" name="height" value="" placeholder="height">
                    <br>
                    <input type="submit" class="btn btn-info" value="Order">
                </div>
            </form>
        </div>
    </body>
</html>
