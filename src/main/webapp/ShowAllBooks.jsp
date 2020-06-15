<%-- 
    Document   : issueBook
    Created on : 14-Jun-2020, 4:47:55 pm
    Author     : Administrator
--%>

<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="database.UseDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issue Book</title>
    </head>
    <body>
        <h1>Issue Book</h1>
  
    <table   
        <c:forEach var="book" items="${books}" >
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.category}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.description}</td>
            <td><c:choose>
                 <c:when test="${book.available eq ''}">Available</c:when>
                    <c:otherwise>${book.available}</c:otherwise>
                </c:choose> 
            </td>
            <td><image src = "${book.imagePath}"></td>
        </tr>
        </c:forEach>
    </table>
    
    
    
    <!--<a href=”<!--c:url value=’/inputComments.jsp’ />”>Click here</a>-->
        
        
    </body>
</html>
