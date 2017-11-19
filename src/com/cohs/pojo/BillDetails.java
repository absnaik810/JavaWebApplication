package com.cohs.pojo;

import java.util.ArrayList;

public class BillDetails {
	private String customerId;
	private String requestId;
	private ArrayList<Room> roomList=new ArrayList<Room>();
	private ArrayList<BookedService> service=new ArrayList<BookedService>();
	private int advancePayment;
	private int totalValue;
	public BillDetails(String customerId, String requestId,
			ArrayList<Room> roomList, ArrayList<BookedService> service,
			int advancePayment, int totalValue) {
		super();
		this.customerId = customerId;
		this.requestId = requestId;
		this.roomList = roomList;
		this.service = service;
		this.advancePayment = advancePayment;
		this.totalValue = totalValue;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}
	public ArrayList<BookedService> getService() {
		return service;
	}
	public void setService(ArrayList<BookedService> service) {
		this.service = service;
	}
	public int getAdvancePayment() {
		return advancePayment;
	}
	public void setAdvancePayment(int advancePayment) {
		this.advancePayment = advancePayment;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
}
