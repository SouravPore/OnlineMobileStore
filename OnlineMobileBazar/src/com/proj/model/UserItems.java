package com.proj.model;

import java.io.Serializable;
import java.sql.Date;

public class UserItems implements Serializable {
	
	private String email;
	private String id;
	private String name;
	private String image;
	private Date purchasedate;
	private String price;
	private String purchasestatus;
	
	
public UserItems() {}
	
	public UserItems(String email,String id,  String name, String image, String price) {
		super();
		this.email = email;
		this.id=id;
		this.name = name;
		this.image = image;
		this.price = price;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getID()
	{
		return id;	
	}
	public void setID(String id)
	{
		this.id=id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price=price;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image=image;
	}
	public String getPurchasestatus() {
		return purchasestatus;
	}
	public void setPurchasestatus(String purchasestatus) {
		this.purchasestatus = purchasestatus;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

}
