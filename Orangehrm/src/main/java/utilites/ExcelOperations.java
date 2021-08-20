package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelOperations {

	XSSFWorkbook excelfile;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;
	
	public int getRowCount(String excelSheetpath,String sheetName) throws IOException
	{
		FileInputStream fis= new FileInputStream(excelSheetpath);
		excelfile= new XSSFWorkbook(fis);
		sheet=excelfile.getSheet(sheetName);
		int rows=sheet.getPhysicalNumberOfRows();
		return rows;
	}
	public int getColumnCount(String excelSheetpath,String sheetName) throws IOException
	{
		FileInputStream fis= new FileInputStream(excelSheetpath);
		excelfile= new XSSFWorkbook(fis);
		sheet=excelfile.getSheet(sheetName);
		int columns= sheet.getRow(0).getPhysicalNumberOfCells();
		return columns;
	}
	public XSSFCell getCellValue(String excelSheetpath,String sheetName,int row,int column) throws IOException
	{
		FileInputStream fis= new FileInputStream(excelSheetpath);
		excelfile= new XSSFWorkbook(fis);
		sheet=excelfile.getSheet(sheetName);
		rows= sheet.getRow(row);
		cell=rows.getCell(column);
		return cell;
		
		
	}
	public void setCellValue(String excelSheetpath,String sheetName,int row,int column,Object value) throws IOException
	{
		FileInputStream fis= new FileInputStream(excelSheetpath);
		excelfile= new XSSFWorkbook(fis);
		sheet=excelfile.getSheet(sheetName);
		rows= sheet.getRow(row);
		cell=rows.createCell(column);
		if(value instanceof String)
		{
			cell.setCellValue((String)value);
		}
		else if(value instanceof Integer)
		{
			cell.setCellValue((Integer)value);
		}
		else if(value instanceof Double)
		{
			cell.setCellValue((Double)value);
		}
		FileOutputStream fos= new FileOutputStream(excelSheetpath);
		excelfile.write(fos);
		fos.close();		
	}
	public static void main(String[] args) throws IOException {
		ExcelOperations obj= new ExcelOperations();
		int row=obj.getRowCount(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataForForgotPassword.xlsx","Sheet1");
		int column=obj.getColumnCount(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataForForgotPassword.xlsx","Sheet1");
		//obj.setCellValue(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataForForgotPassword.xlsx","Sheet1", 1, 4,1);
		XSSFCell cell= obj.getCellValue(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\TestDataForForgotPassword.xlsx","Sheet1", 1, 1);
		System.out.println("Rows :- "+row);
		System.out.println("Columns :- "+column);
		System.out.println(cell.getCellType());
		
		System.out.println(cell.getStringCellValue());

	}
	
}
