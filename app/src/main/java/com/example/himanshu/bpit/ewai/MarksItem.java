package com.example.himanshu.bpit.ewai;

import android.os.Parcel;
import android.os.Parcelable;

public class MarksItem implements Parcelable{
	private int internal;
	private String name;
	private int external;

	protected MarksItem(Parcel in) {
		internal = in.readInt();
		name = in.readString();
		external = in.readInt();
	}

	public static final Creator<MarksItem> CREATOR = new Creator<MarksItem>() {
		@Override
		public MarksItem createFromParcel(Parcel in) {
			return new MarksItem(in);
		}

		@Override
		public MarksItem[] newArray(int size) {
			return new MarksItem[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(internal);
		dest.writeString(name);
		dest.writeInt(external);
	}
}
