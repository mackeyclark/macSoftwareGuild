<%-- 
    Document   : editpower
    Created on : Nov 1, 2018, 12:45:07 AM
    Author     : macam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Edit Power</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="col-md-2">

        </div>
        <div class="col-md-8" style=" margin-top: 10%;">
            <sf:form class="form-horizontal" role="form" modelAttribute="power" method="POST" action="editpower">
                <div class="form-group">
                    <sf:input type="text" path="name" class="form-control" name="name" placeholder="Power name"/>
                </div>
                <div class="form-group">
                    <sf:input type="text" path="description" class="form-control" name="description" placeholder="Quick description of power"/>
                    <sf:hidden path="powerId"/>
                </div>
                <div class="form-group">                    
                    <a href="${pageContext.request.contextPath}/powerlist" class="btn btn-default">Cancel</a>
                    <input type="submit" class="btn btn-default" style=" float: right;" value="Update Power"/>
                </div>
            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
