package com.learnautomation.framework.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	static Properties pro;
	
	public static String getProperty(String key) {
		
		createInstance();
		return pro.getProperty(key);
		
	}
	
	
	public static Properties createInstance()
	{
		if(pro==null)
		{
			System.out.println("Found pro is null- Creating object of properties class");
			
			pro=new Properties();
			try 
			{
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.property")));
			} catch (FileNotFoundException e) 
			{
				System.out.println("Something went wrong !!! "+e.getMessage());
			} catch (IOException e) 
			{
				System.out.println("Something went wrong !!! "+e.getMessage());

			}
			return pro;
		}
		else
		{
			System.out.println("Found pro is not null- Reusing object of properties class");
			
			return pro;
		}
		
	}
	
}
