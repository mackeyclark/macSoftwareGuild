<%-- 
    Document   : admin
    Created on : Oct 15, 2018, 9:58:40 PM
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
            <h2>Admin Page</h2>
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
                    <button class="btn btn-link" 
                            id="submit" 
                            type="submit">Logout</button>
                </form>
            </sec:authorize>
            <p>
                Only users with the ADMIN role can see this page.
            </p>
        </div>
        <div class="container">
            <div class="row">
                <h3>Add User</h3>
                <form class="form form-inline" 
                      method="POST" 
                      action="${pageContext.request.contextPath}/addUser">
                    <input type="hidden" 
                           name="${_csrf.parameterName}" 
                           value="${_csrf.token}"/>
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password">
                    <button type="submit">Add User</button>
                </form>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <h3>Update Password</h3>
                <c:if test="${error != null}">
                    <div class="alert alert-danger" role="alert">
                        <c:out value="${error}"/>
                    </div>
                </c:if>
                <form method="POST" 
                      action="${pageContext.request.contextPath}/editPassword">
                    <input type="hidden" 
                           name="${_csrf.parameterName}" 
                           value="${_csrf.token}"/>
                    <input type="hidden" name="id" value ="${user.id}"/>
                    <div class="form-group">
                        <label for="password" class="col-md-4 control-label">
                            New Password:
                        </label>
                        <div class="col-md-8">
                            <input type="password" 
                                   class="form-control" 
                                   id="password"
                                   name="password"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword" class="col-md-4 control-label">
                            Confirm New Password:
                        </label>
                        <div class="col-md-8">
                            <input type="password" 
                                   class="form-control" 
                                   id="confirmPassword"
                                   name="confirmPassword"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" 
                                   class="btn btn-default" 
                                   id="search-button" 
                                   value="Update Password"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="container">
            <div class ="row">
                <h3>Users</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Username</th>
                        <th>Roles</th>
                        <th>Enabled</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${users}" var="currentUser">
                        <tr>
                            <td><c:out value="${currentUser.username}"/></td>
                            <td>
                                <c:forEach items="${currentUser.roles}" var="currentRole">
                                    <c:out value="${currentRole.role}"/>&nbsp;
                                </c:forEach>
                            </td>
                            <td><c:out value="${currentUser.enabled}"/></td>
                            <td><a href="${pageContext.request.contextPath}/editUser?id=${currentUser.id}">Edit</a></td>
                            <td>
                                <form class="form-inline" 
                                      method="POST" 
                                      action="${pageContext.request.contextPath}/deleteUser">
                                    <input type="hidden" 
                                           name="${_csrf.parameterName}" 
                                           value="${_csrf.token}"/>
                                    <input type="hidden" 
                                           name="id" 
                                           value="${currentUser.id}"/>
                                    <button class="btn btn-link btn-xs" type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>