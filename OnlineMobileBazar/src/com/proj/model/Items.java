package com.proj.model;

import java.io.Serializable;
import java.sql.Blob;

public class Items implements Serializable
{
	private String id;
	private String name;
	private String price;
	private String image;
	private int quantity;
	private int purchases;
	
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Items(String id, String name, String price, String image, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
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
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

}