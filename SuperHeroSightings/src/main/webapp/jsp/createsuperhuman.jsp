<%-- 
    Document   : createSuperhuman
    Created on : Oct 26, 2018, 2:12:06 PM
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
        <div class="row">
            <div class="col-md-8">
                <form class="form-horizontal" role="form" method="POST" action="addSuperhuman">
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="Name of Hero"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="description" placeholder="Quick description of Hero"/>
                    </div>
                    <div class="form-group">                    
                        <a href="${pageContext.request.contextPath}/roguesgallery" class="btn btn-default">Cancel</a>
                        <input type="submit" class="btn btn-default" style=" float: right" value="Create Hero"/>
                    </div>
                </form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
