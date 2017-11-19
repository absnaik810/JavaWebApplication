package com.cohs.pojo;

public class Bill {
int billId;
String customerId;
String requestId;
int roomRent;
int servicePrice;
double totalPrice;
public int getBillId() {
	return billId;
}
public void setBillId(int billId) {
	this.billId = billId;
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
public int getRoomRent() {
	return roomRent;
}
public void setRoomRent(int roomRent) {
	this.roomRent = roomRent;
}
public int getServicePrice() {
	return servicePrice;
}
public void setServicePrice(int servicePrice) {
	this.servicePrice = servicePrice;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public Bill(int billId, String customerId, String requestId, int roomRent,
		int servicePrice, double totalPrice) {
	super();
	this.billId = billId;
	this.customerId = customerId;
	this.requestId = requestId;
	this.roomRent = roomRent;
	this.servicePrice = servicePrice;
	this.totalPrice = totalPrice;
}

}
