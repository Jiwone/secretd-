package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Member;

public class MemberService {
	// �⺻ ����Ʈ �ҷ����� 
	public List<Member> getMemberList() {
		return getMemberList(1);
	}
	
	public List<Member> getMemberList(int page) {
		List<Member> list = null;
		return list;
	}
	
	// �˻� Ű���� �ش� ����Ʈ �ҷ�����
	public List<Member> getMemberList(String id) {
		return getMemberList(1,id);
	}
	
	// ������ �ѱ�
	public List<Member> getMemberList(int page, String id) {
		List<Member> list = null;
		return list;
	}
}
