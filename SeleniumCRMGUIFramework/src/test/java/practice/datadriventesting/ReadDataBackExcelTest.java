package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackExcelTest {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\chall\\OneDrive\\Desktop\\data\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("org");
	Row row = sheet.getRow(1);
	Cell cell = row.createCell(4);
	cell.setCellType(CellType.STRING);
	cell.setCellValue("FAIL");
   System.err.println("===Executed==");
   FileOutputStream fos=new FileOutputStream("C:\\Users\\chall\\OneDrive\\Desktop\\data\\TestScriptData.xlsx");
   wb.write(fos);
   wb.close();
}
}
