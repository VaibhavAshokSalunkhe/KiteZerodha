package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	public static String Getdata(String Sheetname, int row,int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file=new FileInputStream("C:\\Users\\Vaibhav Salunkhe\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\TestData.xlsx");
		
		String s=WorkbookFactory.create(file).getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
		
		return s;
		
	}
	
	public static double Getdata1( String Sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Vaibhav Salunkhe\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\TestData.xlsx");
		
		double data= WorkbookFactory.create(file).getSheet(Sheetname).getRow(row).getCell(cell).getNumericCellValue();
	    return data;
		
	}

}
