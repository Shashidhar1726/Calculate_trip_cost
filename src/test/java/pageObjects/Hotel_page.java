package pageObjects;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Hotel_page {
	public WebDriver driver;
	JavascriptExecutor js;
	public ArrayList<String> hotelNames=new ArrayList<String>();
	public ArrayList<String> hotelPrices=new ArrayList<String>();
	
	
	@FindBy(xpath="//p[text()='5 +']")
	public WebElement rating;
	
	@FindBy(xpath="//span[text()='SHOW HOTELS WITH']")
	public WebElement facilities;
	
	@FindBy(xpath="//label[@class='filter-label ng-binding'and text()[normalize-space()='Free WiFi']]")
	public WebElement wifi;
	
	@FindBy(xpath="//label[@class='filter-label ng-binding'and text()[normalize-space()='Free Breakfast']]")
	public WebElement breakfast;
	
	@FindBy(xpath="//span[text()='Amenities']")
	public WebElement amenities;
	
	@FindBy(xpath="//label[@class='filter-label ng-binding'and text()[normalize-space()='Laundry facilities']]")
	public WebElement laundry;
	
	@FindBy(xpath="//label[@class='filter-label ng-binding'and text()[normalize-space()='Swimming pool']]")
	public WebElement swimming;
	
	@FindBy(xpath="//div[@class='result-details-left']/div/h2/a")
	public List<WebElement> hotelname;
	
	@FindBy(xpath="//div[contains(@class,'result-details-right')]//span[@class='bold ng-binding']/span[2]")
	public List<WebElement> price;
	
	@FindBy(xpath="//p[@class='matrix-label uprcse ng-binding']")
	public WebElement allHotels;
	
	 public Hotel_page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			js= (JavascriptExecutor) driver;
		}
	
	public void user_rating() {
		rating.click();
		
	}
	
	public void check_box() {
		js.executeScript("arguments[0].scrollIntoView();",facilities );
		//wifi.click();
		js.executeScript("arguments[0].click();",wifi );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//breakfast.click();
		js.executeScript("arguments[0].click();",breakfast );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void amenities_click() {
		js.executeScript("arguments[0].scrollIntoView();",amenities );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//laundry.click();
		js.executeScript("arguments[0].click();",laundry );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//swimming.click();
		js.executeScript("arguments[0].click();",swimming );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void hotel_name() {
		int k=1;
		//System.out.println("The names of hotels and their prices are :");
		System.out.println("Hotels :");
		for(int i=0;i<hotelname.size();i++) {
			String hname=hotelname.get(i).getText();
			String tprice=price.get(i).getText();
			hotelPrices.add(tprice);
			System.out.println(k+")"+"Hotel name: "+hname+" - "+"  Price: "+tprice);
			hotelNames.add(hname);
			k++;
		}
//		System.out.println("Prices :");
//		for(int j=0;j<price.size();j++) {
//			String tprice=price.get(j).getText();
//			hotelPrices.add(tprice);
//			System.out.println(tprice);
//			
//		}
		//System.out.println(price.get(0).getText());
		driver.navigate().back();
	}

}
