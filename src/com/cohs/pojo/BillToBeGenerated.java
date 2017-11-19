package com.cohs.pojo;

public class BillToBeGenerated {
	String customerId;
	String requestId;
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
	public BillToBeGenerated(String customerId, String requestId) {
		super();
		this.customerId = customerId;
		this.requestId = requestId;
	}
}
