package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromEXCEL {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\chall\\OneDrive\\Desktop\\data\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	int cellcount = sheet.getRow(1).getLastCellNum();
	for(int i=0;i<=cellcount;i++) {
		String row="";
		try {
			row = sheet.getRow(1).getCell(i).toString();	
		} catch (Exception e) {
			
		}
		
		System.out.println(row);
	//String column1Data = row.getCell(0).toString();
	//String column2Data = row.getCell(1).toString();
	//System.out.println(column1Data+"\t"+column2Data);
	}
	wb.close();
}
}
