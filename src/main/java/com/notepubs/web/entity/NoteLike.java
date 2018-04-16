package com.notepubs.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NoteLike implements Serializable {
	@Id
	private Integer noteId;
	@Id
	private String memberId;
	private Date regDate;
	
	public NoteLike() {
		// TODO Auto-generated constructor stub
	}

	public NoteLike(Integer noteId, String memberId) {
		
		this.noteId = noteId;
		this.memberId = memberId;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
