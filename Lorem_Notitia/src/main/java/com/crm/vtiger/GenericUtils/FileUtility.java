package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class FileUtility {
	/**
	 * This method is used to read data from properties and return the value based on key specification
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{   // ".\\AddCredentials\\commonData.properties"
		FileInputStream file = new FileInputStream(IpathConstant.propertyFilePath);
		Properties pro = new Properties();
		pro.load(file);
		return pro.getProperty(key);
	}
	
	public String getDataFromJson(String jsonKey) throws Throwable {
		  FileReader reader=new FileReader(IpathConstant.jsonFilePath);
		  JSONParser parser=new JSONParser();
		  Object object = parser.parse(reader);
		  JSONObject jsonObject = (JSONObject)object;
		  String value=jsonObject.get(jsonKey).toString();
		  return value;
		 }

}
