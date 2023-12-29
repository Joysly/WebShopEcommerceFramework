package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public static String getProperty(String key) {
	FileInputStream FIS=null;
	//Step 1: Get the java representation of physical commonData file
	try {
	FIS=new FileInputStream("./src/test/resources/commonData.properties");
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties p=new Properties();
	//Step 2: Load all the key and value pair to the properties
	try {
	p.load(FIS);
	}
	catch(IOException i) {
		i.printStackTrace();
	}
	//Step 3: Get the value using key
	return p.getProperty(key);
}
	public static void readDataFromExcel() throws EncryptedDocumentException, IOException {
		//Step 1: Get the java representation of excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		//Get the workbook ---> in the WorkbookFactory class, create() method is present
		Workbook book = WorkbookFactory.create(fis);
		//Get the sheet
		Sheet sheet = book.getSheet("register");
		//Get a row
		Row row = sheet.getRow(2);
		//Get a cell---> getStringValue(),getNumericCellValue()
		Cell cell = row.getCell(2);
		System.out.println(cell);
	}
	
	//Simple way to read from excel
	public static String readDataFromExcel1() throws Exception {
		//Step 1: Get the java representation of excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		return WorkbookFactory.create(fis).getSheet("register").getRow(2).getCell(2).toString();
	}
	public static String readCellDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		//Step 1: Get the java representation of excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
	}
	
	
	public static void main(String[] args) throws Exception {
		readDataFromExcel();
		System.out.println(readDataFromExcel1());
		System.out.println(readCellDataFromExcel("register", 2, 4));
	}
}
