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
import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;
import com.secretd.web.entity.Member;

public class JdbcMyInfoDao implements MyInfoDao{

	@Override
	public Member get(String memberId) {
		

		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "select * from Member where id LIKE ?";
		   
		
		  
		   Member m = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+memberId+"%");
		       
		         ResultSet rs2 = st2.executeQuery();

		     
		  
		         
		        if (rs2.next()) {
		        
		        	m = new Member();
		        	m.setId(rs2.getString("id")); 
		        	m.setName(rs2.getString("name"));
		        	m.setEmail(rs2.getString("email"));
		        	m.setNickname(rs2.getString("nickname"));
		        	m.setPwd(rs2.getString("pwd"));
		
		            
		         }

		         rs2.close();
		         st2.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }

		return m;
		
		
		
		
		
		
		
	
	}

	@Override
	public int update(String id, String email, String nickname) {
		
		
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
	      String sql = "UPDATE `soonfacedb`.`Member` SET `nickname`=?, `email`=? WHERE `id`=?";
	      		
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
	         // Statement st = conn.createStatement();
	         PreparedStatement st = conn.prepareStatement(sql);
	         st.setString(1, nickname);
	         st.setString(2, email);
	         st.setString(3, id);
	         
	        result = st.executeUpdate();
	    /*    업데이트 된 row갯수를 알려줌. st.executeUpdate*/

	         st.close();
	         conn.close();

	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
		return result;
		
		
		
		
	}


		
		
		
		
		
		
		
	}

	
		


	
	


