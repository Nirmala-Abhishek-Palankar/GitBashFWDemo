package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String ReadExcelData(String sheetName, int RowNum, int CellNum) throws Throwable
	{
		
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData1.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet("sheetName");

		// Step4:- Navigating to the Row
		Row row = sheet.getRow(RowNum);

		// Step5:- Navigating to the Cell
		Cell cell = row.getCell(CellNum);
		
		String excelData = cell.getStringCellValue();
		System.out.println(excelData);

		return excelData;
		
	}
	
	public String readExceldataUsingDataFormatter(String sheetname, int rowNum,int cellNum) throws Throwable
	{
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData1.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet("sheetname");

		// Step4:- Navigating to the Row
		Row row = sheet.getRow(rowNum);
		// Step5:- Navigating to the Cell
		Cell cell1 = row.getCell(cellNum);
		
		DataFormatter format1 = new DataFormatter();
		 String excelData= format1.formatCellValue(cell1);
		return excelData;
		
		
	}
	
	public Object[][] readExcelDataForDataProvider(String sheetName) throws Throwable

	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData1.xlsx");

		Workbook book = WorkbookFactory.create(fis1);

		Sheet sheet = book.getSheet(sheetName);

		int lastRow = sheet.getLastRowNum() + 1;
		int lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
		
	}
}


