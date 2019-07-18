package utilsFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataForApp {
	
	
	public static void writedata(String data,String text,int cellnum) throws IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/SailPoit.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		//int columncount = 6;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell=
			//for (int j = 0; j < columncount; j++) {
			row.getCell(0);
			cell.setCellType(cell.CELL_TYPE_STRING);
				String cellvalue = cell.getStringCellValue();
				if (cellvalue.equalsIgnoreCase(text)) {
					//if(j==0) {
						
						
						cell = row.createCell(cellnum);
					cell.setCellValue(data);
					
					
				
			}

		}

		FileOutputStream fos = new FileOutputStream("./testdata/SailPoit.xlsx");

		wb.write(fos);
		fos.flush();

		fos.close();
	}
}
