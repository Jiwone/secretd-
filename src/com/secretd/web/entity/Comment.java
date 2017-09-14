package com.secretd.web.entity;

import java.util.Date;

public class Comment {
	private int number;
	private String nickname;
	private String content;
	private int textnumber;
	private Date date;
	public Comment() {
		// TODO Auto-generated constructor stub
	}



	public Comment(int number, String nickname, String content, int textnumber, Date date) {
		super();
		this.number = number;
		this.nickname = nickname;
		this.content = content;
		this.textnumber = textnumber;
		this.date = date;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getTextnumber() {
		return textnumber;
	}



	public void setTextnumber(int textnumber) {
		this.textnumber = textnumber;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}




	
	
}
