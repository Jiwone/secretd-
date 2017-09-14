package com.secretd.web.dao;

import java.util.List;

import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;

public interface MyCounselingDao {

	List<Counseling> getList(String memberId);

	int delete(String num);

	List<Comment> getComment(String memberId);

	int deleteComment(String num);


	


}
