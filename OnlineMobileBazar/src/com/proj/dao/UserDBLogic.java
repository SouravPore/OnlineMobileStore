 package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.mysql.cj.protocol.Resultset;
import com.proj.model.BuyItems;
import com.proj.model.Items;
 
import com.proj.model.UserInfo;
import com.proj.model.UserItems;


public class UserDBLogic {
	
	public boolean UserRegInfoStoreInDB(UserInfo userobj)
	{
		Connection conobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobject=DBConnect.getDBConnection(); 
			pst=conobject.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, userobj.getName());
			pst.setString(2, userobj.getEmail());
			pst.setString(3, userobj.getMobileno());
			pst.setString(4, userobj.getPassword());
			pst.setString(5, userobj.getDob());
			pst.setString(6, userobj.getAddress());	
			
			pst.setString(7, userobj.getGender());
			pst.setString(8, userobj.getCity());
			pst.setString(9, userobj.getPIN());
			 
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}catch(SQLException e) {System.out.println(e.toString());}
		return f;
	}
	
	
	public UserInfo UserLoginCheck(String email,String password)
	{
		Connection conobject=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		UserInfo userobj=null;
		
		try
		{
			conobject=DBConnect.getDBConnection(); 
			pst=conobject.prepareStatement("select * from userinfo where email=? and password=?");
			pst.setString(1,email);
			pst.setString(2,password);
			rs=pst.executeQuery();
			if(rs.next())
			{
				//create bean class object
			    userobj=new UserInfo();
				//read value from resultset object and store it inside bean object
			    userobj.setName(rs.getString(1));
				userobj.setEmail(rs.getString(2));
				userobj.setMobileno(rs.getString(3));
				userobj.setPassword(rs.getString(4));
				userobj.setDob(rs.getString(5));
				userobj.setAddress(rs.getString(6));
				userobj.setGender(rs.getString(7));
				userobj.setCity(rs.getString(8));
				userobj.setPIN(rs.getString(9));
				 
				
			}
		}catch(SQLException e) {System.out.println(e.toString());}
		return userobj;

    }
	
	public UserInfo fetchDetail(String email)
	{
		Connection conobject=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		UserInfo userobj=null;
		 
		
		try
		{
			conobject=DBConnect.getDBConnection(); 
			pst=conobject.prepareStatement("select * from UserInfo where email=?");
			pst.setString(1,email);
			rs=pst.executeQuery();
			if(rs.next())
			{
				//create bean class object
				userobj=new UserInfo();
				//read value from resultset object and store it inside bean object
				userobj.setName(rs.getString(1));
				userobj.setEmail(rs.getString(2));
				userobj.setMobileno(rs.getString(3));
				userobj.setPassword(rs.getString(4));
				userobj.setDob(rs.getString(5));
				userobj.setAddress(rs.getString(6));
				userobj.setGender(rs.getString(7));
				userobj.setCity(rs.getString(8));
				userobj.setPIN(rs.getString(9));
				
				
			}
		}catch(SQLException e) {System.out.println(e.toString());}
		
		return userobj;
	}
	
	public boolean ItemsStoreInDB(Items itemobj)
	{
		Connection conoject=null;
		PreparedStatement pst=null;
		boolean f=false;
		
		conoject=DBConnect.getDBConnection();
		try {
			pst=conoject.prepareStatement("insert into items values(?,?,?,?,?,?) ");
			
			pst.setString(1,itemobj.getID());
			pst.setString(2,itemobj.getName());
			pst.setString(3,itemobj.getPrice());
			pst.setString(4,itemobj.getImage());
			pst.setInt(5,itemobj.getQuantity());
			pst.setInt(6,0);
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
			
		} catch (SQLException e) {
			 
			System.out.println(e.toString());
		}
		
		
		return f;
				
	}
	
	
	public List<Items> fetchItems()
	{
		Connection conobject=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Items> itemlist=new ArrayList<Items>();
		
		try
		{
			conobject=DBConnect.getDBConnection(); 
			pst=conobject.prepareStatement("select * from items");
			rs=pst.executeQuery();
			while(rs.next())
			{
				//create bean class object
				Items itemobj=new Items();
				//read value from resultset object and store it inside bean object
				itemobj.setID(rs.getString(1));
				itemobj.setName(rs.getString(2));
				itemobj.setPrice(rs.getString(3));
				itemobj.setImage(rs.getString(4));
				itemobj.setQuantity(rs.getInt(5));
				itemobj.setPurchases(rs.getInt(6));
				
				//add bean object to arraylist
				itemlist.add(itemobj);
				
			}
		}catch(SQLException e) {System.out.println(e.toString());}
		return itemlist;
	}
	
	
	public boolean itemsDelete(Items itemobj)
	{
		Connection conobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobject=DBConnect.getDBConnection();
			pst=conobject.prepareStatement("delete from items where id=?");
			pst.setString(1, itemobj.getID());
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}catch(SQLException e) {System.out.println(e.toString());}	
		return f;
	}
	
	public boolean itemsUpdate(Items itemobj)
	{
		Connection conobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobject=DBConnect.getDBConnection();
			pst=conobject.prepareStatement("update items set name=?,price=?,quantity=? where id=?");
			
			pst.setString(1,itemobj.getName());
			pst.setString(2,itemobj.getPrice());
			pst.setInt(3, itemobj.getQuantity());
			pst.setString(4,itemobj.getID());
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}catch(SQLException e) {System.out.println(e.toString());}	
		return f;
	}
	


 


