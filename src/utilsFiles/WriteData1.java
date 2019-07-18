package utilsFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData1 {

	public static void WriteExcel(String value, String text) throws IOException {

		FileInputStream fis = new FileInputStream("./testdata/SailPoit.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int columncount = 3;
		Object cellvalue=null;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			
	
			for (int j = 1; j < columncount; j++) {
				XSSFCell cell=row.getCell(j);
				cell.setCellType(cell.CELL_TYPE_STRING);
				cellvalue=cell.getStringCellValue();
				if (((String) cellvalue).equalsIgnoreCase(text)) {
					if(j==1) {
						
						System.out.println("data j " +cellvalue);
						cell = row.createCell(3);
					cell.setCellValue(value);
					System.out.println("value1 " +value);
					}

					if (value.equalsIgnoreCase("Fail")) {	
						cell =row.getCell(3);
						cell.setCellValue(value);
						System.out.println("value2 " +value);
					}

				}
			}

		}

		FileOutputStream fos = new FileOutputStream("./testdata/SailPoit.xlsx");

		wb.write(fos);
		fos.flush();

		fos.close();

	}

}
