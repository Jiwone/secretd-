package com.secretd.web.dao;

import java.util.List;

import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;
import com.secretd.web.entity.Member;

public interface MyInfoDao {

	Member get(String memberId);

	int update(String id, String email, String nickname);



}
