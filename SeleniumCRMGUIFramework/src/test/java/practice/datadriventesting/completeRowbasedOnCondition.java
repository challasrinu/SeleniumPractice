package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class completeRowbasedOnCondition {
public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("E:\\data\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	String expected = "iphone56";
	int rowcount = sheet.getLastRowNum();
	Row row=null;
	for(int i=1;i<=rowcount;i++) {
		row = sheet.getRow(i);
	}
	int ccount = sheet.getRow(rowcount).getLastCellNum();
	for(int j=1;j<ccount;j++) {
		String cdata = row.getCell(j).toString();
     if(cdata.equals(expected)) {
    	 System.out.println(cdata);
     }
	}
	 
}
}