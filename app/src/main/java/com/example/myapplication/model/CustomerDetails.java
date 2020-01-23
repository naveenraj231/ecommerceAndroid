package com.example.myapplication.model;


import com.google.gson.annotations.SerializedName;

public class CustomerDetails{

	@SerializedName("image")
	private String image;

	@SerializedName("ack")
	private boolean ack;

	@SerializedName("customerId")
	private String customerId;

	@SerializedName("customerName")
	private String customerName;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAck(boolean ack){
		this.ack = ack;
	}

	public boolean isAck(){
		return ack;
	}

	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}

	public String getCustomerId(){
		return customerId;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	@Override
 	public String toString(){
		return 
			"CustomerDetails{" + 
			"image = '" + image + '\'' + 
			",ack = '" + ack + '\'' + 
			",customerId = '" + customerId + '\'' + 
			",customerName = '" + customerName + '\'' + 
			"}";
		}
}