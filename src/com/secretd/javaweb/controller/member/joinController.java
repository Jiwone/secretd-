package com.secretd.javaweb.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secretd.javaweb.dao.MemberDao;
import com.secretd.javaweb.dao.jdbc.JdbcMemberDao;

@WebServlet("/member/join")
public class joinController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����Ʈ�� ���Ծ�");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = "";
		String pwd = "";
		String name = "";
		String email = "";
		String nickname = "";

		String _id = request.getParameter("id");
		String[] _pwds = request.getParameterValues("pwds");
		String _name = request.getParameter("name");
		String _email = request.getParameter("email");
		String _nickname = request.getParameter("nickname");
		System.out.println("id : " + _id);
		System.out.println("_pwds[0] : " + _pwds[0]);
		System.out.println("_pwds[1]: " + _pwds[1]);
		System.out.println("name : " + _name);
		System.out.println("email : " + _email);
		System.out.println("nickname : " + _nickname);

		if (_id != null && !_id.equals(""))
			id = _id;
		if (_name != null && !_name.equals(""))
			name = _name;
		if (_email != null && !_email.equals(""))
			email = _email;
		if (_nickname != null && !_nickname.equals(""))
			nickname = _nickname;

		// ��й�ȣ ��Ȯ��
		if (_pwds[0].equals(_pwds[1])&&!_pwds[0].equals("")) {
			pwd = _pwds[0];
			if (id.equals("") || pwd.equals("") || name.equals("") || email.equals("") || nickname.equals("")) {
				System.out.println("ȸ����������Է�����");
				out.println("<script language='javascript'>");
				out.println("alert('ȸ�������� ��� �Է����ּ���.'); history.go(-1);");
				out.println("</script>");
				out.flush();
				
			} else {
				System.out.println("MemberDao�� ���Ծ�~");
				// -------------------DB(dao)-----------------------------------
				MemberDao memberDao = new JdbcMemberDao();
				int result = memberDao.insert(id, pwd, name, email, nickname);
				if (result==1)
					response.sendRedirect("sucess");
				else
					response.sendRedirect("sucess?error=" + result);
			}
			
		}
		else if (!_pwds[0].equals(_pwds[1])) {
			System.out.println("��й�ȣ Ȯ������");		
			out.println("<script language='javascript'>");
			out.println("alert('��й�ȣ�� �ٽ� Ȯ�����ּ���~!'); history.go(-1);");
			out.println("</script>");
			out.flush();
		}

		

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get�� ���Ӿ�");
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

}