package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;
	// Constructor that will be automatically called as soon as the object of the class is created
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	//Getting row count in given sheet
	public int getRowCount(String sheetName) 
	{
		int rowcount=0;
		try {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
		    rowcount=sheet.getLastRowNum();
		    workbook.close();
			fi.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;		
	}
	//Getting cell count 
	public int getCellCount(String sheetName,int rownum)
	{
		int cellcount=0;
		try {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			cellcount=row.getLastCellNum();
			workbook.close();
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellcount;
	}

	//Getting cell data from excel sheet
	public String getCellData(String sheetName,int rownum,int colnum) 
	{
		try {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			workbook.close();
			fi.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		return data;
	}
	//Writing data in to excel sheet
	public  void writeData(String filename,String sheetName,int rowNumber,int cellNumber, String data) {
				try {
					fi = new FileInputStream(filename);
					workbook = new XSSFWorkbook(fi);
					sheet = workbook.getSheet(sheetName);
					row = sheet.getRow(rowNumber);
					//row = sheet.createRow(rowNumber);
					cell = row.createCell(cellNumber);
					cell.setCellValue(data);

					fo = new FileOutputStream(filename);
					workbook.write(fo);
					workbook.close();
					fi.close();
					fo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
	public  void write_Data(String sheetName, String data, int rowNo, int colNo) throws IOException {
				// XSSFSheet sheet = workbook.getSheet(sheetName);
		FileInputStream file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		try {

 
			XSSFSheet sheet = workbook.getSheet(sheetName);
 
			if (sheet.getRow(rowNo) == null) {
				sheet.createRow(rowNo);
			}
			XSSFRow row = sheet.getRow(rowNo);
			row.createCell(colNo).setCellValue(data);
		} catch (Exception e) {
			XSSFSheet sheet = workbook.createSheet(sheetName);
				if (sheet.getRow(rowNo) == null) {
					sheet.createRow(rowNo);
				}
				XSSFRow row = sheet.getRow(rowNo);
				row.createCell(colNo).setCellValue(data);
		}
		FileOutputStream fo = new FileOutputStream(path);
		workbook.write(fo);
		file.close();
		fo.close();
 
	}


}
