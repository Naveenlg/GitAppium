package EbayBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReadWrite {
	
	FileInputStream fis;
	HSSFWorkbook wb;
	
	public ExcelReadWrite(String path) throws IOException {
		
		fis= new FileInputStream(path);
		
		wb= new HSSFWorkbook(fis);
		
	}
	
	public HSSFSheet SetSheet(String Sheetname) {
		HSSFSheet Sheet = wb.getSheet(Sheetname);
		return Sheet;
		
	}
	
	public int getRowCount(HSSFSheet Sheet1) {
		int LastRowNum = Sheet1.getLastRowNum();
		return LastRowNum;
		
	}
	
	public int getColCount(HSSFSheet Sheet1, int rowindex) {
		int LastRowNum = Sheet1.getRow(rowindex).getLastCellNum();
		return LastRowNum;
		
	}
	
	public  String ReadValue(HSSFSheet sheet,int rowindex, int cellnum) {
		
		HSSFCell cell=sheet.getRow(rowindex).getCell(cellnum);
		String Celltext=null;
		
		if(cell==null)
			Celltext=" ";
		else if(cell.getCellType()==cell.CELL_TYPE_STRING)
			Celltext=cell.getStringCellValue();
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			Celltext=String.valueOf(cell.getNumericCellValue());
		else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
			Celltext=" ";
				
		return Celltext;
		
	}
	
	
	  public String ReadColValue(HSSFSheet sheet,int rowindex, String Colname) {
	  
	  int Colindex=0;
	  
	  for(int i=0; i<getColCount(sheet,0); i++) {
	  if(sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(Colname));
	  Colindex=1; 
	  }
	  
	  return ReadColValue(sheet,rowindex,Colname);
	  
	  }
	 
     
     public void WriteCell(HSSFSheet sheet,int rowindex,int cellnum,String value) {
    	 
    	 HSSFCell WriteCell=sheet.getRow(rowindex).getCell(cellnum);
    	 
    	 if(WriteCell==null) {
    		 
    		 WriteCell=sheet.getRow(rowindex).createCell(cellnum);
    	 }
    	 
    	 WriteCell.setCellValue(value);
     }
     
     public void Save_Excel(String path) throws IOException {
    	 
    	 fis.close();
        FileOutputStream fos= new FileOutputStream(path);
    	 wb.write(fos);
    	 fos.close();
    	 
     }
	

}
