package com.secretd.web.entity;

import java.util.Date;

public class Answer {
	private int number;
	private Date date;
	private String managerid;
	private String content;
	private int letternumber;
	
	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(int number, Date date, String managerid, String content, int letternumber) {
		super();
		this.number = number;
		this.date = date;
		this.managerid = managerid;
		this.content = content;
		this.letternumber = letternumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLetternumber() {
		return letternumber;
	}

	public void setLetternumber(int letternumber) {
		this.letternumber = letternumber;
	}

	
	
	
	
}
