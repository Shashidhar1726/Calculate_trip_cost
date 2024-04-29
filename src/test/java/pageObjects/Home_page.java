package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public WebDriver driver;
	Actions action;
	
	@FindBy(xpath="//span[text()='Hotels']")
	public WebElement hotels;
	
	@FindBy(name="BE_hotel_destination")
	public WebElement location;
	
	@FindBy(id="BE_hotel_checkin_date")
	public WebElement chck_in;
	
	@FindBy(id="BE_hotel_checkout_date")
	public WebElement chck_out;
	
	@FindBy(className="travellerLabel")
	public WebElement traveller;
	
	@FindBy(xpath="//div[@class='dflex pax-vol']/div[2]/div/div/span[2]")
	public WebElement passenger_cnt;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement search_hotel;
	
    public Home_page(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
	}
	
	public void location() {
		hotels.click();
		location.sendKeys("Goa");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void checkin() {
		chck_in.click();
		LocalDate nextDate=LocalDate.now().plusDays(1);
		String Formatter=nextDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		driver.findElement(By.id(Formatter)).click();
		//System.out.println(Formatter);
	}
	public void checkout() {
		chck_out.click();
		LocalDate finaldate=LocalDate.now().plusDays(5);
		String newdate=finaldate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		driver.findElement(By.id(newdate)).click();
		//System.out.println(newdate);
	}
	public void set_Traveller_Count(){
		traveller.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.doubleClick(passenger_cnt).perform();
	}
	public void search_hotel() {
		
		search_hotel.click();
	}	
}