public List<Items> fetchItemsByID(Items itemobj)
{
	Connection conobject=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	List<Items> itemlist=new ArrayList<Items>();

	try
	{
		
		conobject=DBConnect.getDBConnection();
		 
		pst=conobject.prepareStatement("select * from items where id = ?");
		pst.setString(1, itemobj.getID());
		rs=pst.executeQuery();
		while(rs.next())
		{
			//create bean class object
			Items itemobj1=new Items();
			//read value from resultset object and store it inside bean object
			itemobj1.setID(rs.getString(1));
			itemobj1.setName(rs.getString(2));
			itemobj1.setPrice(rs.getString(3));
			itemobj1.setImage(rs.getString(4));
			itemobj1.setQuantity(rs.getInt(5));
			itemobj1.setPurchases(rs.getInt(6));
			 
			
			//add bean object to arraylist
			itemlist.add(itemobj1);
			
		}
	}catch(SQLException e) {System.out.println(e.toString());}
	return itemlist;
}
public List<Items> Cart(Items itemobj)
{
	Connection conobject=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	List<Items> itemlist=new ArrayList<Items>();

	try
	{
		
		conobject=DBConnect.getDBConnection();
		 
		pst=conobject.prepareStatement("select * from items where id = ?");
		pst.setString(1, itemobj.getID());
		rs=pst.executeQuery();
		while(rs.next())
		{
			//create bean class object
			Items itemobj1=new Items();
			//read value from resultset object and store it inside bean object
			itemobj1.setID(rs.getString(1));
			itemobj1.setName(rs.getString(2));
			itemobj1.setPrice(rs.getString(3));
			itemobj1.setImage(rs.getString(4));
			 
			
			//add bean object to arraylist
			itemlist.add(itemobj1);
			
		}
	}catch(SQLException e) {System.out.println(e.toString());}
	return itemlist;
}

public List<Items> searchItem(String name)
{
	Connection conobject=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	List<Items> itemlist=new ArrayList<Items>();
	
	try
	{
		conobject=DBConnect.getDBConnection(); 
		pst=conobject.prepareStatement("select * from items where name=?");
		pst.setString(1,name);
		rs=pst.executeQuery();
		while(rs.next())
		{
			//create bean class object
			Items itemobj=new Items();
			
			itemobj.setID(rs.getString(1));
			itemobj.setName(rs.getString(2));
			itemobj.setPrice(rs.getString(3));
			itemobj.setImage(rs.getString(4));
			itemlist.add(itemobj);
			
		}
	}catch(SQLException e) {System.out.println(e.toString());}
	return itemlist;
}

