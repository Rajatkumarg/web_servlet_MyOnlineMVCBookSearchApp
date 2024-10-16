/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           RequestDispatcher rd;
           String req = request.getParameter("select");
            String sub = request.getParameter("subject");
            if(sub.isEmpty()){
                rd = request.getRequestDispatcher("showerror.html");
                rd.forward(request, response);
            }
            else{
                try{
                ArrayList<Book> b = BookDAO.getBooksBySubject(sub);
                if(b.isEmpty()){
                    rd = request.getRequestDispatcher("nobooks.jsp");
                    request.setAttribute("sub", sub);
                    rd.forward(request, response);
                }
                else{
                    rd = request.getRequestDispatcher("showbooks.jsp");
                    request.setAttribute("bookList",b);
                    request.setAttribute("sub", sub);
                    rd.forward(request, response);
                }
                }
                catch(SQLException e){
                    System.out.println("Error in DB");
                    e.printStackTrace();
                    rd = request.getRequestDispatcher("showdberror.html");
                    rd.forward(request, response);
                }
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
