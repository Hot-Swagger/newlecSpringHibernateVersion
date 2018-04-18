package com.notepubs.web.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.MemberRoleDao;
import com.notepubs.web.entity.MemberRole;

@Repository
public class HbMemberRoleDao implements MemberRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getDefaultRole(String memberId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		// 1.목록 가져오기 , 2. 레코드하나 가져오기(pk or 조건검사), 3.스칼라 가져오기
		/*HQL(where절 사용시 반드시 별칭을 사용해야함)*/
		String hql = "from MemberRole mr where mr.defaultRole=1";
		List<MemberRole> list = session.createQuery(hql).getResultList();
		
		
		String roleName = list.get(0).getRoleId();
		return roleName;
	}
	
}
