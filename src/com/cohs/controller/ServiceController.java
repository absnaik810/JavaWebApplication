package com.cohs.controller;
import com.cohs.dao.DAO;
import com.cohs.pojo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceController
 */
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceController() {
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
		String sname=request.getParameter("sname");
		int sprice=Integer.parseInt(request.getParameter("sprice"));
		int sduration=Integer.parseInt(request.getParameter("sduration"));
		HotelService obj=new HotelService("102", sname, sprice);
		DAO daoobj=new DAO();
		PrintWriter out=response.getWriter();
		try {
			boolean res=daoobj.addService(obj);
			if(res==true)
				out.println("<html><body><script>alert('Successfully Added!!!')</script></body></html>");
			else
				out.println("Addition failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
