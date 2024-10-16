/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rajat
 */
public class BookDAO {
    private static Connection conn;
    private static PreparedStatement ps;
    static{
        try{
        	System.out.println("1111111111");
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("222222");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Rajat:1521/xe","jeebatch","jee");
            
        }
        catch(Exception e){
            System.out.println("Error in DAO");
            e.printStackTrace();
        }
    }
    public static ArrayList<Book> getBooksBySubject(String sub)throws SQLException{
        ps = conn.prepareStatement("select bname,bprice from allbooks where sub=?");
         ps.setString(1, sub);
         ResultSet rs = ps.executeQuery();
         ArrayList<Book> bookList = new ArrayList();
         while(rs.next()){
             String bname = rs.getString(1);
             double amt = rs.getDouble(2);
             Book obj = new Book();
             obj.setBookname(bname);
             obj.setBookprice(amt);
             bookList.add(obj);
         }
         return bookList;
    }
    public static int insertBook(Book b)throws SQLException{
        ps = conn.prepareStatement("insert into allbooks values(?,?,?)");
//        ps.setInt(1,b.getBid());
        ps.setString(1,b.getBookname());
        ps.setString(2, b.getSubject());
        ps.setDouble(3,b.getBookprice());
        return ps.executeUpdate();
    }
    public static int deleteBook(String b)throws SQLException{
        ps = conn.prepareStatement("delete from allbooks where bname=?");
        ps.setString(1,b);
        return ps.executeUpdate();
    }
}
