<%-- 
    Document   : createsighting
    Created on : Oct 28, 2018, 3:57:02 PM
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
        <title>Create a New Sighting Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="col-md-2">

        </div>
        <div class="col-md-8" style=" margin-top: 10%;">
            <form class="form-horizontal" role="form" method="POST" action="addSighting">
                <div class="form-group">
                    <div class="col-md-6">
                        <select id="superhumanList" class="form-control" name="superhumanList" multiple="multiple">
                            <option disabled="true">Select Superhuman</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <select id="locationList" class="form-control" name="locationList" multiple="multiple" style=" float: right;">
                            <option disabled="true">Select Location</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <input type="date" class="form-control" name="date" placeholder="Date sighted"/>
                </div>
                <div class="form-group">                   
                    <a href="${pageContext.request.contextPath}/sightings" class="btn btn-default">Cancel</a>
                    <input type="submit" class="btn btn-default" style=" float: right;" value="Create sighting"/>
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
