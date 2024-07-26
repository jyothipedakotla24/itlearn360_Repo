package com.itlearn360.utilities;//This line specifies the package name for this class.

import java.io.File;//Represents a file on your computer.
import java.io.FileInputStream;//Reads data from a file.
import java.util.Properties;//Stores and retrieves configuration settings.

//This is a Java class named ConfigDataProvider that reads properties from a configuration file named config.properties
public class ConfigDataProvider {

//Properties is class in java that helps to reda all properties in config.properties file
//This line declares a variable named pro of type Properties, which will be used to store the properties read from the configuration file.
Properties pro;
	
//This line begins the definition of the constructor for the ConfigDataProvider class.
	public ConfigDataProvider()
	{
		//This line creates a new File object representing the configuration file located at the specified path.
		File src = new File("J:\\Eclipse programs\\itlearn360\\Configurations\\config.properties");
		
		try {
			//This line creates a new FileInputStream object to read data from the configuration file.
			FileInputStream fis= new FileInputStream(src);
			
			//his line creates a new Properties object to store the properties read from the configuration file.
			pro= new Properties();
			
			//This line loads the properties from the configuration file into the Properties object.
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		} 
	}

	//This line begins the definition of a method named getBrowser that returns the value of the "browser" property.
	public String getBrowser() {
		//This line returns the value of the "browser" property from the Properties object.
		return pro.getProperty("browser");
	}


    //This line begins the definition of a method named getStagingUrl that returns the value of the "testurl" property.
	public String getStagingUrl() {
		//This line returns the value of the "testurl" property from the Properties object.
		return pro.getProperty("testurl");
	}
	
	
	public String getUsername() {
		
		return pro.getProperty("username");
		
	}
	
    public String getPassword() {
		
		return pro.getProperty("password");
		
	}
	
}


