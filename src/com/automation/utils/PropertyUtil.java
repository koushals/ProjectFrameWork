package com.automation.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	private   String fileName ;
	private  final String FILE_NAME = "//src//com//automation//utils//";
	private  Properties p;
	
	public PropertyUtil(String fileName) {
		this.fileName= fileName;
	}

	public Properties getPropertiesFromFile() throws Exception {
		 p= new Properties();
		InputStream is = new FileInputStream(System.getProperty("user.dir") + FILE_NAME+fileName);
		p.load(is);
		is.close();
		return p ;
	}
	
	
	public  String getPropertiesFromParameter(String parameter) throws Exception {
		 return getPropertiesFromFile().getProperty(parameter);
	}

	
	
	

}
