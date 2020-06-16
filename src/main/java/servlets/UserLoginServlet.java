/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import beans.*;
import database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ayush
 */
public class UserLoginServlet extends HttpServlet {

    String destination = "";
    String message1 = "";
    String message2 = "";
    String color = "red";
   
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        HttpSession session = request.getSession();
        
        try {
            
            String uname = request.getParameter("uname").toString();
            String password = request.getParameter("password").toString();
            UseDB db = new UseDB();
            User user = db.getUser(uname,password);
            
            if( user!=null )
            {
                session.setAttribute("user", user);
                message1 = "Login Successfull " + user.getFirstName() + " " + user.getLastName();
                message2 = "Redirecting To User Home Page...";
                destination = "/librarymanagement/UserHomeBooks";
                color = "green";
            }
            else
            {
                message1 = "Login Failed Invalid Username OR Password  ";
                message2 = "Redirecting to Login-User Page...";
                destination = "/librarymanagement/user_login.jsp";
                color = "red";
            }
            
            response.setHeader("Refresh", "5; URL="+destination);
        
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if( color=="red" )
            {
                out.println("<br><h1 style=\"color:red;\" >" + message1 + "</h1><br>");
                out.println("<h1 style=\"color:red;\" >" + message2 + "</h1>");
            }
            else
            {
                out.println("<br><h1 style=\"color:green;\"> " + message1 + "</h1><br>");
                out.println("<h1 style=\"color:green;\"> " + message2 + "</h1>");
            }
            out.println("</body>");            
            out.println("</html>");
            
            
        } catch (Exception ex) 
        {
            System.out.println("UserLoginServlet " + ex.getMessage());
            message1 = "Server OR Database Problems " + ex.getMessage();
            message2 = "Redirect to Login-User Page...";
            destination = "/librarymanagement/user_login.jsp";
            color = "red";
            response.sendRedirect("/librarymanagement/user_login.jsp");
        }    
        
        
                   
    
    }
    

}
