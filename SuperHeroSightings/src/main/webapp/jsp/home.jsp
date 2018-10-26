<%-- 
    Document   : home
    Created on : Oct 25, 2018, 9:46:04 PM
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
        <title>Superhero Sightings Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="nav-tabs">
                <ul class="nav navbar-fixed-top">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home.jsp"><glyph class="glyphicon glyphicon-home"/>Home</a>
                    </li>
                    <li role="presentation" style=" background-color: #28a4c9;">
                        <a href="${pageContext.request.contextPath}/manageSuperhumans">Superhuman</a>
                    </li>
                    <li role="presentation" style=" background-color: #28a4c9;">
                        <a href="${pageContext.request.contextPath}/manageSuperpowers">Superpower</a>
                    </li>
                    <li role="presentation" style=" background-color: #28a4c9;">
                        <a href="${pageContext.request.contextPath}/manageLocations">Location</a>
                    </li>
                    <li role="presentation" style=" background-color: #28a4c9;">
                        <a href="${pageContext.request.contextPath}/manageOrganizations">Organizations</a>
                    </li>
                    <li role="presentation" style=" background-color: #28a4c9;">
                        <a href="${pageContext.request.contextPath}/manageSightings">Sightings</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h2>Latest Sightings</h2>
                    <table id="sightingsTable" class="table table-striped">
                        <tr>
                            <th width="34%">Superhuman</th>
                            <th width="33%">Where</th>
                            <th width="33%">When</th>
                        </tr>
                    </table>
                </div>
                <div class="col-md-6">
                    <p>
                        When people first started to manifest quirks the world was taken by storm as a flurry of heros, and unfortunately villains, suddenly appeared.
                        Our site's goal is to keep a ledger of where all our wonderful licensed heros have been  
                    </p>
                </div>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
