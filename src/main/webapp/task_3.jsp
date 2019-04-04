<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Northwind Webapp</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto|Oswald" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>

<body class="otherbody">

<header>
    <a href="index.html"><h1>{ Northwind Webapp }</h1></a>
</header>

<div class="wrapper">
    <div class="container">
        <div class="containerhead">
            <h3>Query Results</h3>
        </div>
        <form action="task3" method="POST">
                    <p>Enter a company name: </p>
                    <input type="text" name="company">
                    <br>
                    <input type="submit" value="Filter results">
                </form>
         <table>
         <tr>
         <th>Company</th>
         </tr>
         <c:forEach var="item" items="${data}">
         <tr>
         <td>${item.getCompanyName()}</td>
         </tr>
         </c:forEach>
         </table>

        <div class="containerfoot"/>
    </div>
</div>
</body>
</html>
