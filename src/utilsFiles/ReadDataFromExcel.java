package utilsFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ReadDataFromExcel {
	
	@DataProvider(name="fetchdata")
	public static Object[][] getData() throws IOException {
		Object[][] testdata;
		Object cellvalue=null;
		
		FileInputStream fis=new FileInputStream("./testdata/SailPoit.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		int columncount=sheet.getRow(1).getLastCellNum();
		testdata=new String[rowcount][columncount];
		for(int i=1;i<=rowcount;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				 		XSSFCell cell=row.getCell(j);
				cell.setCellType(cell.CELL_TYPE_STRING);
				cellvalue=cell.getStringCellValue();
				
				testdata[i-1][j]=cellvalue;
				//System.out.println(cellvalue);
			}
		}
		return testdata;
		
	} 
	
	
}
