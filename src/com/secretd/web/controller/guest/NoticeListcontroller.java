package com.secretd.web.controller.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.NoticeDao;
import com.secretd.javaweb.dao.jdbc.JdbcNoticeDao;
import com.secretd.web.entity.NoticeView;



@WebServlet("/guest/notice/list")
public class NoticeListcontroller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1; //기본�?		
		String  _page = request.getParameter("p"); 	
		if(_page != null && !_page.equals(""))
			page=Integer.parseInt(_page);	
		String  _query = request.getParameter("title"); 
		String query = ""; // 기본�?
		if(_query != null && !_query.equals(""))
			query=_query;
		//------------------출력-----------------
		List<NoticeView> list= null; 
		int count=0;		
		//---------------DB(DAO)--------------------
		NoticeDao noticeDao = new JdbcNoticeDao();
		list = noticeDao.getList(page, query);
		count = noticeDao.getCount();		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/views/guest/notice/list.jsp").forward(request, response);
	}
}
  