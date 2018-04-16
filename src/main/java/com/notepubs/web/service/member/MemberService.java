package com.notepubs.web.service.member;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.notepubs.web.dao.MemberDao;
import com.notepubs.web.entity.Member;

@Service
@EnableTransactionManagement
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		
		return result;
		
	}

}