public boolean UserUpdate(UserInfo userobj)
{
	Connection conobject=null;
	PreparedStatement pst=null;
	 
	 
	boolean f=false;
	try
	{
		
		 
		conobject=DBConnect.getDBConnection();
		 
		 
		pst=conobject.prepareStatement("update userinfo set name=?,mobileno=?,password=?,dob=?,address=?,gender=?,city=?,pin=? where email=?");	
		pst.setString(1, userobj.getName());
		pst.setString(2, userobj.getMobileno());
		pst.setString(3, userobj.getPassword());
		pst.setString(4, userobj.getDob());
		pst.setString(5, userobj.getAddress());	
		pst.setString(6, userobj.getGender());
		pst.setString(7, userobj.getCity());
		pst.setString(8, userobj.getPIN());
		pst.setString(9, userobj.getEmail());
		 
		
		int i=pst.executeUpdate();
		if(i>0)
			f=true;
		}
	catch(SQLException e) {System.out.println(e.toString());}	
	return f;
}


public List<UserInfo> fetchUser()
{
	Connection conobject=null;
	PreparedStatement pst=null;
	UserInfo userobj=null;
	ResultSet rs=null;
	List<UserInfo> userlist=new ArrayList<UserInfo>();
	
	try
	{
		conobject=DBConnect.getDBConnection(); 
		pst=conobject.prepareStatement("select * from userinfo");
		rs=pst.executeQuery();
		while(rs.next())
		{
			//create bean class object
			userobj=new UserInfo();
			//read value from resultset object and store it inside bean object
			 
			userobj.setName(rs.getString(1));
			userobj.setEmail(rs.getString(2));
			userobj.setMobileno(rs.getString(3));
			userobj.setPassword(rs.getString(4));
			userobj.setDob(rs.getString(5));
			userobj.setAddress(rs.getString(6));
			userobj.setGender(rs.getString(7));
			userobj.setCity(rs.getString(8));
			userobj.setPIN(rs.getString(9));
			
			//add bean object to arraylist
			userlist.add(userobj);
			
		}
	}catch(SQLException e) {System.out.println(e.toString());}
	return userlist;
}


public Items fetchItemsBYID(String id)
{
	Connection conobject=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Items itemobj=null;
	 
	
	try
	{
		conobject=DBConnect.getDBConnection(); 
		pst=conobject.prepareStatement("select * from items where id=?");
		pst.setString(1,id);
		rs=pst.executeQuery();
		if(rs.next())
		{
			//create bean class object
			itemobj=new Items();
			//read value from resultset object and store it inside bean object
			itemobj.setID(rs.getString(1));
			itemobj.setName(rs.getString(2));
			itemobj.setPrice(rs.getString(3));
			itemobj.setImage(rs.getString(4));
			
			
			
		}
	}catch(SQLException e) {System.out.println(e.toString());}
	
	return itemobj;
}


public boolean CartStoreInDB(UserItems itemobj)
{
	Connection conoject=null;
	PreparedStatement pst=null;
	boolean f=false;
	
	conoject=DBConnect.getDBConnection();
	try {
		pst=conoject.prepareStatement("insert into useritems values(?,?,?,?,?,?) ");
		
		pst.setString(1,itemobj.getEmail());
		pst.setString(2, itemobj.getID());
		pst.setString(3,itemobj.getName());
		pst.setString(4,itemobj.getImage());
		pst.setString(5,itemobj.getPrice());
		java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
		pst.setDate(6,currentDate);
		
		int i=pst.executeUpdate();
		if(i>0)
			f=true;
		
	} catch (SQLException e) {
		 
		System.out.println(e.toString());
	}
	
	return f;			
}

public List<UserItems> CartShow(String email)
{
	Connection conobj=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	UserItems uiobj=null;
	List<UserItems> uilist=new ArrayList<UserItems>();
	try
	{
		conobj=DBConnect.getDBConnection();
		pst=conobj.prepareStatement("select * from useritems where email=?");
		pst.setString(1, email);
		rs=pst.executeQuery();
		while(rs.next())
		{
			uiobj=new UserItems();
			uiobj.setEmail(rs.getString(1));
			uiobj.setID(rs.getString(2));
			uiobj.setName(rs.getString(3));
			uiobj.setImage(rs.getString(4));
			uiobj.setPrice(rs.getString(5));
			
		
			
			uilist.add(uiobj);
		}
	}
	catch(SQLException e) {System.out.println(e.toString());}
	
	return uilist;
}


