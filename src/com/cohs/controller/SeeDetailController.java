package com.cohs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cohs.dao.BillDAO;
import com.cohs.pojo.BillDetails;
import com.cohs.pojo.BillToBeGenerated;
import com.cohs.pojo.BookedService;
import com.cohs.pojo.Room;

/**
 * Servlet implementation class SeeDetailController
 */
public class SeeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeDetailController() {
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
		String value=request.getParameter("checkBoxGroup");
		String temp[]=value.split("-");
		BillToBeGenerated billFor=new BillToBeGenerated(temp[0], temp[1]);
		BillDAO dao=new BillDAO();
		BillDetails billToGenerate;
		try {
			billToGenerate = dao.getBillDetails(billFor);
			HttpSession session=request.getSession(true);
			session.setAttribute("bill", billToGenerate);
			response.sendRedirect("SeeBillDetails.jsp");
			/*PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<form action=\"GenerateBillController\" method=\"get\">");
			writer.println("<table border=\"1\">");
			writer.println("<tr>");
			writer.println("<td><label>Customer ID</label>");
			writer.println("</td>");
			writer.println("<td><label>"+billToGenerate.getCustomerId()+"</label>");
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td><label>Request ID</label>");
			writer.println("</td>");
			writer.println("<td><label>"+billToGenerate.getRequestId()+"</label>");
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td><label>Room Booked</label>");
			writer.println("</td>");
			writer.println("<td>");
			writer.println("<table border=\"1\">");
			writer.println("<th>Room No</th><th>Room Rent</th>");
			for(int i=0;i<billToGenerate.getRoomList().size();i++)
			{
				Room room=billToGenerate.getRoomList().get(i);
				writer.println("<tr>");
				
				writer.println("<td>"+room.getRoomNo());
				writer.println("</td>");
				
				writer.println("<td>"+room.getRoomRent());
				writer.println("</td>");
				writer.println("</tr>");
			}
			writer.println("</table>");
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Service Booked");
			writer.println("</td>");
			writer.println("<td>");
			writer.println("<table border=\"1\">");
			writer.println("<th>Service Id</th><th>Service Name</th><th>Room No</th><th>Service Charge</th><th>Booking Date</th><th>Booking Upto</th>");
			for(int i=0;i<billToGenerate.getService().size();i++)
			{
				BookedService service=billToGenerate.getService().get(i);
				writer.println("<tr>");
				
				writer.println("<td>"+service.getServiceId());
				writer.println("</td>");
				
				writer.println("<td>"+service.getServiceName());
				writer.println("</td>");
				
				writer.println("<td>"+service.getRoomNo());
				writer.println("</td>");
				
				
				writer.println("<td>"+service.getServiceCharge());
				writer.println("</td>");
				
				writer.println("<td>"+service.getBookedDate());
				writer.println("</td>");
				
				writer.println("<td>"+service.getBookedUpto());
				writer.println("</td>");
				writer.println("</tr>");
			}
			writer.println("</table>");
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Advance Payment");
			writer.println("</td>");
			writer.println("<td>"+billToGenerate.getAdvancePayment());
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td><label>Add any offline service charge</label>");
			writer.println("</td>");
			writer.println("<td><input type=\"text\" name=\"offlinecharge\"></input>");
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>");
			writer.println("<input type=\"submit\" value=\"Generate Bill\"></input></td>");
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

}
