package com.example.himanshu.bpit.ewai;

import java.util.List;

public class ResultItem{
	private String sem;
	private List<MarksItem> marks;

	public void setSem(String sem){
		this.sem = sem;
	}

	public String getSem(){
		return sem;
	}

	public void setMarks(List<MarksItem> marks){
		this.marks = marks;
	}

	public List<MarksItem> getMarks(){
		return marks;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"sem = '" + sem + '\'' + 
			",marks = '" + marks + '\'' + 
			"}";
		}
}