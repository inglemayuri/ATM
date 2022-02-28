package com.atm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atm.dao.DBconnection;
import com.atm.entities.AtmUser;

public class AtmcustomerDBoperation {
	
	DBconnection ob=new DBconnection();
	Connection conn=ob.connection();
	
	public boolean login(long cid,String pin) throws SQLException
	{
		
		PreparedStatement stmt=conn.prepareStatement("select * from atmcustomer where atmcusId=? and 	atmcusPin=? ");
						stmt.setLong(1, cid);
						stmt.setString(2,pin);
						
						ResultSet result=stmt.executeQuery();
						if(result.next())
						{
							return true;
						}
						else
						{
							return false;
						}
					}
	public boolean accountClose(long userId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from atmuser where userID=?");
				stmt.setLong(1, userId);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}

				}
	synchronized public boolean viewAccount(AtmUser c) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("insert into atmuser values(?,?,?,?,?,?,?)");
		stmt.setLong(1, c.getUserId());
		stmt.setString(2,c.getUserName());
		stmt.setString(3,c.getUserAddress());
		stmt.setString(4,c.getUserPin());
		stmt.setDouble(5, c.getBalance());
		stmt.setLong(6,c.getPhone());
		stmt.setString(7, c.getUserEmail());
		
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public ResultSet checkUserinfo(long accId) 
	{
		ResultSet result=null;
		try
		{
		PreparedStatement stmt=conn.prepareStatement("select * from atmuser where userId=? ");
		stmt.setLong(1, accId);
	
		result=stmt.executeQuery();
		
		
		}
		catch(Exception e)
		{
			System.out.println("Wrong User Id..!!");
		}
		return result;
	}	
	public boolean changePin(long cid,String newPin) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("update atmcustomer set atmcusPin=? where atmcusId=? ");
		stmt.setString(1,newPin);
		stmt.setLong(2, cid);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	public void logout() throws SQLException
	{
		conn.close();
		
		
	}


}
