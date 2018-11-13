package com.example.himanshu.bpit.ewai;

public class MarksItem{
	private int internal;
	private String name;
	private int external;

	public void setInternal(int internal){
		this.internal = internal;
	}

	public int getInternal(){
		return internal;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setExternal(int external){
		this.external = external;
	}

	public int getExternal(){
		return external;
	}

	@Override
 	public String toString(){
		return 
			"MarksItem{" + 
			"internal = '" + internal + '\'' + 
			",name = '" + name + '\'' + 
			",external = '" + external + '\'' + 
			"}";
		}
}
