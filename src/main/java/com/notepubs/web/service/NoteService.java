package com.notepubs.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteLike;


@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	@Transactional
	public List<Note> getNoteList(Integer page) {
		
		//noteDao = new MyBatisNoteDao();
		
		return noteDao.getList(page);
	}

	@Transactional
	public Note getNote(Integer id) {
		
		//noteDao = new MyBatisNoteDao()();
		
		return noteDao.get(id);
	}
	
	@Transactional
	public void setNoteLike(Integer noteId, String memberId) {

		NoteLike noteLike = noteLikeDao.get(noteId, memberId);
		
		if(noteLike == null)
			noteLikeDao.insert(new NoteLike(noteId, memberId));
		else
			noteLikeDao.delete(noteLike);
	}
	
}
