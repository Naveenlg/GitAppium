package EbayPageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class EbayPageObjectTests {

	public AppiumDriver<WebElement> driver;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public WebElement skipsigninbtn;

	@FindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement searchbtn;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement searchtextbox;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/rs_results_count_text")
	public WebElement resultSearchcount;
	
	@FindBy(xpath="[@class='android.widget.LinearLayout'][@package='com.amazon.mShop.android.shopping'][@index='3']")
	public WebElement ProductClick;
	
	@FindBy(linkText="Amazon'sChoicefor \"samsung q60t\"")
	public WebElement Productname;
	
	@FindBy(xpath="[@resource-id='usedBuyBoxPrice_feature_div'][@class='android.view.View'][@package='com.amazon.mShop.android.shopping'][@index='0']")
	public WebElement Productprice;
	
	@FindBy(linkText="SAMSUNG Q60T Series 65-inch Class QLED Smart TV | 4K, UHD Dual LED Quantum HDR | Alexa Built-in | QN65Q60TAFXZA, 2020 Model")
	public WebElement ProductDescription;
	
	@FindBy(id="add-to-cart-button-ubb-mobile")
	public WebElement Addcartbtn;
	
	@FindBy(id="com.amazon.mShop.android.shopping:id/action_bar_cart_image")
	public WebElement CartUpdatedcheck;
	
	@FindBy(linkText="Proceed to checkout")
	public WebElement ProceedtoCheckoutbtn;
	
	@FindBy(linkText="Deliver to this address 113,7th Cross")
	public WebElement DelivertoAddressbtn;

	
	@FindBy(xpath="[@class='android.view.View'][@package='com.amazon.mShop.android.shopping'][@index='1']")
	public WebElement ProceedtoContinueerrormsg;
	
	@FindBy(xpath="[@class='android.widget.Button'][@text='Delete'][@package='com.amazon.mShop.android.shopping'][@index='0']")
	public WebElement DeleteCartbtn;
	
	@FindBy(xpath="[@class='android.view.View'][@text='Your Shopping Cart lives to serve. Give it purpose — fill it with groceries, clothing, household supplies, electronics, and more.'][@package='com.amazon.mShop.android.shopping'][@index='2']")
    public WebElement NoItemsinCartmsg;
	
	public EbayPageObjectTests(AppiumDriver<WebElement> driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public void Click_sigininbtn() {
 
		skipsigninbtn.click();
	}
	
	public void Click_searchbtn() {
		searchbtn.click();
	}
	
	public void Enter_searchtextbox(String value) {
		searchtextbox.sendKeys(value+"\n");
	}
	
	public String ResultofSearchcount() {
		
		return resultSearchcount.getText();
	}
	
	public void Click_Product() {
		ProductClick.click();
	}

	
	public String getProductnamemsg() {
		return Productname.getText();
	}
	
	public String getProductpricemsg() {
		return Productprice.getText();
	}
	
	public String getProductDescriptionmsg() {
		return ProductDescription.getText();
	}
	
	 public void getAddcartbtn() {
			
			Addcartbtn.click();
	}
	 
	 public void getCartUpadtedcheck() {
		 
		 CartUpdatedcheck.click();
	 }
	 
	 public void getProceedtoCheckout() {
		 
		 ProceedtoCheckoutbtn.click();
	 }
	 
	 public void getDelivertoAddressbtn() {
		 
		 DelivertoAddressbtn.click();
	 }
	 
	 public String getProceedtoContineerrormsg() {
		 
			return ProceedtoContinueerrormsg.getText();

	 }
	 
	 public void getDeleteCartbtn() {
		 
		 DeleteCartbtn.click();
	 }
	 
	 public String getNoItemsinCartmsg() {
		 
		 return NoItemsinCartmsg.getText();
	 }
	
}
