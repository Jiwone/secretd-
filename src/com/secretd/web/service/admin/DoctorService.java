package com.secretd.web.service.admin;

import java.util.List;

import com.secretd.web.entity.Doctor;

public class DoctorService {
	// �⺻ ����Ʈ �ҷ����� 
	public List<Doctor> getDoctorList() {
		return getDoctorList(1);
	}
	
	public List<Doctor> getDoctorList(int page) {
		List<Doctor> list = null;
		return list;
	}
	
	// �˻� Ű���� �ش� ����Ʈ �ҷ�����
	public List<Doctor> getDoctorList(String id) {
		return getDoctorList(1,id);
	}
	
	// ������ �ѱ�
	public List<Doctor> getDoctorList(int page, String id) {
		List<Doctor> list = null;
		return list;
	}
}
