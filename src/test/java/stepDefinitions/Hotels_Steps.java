package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.Home_page;
import pageObjects.Hotel_page;
import utilities.ExcelUtility;

public class Hotels_Steps {
	WebDriver driver;
	Home_page hp;
	Hotel_page htlp;
	String path=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
	ExcelUtility excelWrite=new ExcelUtility(path);
	
	@Given("user open application with provided url")
	public void user_open_application_with_provided_url()
	{
		BaseClass.getLogger().info("User opens the application with provided url.........");
	    driver=BaseClass.getDriver();
		hp=new Home_page(driver);
		htlp=new Hotel_page(driver);
	}

	@When("user click on hotels button and set the location")
	public void user_click_on_hotels_button_and_set_the_location()
	{
	 BaseClass.getLogger().info("User click on hotels button and set the location.........");
	 hp.location();   
	}

	@When("select the checkin and checkout dates")
	public void select_the_checkin_and_checkout_dates() 
	{
		BaseClass.getLogger().info("Selecting the checkin and checkout dates for the booking.........");
		hp.checkin();
		hp.checkout();
	    
	}

	@When("set the traveller count")
	public void set_the_traveller_count() 
	{
	   BaseClass.getLogger().info("set the traveller count for the booking.........");
	   hp.set_Traveller_Count();
	}

	@When("click on search hotels button")
	public void click_on_search_hotels_button() 
	{
		BaseClass.getLogger().info("Clicking on the search button to get results.........");
	    hp.search_hotel();
	}

	@Then("list of hotels will be displayed")
	public void list_of_hotels_will_be_displayed()
	{
		BaseClass.getLogger().info("Checking whether hotels displayed or not.........");
		boolean hotels=htlp.allHotels.isDisplayed();
		
		
		
		if(hotels==true) {
			System.out.println("list of hotels are displayed");
		}
	    
	}

	@When("user sort the list with highest user rating")
	public void user_sort_the_list_with_highest_user_rating() 
	{
	  BaseClass.getLogger().info("Sorting of hotels by highest user rating.........");
	  htlp.user_rating();  
	}

	@When("select  free wifi and free breakfast filters")
	public void select_free_wifi_and_free_breakfast_filters()
	{
		BaseClass.getLogger().info("Selecting free wifi and breakfast checkboxes.........");
	    htlp.check_box();
	}

	@When("select laundry  and swimming pool filters under amenities")
	public void select_laundry_and_swimming_pool_filters_under_amenities()
	{
	   BaseClass.getLogger().info("Selecting laundry  and swimming pool checkboxes under amenities.........");
	   htlp.amenities_click(); 
	}

	@Then("collect the hotel details that are filtered")
	public void collect_the_hotel_details_that_are_filtered() 
	{
	  BaseClass.getLogger().info("Get the sorted hotels after specific requirements.......");
	  htlp.hotel_name();  
	}
	@Then("Store the details in excel sheet")
	public void store_the_details_in_excel_sheet()  {
		BaseClass.getLogger().info("Store the sorted hotels details in excel sheet.........");
	    int cnt=htlp.hotelNames.size();
	  
	    for(int i=0;i<cnt;i++) {
	    	try {
				excelWrite.write_Data("Sheet3",htlp.hotelNames.get(i), (i+1), 0);
				excelWrite.write_Data("Sheet3",htlp.hotelPrices.get(i), (i+1), 1);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
		
	    		
	}




}
