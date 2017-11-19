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
import com.cohs.pojo.Bill;

/**
 * Servlet implementation class ViewAllBill
 */
public class ViewAllBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BillDAO dao=new BillDAO();
		List<Bill> list;
		try {
			list = dao.getAllBill();
			request.setAttribute("all", list);
			RequestDispatcher rd=request.getRequestDispatcher("ClerkViewBill.jsp");
			rd.forward(request, response);
			PrintWriter writer=response.getWriter();
			/*writer.println("<html>");
			writer.println("<body>");
			writer.println("<form method=\"get\" action=\"DeleteBillController\">");
			writer.println("<table border=\"1\">");
			writer.println("<th>Bill ID");
			writer.println("</th>");
			writer.println("<th>Customer ID");
			writer.println("</th>");
			writer.println("<th>Request ID");
			writer.println("</th>");
			writer.println("<th>Room Rent");
			writer.println("</th>");
			writer.println("<th>Service Charge");
			writer.println("</th>");
			writer.println("<th>Total Price");
			writer.println("</th>");
			for(int i=0;i<list.size();i++)
			{
				Bill obj=list.get(i);
				writer.println("<tr>");
				writer.println("<td>"+obj.getBillId());
				writer.println("</td>");
				writer.println("<td>"+obj.getCustomerId());
				writer.println("</td>");
				writer.println("<td>"+obj.getRequestId());
				writer.println("</td>");
				writer.println("<td>"+obj.getRoomRent());
				writer.println("</td>");
				writer.println("<td>"+obj.getServicePrice());
				writer.println("</td>");
				writer.println("<td>"+obj.getTotalPrice());
				writer.println("</td>");
				writer.println("<td><input type=\"checkbox\" name=\"checkboxgroup\" value=\""+obj.getBillId()+"\"></input>");
				writer.println("</td>");
				writer.println("</tr>");
			}
			writer.println("<tr>");
			writer.println("<td><input type=\"submit\" value=\"Delete\"></input>");
			writer.println("</td>");
			writer.println("</tr>");
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
