package com.cohs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cohs.dao.BillDAO;
import com.cohs.pojo.BillToBeGenerated;

/**
 * Servlet implementation class GetAllPendingBillController
 */
public class GetAllPendingBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllPendingBillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter writer=response.getWriter();
		BillDAO dao=new BillDAO();
		try {
			List<BillToBeGenerated> billList=dao.getBillToBeGenerated();
			request.setAttribute("custList", billList);
			RequestDispatcher rd=request.getRequestDispatcher("GenerateBillHome.jsp");
			rd.forward(request, response);
			/*writer.println("<html>");
			writer.println("<body>");
			writer.println("<form method=\"post\" action=\"SeeDetailController\">");
			writer.println("<table border=\"1\">");
			writer.println("<th>Customer Id</th><th>Request Id</th>");
			for(int i=0;i<billList.size();i++)
			{
				BillToBeGenerated obj=billList.get(i);
				writer.println("<tr>");
				writer.println("<td>");
				writer.println(obj.getCustomerId());
				writer.println("</td>");
				writer.println("<td>");
				writer.println(obj.getRequestId());
				writer.println("</td>");
				writer.println("<td>");
				String temp=obj.getCustomerId()+"-"+obj.getRequestId();
				writer.println("<input type=\"checkbox\" name=\"checkBoxGroup\" value=\""+temp+"\"></input>");
				writer.println("</td>");
				writer.println("</tr>");
			}
			writer.println("<tr><td><input type=\"submit\" value=\"See Details\"></input></td></tr>");
			writer.println("</table>");
			writer.println("</form>");
			writer.println("</body>");
			writer.println("</html>");*/
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
