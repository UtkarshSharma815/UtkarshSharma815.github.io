/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class TransferCredits extends HttpServlet 
{
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        
        
        PrintWriter p=res.getWriter();
       
        try 
        {
            String uname=req.getParameter("uname");
            int c=Integer.parseInt(req.getParameter("c"));
            String uname1=req.getParameter("uname1");
            int c1=Integer.parseInt(req.getParameter("c1"));
            if(c>c1)
            {
            
              int k=c-c1;                 
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creditmngtdb","root","");
            
              //create statement object
              String sql="update users set current_credit=current_credit+? where uname=?;";
              String sql1="update users set current_credit=? where uname=?";
              
              
              PreparedStatement s;
              s = con.prepareStatement(sql);
            
              s.setInt(1, c1);
              s.setString(2,uname1);
            
              //execute query
            
            
              int i=s.executeUpdate();
              
              s=con.prepareStatement(sql1);
              s.setInt(1,k);
              s.setString(2, uname);
              
              int j=s.executeUpdate();
              
            
              if(i==1 && j==1)
                 p.print("successful");
              else
                 p.print("retry");
              
            }
            else
            {
                p.println("u dont have enf credits");
            }
            
            
           
            
           
        } 
        catch(Exception e)
        {
            p.println(e);
        }
        
       
       
           
       }
       
    
}
