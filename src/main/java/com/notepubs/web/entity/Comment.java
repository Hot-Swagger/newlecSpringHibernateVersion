package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//	mysql에서 컬럼 자체에 설정되어있는 증가 옵션을 사용하겠다.
	private int id;
	private String content;
	private Date regDate;
	private String writerId;
	@Column(insertable=false, updatable=false)
	private int noteId;
	
	@ManyToOne(cascade= {CascadeType.DETACH
						, CascadeType.MERGE
						, CascadeType.PERSIST
						, CascadeType.REFRESH})
	@JoinColumn(name="noteId")
	private Note note;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String content, Date regDate, String writerId, int noteId) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.writerId = writerId;
		this.noteId = noteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", writerId=" + writerId
				+ ", noteId=" + noteId + ", getId()=" + getId() + ", getContent()=" + getContent() + ", getRegDate()="
				+ getRegDate() + ", getWriterId()=" + getWriterId() + ", getNoteId()=" + getNoteId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
