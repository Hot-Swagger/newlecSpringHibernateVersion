package com.notepubs.web.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteView;


@Repository
public class HbNoteDao implements NoteDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<NoteView> getList(Integer page) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session.createQuery("from NoteView", NoteView.class);
		List<NoteView> list = query.getResultList();
		
		return list;
	}

	@Override
	public NoteView get(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		
		NoteView note = session.get(NoteView.class, id);
		
		return note;
	}

	@Override
	public int insert(Note note) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoteView getPrev(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session.createQuery(
				"from NoteView " + 
				"where regDate < (select regDate from NoteView where id = :id) " + 
				"order by regDate desc"
				,NoteView.class)
				.setParameter("id", id)
				.setMaxResults(1);
		
		NoteView note = query.getSingleResult();
		
		return note;
	}

	@Override
	public NoteView getNext(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session.createQuery(
				"from NoteView " + 
				"where regDate > (select regDate from NoteView where id = :id) " + 
				"order by regDate asc"
				,NoteView.class)
				.setParameter("id", id)
				.setMaxResults(1);
		
		NoteView note = query.getSingleResult();
		
		return note;
	}
	
}
