package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Hospital;

public class HospitalService {
	// �⺻ ����Ʈ �ҷ�����
	public List<Hospital> getHospitalList() {
		return getHospitalList(1);
	}
	
	public List<Hospital> getHospitalList(int page) {
		List<Hospital> list = null;
		return list;
	}
	
	// �˻� Ű���� �ش� ����Ʈ �ҷ�����
	public List<Hospital> getHospitalList(String name) {
		return getHospitalList(1,name);
	}
	
	// ������ �ѱ�
	public List<Hospital> getHospitalList(int page, String name) {
		List<Hospital> list = null;
		return list;
	}
	
	// ���� ����
	public Hospital getHospitalDetail(int key) {
		Hospital hos = null;
		return hos;
	}
}
