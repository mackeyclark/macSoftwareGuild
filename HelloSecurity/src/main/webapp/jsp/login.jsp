<%-- 
    Document   : login
    Created on : Oct 15, 2018, 10:03:02 PM
    Author     : macam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Security: Login</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Hello Security</h1>
            <hr/>
            <h2>Login Page</h2>

            <c:if test="${param.login_error == 1}"><h3>Wrong id or password!</h3></c:if>
                <form class="form-horizontal" role="form" method="post" action="login">
                    <div class="form-group">
                        <label for="username" class="col-md-4 control-label">Username:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="username" name="username" placeholder="Username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-md-4 control-label">Password:</label>
                        <div class="col-md-8">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
                        </div>
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" id="search-button" value="Sign In"/>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
