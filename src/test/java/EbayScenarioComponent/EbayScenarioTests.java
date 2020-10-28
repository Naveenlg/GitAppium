package EbayScenarioComponent;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.LogStatus;

import EbayBase.EbaybaseTests;
import EbayPageObject.EbayPageObjectTests;

public class EbayScenarioTests extends EbaybaseTests{
	
	public static Logger log = Logger.getLogger(EbayScenarioTests.class);
	
	SoftAssert sassert= new SoftAssert();
	
	//add cart dataprovider
	
	@Test(dataProvider= "dp_AddCart", dataProviderClass=EbayDataProvider.EbayDataproviderTests.class)
	public void testAddcart(Map search) {
		
		String TC_ID = search.get("TC_ID").toString();
		
		String Order = search.get("Order").toString();

		String SearchItem = search.get("SearchItem").toString();

		String ExpectedResult = search.get("ExpectedResult").toString();
		
		extenttest = extentreport.startTest(TC_ID);
		
		//starts the Appium Server
		start_server();
		
		log.info("Executing the test cases"+ TC_ID+ "Order"+Order);
		
		//launches emulator device
		launchEmulator("NaveenEmulator");
		
		ExtentReports();
		
		extenttest.log(LogStatus.PASS, "App is invoked");
		
		EbayPageObjectTests Ebaypob = new EbayPageObjectTests(driver);
		
		ExplicitWait(Ebaypob.skipsigninbtn, 25);
		
		Ebaypob.Click_sigininbtn();

		ExplicitWait(Ebaypob.searchbtn, 25);
		
		Ebaypob.Click_searchbtn();
		
		ExplicitWait(Ebaypob.searchtextbox, 25);
		
		Ebaypob.Enter_searchtextbox(SearchItem);
		
        ExplicitWait(Ebaypob.ProductClick, 25);
		
		Ebaypob.Click_Product();
		
        ExplicitWait(Ebaypob.Productname, 25);
		
		String ActualProductname= Ebaypob.getProductpricemsg();
		
        ExplicitWait(Ebaypob.Productprice, 25);
		
		Ebaypob.getProductnamemsg();
		
        ExplicitWait(Ebaypob.ProductDescription, 25);
		
		Ebaypob.getProductDescriptionmsg();
		
        ExplicitWait(Ebaypob.Addcartbtn, 25);
		
		Ebaypob.getAddcartbtn();
		
		 ExplicitWait(Ebaypob.CartUpdatedcheck, 25);
			
	     Ebaypob.getCartUpadtedcheck();
		
		if(ActualProductname.equals(ExpectedResult)) {
			
			log.info("passed as actual"+ ActualProductname + "Expected Result is"+ ExpectedResult);
			
		}

		else {
			
			log.info("failed as actual"+ ActualProductname + "Expected Result is"+ ExpectedResult);
			sassert.fail("Failed as actual message"+ ActualProductname + "Expected Result is"+ ExpectedResult);

		}

        Stop_Server();
		
		sassert.assertAll();

	}
	

	@Test(dataProvider= "dp_PurchaseCart", dataProviderClass=EbayDataProvider.EbayDataproviderTests.class)
	public void testPurchasecart(Map search) {
		
		String TC_ID = search.get("TC_ID").toString();
		
		String Order = search.get("Order").toString();

		String SearchItem = search.get("SearchItem").toString();

		String ExpectedResult = search.get("ExpectedResult").toString();
		
		extenttest = extentreport.startTest(TC_ID);
		
		start_server();
		
		log.info("Executing the test cases"+ TC_ID+ "Order"+Order);
		
		launchEmulator("NaveenEmulator");
		
		ExtentReports();
		
		extenttest.log(LogStatus.PASS, "App is invoked");
		
		EbayPageObjectTests Ebaypob = new EbayPageObjectTests(driver);

        ExplicitWait(Ebaypob.ProceedtoCheckoutbtn, 25);
		
		Ebaypob.getProceedtoCheckout();
		
        ExplicitWait(Ebaypob.DelivertoAddressbtn, 25);

		Ebaypob.getDelivertoAddressbtn();

		
        ExplicitWait(Ebaypob.ProceedtoContinueerrormsg, 25);
		
		String ActualMessage= Ebaypob.getProceedtoContineerrormsg();
		
				
		if(ActualMessage.equals(ExpectedResult)) {
			
			log.info("passed as actual message"+ ActualMessage + "Expected Result is"+ ExpectedResult);
			
		}
		else {
			
			log.info("Failed as actual message"+ ActualMessage + "Expected Result is"+ ExpectedResult);
		
			sassert.fail("Failed as actual message"+ ActualMessage + "Expected Result is"+ ExpectedResult);
		}
		
        Stop_Server();
		
		sassert.assertAll();
		
	}
	
	@Test(dataProvider= "dp_DeleteCart", dataProviderClass=EbayDataProvider.EbayDataproviderTests.class)
	public void testDeletecart(Map search) {
	
		String TC_ID = search.get("TC_ID").toString();
		
		String Order = search.get("Order").toString();

		String SearchItem = search.get("SearchItem").toString();

		String ExpectedResult = search.get("ExpectedResult").toString();

		extenttest = extentreport.startTest(TC_ID);
		
		start_server();
		
		log.info("Executing the test cases"+ TC_ID+ "Order"+Order);
		
		launchEmulator("NaveenEmulator");

		ExtentReports();
		
		extenttest.log(LogStatus.PASS, "App is invoked");

		EbayPageObjectTests Ebaypob = new EbayPageObjectTests(driver);

        ExplicitWait(Ebaypob.DeleteCartbtn, 25);

		Ebaypob.getDeleteCartbtn();
       
	    ExplicitWait(Ebaypob.CartUpdatedcheck, 25);

		 Ebaypob.getCartUpadtedcheck();
		 
	     ExplicitWait(Ebaypob.NoItemsinCartmsg, 25);

	     String Actualmessage= Ebaypob.getNoItemsinCartmsg();

		 if(Actualmessage.equals(ExpectedResult)) {
			
			log.info("passed as actual message"+ Actualmessage + "Expected Result is"+ ExpectedResult);

		}
		else {
			
			log.info("Failed as actual message"+ Actualmessage + "Expected Result is"+ ExpectedResult);

			sassert.fail("Failed as actual message"+ Actualmessage + "Expected Result is"+ ExpectedResult);
			
		}

		Stop_Server();
		
		sassert.assertAll();
		
	}
}
