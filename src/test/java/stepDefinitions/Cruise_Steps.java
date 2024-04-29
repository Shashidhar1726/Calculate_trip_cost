package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cruises_page;
import utilities.ExcelUtility;

public class Cruise_Steps 
{
	Cruises_page cp;
	String path=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
	ExcelUtility excelWrite=new ExcelUtility(path);
	@Given("user in home page")
	public void user_in_home_page() 
	{
		BaseClass.getLogger().info("User in the home page.........");
	    cp=new Cruises_page(BaseClass.getDriver());
	    
	}

	@When("user click on more button")
	public void user_click_on_more_button() 
	{
		BaseClass.getLogger().info("Clicking on more button.........");
	    cp.click_more();
	}

	@When("click on cruise")
	public void click_on_cruise() 
	{
		BaseClass.getLogger().info("clicking on the cruise option.........");
	    cp.click_cruise();
	}

	@When("select first cruise line")
	public void select_first_cruise_line() 
	{
		BaseClass.getLogger().info("Selecting the first cruise line from the available cruise lines.........");
	    cp.select_cruise.click();
	}

	@Then("cruise line details will be displayed")
	public void cruise_line_details_will_be_displayed() 
	{
		BaseClass.getLogger().info("Checking whether cruise line details are displayed or not.........");
		boolean cruise=cp.cruiseImg.isDisplayed();
		Assert.assertEquals(cruise,true);
		
	    System.out.println("cruise line displayed");
	}

	@Then("get the inclusion points and display in console")
	public void get_the_inclusion_points_and_display_in_console()
	{
		BaseClass.getLogger().info("Getting inclusion points to display on console.........");
	    cp.cruise_desc();
	}

	@Then("store inclusion points in excel sheet")
	public void store_inclusion_points_in_excel_sheet()
	{ 
		BaseClass.getLogger().info("Storing the inclusion points into the excel sheet.........");
		int cnt=cp.inclusions.size();
		for(int i=0;i<cnt;i++) {
		try {
			excelWrite.write_Data("Sheet1",cp.inclusions.get(i), (i+1), 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	    System.out.println("points stored in excel sheet");
	}



}
