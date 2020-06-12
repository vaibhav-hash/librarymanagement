<%-- 
    Document   : newjsp
    Created on : 12-Jun-2020, 9:24:48 pm
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Person p = UseDB.getUser();
        request.setAttribute("user", p); %>
        <% 
        
        <h1>Hello World!</h1>
    </body>
</html>
