package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class is for reading data from Excel file
 
 *
 */
public class ExcelReader {

public static final String FILE_PATH = "dataFiles/Data.xlsx";
static FileInputStream fis = null ; 
	
	public static FileInputStream getFileInputStream(String path) 
	{
	
		File srcFile = new File(path);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
			System.exit(0);
		}
		return fis ; 
	}
	
	/**
	 * This method is for reading the data from Excel file
	 * @param path the path of the file to read the data from
	 * @return the data in form of 2 dimensional array of objects   
	 * @throws IOException
	 */
	public static Object[][] getExcelData(String path) throws IOException
	{
		fis = getFileInputStream(path); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 10 ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}
	public static String Email ;
	public static String Card ;
	public static String ZipCode ;
	public static String Date ;
	public static String Cvv ;
	/**
	 * This method is for reading and setting the data of Excel file
	 * @param path path of the file to read the data from
	 * @throws IOException
	 */
	public static void getDataFromExcel(String path) throws IOException {
		Object[][] data = getExcelData(path);
		System.out.println(data[0][1]);
		Email = (String) data[0][1];
		Card = (String) data[0][3];
		ZipCode = (String) data[0][5];
		Date = (String) data[0][7];
		Cvv = (String) data[0][9];
	}

	
}
