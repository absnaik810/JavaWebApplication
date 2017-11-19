package com.cohs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cohs.dao.CustomerBookServiceDAO;
import com.cohs.pojo.HotelService;

/**
 * Servlet implementation class GetAllRoomBookingDetails
 */
public class GetAllRoomBookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllRoomBookingDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerBookServiceDAO dao=new CustomerBookServiceDAO();
		ArrayList<String> roomNo=dao.getAllRoom();
		request.setAttribute("roomNo", roomNo);
		ArrayList<HotelService> list=dao.getAllService();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("CustomerBookService.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
