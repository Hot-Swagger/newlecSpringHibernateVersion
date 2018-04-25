package com.notepubs.web.entity2.copy;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BookDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//	mysql에서 컬럼 자체에 설정되어있는 증가 옵션을 사용하겠다.
	private int id;
	private int pageCount;
	private int width;
	private int height;
	private String publisher;
	private Date pubDate;
	private int bookId;
	
	public BookDetail() {
		// TODO Auto-generated constructor stub
	}

	public BookDetail(int pageCount, int width, int height, String publisher, Date pubDate) {
		super();
		this.pageCount = pageCount;
		this.width = width;
		this.height = height;
		this.publisher = publisher;
		this.pubDate = pubDate;
	}

	public BookDetail(int id, int pageCount, int width, int height, String publisher, Date pubDate) {
		super();
		this.id = id;
		this.pageCount = pageCount;
		this.width = width;
		this.height = height;
		this.publisher = publisher;
		this.pubDate = pubDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "BookDetail [id=" + id + ", pageCount=" + pageCount + ", width=" + width + ", height=" + height
				+ ", publisher=" + publisher + ", pubDate=" + pubDate + ", bookId=" + bookId + "]";
	}

}
