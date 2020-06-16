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
@WebServlet(name = "AdminLogin", urlPatterns = {"/AdminLogin"})
public class AdminLoginServlet extends HttpServlet {

    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message1 = "";
        String message2 = "";
        String destination = "/librarymanagement/admin_login.jsp";
        String color = "red";
        HttpSession session = request.getSession();
        
        
        try
        {
        
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
        
            UseDB db = new UseDB();
            Admin admin = db.getAdmin(uname,password);
            
            if( admin!=null )
            {
                message1 = "Successfull Login " + admin.getFirstName() + " " + admin.getLastName();
                message2 = "Redirecting to ADMIN Home Page...";
                color = "green";
                session.setAttribute("admin",admin);

                destination = "/librarymanagement/AdminHomeBooks";
                
            }
            else
            {
                message1 = "Login Failed Username OR Password Invalid ";
                message2 = "Redirecting to ADMIN Login Page...";
                color = "red";
                destination = "/librarymanagement/admin_login.jsp";
            }
            
            response.setHeader("Refresh", "5; URL="+destination);
        
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminLogin</title>");            
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
            
        }
        catch(Exception e)
        {
            message1 = "Login Failed Server OR Database error ";
            message2 = "Redirecting to ADMIN Login Page";
            System.out.println("Admin Login Servlet " + e.getMessage());
            response.sendRedirect(destination);
        }
        
        
        
    }



}
