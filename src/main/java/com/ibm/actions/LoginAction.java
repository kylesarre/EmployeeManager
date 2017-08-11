package com.ibm.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import com.ibm.dao.AccountDAO;
import com.ibm.dao.EmployeeDAO;
import com.ibm.beans.Employee;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	
	private String username;	
	private String password;
	private HashMap<String, String> accountData = new HashMap<String, String>();
	private List<Employee> employeeData = new ArrayList<>();
	
	public String login()
	{
		try {
			accountData = new AccountDAO().fetchAccountData(); // attempt to load account data
		}
		catch(IOException e)
		{
			e.printStackTrace();
			addActionError("Failed to fetch account data. You shouldn't see this.");
			return Action.ERROR; // failed to load employee data; not sure how to handle this atm.
		}
		if( accountData.containsKey(username) 
			&& accountData.get(username).equals(password) )
		{
			// retrieve required data
			String welcome = String.format("Welcome %s!\n", username);
			addActionMessage(welcome);
			setEmployeeData(new EmployeeDAO().fetchEmployeeData());			
			return Action.SUCCESS;
		}
		else
		{
			addActionError("Invalid username or password.");
			return Action.ERROR;
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public HashMap<String, String> getAccountData()
	{
		return accountData;
	}

	public List<Employee> getEmployeeData() {
		return employeeData;
	}

	public void setEmployeeData(List<Employee> employeeData) {
		this.employeeData = employeeData;
	}
}
