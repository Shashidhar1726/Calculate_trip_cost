package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class Gift_Voucher {

	public WebDriver driver;
	Actions action;
	JavascriptExecutor js ;
	String error_msg;
	int i=0;
	String path=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
	String dataPath=System.getProperty("user.dir")+"\\testData\\Data.xlsx";
	ExcelUtility excelWrite=new ExcelUtility(path);
	ExcelUtility excelRead=new ExcelUtility(dataPath);
	String nm;
	@FindBy(xpath="//span[text()='Gift Voucher']")
	public WebElement voucher;
	
	@FindBy(xpath="//p[text()='Please Share']")
	public WebElement query;
	
	@FindBy(name="name")
	public WebElement name;
	
	@FindBy(name="phone")
	public WebElement ph_num;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//div[@class='toasterHolder']")
	public WebElement error;
	
	@FindBy(id="email")
	public WebElement email;
	
	public Gift_Voucher(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
		js= (JavascriptExecutor) driver;
	}
	
	public void click_voucher() {
		action.moveToElement(voucher).click().perform();
	}
	
	public void window_handle() {
		for(String window:driver.getWindowHandles()) {
	        driver.switchTo().window(window);
	        }
	}
	
	public void corp_query() {
		js.executeScript("arguments[0].scrollIntoView();",query);
	}
	
	public void ph_data() {
		nm=excelRead.getCellData("Sheet1", 1, 0);
		name.sendKeys(nm);
		String invalidPn=excelRead.getCellData("Sheet1", 2, 0);
		ph_num.sendKeys(invalidPn);
		submit.click();
		
		
	}
	
	public void mail_data()
	{
		name.clear();
		name.sendKeys(nm);
	    String phoneNum=excelRead.getCellData("Sheet1", 1, 1);
		String InvalidEmail=excelRead.getCellData("Sheet1", 2, 1);
		ph_num.sendKeys(phoneNum);
		email.sendKeys(InvalidEmail);
		submit.click();
		//error_msg=error.getText();
		//System.out.println(error_msg);
		
	}
	public void get_error_message()
	{
		
		try {
			error_msg=error.getText();
			excelWrite.write_Data("Sheet2",error_msg, 1, i);
			i++;
			System.out.println("Error message :"+error_msg);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
