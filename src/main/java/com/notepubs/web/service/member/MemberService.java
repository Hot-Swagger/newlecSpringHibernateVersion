package com.notepubs.web.service.member;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.notepubs.web.dao.MemberDao;
import com.notepubs.web.dao.MemberRoleDao;
import com.notepubs.web.entity.Member;

@Service
@EnableTransactionManagement
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Transactional
	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		//memberRoleDao.insert(new MemberRole(?,"ROLE_AUTHOR");)
		
		return result;
		
	}

	@Transactional
	public String getDefaultRoleByMemberId(String memberId) {
		
		String defaultRole = memberRoleDao.getDefaultRole(memberId);
		
		return defaultRole;
	}

}
