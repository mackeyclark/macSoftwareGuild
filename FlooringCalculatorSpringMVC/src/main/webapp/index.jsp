<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Flooring Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>
            <h2>Calculate your flooring price</h2>
            <p>
                Flooring specialists can install 20 square feet of your floors <br/>
                for a rate of $86 per hour. Please enter the dimensions of the <br/>
                space you wish to cover and the price per square foot of your <br/>
                desired material.
            </p>
            <form method="POST" action="calculateFloor">
                <label for="length">
                    Length:
                </label>
                <input type="text" name="length"/>
                <br/>
                <label for="width">
                    Width:
                </label>
                <input type="text" name="width"/>
                <br/>
                <label for="materialCost">
                    Material Cost (per square foot):
                </label>
                <input type="text" name="materialCost"/>
                <br/>
                <input type="submit" value="Calculate Price"/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