public static int getPurchased(String id){
	int purchases=0;
	Connection conobj=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
			
	try{
		conobj=DBConnect.getDBConnection();
		pst=conobj.prepareStatement("select * from items where id=?");
		pst.setString(1, id);
		rs=pst.executeQuery();
		if(rs.next()){
			purchases=rs.getInt("purchases");
		}
		
	}catch(Exception e){System.out.println(e);}
	
	return purchases;
}

public static boolean checkPurchase(String id){
	boolean status=false;
	Connection conobj=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	try{
		conobj=DBConnect.getDBConnection();
		pst=conobj.prepareStatement("select * from items where id=? and quantity>purchases");
		pst.setString(1, id);
		rs=pst.executeQuery();
		if(rs.next()){
			status=true;
		}
		
	}
	catch(SQLException e){System.out.println(e.toString());}
	
	return status;

}


public int purchaseItems(BuyItems bobj){
	String id=bobj.getID();
	boolean checkpurchase=checkPurchase(id);
	System.out.println("Check status: "+checkpurchase);
	if(checkpurchase){
		int status=0;
		try{
			Connection conobj=DBConnect.getDBConnection();
			PreparedStatement pst=conobj.prepareStatement("insert into buyitems values(?,?,?,?,?,?)");
			pst.setString(1, bobj.getEmail());
			pst.setString(2, bobj.getID());
			pst.setString(3, bobj.getName());
			pst.setString(4, bobj.getImage());
			pst.setString(5, bobj.getPrice());
			java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
			pst.setDate(6, currentDate);
			
			
			status=pst.executeUpdate();
			if(status>0){
				PreparedStatement pst2=conobj.prepareStatement("update items set purchases=? where id=?");
				pst2.setInt(1,getPurchased(id)+1);
				pst2.setString(2,id);
				status=pst2.executeUpdate();
			}
			if(status>0)
			{
				PreparedStatement pst3=conobj.prepareStatement("delete from useritems where email=? and id=?");
				pst3.setString(1, bobj.getEmail());
				pst3.setString(2, id);
				status=pst3.executeUpdate();
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	else
	{
		return 0;
	}
}


public List<BuyItems> fetchBuyItems(String email)
{
	Connection conobj=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	BuyItems biobj=null;
	List<BuyItems> bilist=new ArrayList<BuyItems>();
	try
	{
		conobj=DBConnect.getDBConnection();
		pst=conobj.prepareStatement("select * from buyitems where email=?");
		pst.setString(1, email);
		rs=pst.executeQuery();
		while(rs.next())
		{
			biobj=new BuyItems();
			biobj.setName(rs.getString(3));
			biobj.setImage(rs.getString(4));
			biobj.setPrice(rs.getString(5));
			biobj.setBuydate(rs.getDate(6));
			
			bilist.add(biobj);
		}
	}
	catch(SQLException e) {System.out.println(e.toString());}
	
	return bilist;
}

public boolean deleteCartItems(String email,String id)
{
	Connection conobj=null;
	PreparedStatement pst=null;
	boolean f=false;
	try
	{
		conobj=DBConnect.getDBConnection();
		pst=conobj.prepareStatement("delete from useritems where email=? and id=?");
		pst.setString(1, email);
		pst.setString(2, id);
		int i=pst.executeUpdate();
		if(i>0)
			f=true;
	}
	catch(SQLException e) {System.out.println(e.toString());}
	
	return f;
}


public List<BuyItems> fetchAllShoppingHistory()
{
	Connection conobj=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	BuyItems biobj=null;
	List<BuyItems> bilist=new ArrayList<BuyItems>();
	try
	{
		conobj=DBConnect.getDBConnection();
		pst=conobj.prepareStatement("select * from buyitems");
		rs=pst.executeQuery();
		while(rs.next())
		{
			biobj=new BuyItems();
			
			biobj.setEmail(rs.getString(1));
			biobj.setID(rs.getString(2));
			biobj.setName(rs.getString(3));
			biobj.setImage(rs.getString(4));
			biobj.setPrice(rs.getString(5));
			biobj.setBuydate(rs.getDate(6));
			
			bilist.add(biobj);
		}
	}
	catch(SQLException e) {System.out.println(e.toString());}
	
	return bilist;
}
}
