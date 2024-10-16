/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Rajat
 */
public class BookInsertServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;
        try (PrintWriter out = response.getWriter()) {
            Book b = null;
            try{
            	System.out.println("---------");
//            int bid = Integer.parseInt(request.getParameter("bid"));
            String bname = request.getParameter("bname");
            String sub = request.getParameter("sub");
            Double bprice = Double.parseDouble(request.getParameter("bprice"));
            b= new Book(1,bname,sub,bprice);
            System.out.println(b);
            }
            catch(Exception e){
                rd = request.getRequestDispatcher("inserterrormsg.html");
                rd.forward(request, response);
            }
            try{
            	System.out.println(33333333);
            if(BookDAO.insertBook(b)!=0){
                rd = request.getRequestDispatcher("insertmsg.html");
                rd.forward(request, response);
            }
            }
            catch(SQLException e){
            	System.out.println(e);
                rd = request.getRequestDispatcher("inserterrormsg.html");
                rd.forward(request, response);
            }
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

}
