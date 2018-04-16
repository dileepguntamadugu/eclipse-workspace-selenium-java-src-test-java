package hybrid.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {
	private XSSFWorkbook workBook;
	private XSSFSheet spreadSheet;
	public XSSFWorkbook establishConnection(String sheetName) throws InvalidFormatException {
		workBook = new XSSFWorkbook();
		spreadSheet = workBook.createSheet(sheetName);
		return workBook;		
	}
	public void writeToExcel(Object obj) throws IOException {
		File file = new File("E:\\Learnings\\Automation\\ReadExcel.xlsx");
		FileOutputStream out = new FileOutputStream(file);
		int rowId = 0;
		XSSFRow row=spreadSheet.createRow(rowId);
		int cellId = 0;
		Cell cell = row.createCell(cellId);
		cell.setCellValue("CellOne");
		System.out.println("Excel file writing is completed");
		workBook.write(out);
		out.close();
	}
}