package com.notepubs.web.entity2.copy;

import java.io.Serializable;

import javax.persistence.Embeddable;

//Entity 안에 사용될 일부 키를 구현한 클래스라는걸 명시
@Embeddable
public class MemberRoleId implements Serializable {
	
	private String memberId;
	private String roleId;
	
	public MemberRoleId() {
		// TODO Auto-generated constructor stub
	}

	public MemberRoleId(String memberId, String roleId) {
		super();
		this.memberId = memberId;
		this.roleId = roleId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "MemberRoleId [memberId=" + memberId + ", roleId=" + roleId + "]";
	}
	
}
