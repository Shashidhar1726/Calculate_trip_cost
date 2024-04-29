package pageObjects;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cruises_page {
	public WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	public ArrayList<String> inclusions=new ArrayList<String>();
	public Cruises_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
		 js= (JavascriptExecutor) driver;
	}
	
	@FindBy(className="more-arr")
	public WebElement more;
	
	@FindBy(xpath="//span[text()='Cruise']")
	public WebElement cruise;
	
	@FindBy(xpath="//span[text()='Mumbai Cruise Holiday']")
	public WebElement select_cruise;
	
	@FindBy(xpath="//h4[text()='EXCLUSIONS']")
	public WebElement include;
	
	@FindBy(xpath="//section[@id='inc']//li[1]/span[1]/ul[1]/li[1]/ul[1]/li")
	public List<WebElement> includedata;
	
	@FindBy(xpath="//div[@class='owl-wrapper']/div[1]/figure[@class='hero item']")
			//div[@id='mobile-doc']/h1")
			//div[@id='mobile-doc']/h1[text()='Mumbai Cruise Holiday']")
	public WebElement cruiseImg;
	public void click_more() {
		action.moveToElement(more).perform();
	}
	
	public void click_cruise(){
		action.moveToElement(cruise).click().perform();	
		
	}
	
	public void cruise_desc() {
		js.executeScript("arguments[0].scrollIntoView();",include);
		System.out.println("Inclusions :");
		int k=1;
		for(int a=0;a<includedata.size();a++) {
			String description=includedata.get(a).getText();
			inclusions.add(description);
			System.out.println(k+"."+description);
			k++;
		}
		//Thread.sleep(2000);
		driver.navigate().back();
	}
}
