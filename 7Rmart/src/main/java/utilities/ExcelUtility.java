package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constance.Constants;



public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	
		public static String getStringData(int a,int b,String sheet)
		{
			try {
			
		String filepath=Constants.TESTDATAFILE;//testdatafile is a static variable,so calling it using class name
		f=new FileInputStream(filepath);
		w=new XSSFWorkbook(f);//classes
		sh=w.getSheet(sheet);//classes
		Row r=sh.getRow(a);//interfaces
		Cell c=r.getCell(b);//interfaces
		return c.getStringCellValue();
			}
			catch(Exception e)
			{
				throw new RuntimeException("Excel sheet not found");
			}
		}
		public static String getIntegerData(int a,int b,String sheet)
		{
			try {	
			
		String filepath=Constants.TESTDATAFILE;	
		f=new FileInputStream(filepath);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheet);
		Row r=sh.getRow(a);
		Cell c=r.getCell(b);
		int x=(int)c.getNumericCellValue();//double to integer type casting
		return String.valueOf(x);//integer to string
		}
			catch(Exception e)
			{
				throw new RuntimeException("Excel sheet not found");
			}
		}

		}

		
	

		

	