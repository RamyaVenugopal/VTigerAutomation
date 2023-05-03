package Automation.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellFileUtility{

	/**
	 * @return 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public String getDataFromExcell(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ConstantUtility.ExcellFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		sh.getRow(rownum).getCell(cellnum);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return value;	
	}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	 public String writeDataToExcell(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		 FileInputStream fis=new FileInputStream(ConstantUtility.ExcellFilePath);
		 Workbook book=WorkbookFactory.create(fis);
		 Sheet sh=book.createSheet(sheetName);
			sh.createRow(rownum).createCell(cellnum);
			FileOutputStream fos=new FileOutputStream(ConstantUtility.ExcellFilePath);
			DataFormatter format=new DataFormatter();
			String value=format.formatCellValue(sh.createRow(rownum).createCell(cellnum));
			book.write(fos);
			fos.flush();
			book.close();
	         return value;     
	 }
	 /**
	  * This method will capture all the data inside a sheet for dataprovider
	  * @param sheetname
	  * @return
	  * @throws EncryptedDocumentException
	  * @throws IOException
	  */
	
	 public Object[][] readMultipledataFromExcell(String sheetname) throws EncryptedDocumentException, IOException {
		 FileInputStream fis=new FileInputStream(ConstantUtility.ExcellFilePath);
		 Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	 }
	 }
	

