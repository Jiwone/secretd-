package com.secretd.web.dao;

import java.util.List;

import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;
import com.secretd.web.entity.Letter;
import com.secretd.web.entity.Member;
import com.secretd.web.entity.Answer;

public interface MyLetterDao {

	List<Letter> getList(String memberId);

	Letter getQ(String memberId,int number);

	Answer getA(String memberId,int number);

	int insert(String memberId,int number,String title, String content);

	int getnum();


	


}
