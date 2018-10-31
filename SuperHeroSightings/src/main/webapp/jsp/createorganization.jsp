<%-- 
    Document   : createorganization
    Created on : Oct 28, 2018, 2:55:12 PM
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
        <title>Create a New Hero Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="col-md-2">

        </div>
        <div class="col-md-8" style=" margin-top: 10%;">
            <form class="form-horizontal" role="form" method="POST" action="addorganization">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Quick description of the organization"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Address of organization"/>
                </div>
                <div class="form-group">
                    <input type="tel" class="form-control" name="phone" placeholder="555-555-5555"/>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="organization@host.org"/>
                </div>
                <div class="form-group">                   
                    <a href="${pageContext.request.contextPath}/organizations" class="btn btn-default">Cancel</a>
                    <input type="submit" class="btn btn-default" style=" float: right;" value="Create organization"/>
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
