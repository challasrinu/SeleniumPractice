package practice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
	public static void main(String[] args) throws Throwable, IOException, ParseException {
		//Step1:parse Json Physical file in to java Object using JSONParse class
		JSONParser parser=new JSONParser();
		 Object obj = parser.parse(new FileReader("C:\\Users\\chall\\OneDrive\\Desktop\\data\\appCommonData.json"));
		 //Step2:Convert java object into JsonObject using downcasting
		 JSONObject map=(JSONObject) obj;
		 //step3: get the value from json file usinf key
		 System.out.println(map.get("url"));
		 System.out.println(map.get("browser"));
		 System.out.println(map.get("username"));
		 System.out.println(map.get("password"));
		 System.out.println(map.get("timeouts"));
	}

}
