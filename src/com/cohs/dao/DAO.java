package com.cohs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cohs.pojo.Connect;
import com.cohs.pojo.HotelService;

public class DAO {
	Connect con1=new Connect();
	Connection con=con1.getCon();
	PreparedStatement ps=null;
public boolean addService(HotelService service) throws SQLException
{
	ps=con.prepareStatement("insert into SERVICEDETAILS values(?,?,?,?)");
	ps.setString(1, service.getServiceId());
	ps.setString(2, service.getServiceName());
	ps.setInt(3, service.getServicePrice());
	ps.setInt(4, service.getServiceDuration());
	int res=ps.executeUpdate();
	if(res>=1)
		return true;
	else
		return false;
}
}
