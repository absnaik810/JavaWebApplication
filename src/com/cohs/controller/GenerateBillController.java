package com.cohs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cohs.dao.BillDAO;
import com.cohs.pojo.Bill;
import com.cohs.pojo.BillDetails;

/**
 * Servlet implementation class GenerateBillController
 */
public class GenerateBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateBillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		BillDetails billDetails=(BillDetails)session.getAttribute("bill");
		BillDAO dao=new BillDAO();
		int offlinecharge=Integer.parseInt(request.getParameter("offlinecharge"));
		try {
			Bill bill=dao.addBill(billDetails,offlinecharge);
			session.setAttribute("billGenerated", bill);
			RequestDispatcher rd=request.getRequestDispatcher("BillGenerated.jsp");
			rd.forward(request, response);
			/*PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<div style=\"margin:auto\">");
			writer.println("<table>");
			writer.println("<tr>");
			writer.println("<td>Bill Id");
			writer.println("</td>");
			writer.println("<td>"+bill.getBillId());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Customer Id");
			writer.println("</td>");
			writer.println("<td>"+bill.getCustomerId());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Request Id");
			writer.println("</td>");
			writer.println("<td>"+bill.getRequestId());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Room Rent");
			writer.println("</td>");
			writer.println("<td>"+bill.getRoomRent());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Service Charge");
			writer.println("</td>");
			writer.println("<td>"+bill.getServicePrice());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Total Amount");
			writer.println("</td>");
			writer.println("<td>"+bill.getTotalPrice());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("</table>");
			writer.println("</div>");
			writer.println("</body>");
			wr-iter.println("</html>");*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
