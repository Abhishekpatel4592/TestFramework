package com.framework.test.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

// Class to get test from excel file
public class RegistrationDataReader {

	
	@DataProvider
	public Object[][] TestData() throws IOException, BiffException
	{
		String filepath = "resources//TestData.xls";
		
		//Read Excel data
		FileInputStream Excelfile = new FileInputStream(filepath);
		
		//Read Workbook
		Workbook Exbook = Workbook.getWorkbook(Excelfile);
		
		//Read Sheet
		Sheet Exsheet = Exbook.getSheet("Registration");
		
		//Read Rows and Columns
		int Rows = Exsheet.getRows();
		int Columns = Exsheet.getColumns();
		
		// Save Rows and Columns in String array
		String Testdata[][] = new String[Rows-1][Columns];
		
		int count=0;
		
		//For loop to get data
		for(int i=1;i<Rows;i++)
		{
			for(int j=0;j<Columns;j++)
			{
				Cell Excell = Exsheet.getCell(j, i);
				Testdata[count][j] = Excell.getContents();
			}
			count++;
		}
		Excelfile.close();
		return Testdata;
					
	}

}
