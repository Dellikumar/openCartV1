package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	

	
	public String[][] getCellData(String FileName,String SheetName) throws IOException
	{
		
		System.out.println("inside get cell data");
		String [][] data= null;
		
		FileInputStream fs =new FileInputStream(FileName);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheets =wb.getSheet(SheetName);
		XSSFRow row=sheets.getRow(0);
		
		int noOfRows=sheets.getPhysicalNumberOfRows();
		int noOfCols =row.getLastCellNum();
		
		System.out.println("no of rows is " + noOfRows);
		System.out.println("no of colms is " + noOfCols);
		data =new String[noOfRows-1][noOfCols];
		Cell cell;
		for(int i=1;i<noOfRows;i++)
		{
			for(int j=0;j<noOfCols;j++)
			{
				row=sheets.getRow(i);
				cell=row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
				System.out.print(data[i-1][j]+ " \n");
			}
		}
		return data;
		
		
	}

	/*
	 * public FileInputStream fi; public FileOutputStream fo; public XSSFWorkbook
	 * workbook; public XSSFSheet sheet; public XSSFRow row; public XSSFCell cell;
	 * public CellStyle style; String path;
	 * 
	 * public ExcelUtility(String path) { this.path=path; }
	 * 
	 * public int getRowCount(String sheetName) throws IOException { fi=new
	 * FileInputStream(path); workbook=new XSSFWorkbook(fi);
	 * sheet=workbook.getSheet(sheetName); int rowcount=sheet.getLastRowNum();
	 * workbook.close(); fi.close(); return rowcount; }
	 * 
	 * public int getCellCount(String sheetName,int rownum) throws IOException {
	 * fi=new FileInputStream(path); workbook=new XSSFWorkbook(fi);
	 * sheet=workbook.getSheet(sheetName); row=sheet.getRow(rownum); int
	 * cellcount=row.getLastCellNum(); workbook.close(); fi.close(); return
	 * cellcount; }
	 * 
	 * 
	 * public String getCellData(String sheetName,int rownum,int colnum) throws
	 * IOException { fi=new FileInputStream(path); workbook=new XSSFWorkbook(fi);
	 * sheet=workbook.getSheet(sheetName); row=sheet.getRow(rownum);
	 * cell=row.getCell(colnum);
	 * 
	 * DataFormatter formatter = new DataFormatter(); String data; try{ data =
	 * formatter.formatCellValue(cell); //Returns the formatted value of a cell as a
	 * String regardless of the cell type. } catch(Exception e) { data=""; }
	 * workbook.close(); fi.close(); return data; }
	 * 
	 * public void setCellData(String sheetName,int rownum,int colnum,String data)
	 * throws IOException { File xlfile=new File(path); if(!xlfile.exists()) // If
	 * file not exists then create new file { workbook=new XSSFWorkbook(); fo=new
	 * FileOutputStream(path); workbook.write(fo); }
	 * 
	 * fi=new FileInputStream(path); workbook=new XSSFWorkbook(fi);
	 * 
	 * if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create
	 * new Sheet workbook.createSheet(sheetName);
	 * sheet=workbook.getSheet(sheetName);
	 * 
	 * if(sheet.getRow(rownum)==null) // If row not exists then create new Row
	 * sheet.createRow(rownum); row=sheet.getRow(rownum);
	 * 
	 * cell=row.createCell(colnum); cell.setCellValue(data); fo=new
	 * FileOutputStream(path); workbook.write(fo); workbook.close(); fi.close();
	 * fo.close(); }
	 * 
	 * 
	 * public void fillGreenColor(String sheetName,int rownum,int colnum) throws
	 * IOException { fi=new FileInputStream(path); workbook=new XSSFWorkbook(fi);
	 * sheet=workbook.getSheet(sheetName);
	 * 
	 * row=sheet.getRow(rownum); cell=row.getCell(colnum);
	 * 
	 * style=workbook.createCellStyle();
	 * 
	 * style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	 * style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 * 
	 * cell.setCellStyle(style); workbook.write(fo); workbook.close(); fi.close();
	 * fo.close(); }
	 * 
	 * 
	 * public void fillRedColor(String sheetName,int rownum,int colnum) throws
	 * IOException
	 */
	/*
	 * { fi=new FileInputStream(path); workbook=new XSSFWorkbook(fi);
	 * sheet=workbook.getSheet(sheetName); row=sheet.getRow(rownum);
	 * cell=row.getCell(colnum);
	 * 
	 * style=workbook.createCellStyle();
	 * 
	 * style.setFillForegroundColor(IndexedColors.RED.getIndex());
	 * style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 * 
	 * cell.setCellStyle(style); workbook.write(fo); workbook.close(); fi.close();
	 * fo.close(); }
	 */
	
}