<%-- 
    Document   : rougesgallery
    Created on : Oct 26, 2018, 1:00:55 PM
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
        <div class="container-fluid">
            <div class="navbar">
                <ul class="nav nav-justified">
                    <li role="presentation" style=" color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/home"><glyph class="glyphicon glyphicon-home"/> Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/roguesgallery">Superhuman</a>
                    </li>
                    <li role="presentation" style=" color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/manageSuperpowers">Superpower</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/manageLocations">Location</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/manageOrganizations">Organizations</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/manageSightings">Sightings</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h2>Our Rogues' Gallery <a href="${pageContext.request.contextPath}/createsuperhuman" class="btn btn-default" style=" vertical-align: middle; float: right">Add New Superhuman</a></h2>
                    <table id="superhumanTable" class="table table-striped">
                        <tr>
                            <th width="20%">Hero</th>
                            <th width="30%">Description</th>
                            <th width="20%">Power</th>
                            <th width="30%">Associates with</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>