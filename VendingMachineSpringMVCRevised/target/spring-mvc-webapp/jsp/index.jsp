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
                        <button type="button" class="btn btn-block" id="item" onclick="saveName('${currentItem.name}'), saveId('${currentItem.id}'), savePrice('${currentItem.price}'), saveInventory('${currentItem.inventory}')">
                            <c:out value="${currentItem.id}, ${currentItem.name}, ${currentItem.price}, ${currentItem.inventory}"/>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-4">
                <h2 class="text-center">Total $ in</h2>
                <form role="form" id="vend" method="POST" action="venditem">
                    <div class="form-group">
                        <input type="text" class="form-control" id="total-inserted-display" name="totalInserted" placeholder="$0.00" readonly/>
                        <div class="col-md-offset-3" id="add-money">
                            <div class="row">
                                <button type="button" class="btn btn-default" id="add-dollar" onclick="addMoney(0)">Add Dollar</button>
                                <button type="button" class="btn btn-default" id="add-quarter" onclick="addMoney(0)">Add Quarter</button>
                            </div>
                            <div class="row">
                                <button type="button" class="btn btn-default" id="add-dime" onclick="addMoney(0)">Add Dime</button>
                                <button type="button" class="btn btn-default" id="add-nickel" onclick="addMoney(0)">Add Nickel</button>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <h2 class="text-center">Messages</h2>
                    <div class="form-group">
                        
                        <input type="text" class="form-control" id="messages-display" readonly />
                        <label for="item-display" class="col-md-2 control-label">
                            <h4>Item:</h4>
                        </label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="itemName" name="itemName" readonly />
                        </div>
                        <input type="hidden" class="form-control" id="itemId" name="itemId" value=""/>
                        <input type="hidden" class="form-control" id="itemPrice" name="itemPrice" value=""/>
                        <input type="hidden" class="form-control" id="itemInventory" name="itemInventory" value=""/>
                        <button type="submit" class="btn btn-default" id="make-purchase">Make Purchase</button>
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

