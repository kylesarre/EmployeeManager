package com.ibm.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.beans.Employee;

public class EmployeeDAO 
{
	private final String PATH = "/employees.txt";
	private final String COMMA_PATTERN = ",";
	
		public List<Employee> fetchEmployeeData()
		{
			List<Employee> employeeData = new ArrayList<>();
			BufferedReader br = getFileInputStream();
			String line = "";
			if(br != null)
			{
				try {
						while(  (line = br.readLine()) != (null) )
						{		
							System.out.println(line);
							String[] fields = line.split(COMMA_PATTERN);
							if(fields.length == 10)
								employeeData.add(new Employee(fields));
							else
							{
								System.out.println("Unexpected arg length. Expected nine strings.");
							}
						}
					}
				catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				finally {
					try{
						br.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}				
		}
			return employeeData;
	}
		// returns an input stream for reading from a file
		public BufferedReader getFileInputStream() {
		try {
			File empFile = new File(this.getClass().getClassLoader().getResource(PATH).toURI());
			BufferedReader br = new BufferedReader(new FileReader(empFile));
			return br;			
		} 
		catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	// returns an output stream for writing to the file
	public BufferedWriter getFileOutputStream() throws IOException, URISyntaxException
	{
			File empFile = new File(this.getClass().getClassLoader().getResource(PATH).toURI());
			BufferedWriter bw = new BufferedWriter(new FileWriter(empFile));
			return bw;
	}
	
	public void save(List<Employee> employeeData) throws IOException, URISyntaxException
	{
		BufferedWriter bw = getFileOutputStream();
		for (Employee emp: employeeData) {
			String firstName = emp.getFirstName();
			String lastName = emp.getLastName();
			String address = emp.getAddress();
			String city = emp.getCity();
			String state = emp.getState();
			String zip = emp.getZip();
			String cellPhone = emp.getCellPhone();
			String homePhone = emp.getHomePhone();
			String email = emp.getEmail();
			String id = emp.getId();
			
			bw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", firstName, lastName,
					address, city, state, zip, cellPhone, homePhone, email, id));
		}
		bw.close();
	} 
}
