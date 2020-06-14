/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Book;
import beans.User;
import database.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Administrator
 */
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class AddBook extends HttpServlet {

    private static final String SAVE_DIR = "image_folder";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void init()
            throws ServletException {
        try {
            UseDB db = new UseDB();
        }
        catch(Exception e){
            System.out.println("Database connection exception");
        }
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        String savePath = "C:/Users/Administrator/Doc uments/NetBeansProjects/mavenproject2/"
//                + "librarymanagement/web" + File.separator + SAVE_DIR;
        
        String savePath = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\mavenproject2\\librarymanagement\\"
                + File.separator + SAVE_DIR;
        
        File fileSaveDir = new File(savePath);
        
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String category = request.getParameter("category");
        String author = request.getParameter("author");    
        String publisher = request.getParameter("publisher");
        String description = request.getParameter("description");
        
        Part part = request.getPart("file");
        
        String filename = extractFileName(part);
        
        part.write(savePath + File.separator + filename);
        
        
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
               String filePath = savePath + File.separator + filename;
               
               Book book = new Book(bookId, bookName, category, author, publisher, description, filePath, "");
               
               UseDB.addBook(book);
//            request.getParameter(string)
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String extractFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(",");
        for(String s: items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
