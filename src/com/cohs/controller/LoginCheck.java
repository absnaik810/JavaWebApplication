package com.cohs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cohs.pojo.Connect;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("select");
		Connection con=null;
		Connect con1=new Connect();
		
		con=con1.getCon();
		PreparedStatement ps=null;
		PrintWriter out=response.getWriter();
		try {
			ps=con.prepareStatement("select username,password,type from logindetails where username=? and password=? and type=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, type);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if(type.equals("Customer"))
				{
					out.println("Welcome customer");
				}
				else if(type.equals("Admin"))
				{
					out.println("Welcome admin");
				}
				else if(type.equals("Clerk"))
				{
					out.println("Welcome clerk");
				}
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
