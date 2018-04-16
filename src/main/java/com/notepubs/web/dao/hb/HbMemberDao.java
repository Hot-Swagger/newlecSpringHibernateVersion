package com.notepubs.web.dao.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.MemberDao;
import com.notepubs.web.entity.Member;


@Repository
public class HbMemberDao implements MemberDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insert(Member member) {
		
		Session session = sessionFactory.getCurrentSession();
		//session.save(member);
		session.update(member);
		return 1;
	}
	
}
