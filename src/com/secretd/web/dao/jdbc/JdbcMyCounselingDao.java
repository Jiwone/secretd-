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
import com.secretd.web.entity.Comment;
import com.secretd.web.entity.Counseling;

public class JdbcMyCounselingDao implements MyCounselingDao{

	@Override
	public List<Counseling> getList(String memberId) {
		
		
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "select number,title,date from Counseling where writer_id LIKE ?";
		   
		     int n=0;
		   List<Counseling> list = null;
		   Counseling c = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+memberId+"%");
		       
		         ResultSet rs2 = st2.executeQuery();

		         list = new ArrayList<>();
		  
		         
		         while (rs2.next()) {
		        
		        	c = new Counseling(); 
		          	c.setNumber(rs2.getString("number"));
		        	c.setTitle(rs2.getString("title"));
		        	c.setDate(rs2.getDate("date"));
		         
		      
		            list.add(c);
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
	public int delete(String num) {

		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "DELETE FROM `soonfacedb`.`Counseling` WHERE `number` LIKE ?";
		   
		     int result=0;
		   List<Counseling> list = null;
		   Counseling c = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+num+"%");
		       
		         result = st2.executeUpdate();

		         st2.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		     return result;
	}

	@Override
	public List<Comment> getComment(String memberId) {
		List<Comment> list = null;
		Comment co=null;
		
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "select date,textnumber,number,content from Comment where member_id LIKE ?";

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url,"soonface", "2014");
	         // Statement st = conn.createStatement();
	         PreparedStatement st2 = conn.prepareStatement(sql2);
	         st2.setString(1, memberId);
	         ResultSet rs2 = st2.executeQuery();
	        
	         list = new ArrayList<>();
	        
	         while(rs2.next()) {
	        
	        	co = new Comment(); 
	        	co.setNumber(rs2.getInt("number"));
	           co.setTextnumber(rs2.getInt("textnumber"));
	        	co.setContent(rs2.getString("content"));
	        	co.setDate(rs2.getDate("date"));
	        	list.add(co);
	        	
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
	public int deleteComment(String num) {
		

		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql2 = "DELETE FROM `soonfacedb`.`Comment` WHERE `number`LIKE ?";
		   
		     int result=0;
		   List<Counseling> list = null;
		   Counseling c = null;
		  
		     try {
		         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url, "soonface", "2014");
		         // Statement st = conn.createStatement();
		         PreparedStatement st2 = conn.prepareStatement(sql2);
		         st2.setString(1, "%"+num+"%");
		       
		         result = st2.executeUpdate();

		         st2.close();
		         conn.close();
		        
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		     return result;
	}
		
		
		
	}


	
	


