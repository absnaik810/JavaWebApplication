package com.cohs.pojo;

public class Room {
	private int roomNo;
	private int roomRent;
	
	public Room(int roomNo, int roomRent, String bookedDate, String bookedUpto) {
		super();
		this.roomNo = roomNo;
		this.roomRent = roomRent;
		this.bookedDate = bookedDate;
		this.bookedUpto = bookedUpto;
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(int roomRent) {
		this.roomRent = roomRent;
	}
	private String bookedDate;
	private String bookedUpto;
	
}
