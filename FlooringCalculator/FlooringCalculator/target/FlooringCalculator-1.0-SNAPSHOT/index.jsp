<%-- 
    Document   : index
    Created on : Sep 25, 2018, 11:19:59 AM
    Author     : macam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    </head>
    <body>
        <h1>Flooring Calculator</h1>
        <p>
            Flooring experts can install 20 square ft of material at a rate of $86 per hour.
        </p>
        <form method="post" action="FlooringCalculatorServlet">
            <label for="lengthInput">
                Length:
            </label>
            <input type="text" name="lengthInput"/>
            <br/>
            <label for="widthInput">
                Width:
            </label>
            <input type="text" name="widthInput"/>
            <br/>
            <label for="materialCost">
                Material Cost (per square foot):
            </label>
            <input type="text" name="materialCost"/>
            <br/>
            <input type="submit" value="calculate price"/>
        </form>
    </body>
</html>
