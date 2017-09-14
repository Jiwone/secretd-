package com.secretd.web.controller.member.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.secretd.web.dao.CounselingDao;
import com.secretd.web.dao.MyCounselingDao;
import com.secretd.web.dao.MyInfoDao;
import com.secretd.web.dao.MyLetterDao;
import com.secretd.web.dao.jdbc.JdbcCounselingDao;
import com.secretd.web.dao.jdbc.JdbcMyCounselingDao;
import com.secretd.web.dao.jdbc.JdbcMyInfoDao;
import com.secretd.web.dao.jdbc.JdbcMyLetterDao;
import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;
import com.secretd.web.entity.Member;


@WebServlet("/member/myletter-reg")



public class MyLetterRegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session =request.getSession();
	   	
	   	Object _memberId = session.getAttribute("id");
		
	   	System.out.println(_memberId);
		if(_memberId==null) //1. 로그인 한 적이 없다면 일단 로그인 하러가쟈
	   		response.sendRedirect("login?returnURL=home"); 
	 	else { 	
	 		
	 		String memberId = _memberId.toString();
	 		MyLetterDao myletterdao = new JdbcMyLetterDao();
		
		request.setAttribute("num",myletterdao.getnum());
		request.setAttribute("id",memberId);
		
		request.getRequestDispatcher("/WEB-INF/views/member/mypage/myletterReg.jsp").forward(request, response); //이어서 출발
	   	}
	   	

	}
	

	

    protected void doPost(
	         HttpServletRequest request, 
	         HttpServletResponse response) throws ServletException, IOException {
    
    	
	/*	HttpSession session =request.getSession();
	   	Object _memberId = session.getAttribute("id");
	   	String memberId = _memberId.toString();*/
      	request.setCharacterEncoding("UTF-8");
    	int number=0;
    	String id=request.getParameter("id");
    	String num=request.getParameter("num");
    	
    	number= Integer.parseInt(num);
    	System.out.println(number);
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		
	   	
    	MyLetterDao myletterdao = new JdbcMyLetterDao();
    	int result = myletterdao.insert(id,number,title,content);
    	
    	 response.sendRedirect("myletter-list");
    	
  
    }
    

}
