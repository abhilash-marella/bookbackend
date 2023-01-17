package com.UserServices.models;

import java.time.LocalDate;


public class Book {

	
	private int id ;
	private String title;
	private String author;
	private String category;
	private double price;
	private String publisher;
	private LocalDate publisheddate ;
	private boolean active;
	private String logo;
	
	
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Book()
	{
		
	}
	
	public Book(int id, String title, String author, String category, double price, String publisher,
			LocalDate publisheddate, boolean active,String logo) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publisheddate = publisheddate;
		this.active = active;
		this.logo= logo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", price="
				+ price + ", publisher=" + publisher + ", publisheddate=" + publisheddate + ", active=" + active
				+ ", logo=" + logo + "]";
	}
	
	
}
