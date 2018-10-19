<%-- 
    Document   : result
    Created on : Sep 25, 2018, 11:20:46 AM
    Author     : macam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>result</title>
    </head>
    <body>
        <h1>Results</h1>
        <p>
            The area you wish to floor (${length} times ${width}) is ${area}
        </p>
        <p>
            Total cost =
            <c:out value="${total}"/>
        </p>
        <p>
            <a href="index.jsp">Calculate your flooring cost</a>
        </p>
    </body>
</html>
