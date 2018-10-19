<%-- 
    Document   : editUser
    Created on : Oct 16, 2018, 7:45:03 PM
    Author     : macam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Security: Admin</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Hello Security</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/content">
                            Content (must have the user role)
                        </a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/admin">
                            Admin (must have the admin role)
                        </a>
                    </li>
                </ul>    
            </div>
            <h2>Edit User Page</h2>
            <sec:authorize access="isAuthenticated()">
                <form class="form-inline" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/logout">
                    <input type="hidden" 
                           name="${_csrf.parameterName}" 
                           value="${_csrf.token}"/>
                    <label for="submit">
                        Hello : ${pageContext.request.userPrincipal.name}&nbsp;&nbsp;&nbsp;|
                    </label>
                    <button class="btn btn-link" id="submit" type="submit">Logout</button>
                </form>
            </sec:authorize>
            <p>
                Only users with the ADMIN role can see this page.
            </p>
        </div>
        <div class="container">
            <div class="row">
                <h3>Update User</h3>
                <form method="POST" action="${pageContext.request.contextPath}/editUser">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="hidden" name="id" value ="${user.id}"/>
                    <div class="form-group">
                        <label for="username" class="col-md-4 control-label">Username:</label>
                        <div class="col-md-8">
                            <input type="text" 
                                   class="form-control" 
                                   id="username"
                                   name="username" 
                                   placeholder="Username"
                                   value="${user.username}"
                                   disabled/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="enabled" class="col-md-4 control-label">Enabled:</label>
                        <div class="col-md-8">
                            <label>
                                <input type="checkbox"  
                                       id="enabled"
                                       name="enabled"
                                       checked="${user.enabled}"/>
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="roleIdList" class="col-md-4 control-label">Roles:</label>
                        <div class="col-md-8">
                            <select id="roleIdList" 
                                    name="roleIdList" 
                                    multiple="multiple" 
                                    class="form-control">
                                <c:forEach items="${roles}" var="currentRole">
                                    <option value="${currentRole.id}" 
                                            <c:if test="${user.roles.contains(currentRole)}">selected</c:if>>
                                        <c:out value="${currentRole.role}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" 
                                   class="btn btn-default" 
                                   id="search-button" 
                                   value="Update User"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>                    
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
