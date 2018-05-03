package com.notepubs.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.entity.NoteView;

@Service
public class HomeService {
	
	@Autowired
	private NoteDao noteDao;
	
	@Transactional
	public List<NoteView> getNoteList(Integer page) {
		
		//noteDao = new MyBatisNoteDao();
		
		return noteDao.getList(page);
	}
}
