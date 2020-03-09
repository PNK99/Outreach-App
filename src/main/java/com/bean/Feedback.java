package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Feedback {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String co_ordinator;
	private String fun;
	private String enjoy;
	private String infrastructure;
	private String recommend;
	
	
	
	
	public String getCo_ordinator() {
		return co_ordinator;
	}
	public void setCo_ordinator(String co_ordinator) {
		this.co_ordinator = co_ordinator;
	}
	public String getFun() {
		return fun;
	}
	public void setFun(String fun) {
		this.fun = fun;
	}
	public String getEnjoy() {
		return enjoy;
	}
	public void setEnjoy(String enjoy) {
		this.enjoy = enjoy;
	}
	public String getInfrastructure() {
		return infrastructure;
	}
	public void setInfrastructure(String infrastructure) {
		this.infrastructure = infrastructure;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
