package Sanity;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static Workbook Wb;
	public static XSSFSheet Sheet1;
	public int rowcount;
	
	public ExcelData(String Path)
	{
		//Opening the File
		File F = new File(Path);
		try {
			FileInputStream Fis = new FileInputStream(F);
			Wb = new XSSFWorkbook(Fis);
				
			rowcount= Wb.getSheetAt(0).getLastRowNum();
			System.out.println(rowcount);
			
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
		public static String getData(int SheetNumber, int RowNum, int CellNum) throws Exception
		{
			Sheet1 = (XSSFSheet) Wb.getSheetAt(SheetNumber);
			String data= Sheet1.getRow(RowNum).getCell(CellNum).getStringCellValue();
			//Wb.close();
			return data;
			
		}
}
