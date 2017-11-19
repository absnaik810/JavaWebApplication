package com.cohs.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cohs.pojo.Bill;
import com.cohs.pojo.BillDetails;
import com.cohs.pojo.BillToBeGenerated;
import com.cohs.pojo.BookedService;
import com.cohs.pojo.Connect;
import com.cohs.pojo.Room;

public class BillDAO {
	public List<BillToBeGenerated> getBillToBeGenerated() throws SQLException
	{
		List<BillToBeGenerated> billList=new ArrayList<BillToBeGenerated>();
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
	ps=con.prepareStatement("select distinct customer_id,request_id from ROOM_BOOKING_2 where CHECKOUT_DATE=to_date(sysdate,'dd-mm-yy') minus select distinct customerid,requestid from BILL_2");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			BillToBeGenerated obj=new BillToBeGenerated(rs.getString("customer_id"),rs.getString("request_id"));
			billList.add(obj);
		}
		return billList;
	}
	public BillDetails getBillDetails(BillToBeGenerated obj) throws SQLException
	{
		ArrayList<Room> listRoom=new ArrayList<Room>();
		ArrayList<BookedService> listService=new ArrayList<BookedService>();
		String customerId=obj.getCustomerId();
		String requestId=obj.getRequestId();
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ps=con.prepareStatement("select a.room_number,b.ROOM_RENT,a.CHECKIN_DATE,a.CHECKOUT_DATE   from Room_booking_2 a,ROOM_2 b where a.room_number=b.room_number and a.Customer_id =? and a.request_id =?");
		ps.setString(1, customerId);
		ps.setString(2, requestId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Room room=new Room(rs.getInt("room_number"), rs.getInt("ROOM_RENT"),String.valueOf(rs.getDate(3)),String.valueOf(rs.getDate(4)));
			listRoom.add(room);
		}
		ps=con.prepareStatement("SELECT a.INSERVICEID ,b.SERVICENAME ,a.ROOMNUMBER ,b.SERVICEPRICE,a.BOOKINGDATE ,a.BOOKINGUPTO FROM INSERVICE_2 b , SERVICE_BOOKED_2 a where a.INSERVICEID =b.INSERVICEID  and a.Customerid =? and a.requestid =?");
		//rs.close();
		ps.setString(1, customerId);
		ps.setString(2, requestId);
		ResultSet rs1=ps.executeQuery();
		while(rs1.next())
		{
			String id=rs1.getString("INSERVICEID");
			String name=rs1.getString("SERVICENAME");
			int roomNumber=rs1.getInt("ROOMNUMBER");
			int price=rs1.getInt("SERVICEPRICE");
			String bookDate=String.valueOf(rs1.getDate("BOOKINGDATE"));
			String bookUpto=String.valueOf(rs1.getDate("BOOKINGUPTO"));
			listService.add(new BookedService(id,name,roomNumber, price, bookDate, bookUpto));
		}
		ps=con.prepareStatement("select PAYMENT_ID from ADVANCE_PAYMENT_2 where CUSTOMER_ID =? and REQUEST_ID =?");
		ps.setString(1, customerId);
		ps.setString(2, requestId);
		//rs.close();
		ResultSet rs2=ps.executeQuery();
		int advancePayment=0;
		while(rs2.next())
		{
			advancePayment=500;
		}
		BillDetails billDetails=new BillDetails(customerId, requestId, listRoom, listService, advancePayment, 0);
		return billDetails;
		
	}
	public Bill addBill(BillDetails bill,int offlineCharge) throws SQLException, ParseException
	{
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		String billId=bill.getCustomerId()+bill.getRequestId();
		int roomRent=0;
		int serviceCharge=0;
		
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d1=null;
		java.util.Date d2=null;
		//SimpleDateFormat dtformat=new SimpleDateFormat();
		for(int i=0;i<bill.getRoomList().size();i++)
		{
			String cindate=bill.getRoomList().get(i).getBookedDate();
			String coutdate=bill.getRoomList().get(i).getBookedUpto();
			int day=(int)getDiff(cindate, coutdate);
			/*System.out.println(cindate);
			System.out.println(coutdate);
			d1=dt.parse(cindate);
			d2=dt.parse(coutdate);
			System.out.println(d2.getTime());
			System.out.println(d1.getTime());
			long diff=Math.abs(d2.getTime()-d2.getTime());
			System.out.println(diff);
			long a=diff/(24 * 60 * 60 * 1000);
			System.out.println(a);*/
			roomRent=roomRent+(bill.getRoomList().get(i).getRoomRent()*day);
		}
		
		for(int i=0;i<bill.getService().size();i++)
		{
			serviceCharge=serviceCharge+bill.getService().get(i).getServiceCharge();
		}
		int totalAmount=serviceCharge+roomRent+offlineCharge-bill.getAdvancePayment();
		ps=con.prepareStatement("insert into bill_2 values(billsequence.nextval,?,?,?,?,?,SYSDATE)");
		//ps.setString(1, billId);
		ps.setString(1, bill.getCustomerId());
		ps.setString(2, bill.getRequestId());
		ps.setInt(3, roomRent);
		ps.setInt(4, serviceCharge);
		ps.setInt(5, totalAmount);
		
		Bill bill1=new Bill(1000, bill.getCustomerId(), bill.getRequestId(), roomRent, serviceCharge, totalAmount);
		ps.executeUpdate();
		return bill1;
	}
	public long getDiff(String cin,String cout)
	{
		String dateStart = cin;
		String dateStop = cout;
		long diffDays=0;
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 
		java.util.Date d1 = null;
		java.util.Date d2 = null;
 
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}
	public boolean updateBill(int billNo) throws SQLException
	{
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ps=con.prepareStatement("select CUSTOMERID ,REQUESTID,totalAmount  from BILL_2 where billid=?");
		ps.setInt(1, billNo);
		ResultSet rs=ps.executeQuery();
		String custId="";
		String reqId="";
		double totalAmount=0;
		while(rs.next())
		{
			custId=rs.getString("CUSTOMERID");
			reqId=rs.getString("REQUESTID");
			totalAmount=rs.getDouble("totalAmount");
		}
		ps=con.prepareStatement("select a.INSERVICEID,b.SERVICEPRICE from SERVICE_BOOKED_2 a,INSERVICE_2 b where a.CUSTOMERID =? and a.REQUESTID =? and a.INSERVICEID =b.INSERVICEID and a.STATUS ='offline'");
		rs=ps.executeQuery();
		if(rs.getRow()>0)
		{
			int servicePrice=0;
			while(rs.next())
			{
				servicePrice=rs.getInt("SERVICEPRICE");
			}
			totalAmount=totalAmount+servicePrice;
			ps=con.prepareStatement("update bill_2 set totalAmount=? where billid=?");
			ps.setDouble(1, totalAmount);
			ps.setInt(2, billNo);
			ps.executeUpdate();
		}
		
		return true;
	}
	/*public List<Bill> getAllBill()
	{
		Connect con1=new Connect();
		
	}*/
	public List<Bill> getAllBill() throws SQLException
	{
		List< Bill> billList=new ArrayList<Bill>();
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ps=con.prepareStatement("select BILLID,CUSTOMERID,REQUESTID,ROOMRENT,SERVICEPRICE,TOTALPRICE,BILLDATE from bill_2");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Bill obj=new Bill(rs.getInt("BILLID"),rs.getString("CUSTOMERID"), rs.getString("REQUESTID"), rs.getInt("ROOMRENT"), rs.getInt("SERVICEPRICE"), rs.getInt("TOTALPRICE"));
			billList.add(obj);
		}
		return billList;
	}
	public List<Bill> getAllBill(String customerId) throws SQLException
	{
		List< Bill> billList=new ArrayList<Bill>();
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ps=con.prepareStatement("select BILLID,CUSTOMERID,REQUESTID,ROOMRENT,SERVICEPRICE,TOTALPRICE,BILLDATE from bill_2 where CUSTOMERID=?");
		ps.setString(1, customerId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Bill obj=new Bill(rs.getInt("BILLID"),rs.getString("CUSTOMERID"), rs.getString("REQUESTID"), rs.getInt("ROOMRENT"), rs.getInt("SERVICEPRICE"), rs.getInt("TOTALPRICE"));
			billList.add(obj);
		}
		return billList;
	}
	public void deleteBill(int billNo) throws SQLException
	{
		Connect con1=new Connect();
		Connection con=con1.getCon();
		PreparedStatement ps=null;
		ps=con.prepareStatement("delete from bill_2 where billid=?");
		ps.setInt(1, billNo);
		ps.executeUpdate();
	}

}
