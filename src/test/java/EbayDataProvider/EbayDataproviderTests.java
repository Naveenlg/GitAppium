package EbayDataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import EbayBase.ExcelReadWrite;

public class EbayDataproviderTests {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<Object[]> getAddCartData() throws IOException {
		
		List<Object[]> obj = flagRowCount("Add_Cart");
		return obj.iterator();
		
	}
     @DataProvider(name="dp_PurchaseCart")
     public static Iterator<Object[]> getPurchaseCartData() throws IOException {
		
		List<Object[]> obj = flagRowCount("Purchase_Cart");
		return obj.iterator();
		
	}
     //delete cart
     @DataProvider(name="dp_DeleteCart")
     public static Iterator<Object[]> getDeleteCartData() throws IOException {
		
		List<Object[]> obj = flagRowCount("Delete_Cart");
		return obj.iterator();
		
	}
     
     public static List<Object[]> flagRowCount(String Scriptname) throws IOException{
	
    	 
    	 ExcelReadWrite x1= new ExcelReadWrite("D:/Selenium_Programs_Java/EbayTestcases/src/test/resources/TestEbayData.xlsx");
    	 
    	 HSSFSheet scenarioSearch =x1.SetSheet("TestData");
    	 
    	 int Rowcount=x1.getRowCount(scenarioSearch);
    	 
    	 int Colcount=x1.getColCount(scenarioSearch,0);
    	 
    	 List<Object[]> arrlistcart = new ArrayList<Object[]>();
    	 
    	 for(int irow=1; irow<=Rowcount; irow++) {
    		 
    		 String Execute_Flag=x1.ReadColValue(scenarioSearch,irow,"Execute_Flag");
    		 
    		 String Scriptname1=x1.ReadColValue(scenarioSearch,irow,"Scriptname");
    	 
    	 if((Execute_Flag.equals("Y")&&(Scriptname1.equals(Scriptname)))) {
    		 
    		 Map<String,String> dsmap= new HashMap<String,String>();
    		 
    		 for(int jcol=0;jcol<=Colcount;jcol++) {
    			 
    			 String Key= x1.ReadValue(scenarioSearch,0,jcol);
    			 String Value=x1.ReadValue(scenarioSearch,irow,jcol);
    			 
    			 dsmap.put(Key,Value);
    			 
    		 }
    		 
    		 Object[] x= new Object[1];
    		 x[0]=dsmap;
    		 
    		 arrlistcart.add(x); 
    		 
    	 }
    	 
    	 }
    	 
    	 return arrlistcart;
    	 
     }

}
