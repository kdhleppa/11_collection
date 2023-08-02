package edu.kh.collection.model.vo;

import java.text.NumberFormat;

public class Book {
	private int bookNum;
	private String bookName;
	private String author;
	private int won;
	private String hs;
	
	
	
	public Book(int bookNum, String bookName, String author, int won, String hs) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.author = author;
		this.won = won;
		this.hs = hs;
	}

	public Book(int bookNum) {
		super();
		this.bookNum = bookNum;
		
	}

	public int getBookNum() {
		return bookNum;
	}



	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}



	public Book() {
		// TODO Auto-generated constructor stub
	}



	public Book(String bookName, String author, int won, String hs) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.won = won;
		this.hs = hs;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getWon() {
		return won;
	}



	public void setWon(int won) {
		this.won = won;
	}



	public String getHs() {
		return hs;
	}



	public void setHs(String hs) {
		this.hs = hs;
	}



	@Override
	public String toString() {
		NumberFormat num = NumberFormat.getInstance();
		String num1 = num.format(won);
		return bookNum+"번" + bookName + "     " + author + "     " + won+"원" + "     " + hs;
	}
	
	

}
