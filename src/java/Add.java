/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(urlPatterns = {"/Add"})
public class Add extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
       processRequest(req,res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        processRequest(req,res);
    }
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)throws IOException
    {
        int i=Integer.parseInt(req.getParameter("n1"));
        int j= Integer.parseInt(req.getParameter("n2"));
        
        int c=i+j;
        
        PrintWriter out=res.getWriter();
        out.println(c);
    }
    
}
