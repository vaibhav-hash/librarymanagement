<%-- 
    Document   : newjsp
    Created on : 12-Jun-2020, 9:24:48 pm
    Author     : Administrator
--%>

<%@page import="database.UseDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
       <%@page import="java.io.PrintWriter"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page import="database.UseDB"%>
        <%@page import="java.util.ArrayList"%>
        <%@page import="beans.Book"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <table>    
        <form action="AfterIssueBook" method="POST">
        
            <c:forEach var="book" items="${booksAvailable}">
                <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.category}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.description}</td>
            <td><image src = "${book.imagePath}"></td>
            <td><input type="checkbox" name="books" value="${book.bookId}" /></td>
             </tr>    
            </c:forEach>
             <input type="submit" value="submit"/>
        </form>
    </table>
        
    </body>
</html>
