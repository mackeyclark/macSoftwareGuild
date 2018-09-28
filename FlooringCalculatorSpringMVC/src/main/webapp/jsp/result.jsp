<%-- 
    Document   : result
    Created on : Sep 26, 2018, 1:42:48 PM
    Author     : macam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            You asked to floor a space of ${area} feet squared.
        </p>
        <p>
            This would take ${totalHours} hours todo, and would cost $ ${total}.
        </p>
        <p>
            <a href="index.jsp">Price another floor</a>
        </p>
    </body>
</html>
