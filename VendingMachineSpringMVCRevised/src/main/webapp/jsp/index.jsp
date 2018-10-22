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
            <h1 class="center-block">Vending Machine</h1>
            <hr/>
            <div class="col-md-8">
                <div id="buttonDiv">
                    <c:forEach var="currentItem" items="${itemList}">
                        <button type="button" class="btn btn-block" id="item" onClick="itemSelect()">
                            <c:out value="${currentItem.name}"/>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-4">
                <h2 class="text-center">Total $ in</h2>
                <form role="form" id="money">
                    <div class="form-group">
                        <input type="text" class="form-control" id="total-inserted-display" placeholder="$0.00" readonly/>
                        <div class="col-md-offset-3" id="add-money">
                            <div class="row">
                                <button type="button" class="btn btn-default" id="add-dollar" value="1" onclick="addMoney()">Add Dollar</button>
                                <button type="button" class="btn btn-default" id="add-quarter" value="0.25">Add Quarter</button>
                            </div>
                            <div class="row">
                                <button type="button" class="btn btn-default" id="add-dime" value="0.1">Add Dime</button>
                                <button type="button" class="btn btn-default" id="add-nickel" value="0.05">Add Nickel</button>
                            </div>
                        </div>
                    </div>
                </form>
                <hr/>
                <h2 class="text-center">Messages</h2>
                <form role="form" id="messages">
                    <div class="form-group">
                        <input type="text" class="form-control" id="messages-display" readonly />
                        <label for="item-display" class="col-md-2 control-label">
                            <h4>Item:</h4>
                        </label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="item-display" readonly />
                        </div>
                        <form class="form-group" name="makePurchase" method="post" action="vendItem">
                            <input type="hidden" class="form-control" value="${}"
                            <button type="button" class="btn btn-default" id="make-purchase">Make Purchase</button>
                        </form>
                    </div>
                </form>
                <hr />
                <h2 class="text-center">Change</h2>
                <form role="form" id="change">
                    <div class="form-group">
                        <input type="text" class="form-control" id="change-display" readonly />
                        <button type="button" class="btn btn-default" id="cancel">Return Change</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/index.js"></script>

    </body>
</html>

