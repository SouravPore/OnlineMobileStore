package com.proj.model;

import java.io.Serializable;
import java.sql.Date;

public class BuyItems implements Serializable {
	
	private String email;
	private String id;
	private String name;
	private String image;
	private Date buydate;
	private String price;
	
	
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
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}


}
