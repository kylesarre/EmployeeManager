package com.ibm.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AccountDAO {
	private final String PATH = "/login_account.txt";
	private final String COMMA_PATTERN = ",";
	
	public HashMap<String, String> fetchAccountData() throws IOException
	{
		HashMap<String, String> accountData = new HashMap<>();
		BufferedReader br = getFileInputStream();
		String line = "";
		if(br != null)
		{
			while(  (line = br.readLine()) != (null) )
			{
				String[] fields = line.split(COMMA_PATTERN);
				if(fields.length == 2)
					accountData.put(fields[0], fields[1]);
				else
				{
					System.out.println("Unexpected arg length. Expected two strings.");
				}
			}
			try{
				br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return accountData; // to be removed
	}
	
	public void save(HashMap<String, String> accountData) throws IOException, URISyntaxException
	{
		BufferedWriter bw = getFileOutputStream();
		Iterator<Map.Entry<String, String>> it = accountData.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<String, String> pair = it.next();
			if(it.hasNext())
				bw.write(String.format("%s,%s\n", pair.getKey(), pair.getValue()));
			else
				bw.write(String.format("%s,%s", pair.getKey(), pair.getValue()));
		}
		bw.close();
	}
	
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
	
	// returns a bufferedWriter that appends content to the end of the file.
	public BufferedWriter getFileOutputStream() throws IOException, URISyntaxException
	{
			File empFile = new File(this.getClass().getClassLoader().getResource(PATH).toURI());
			BufferedWriter bw = new BufferedWriter(new FileWriter(empFile));
			return bw;
	}
	
	public void writeToFile(String entry)  throws IOException, URISyntaxException{
		BufferedWriter br = getFileOutputStream();
		br.write(entry+"\n");
		br.close();
	}
}
