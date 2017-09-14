package com.secretd.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.secretd.web.dao.CounselingDao;
import com.secretd.web.dao.MyCounselingDao;
import com.secretd.web.dao.MyInfoDao;
import com.secretd.web.dao.MyLetterDao;
import com.secretd.web.entity.Answer;
import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;
import com.secretd.web.entity.Letter;
import com.secretd.web.entity.Member;

public class JdbcMyLetterDao implements MyLetterDao{

	@Override
	public List<Letter> getList(String memberId) {
		
		

		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "select number,date,title,chk from Letter where writer_id LIKE ?";
		   
		     int n=0;
		   List<Letter> list = null;
		   Letter L = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+memberId+"%");
		       
		         ResultSet rs2 = st2.executeQuery();

		         list = new ArrayList<>();
		  
		         
		         while (rs2.next()) {
		        
		        	L = new Letter(); 
		        	L.setNumber(rs2.getInt("number"));
		        	L.setDate(rs2.getDate("date"));
		        	L.setTitle(rs2.getString("title"));
		        	L.setChk(rs2.getString("chk"));
		        
		      
		            list.add(L);
		         }

		         rs2.close();
		         st2.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }

		return list;
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public Letter getQ(String memberId,int number) {
		


		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "select L.title, L.content q, A.content a from Letter L left outer join Answer A on L.number= A.letternumber where L.writer_id LIKE ? && L.number LIKE ?";
		   
		
		  
		  Letter L = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+memberId+"%");
		         st2.setString(2, "%"+number+"%");
		         ResultSet rs2 = st2.executeQuery();

		   
		        if (rs2.next()) {
		        
		        	L = new Letter();
		        	L.setTitle(rs2.getString("title"));
		        	L.setContent(rs2.getString("q"));
		        
		
		            
		         }

		         rs2.close();
		         st2.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }

		return L;
		
		
	}

	@Override
	public Answer getA(String memberId,int number) {
		


		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "select L.title, L.content q, A.content a from Letter L left outer join Answer A on L.number= A.letternumber where L.writer_id LIKE ? && L.number LIKE ?";
		   
		
		  
		 Answer a = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+memberId+"%");
		         st2.setString(2, "%"+number+"%");
		         ResultSet rs2 = st2.executeQuery();

		     
		  
		         
		        if (rs2.next()) {
		        
		        	a = new Answer();
		        a.setContent(rs2.getString("a"));
		            
		         }

		         rs2.close();
		         st2.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }

		return a;
		
		
	}

	@Override
	public int insert(String memberId,int number,String title, String content) {
		
		int result=0;
		
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql= "INSERT INTO `soonfacedb`.`Letter` (`number`, `title`, `content`, `writer_id`, `chk`) VALUES (?, ?, ?, ?, ?)";
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
	         // Statement st = conn.createStatement();
	         PreparedStatement st = conn.prepareStatement(sql);
	         st.setInt(1, number);
	         st.setString(2, title);
	         st.setString(3, content);
	         st.setString(4, memberId);
	         st.setString(5, "N");
	         result = st.executeUpdate();
	    

	         st.close();
	         conn.close();

	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

		return result;
	}

	@Override
	public int getnum() {
		
		int num=0;


		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "\r\n" + 
				"select IFNULL(MAX(CAST(number as unsigned)),0)+1 as n from Letter";
		 
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         
		         Statement st = conn.createStatement();
		       
		         ResultSet rs2 = st.executeQuery(sql2);
		         rs2.next();
		   
		         num=rs2.getInt("n");
		         
		         rs2.close();
		         st.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }

		return num;
		
		
		
		
		
	}

		
		
	
		
		
	}

	
		


	
	


