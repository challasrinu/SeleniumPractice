package task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

public class Task {
@Test
public void sample( ) throws Throwable {
	FileInputStream fis=new FileInputStream("./configAppData/task.properties");
    Random ran=new Random();
    int ran1 = ran.nextInt(10);
	Properties pobj=new Properties();
	pobj.load(fis);
   Set<String> key = pobj.stringPropertyNames();
    int size = key.size();
	FileInputStream fis1=new FileInputStream("./testdata/task.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sheet = wb.createSheet("Srinu"+ran1);
	Sheet sh1 = wb.createSheet("sri"+ran1);
	Sheet sh2 = wb.createSheet("challa"+ran1);
	int rownum=0;
	int row2=0,n=0;
    for(String keys: key) {
    		String values = pobj.getProperty((String)keys);
    		if(n<=size/2) {
    			sheet.createRow(rownum++).createCell(0).setCellValue(values);
    		}
    		else {
    			sh1.createRow(row2++).createCell(0).setCellValue(values);
    		}
    		FileOutputStream fos=new FileOutputStream("./testdata/task.xlsx");
    		wb.write(fos);
    		
    }
    //read data from excel
    int rowcount = sheet.getLastRowNum()+sh1.getLastRowNum();
    for(int i=0;i<rowcount;i++) {
    	if(i<sheet.getLastRowNum()) {
    		sh2.createRow(i).createCell(0).setCellValue(sheet.getRow(i).getCell(0).getStringCellValue());
    	}else {
    		sh2.createRow(i).createCell(0).setCellValue(sheet.getRow(i).getCell(0).getStringCellValue());
    	}
    }
    
 FileOutputStream fos1=new FileOutputStream("./testdata/task.xlsx");
 wb.write(fos1);
  wb.close();
}
}



