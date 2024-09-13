package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String SheetName,int rowNum,int cellNum) throws Throwable {
	FileInputStream fis=new FileInputStream("./testdata/al.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
}
public int getRowcount(String sheetName) throws Throwable {
	FileInputStream fis=new FileInputStream("./testdata/al.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount = wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
	
}
public void setDataIntoExcel(String SheetName,int rowNum,int cellNum,String Data) throws Throwable {
	FileInputStream fis=new FileInputStream("./testdata/al.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(SheetName).getRow(rowNum).createCell(cellNum);
	FileOutputStream fos=new FileOutputStream("./testdata/al.xlsx");
	wb.write(fos);
	wb.close();
}
}
