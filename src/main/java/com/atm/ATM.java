package com.atm;


import java.util.Scanner;

import com.atm.dao.AtmcustomerDBoperation;

import com.atm.entities.AtmUser;


import com.mysql.cj.xdevapi.Result;

import java.sql.ResultSet;


import com.atm.dao.AtmUserDBOperation;



public class ATM 
{
	 public static void main( String[] args )
	    {
	    	System.out.println("==========================================================================================================");
	    	System.out.println("                                             Welcome to ATM                                         ");
	    	System.out.println("==========================================================================================================");
	    	
	    	boolean status=true;
	    	do
	    	{
	       try
	       {
	    	   Scanner scan=new Scanner(System.in);
	    System.out.println("\t Press 1 -> Atm Customer ");
	   	System.out.println("\t Press 2 -> Atm User ");
	   	int userType=scan.nextInt();
	   	
	   	AtmcustomerDBoperation bo=new AtmcustomerDBoperation();
	   	
	   	if(userType==1)
	   	{
	   		System.out.println("\t Enter Customer Id:");
	   		long cId=scan.nextLong();
	   		System.out.println("\t Enter Pin:");
	   		String pin=scan.next();
	   		boolean validUser=bo.login(cId, pin);
	   		
	   		if(validUser)
	   		{
	   	       	System.out.println("==========================================================================================================");
	   			System.out.println("Login Successfull!!");
	   	       	System.out.println("==========================================================================================================");
	   	       	System.out.println(
	   	       			 
	   	       			"\t 1.Check User Information\r\n"
	   	       			+ "2.Password Change\r\n"
	   	       			+ "3.Logout");
	   	       	int operation=scan.nextInt();
	   	       	
	   		
	   	    	if(operation==1)
	   	       	{
	   	       		System.out.println("==========================================================================================================");
		       			System.out.println("Account Opening");
		       			System.out.println("==========================================================================================================");
		       		
	   	       		System.out.println("Enter account Id for the user:");
	   	       		long accId=scan.nextLong();
	   	       		System.out.println("Enter account holder name: :");
	   	       		String accName=scan.next();
	   	       		System.out.println("Enter account holder address: :");
	   	       		String accAddress=scan.next();
	   	       		System.out.println("Set account holder password: :");
	   	       		String accPassword=scan.next();
	   	       		System.out.println("Enter initial balance:");
	   	       		double accBalance=scan.nextDouble();
	   	       		System.out.println("Enter Phone Number:");
	   	       		long accPhone=scan.nextLong();
	   	       		System.out.println("Enter email address: :");
	   	       		String accEmail=scan.next();
	   	       		
	   	       		AtmUser u=new AtmUser(accId, accName, accAddress, accBalance,accPassword, accPhone,
	   	       				accEmail);
	   	       		if(bo.viewAccount(u))
	   	       		{
	   	       			System.out.println("==========================================================================================================");
	   	       			System.out.println("Account created!!");
	   	       			System.out.println("==========================================================================================================");
	   	       		}
	   	       		else
	   	       		{
	   	       			System.out.println("Problem in account creation!! ");
	   	       		}
	   	       		
	   	       	
	   	     if(operation==1)
	   	       	{
	   	       		
	   	       		
	   	       		System.out.println("Enter account id for closing account:");
	   	       		long cusId=scan.nextLong();
	   	       		
	   	       		if(bo.accountClose(accId))
	   	       		{
	   	       			System.out.println("Account closed successfully!! ");
	   	       		}
	   	       		else
	   	       		{
	   	       			System.out.println("Problem in account closing!! ");
	   	       		}
	   	       	}
	   		else if(operation==2)
	   	       	{
	   	       		System.out.println("==========================================================================================================");
	       			System.out.println("User Infomation ");
	       	       	System.out.println("==========================================================================================================");
	       	       	System.out.println("Enter the account Id for the User:");
	       	       	long cusId=scan.nextLong();
	       	       	ResultSet result=bo.checkUserinfo(cusId);
	       	       	if(result!=null)
	       	       	{
	       	       		while(result.next())
	       	       		{
	       	       		System.out.println("User Name:"+result.getString(2));
	       	       		System.out.println("Address:"+result.getString(3));
	       	       		System.out.println("Phone number:"+result.getLong(6));
	       	       		System.out.println("Email:"+result.getString(7));        	     
	       	       		System.out.println("Balance:"+result.getDouble(5));
	       	       	}
	       	       	}
	       	       	else
	       	       	{
	       	       		System.out.println("Account Id does not exist!! ");
	       	       	}
	   	       	}
	   	       	else if(operation==3)
	   	       	{
	   	       		System.out.println("Enter your Customer Id:");
	   	       		long cid=scan.nextLong();
	   	       		System.out.println("Set new Pin:");
	   	       		String newPin=scan.next();
	   	       		if(bo.changePin(cid, newPin))
	   	       		{
	   	       			System.out.println("Pin Changed!!");
	   	       		}
	   	       		else
	   	       		{
	   	       			System.out.println("Error occurred!!");
	   	       		}
	   	       	}
	   	       	else if(operation==4)
	   	       	{
	   	       		bo.logout();
	   	       		System.out.println("==========================================================================================================");
	       			System.out.println("Logged Out!! ");
	       	       	System.out.println("==========================================================================================================");

	   	       	}
	   	       	
	   	       	
	   		}
	   		else
	   		{
	   	       	System.out.println("==========================================================================================================");
	   			System.out.println("Incorrect UserId/Password!! ");
	   	       	System.out.println("==========================================================================================================");

	   		}
	   		
	   		
	   	}
	   	
	   	else if(userType==2)
	   	{
	   		
	   	   AtmUserDBOperation ob=new AtmUserDBOperation();
	   		System.out.println("\t Enter Account Id:");
	   		long uId=scan.nextLong();
	   		System.out.println("\t Enter Pin:");
	   		String pin1=scan.next();
	   		
	   		if(ob.login(uId, pin1))
	   		{
	   			System.out.println("==========================================================================================================");
	   			System.out.println("Logged In!!");
	   			System.out.println("==========================================================================================================");

	   			System.out.println("\r\n"
		       			+ "1.Withdraw\r\n"
		       			+ "2.Deposit\r\n"
		       			+ "3.Check Balance\r\n"
		       			+ "4.Change Pin\r\n"
		       			+"5.Recent Transactions\r\n"
		       			+ "6.Logout");
	   			
	int operation=scan.nextInt();

	   			if(operation==1)//Withdraw
		       	{
	   				System.out.println("Enter the withdrawal amount:");
		       		double withdrawAmount=scan.nextDouble();
	       			System.out.println("==========================================================================================================");
		       		ob.withdraw(withdrawAmount, uId);
	       			System.out.println("==========================================================================================================");

		       	}
		       	else if(operation==2)//Deposit
		       	{
		       		System.out.println("Enter the deposit amount:");
		       		double depositAmount=scan.nextDouble();
	       			System.out.println("==========================================================================================================");
		       		ob.deposit(depositAmount, uId);
	       			System.out.println("==========================================================================================================");

		       	}

		       		
		       	
		       	else if(operation==3)//check Balance
		       	{
		       		System.out.println("==========================================================================================================");
	      			 ResultSet rs=ob.balanceCheck(uId);
	      			 while(rs.next())
	      			 {
	      				 System.out.println("Available Balance :"+rs.getDouble(5));
	      			 }
	      				 System.out.println("==========================================================================================================");


		       	}
		    	
		       	else if(operation==4)//Change Password
		       	{
		    		System.out.println("Enter new password:");
		    		String newPin=scan.next();
		       		if(ob.changePin(uId, newPin))
		       		{
		       			System.out.println("==========================================================================================================");
		    			System.out.println("Pin changed successfully!!");
		    	       
		    			System.out.println("==========================================================================================================");

		       		}
		       		else
		       		{
		       		
		       			System.out.println("==========================================================================================================");
		        	    
		       			System.out.println("Problem in pin change!!");
		    	       	System.out.println("==========================================================================================================");

		       		}
		       	}
		    	else if(operation==5)//Recent Transactions
		    	{
		    		System.out.println("==========================================================================================================");
	       			System.out.println("Transaction Id" + "\t" +"Amount"+ "\t"+"Date"+"\t\t"+"Sender Id"+"\t"+"Receiver Id");
		       		System.out.println("==========================================================================================================");

		       		ResultSet rs=ob.transactions(uId);
		       		while(rs.next())
		       		{
		       			System.out.println(rs.getLong(1) + "\t\t" +rs.getDouble(2)+ "\t"+rs.getTimestamp(3)+"\t"+rs.getLong(4)+"\t"+rs.getLong(5));
		       		}
		       	
		       		System.out.println("==========================================================================================================");


		    	}
		       	else if(operation==6)//Logout
		       	{
		       		
	    	       		ob.logout();
	    	       		status=false;
	    	       		System.out.println("==========================================================================================================");
	        			System.out.println("Logged Out!!");
	        	       	System.out.println("==========================================================================================================");

	    	       	}
	    	    	else 
	    	       	{
	    	    		System.out.println("==========================================================================================================");
	    	       	}
		       	}
	    	    		else
	    		{
	    			System.out.println("==========================================================================================================");
	    			System.out.println("User Id or Pin Incorrect!!");
	    	       	System.out.println("==========================================================================================================");

	    		}


	   		}
	   		
	   	
	   	else
	   	{
	   		System.out.println("\t Please enter a correct input!!");
	   	}
	      }
	       }
	      catch(Exception e)
	      {
	   	   System.out.println(e.getMessage());
	   	   System.out.println("\t Wrong Input!!");
	   	   System.out.println("\t Provide Number input!!");
	      	   System.out.println("==========================================================================================================");

	      }
	   	}
	    
	   	while(status);
	   }
	
	    }




