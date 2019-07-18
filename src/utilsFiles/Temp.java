package utilsFiles;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.annotations.DataProvider;

public class Temp {
	/*public static String cellToString(XSSFCell cell) {  
    int type;
    Object result;
    type = cell.getCellType();

    switch (type) {

        case 0: // numeric value in Excel
            result = cell.getNumericCellValue();
            break;
        case 1: // String Value in Excel 
            result = cell.getStringCellValue();
            break;       
        case 3:
            result = "";
        case 4: //boolean value 
            result = cell.getBooleanCellValue();
            break;
        case Cell.CELL_TYPE_ERROR:
        default:  
            throw new RuntimeException("There is no support for this type of cell");                        
    }

    return result.toString();
}*/


/*public static String[][] getData() throws IOException {

	FileInputStream fis=new FileInputStream("./testdata/SailPoit.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheetAt(0);
	int rowcount=sheet.getLastRowNum();
	int columncount=sheet.getRow(1).getLastCellNum();
	String [][] testdata=new String[rowcount][columncount];
	for(int i=1;i<=rowcount;i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<columncount;j++) {
			 		XSSFCell cell;
			 		
			String cellvalue=row.getCell(j).getStringCellValue();
			testdata[i-1][j]=cellvalue;
			//System.out.println(cellvalue);
		}
	}
	return testdata;
	
} */
@DataProvider(name="fetchdata")
public  String[][] getValues() throws EncryptedDocumentException, InvalidFormatException, IOException{
	InputStream inp =getClass().getResourceAsStream("./testdata/SailPoit.xlsx");
	Workbook wb = WorkbookFactory.create(inp);
	DataFormatter objDefaultFormat = new DataFormatter();
	FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);

	org.apache.poi.ss.usermodel.Sheet sheet= wb.getSheetAt(0);
	int rowcount=sheet.getLastRowNum();
	int columncount=sheet.getRow(1).getLastCellNum();
	String [][] testdata=new String[rowcount][columncount];
	//Iterator<Row> objIterator = sheet.rowIterator();
	for(int i=1;i<=rowcount;i++) {
		XSSFRow row=(XSSFRow) sheet.getRow(i);
		
	for(int j=0;j<columncount;j++) {
	

	   
	    Cell cellValue = row.getCell(j);
	    objFormulaEvaluator.evaluate(cellValue); // This will evaluate the cell, And any type of cell will return string value
	    String cellValueStr = objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator);
	    testdata[i-1][j]=cellValueStr;
	    System.out.println(cellValueStr);
	}
	
	}
	return testdata;
}
	
	
}
