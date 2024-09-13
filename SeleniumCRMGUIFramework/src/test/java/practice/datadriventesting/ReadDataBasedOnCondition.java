package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {
public static void main(String[] args) throws IOException {
	String ExpectedTestId="tc_01";
	String data1="";
	String data2="";
	String data3="";
	boolean flag=false;
	FileInputStream fis=new FileInputStream("E:\\data\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("org");
	int rowcount = sheet.getLastRowNum();
	for(int i=0;i<=rowcount;i++) {
		String data="";
		try {
		data = sheet.getRow(i).getCell(0).toString();
		System.out.println(data);
		flag=true;
		if(data.equals(ExpectedTestId)) {
			data1 = sheet.getRow(i).getCell(1).toString();
			data2 = sheet.getRow(i).getCell(2).toString();
			data3 = sheet.getRow(i).getCell(3).toString();
		}
		}catch (Exception e) {	
			}
	}
	if(flag==true) {
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
	}
	else {
		System.out.println(ExpectedTestId+ "is not available");
	}
	

	wb.close();
}
}

