<%-- 
    Document   : createpower
    Created on : Oct 27, 2018, 5:44:04 PM
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
        <title>Create a New Power Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="col-md-2">

        </div>
        <div class="col-md-8" style=" margin-top: 10%;">
            <form class="form-horizontal" role="form" method="POST" action="addpower">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Power name"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Quick description of power"/>
                </div>
                <div class="form-group">                    
                    <a href="${pageContext.request.contextPath}/powerlist" class="btn btn-default">Cancel</a>
                    <input type="submit" class="btn btn-default" style=" float: right;" value="Create Power"/>
                </div>
            </form>
        </div>
    </body>
</html>
