package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelSample {

	@Test
	public void testdata() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Downloads\\LoginData.xlsx");
		XSSFWorkbook excelfile= new XSSFWorkbook(fis);
		XSSFSheet sheet = excelfile.getSheet("Sheet1");
		
		int rowCount  = sheet.getLastRowNum(); // method 2 sheet.getPhysicalNumberOfRows();
		int colCount= sheet.getRow(rowCount).getLastCellNum(); // method 2 sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(sheet.getPhysicalNumberOfRows());
		System.out.println(rowCount);
		System.out.println(sheet.getRow(rowCount).getLastCellNum());
		System.out.println(sheet.getRow(1).getPhysicalNumberOfCells());
		
		for(int i=0; i<=rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				XSSFRow row =sheet.getRow(i);
				Cell  cell = row.getCell(j);
				System.out.print(cell.getStringCellValue()+"  "); 

			}
			System.out.println();
		}
		
	}
	// XSSFWorkbook

}
