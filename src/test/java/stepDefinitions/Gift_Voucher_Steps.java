package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cruises_page;
import pageObjects.Gift_Voucher;

public class Gift_Voucher_Steps 
{
	Cruises_page cp;
	Gift_Voucher gv;
	WebDriver driver;
	@Given("user in gift voucher page")
	public void user_in_gift_voucher_page() 
	{
		BaseClass.getLogger().info("User enters the Gift voucher window by clicking on gift voucher option from more.........");
	    driver=BaseClass.getDriver();
	    cp=new Cruises_page(driver);
	    gv= new Gift_Voucher(driver);
	    cp.click_more();
	    gv.click_voucher();
	    gv.window_handle();
	}

	@When("user fill corparate quieries form with invalid phone number")
	public void user_fill_corparate_quieries_form_with_invalid_phone_number()
	{
	   BaseClass.getLogger().info("User fills the form by giving invalid phone number.........");
	   gv.corp_query();
	   gv.ph_data();
	   
	}

	@Then("get the error message and store it in excel sheet")
	public void get_the_error_message_and_store_it_in_excel_sheet() 
	{
	   BaseClass.getLogger().info("Capturing error messages for invalid data .........");
	   gv.get_error_message();
	   
	}

	@When("user fill corparate quieries form with invalid email id")
	public void user_fill_corparate_quieries_form_with_invalid_email_id()
	{
		BaseClass.getLogger().info("User fills the form by giving invalid phone number.........");
		gv.mail_data();
	}



}
