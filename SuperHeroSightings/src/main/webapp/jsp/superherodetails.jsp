<%-- 
    Document   : superherodetails
    Created on : Oct 30, 2018, 10:31:30 AM
    Author     : macam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Rouge's Gallery</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container-fluid" style=" margin-top: 20px; margin-left: 2%;">
            <div class="row">
                <a href="${pageContext.request.contextPath}/roguesgallery" class="btn btn-default">Back</a>
            </div>
            <div class="row">
                <h2><c:out value="${superhuman.name}"/></h2>
                <p><c:out value="${superhuman.description}"/></p>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
