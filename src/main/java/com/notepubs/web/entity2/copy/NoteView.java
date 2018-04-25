package com.notepubs.web.entity2.copy;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class NoteView extends Note{
	
	private int commentCount;
	
	public NoteView() {
		// TODO Auto-generated constructor stub
	}
	
	public NoteView(int id, String title, String content, Date regDate, int hit, boolean pub, int commentCount) {
		super(id, title, content, regDate, hit, pub);
		
		this.commentCount = commentCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "NoteView [note=" + super.toString() + "commentCount=" + commentCount + "]";
	}
	
}
