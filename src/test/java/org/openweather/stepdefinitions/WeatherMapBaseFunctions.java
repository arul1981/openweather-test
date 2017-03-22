package org.openweather.stepdefinitions;

import org.openweather.selenium.HomePageObjects;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherMapBaseFunctions {
	
	HomePageObjects hPG;
	
	public WeatherMapBaseFunctions(){
		hPG = new HomePageObjects();
	}
	@Given("^the firefox browser is opened$")
	public void the_firefox_browser_is_opened() throws Throwable {
		hPG.createDriver();
	}

	@When("^user navigates to HomePage \"(.*?)\"$")
	public void user_navigates_to_HomePage(String arg1) throws Throwable {
		hPG.getHomepageURL(arg1);
	}

	@Then("^user should be displayed with five day forecast for the \"(.*?)\" city$")
	public void user_should_be_displayed_with_five_day_forecast_for_the_city(String arg1) throws Throwable {
		hPG.getAllWeatherDaysCount();
	}
	
	@And("^user verify if the date starting order is correct$")
    public void userVerifyIfTheDateStartingOrderIsCorrect() throws Throwable {
		Boolean currentDate = hPG.getWeatherForecastDate();
		if(!currentDate)
			throw new Exception("Date does not start in correct order");
    }

	@Given("^user is on the home page$")
	public void user_is_on_the_home_page() throws Throwable {
		hPG.createDriver(hPG.baseURL);
	}

	@When("^user enters Edinburgh on the home page$")
	public void user_enters_Edinburgh_on_the_home_page() throws Throwable {
		hPG.inputCityName("Edinburgh");
	}

	
	@Then("^user should be displayed with five day forecast for the Edinburgh city$")
	public void user_should_be_displayed_with_five_day_forecast_for_the_Edinburgh_city() throws Throwable {
		hPG.getAllWeatherDaysCount();
	}

	@When("^user enters Glassgow on the home page$")
	public void user_enters_Glassgow_on_the_home_page() throws Throwable {
		hPG.inputCityName("Glassgow");
	}

	@Then("^user should be displayed with five day forecast for the Glassgow city$")
	public void user_should_be_displayed_with_five_day_forecast_for_the_Glassgow_city() throws Throwable {
		hPG.getAllWeatherDaysCount();
	}


	@Then("^user should be displayed with Unable to fetch the value$")
	public void user_should_be_displayed_with_Unable_to_fetch_the_value() throws Throwable {
	    if(hPG.getErrorMessage().equalsIgnoreCase("Error retrieving the forecast"))
	    {
	    	System.out.println("error present");
	    }
	    else
	    	throw new Exception("Error not fidplayed");
	}

	@When("^user enters sasdad on the home page$")
	public void user_enters_sasdad_on_the_home_page() throws Throwable {
		hPG.inputCityName("sasdad");
	}
	
	@After
    public void afterScenario(){
       hPG.teardown();
    }
	
	//missing steps with the snippets below:

		@When("^user enters (\\d+) on the home page$")
		public void user_enters_on_the_home_page(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@When("^user clicks on any day$")
		public void user_clicks_on_any_day() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@Then("^user should be displayed with all details of the forecast for every (\\d+) hourly forecast entry for the selected day$")
		public void user_should_be_displayed_with_all_details_of_the_forecast_for_every_hourly_forecast_entry_for_the_selected_day(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@Then("^I don’t see summary of any other days$")
		public void i_don_t_see_summary_of_any_other_days() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@When("^user clicks on again on the same day$")
		public void user_clicks_on_again_on_the_same_day() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@When("^it has the details of the three hour display$")
		public void it_has_the_details_of_the_three_hour_display() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@Then("^(\\d+) hour display details are hidden$")
		public void hour_display_details_are_hidden(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

		@Then("^I see only the (\\d+) day forecast$")
		public void i_see_only_the_day_forecast(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		}

}
