package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {

 	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	Long id;
	
	@Column(name="title")
    String title;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_detail_id")
    private BookDetail bookDetail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	
	
}
