package practice2;

import java.io.Serializable;

public class Book implements Serializable{ // 책
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bNo;
	private int category;
	private String title;
	private String author;
	
	public Book() {}

	public Book(String bNo, int category, String title, String author) {
		this.bNo = bNo;
		this.category = category;
		this.title = title;
		this.author = author;
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	@Override
	public String toString() { // 정보 반환
		// TODO Auto-generated method stub
		return "[Book No. : "+ bNo + "|Category : " + category + "|Title : " + title + "|Author : "+ author +"]";
	}
	
}
