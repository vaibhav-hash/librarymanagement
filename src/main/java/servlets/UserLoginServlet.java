/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import beans.*;
import com.mysql.cj.Session;
import database.*;
import issuebooks.*;
import static java.awt.Color.green;
import validate.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin","/librarymanagemant/UserLogin","/librarymanagemant/UserLogin"})
public class UserLoginServlet extends HttpServlet {

    String destination = "";
    String message1 = "";
    String message2 = "";
    String color = "red";
   
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("uname").toString();
        String password = request.getParameter("password").toString();
        
        HttpSession session = request.getSession();
        
        try {
            UseDB db = new UseDB();
            User user = db.getUser(uname,password);
            
            if( user!=null )
            {
                session.setAttribute("user", user);
                message1 = "Login Successfull " + user.getFirstName() + " " + user.getLastName();
                message2 = "Redirecting To User Home Page...";
                destination = "/librarymanagement/UserHomePage";
                color = "green";
            }
            else
            {
                message1 = "Login Failed Invalid Username OR Password  ";
                message2 = "Redirect to Login-User Page...";
                destination = "/librarymanagement/user_login.jsp";
            }
            
        } catch (Exception ex) 
        {
            Logger.getLogger(UserLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            message1 = "Server OR Database Problems";
            message2 = "Redirect to Login-User Page...";
            destination = "/librarymanagement/user_login.jsp";
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
            out.println("<h1>" + message1 + "</h1>");
            out.println("</body>");
            out.println("</html>");
            out.println("<script>");
            out.println("h1{");
            out.println("color:"+color+";");
            out.println("}");
            out.println("</html>");
            out.println("</script>");
        
    
    }
    

}
