package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
public String getDataFromPropertiesFile(String key) throws Throwable {
	JsonUtility JU=new JsonUtility();
	//FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
	Properties pobj=new Properties();
	pobj.load(JU.getjavaphysicalfile("./configAppData/commondata.properties"));
	String data=pobj.getProperty(key);
	
	return data;
}

}

