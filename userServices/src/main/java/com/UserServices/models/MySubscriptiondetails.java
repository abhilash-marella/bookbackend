package com.UserServices.models;

import java.time.LocalDate;

public class MySubscriptiondetails {
	private int bookId ;
	private String title;
	private String author;
	private String category;
	private double price;
	private String publisher;
	private LocalDate publisheddate ;
	private boolean active;
	private String logo;
	private int subscription_id;
	private LocalDate subscribedDate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDate getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(LocalDate publisheddate) {
		this.publisheddate = publisheddate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getSubscription_id() {
		return subscription_id;
	}
	public void setSubscription_id(int subscription_id) {
		this.subscription_id = subscription_id;
	}
	public LocalDate getSubscribedDate() {
		return subscribedDate;
	}
	public void setSubscribedDate(LocalDate subscribedDate) {
		this.subscribedDate = subscribedDate;
	}
	
	public MySubscriptiondetails(int bookId, String title, String author, String category, double price, String publisher,
			LocalDate publisheddate, boolean active, String logo, int subscription_id, LocalDate subscribedDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publisheddate = publisheddate;
		this.active = active;
		this.logo = logo;
		this.subscription_id = subscription_id;
		this.subscribedDate = subscribedDate;
	}
	@Override
	public String toString() {
		return "MySubscriptions [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category="
				+ category + ", price=" + price + ", publisher=" + publisher + ", publisheddate=" + publisheddate
				+ ", active=" + active + ", logo=" + logo + ", subscription_id=" + subscription_id + ", subscribedDate="
				+ subscribedDate + "]";
	}
	
}
