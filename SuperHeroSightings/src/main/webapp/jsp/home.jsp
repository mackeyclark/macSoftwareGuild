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
        <div class="container-fluid">
            <div class="navbar">
                <ul class="nav nav-justified">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home"><glyph class="glyphicon glyphicon-home"/> Home</a>
                    </li>
                    <li role="presentation" style=" color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/roguesgallery">Superhuman</a>
                    </li>
                    <li role="presentation" style=" color: #9acfea;">
                        <a href="${pageContext.request.contextPath}/powerlist">Superpower</a>
                    </li>
                    <li role="presentation" style="  color: #9acfea;">
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
                <div class="col-md-6 text-center" style=" margin-top: 7.5%;">
                    <p>
                        When people first started to manifest quirks the world was taken by storm as a flurry of heros, and unfortunately villains, suddenly appeared.
                        Our site's goal is to keep a ledger of where all our wonderful licensed heros have been.
                    </p>
                    <p>
                        <text style=" color: #c12e2a">Please DO NOT encourage unlawful vigilantism by recording sightings of amateurs!!</text>
                    </p>
                    <p>
                        We encourage you not to record villain sightings either, but in an effort to keep others safe we will not remove records tracking evil-doer's movements. 
                    </p>
                </div>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
