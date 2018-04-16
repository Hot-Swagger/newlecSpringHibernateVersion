package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.entity.Note;


@Repository
public class HbNoteDao implements NoteDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Note> getList(Integer page) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Note> query = session.createQuery("from Note");
		List<Note> list = query.getResultList();
		
		return list;
	}

	@Override
	public Note get(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		
		Note note = session.get(Note.class, id);
		
		return note;
	}

	@Override
	public int insert(Note note) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
