package com.learnautomation.framework.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook wb;
	
	public ExcelReader()
	{
		try 
		{
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/AutomationData.xlsx")));
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("File could not found, please check the path "+e.getMessage());
			
		} catch (IOException e)
		{
			System.out.println("Something went wrong, please check or try after sometime"+e.getMessage());
		}

	}
	
	public String getCellData(String sheetName,int row,int column) {
		
		String data = null;
		
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			 data=String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK){
			data="";
		}
		
		return data;
		
	}
	
	public int getRowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public int getColumnCount(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	
}
