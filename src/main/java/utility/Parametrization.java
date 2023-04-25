package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
 public static String getExcelData(String name , int row , int cell) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream("D:\\program\\Eclipse JAVA\\SwagLab\\src\\test\\resources\\TestData.xlsx");
	
	String value = WorkbookFactory.create(file).getSheet(name).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
// public static void main(String[] args) throws EncryptedDocumentException, IOException
//	{
//		String a =Parametrization.getExcelData("Sheet1", 0, 0);
//		System.out.println(a);
//	}
}
