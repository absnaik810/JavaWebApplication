package com.cohs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cohs.pojo.Connect;
import com.cohs.pojo.HotelService;

public class CustomerBookServiceDAO {
	public ArrayList<String> getAllRoom()
	{
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ArrayList<String> roomNo=new ArrayList<String>();
		try {
			ps=con.prepareStatement("select room_number from Room_booking_2 where Customer_id=? and request_id=?");
			ps.setString(1, "1235");
			ps.setString(2, "req2");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				roomNo.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roomNo;
		
	}
	public ArrayList<HotelService> getAllService()
	{
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ArrayList<HotelService> list=new ArrayList<HotelService>();
		try {
			ps=con.prepareStatement("select * from INSERVICE_2");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				HotelService obj=new HotelService(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
