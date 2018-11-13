package com.example.himanshu.bpit.ewai;

import java.util.List;

public class Result {
	private List<ResultItem> result;
	private String registeration;
	private String stream;
	private String name;
	private String course;
	private String email;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setRegisteration(String registeration){
		this.registeration = registeration;
	}

	public String getRegisteration(){
		return registeration;
	}

	public void setStream(String stream){
		this.stream = stream;
	}

	public String getStream(){
		return stream;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCourse(String course){
		this.course = course;
	}

	public String getCourse(){
		return course;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Result{" +
			"result = '" + result + '\'' + 
			",registeration = '" + registeration + '\'' + 
			",stream = '" + stream + '\'' + 
			",name = '" + name + '\'' + 
			",course = '" + course + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}