package com.notepubs.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class NoteView extends Note {
	
	@Column(insertable=false, updatable=false)
	private int commentCount;
	
	@Transient	//	db의 컬럼과 매핑할 데이터가 아니라는 명시
	private NoteView prev;
	
	@Transient	//	db의 컬럼과 매핑할 데이터가 아니라는 명시
	private NoteView next;
	
	public NoteView() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public NoteView getPrev() {
		return prev;
	}

	public void setPrev(NoteView prev) {
		this.prev = prev;
	}

	public NoteView getNext() {
		return next;
	}

	public void setNext(NoteView next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "NoteView [commentCount=" + commentCount + "]";
	}
	
}
