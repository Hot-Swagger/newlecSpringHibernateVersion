package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteLike;


@Repository
public class HbNoteLikeDao implements NoteLikeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
/*	@Override
	public Note get(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		
		Note note = session.get(Note.class, id);
		
		return note;
	}*/

	@Override
	@Transactional
	public NoteLike get(Integer noteId, String memberId) {
		Session session = sessionFactory.getCurrentSession();
		//NoteLike 클래스가 시리얼라이저블 인터페이스를 구현해야 애러 안남
		NoteLike noteLike = session.get(NoteLike.class,new NoteLike(noteId, memberId));
		
		return noteLike;
	}

	@Override
	@Transactional
	public int insert(NoteLike noteLike) {
		Session session = sessionFactory.getCurrentSession();
		session.save(noteLike);
		
		return 0;
	}

	@Override
	@Transactional
	public int delete(NoteLike noteLike) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(noteLike);
		
		return 0;		
	}
	
}
