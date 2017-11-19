package com.cohs.pojo;

public class BookedService {
	private String serviceId;
	private String serviceName;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	private int roomNo;
	private int serviceCharge;
	private String bookedDate;
	private String bookedUpto;
	
	public BookedService(String serviceId, String serviceName, int roomNo,
			int serviceCharge, String bookedDate, String bookedUpto) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.roomNo = roomNo;
		this.serviceCharge = serviceCharge;
		this.bookedDate = bookedDate;
		this.bookedUpto = bookedUpto;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public String getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
	public String getBookedUpto() {
		return bookedUpto;
	}
	public void setBookedUpto(String bookedUpto) {
		this.bookedUpto = bookedUpto;
	}
}
