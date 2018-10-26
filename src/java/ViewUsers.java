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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class ViewUsers extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        PrintWriter p=res.getWriter();
            
        res.setContentType("text/html");
        try 
        {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creditmngtdb","root","");
            
            //create statement object
            
            PreparedStatement s;
            s = con.prepareStatement("select * from users;");
            
            //execute query
            
            p.print("<meta charset='UTF-8'>");
            p.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            p.print("<table width=20px border=1>");
            
            p.print("<center><h1>Result</h1></center>");
            
            ResultSet rs=s.executeQuery();
            
            ResultSetMetaData rmd=rs.getMetaData();
            
            //move to each row
            p.print("<tr>");
            p.print("<td>uid</td>");
            p.print("<td>uname</td>");
            p.print("<td>email</td>");
            p.print("<td>current_credit</td>");
            
            while(rs.next())
            {
                p.print("<tr>");
                p.print("<td>"+rs.getInt("uid")+"</td>");
                p.print("<td>"+rs.getString("uname")+"</td>");
                p.print("<td>"+rs.getString("email")+"</td>");
                p.print("<td>"+rs.getInt("current_credit")+"</td>");
                p.print("</tr>");    
            }
            
            p.println("</tr>");
            p.println("</table>");
        } 
        catch(Exception e)
        {
            p.println(e);
        }
        
       
       
           
       }
       
       
    }

   

