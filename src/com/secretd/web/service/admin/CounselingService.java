package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;

public class CounselingService {
	// �⺻ ����Ʈ �ҷ�����
	public List<Counseling> getCounselingList() {
		return getCounselingList(1);
	}
	
	public List<Counseling> getCounselingList(int page) {
		List<Counseling> list = null;
		return list;
	}
	
	// �ش� �� ��� ����Ʈ �ҷ�����
	public List<Comment> getCounselingCommentList(int num) {
		List<Comment> list = null;
		return list;
	}
}
