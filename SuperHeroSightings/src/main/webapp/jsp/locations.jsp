<%-- 
    Document   : locations
    Created on : Oct 28, 2018, 11:52:06 AM
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
        <title>Location List</title>
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
                    <li role="presentation" style=" color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/roguesgallery">Superhuman</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/powerlist">Superpower</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/locations">Location</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/organizations">Organizations</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/sightings">Sightings</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h2>Locations <a href="${pageContext.request.contextPath}/createlocation" class="btn btn-default" style=" vertical-align: middle; float: right;">Create new location</a></h2>
                <table id="locationTable" class="table table-striped">
                    <tr>
                        <th width="10%">Name</th>
                        <th width="25%">Description</th>
                        <th width="25%">Address</th>
                        <th width="10%">Latitude</th>
                        <th width="10%">Longitude</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>
                </table>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>