package com.UserServices.models;

import java.time.LocalDate;

public class Subscription {

	private int subscriptionId;
	private int userId;
	private LocalDate subsribedDate;
	private int bookid;
	private boolean active;
	private double netPrice;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getSubsribedDate() {
		return subsribedDate;
	}

	public void setSubsribedDate(LocalDate subsribedDate) {
		this.subsribedDate = subsribedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Subscription(int subscriptionId, int userId, LocalDate subsribedDate, int bookid, boolean active,
			double netPrice) {
		super();
		this.subscriptionId = subscriptionId;
		this.userId = userId;
		this.subsribedDate = subsribedDate;
		this.bookid = bookid;
		this.active = active;
		this.netPrice = netPrice;
	}

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

}
