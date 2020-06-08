<%-- 
    Document   : index
    Created on : 2020-4-26, 13:58:36
    Author     : AAKK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ISD.Assignment.Model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoT.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Home Page</title>
    </head>
    <body onload="startTime()">
        <h1>Welcome to IoTBay</h1>
        <div>
            <p class="navi">
                <a class="button"  href ="shipmentNew.jsp">shipmentSearch</a>
                <a class="button"  href = "AllShipmentsServlet">Register </a>
                
            </p>
        </div>
        <jsp:include page = "/ConnServlet" flush = "true"/>
    </body>
</html>
