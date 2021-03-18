package com.training.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.training.utilities.Constants.APPLICATION_PROPERTIES;


public class CommonUtilities {

	public String getApplicationproperty(String sKey) throws IOException{
		
		Properties props = new Properties();
		String sFilePath = System.getProperty("user.dir");
		sFilePath = sFilePath+File.separator + APPLICATION_PROPERTIES;
		FileInputStream inputfile = new FileInputStream(sFilePath); 
		String sValue = "";
		try {
			props.load(inputfile);
			sValue = props.getProperty(sKey);
			if(sValue == "") {
				return null;
			}
			
		}catch (IOException e)
		{
			
		}finally {
			inputfile.close();
		}
		return sValue;		
		
		
		
	}
	
}
