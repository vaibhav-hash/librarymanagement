
package servlets;
import beans.*;
import com.mysql.cj.Session;
import database.*;

import static java.awt.Color.green;
import validate.*;
import filters.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ayush
 */
@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class RegistrationServlet extends HttpServlet implements Filter {


    public  void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    if( request!=null )    
    {    
        String destination = "";
        HttpSession session = request.getSession();
        User user = new User();
        String uname = request.getParameter("uname").toString();
        String password = request.getParameter("password").toString();
        
        try
        {    
            String fname = request.getParameter("fname").toString();
            String lname = request.getParameter("lname").toString();            
            String email = request.getParameter("email").toString();
                       
            
            UseDB db = new UseDB();
            String result = db.isUserRepeated(uname,email);
            String message1 = " ";
            String message2 = " ";
            String color = "";
            
            if( result=="false" )
            {
                ArrayList<String> booksIssued = new ArrayList<String>();

//                User user = new User(uname,password,email,fname,lname, "image_folder/user_profile", booksIssued);
//                User user = new User();
                user.setUserName(uname);
                user.setPassword(password);
                user.setFirstName(fname);
                user.setLastName(lname);
                user.setEmail(email);
                user.setImagePath("image_folder/user_profile");
//                user.setBooksIssued(booksIssued);

                
                db.addUser(user);
                
                session.setAttribute("user", user);  
                
                message1 = "Congrats " + fname + " " + lname + 
                        " User Registration Successfull";
                message2 =  "Redirecting to Home Page...";
                color = "green";
                destination = "/librarymanagement/UserHomePage";
                
            }
            else if( result=="error" )
            {
                message1 = "Some error occured";
                message2 = "Redirecting to User Login-Register Page....";
                destination = "/librarymanagement/user_login.jsp";
            }
            else
            {
                message1 = result + " Already in Use - Try with another " + result; 
                message2 = "Redirecting to User Login-Register Page....";
                color = "red";
                destination = "/librarymanagement/user_login.jsp";
            }
            
            
            response.setHeader("Refresh", "5; URL="+destination);
            
            
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");  
            out.println("</head>");
            out.println("<body><br>");
            out.println("<h1>" +  message1 + "</h1><br>");
            out.println("<h1>" +  message2 + "</h1><br>");
            out.println("</body>");
            out.println("</html>");
            
        
//            response.setHeader("Refresh", "10; URL="+destination);

            if( result=="false")
            {
                System.out.println("Going to Home Page");
                
            }
            else
            {
                System.out.println("Going to LOgin Page");
                
            }
        }
        catch(Exception e)
        {
            System.out.println("Error at Registration Servlet " + e.getMessage());
            destination = "/librarymanagement/user_login.jsp";
        }
        
    }
    else
    {
        response.sendRedirect("/librarymanagement/user_login.jsp");
    }
        
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
