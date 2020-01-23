package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Attributes{

	@SerializedName("attrName")
	private String attrName;

	public void setAttrName(String attrName){
		this.attrName = attrName;
	}

	public String getAttrName(){
		return attrName;
	}

	@Override
 	public String toString(){
		return 
			"Attributes{" + 
			"attrName = '" + attrName + '\'' + 
			"}";
		}
}