package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Disease;

public class DiseaseService {
	// �⺻ ����Ʈ �ҷ�����
	public List<Disease> getDiseaseList() {
		return getDiseaseList(1);
	}
	
	public List<Disease> getDiseaseList(int page) {
		List<Disease> list = null;
		return list;
	}
	
	// �˻� Ű���� �ش� ����Ʈ �ҷ�����
	public List<Disease> getDiseaseList(String name) {
		return getDiseaseList(1,name);
	}
	
	// ������ �ѱ�
	public List<Disease> getDiseaseList(int page, String name) {
		List<Disease> list = null;
		return list;
	}
}
