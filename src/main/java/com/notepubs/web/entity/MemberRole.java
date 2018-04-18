package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MemberRole {
	
	@EmbeddedId
	private MemberRoleId memberRoleId;
	private String regAdmin;
	private Date regDate;
	private boolean defaultRole;
	
	public MemberRole() {
		// TODO Auto-generated constructor stub
	}

	public MemberRole(String memberId, String roleId, String regAdmin) {
		super();
		this.memberRoleId.setMemberId(memberId);
		this.memberRoleId.setRoleId(roleId);
		this.regAdmin = regAdmin;
	}
	
	public MemberRole(String memberId, String roleId, String regAdmin, Date regDate, boolean defaultRole) {
		super();
		this.memberRoleId.setMemberId(memberId);
		this.memberRoleId.setRoleId(roleId);
		this.regAdmin = regAdmin;
		this.regDate = regDate;
		this.defaultRole = defaultRole;
	}

	public String getMemberId() {
		return memberRoleId.getMemberId();
	}

	public void setMemberId(String memberId) {
		this.memberRoleId.setMemberId(memberId);
	}

	public String getRoleId() {
		return memberRoleId.getRoleId();
	}

	public void setRoleId(String roleId) {
		this.memberRoleId.setRoleId(roleId);
	}

	public String getRegAdmin() {
		return regAdmin;
	}

	public void setRegAdmin(String regAdmin) {
		this.regAdmin = regAdmin;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}
	
	public MemberRoleId getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(MemberRoleId memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	@Override
	public String toString() {
		return "MemberRole [memberId=" + memberRoleId.getMemberId() + ", roleId=" + memberRoleId.getRoleId() + ", regAdmin=" + regAdmin + ", regDate="
				+ regDate + ", defaultRole=" + defaultRole + "]";
	}
	
}
