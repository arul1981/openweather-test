package org.openweather.selenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class HomePageObjects extends DriverManager{
	
	private static final long timeoutInSeconds = 10;
	String cityXpath = "//input[@id='city']";
	public static WebDriverWait waitTime;
	
	//will check if the home is displayed correctly based of the title of the page
	public Boolean ishomepageDisplayed(String title) {
		String homePageTitle = driver.getTitle();
		if(title.equalsIgnoreCase(homePageTitle)){
			return true;
		}
		return false;
	}

	
	//input the city based on the value passed by
	public void inputCityName(String cCityName) {
		String cityXpath = "//input[@id='city']";
		driver.findElement(By.xpath(cityXpath)).clear();
		driver.findElement(By.xpath(cityXpath)).sendKeys(cCityName);
		driver.findElement(By.xpath(cityXpath)).sendKeys(Keys.RETURN);
		
	}
	
	public String getErrorMessage(){
		return driver.findElement(By.xpath("//*[@id='root']/div/div")).getText();
	}
	
	//this function will return either current date dd or current Hour HH based on the parameter date or time
	public String getCurrentDateorTime(String pDateorTime) throws Exception{
		
			DateFormat getCurrentDate = new SimpleDateFormat("dd");
			DateTimeFormatter getCurrentHour = DateTimeFormatter.ofPattern("HH");
			if(pDateorTime.equalsIgnoreCase("date")){
				Date date = new Date();
				return getCurrentDate.format(date);
			}
			else if(pDateorTime.equalsIgnoreCase("time")){
				LocalDateTime now = LocalDateTime.now();
				return getCurrentDate.format(getCurrentHour.format(now));
			}else
				throw new Exception("Please pass either date or time");
	}
	
	//based on first forecast date and if is not matching with the currentdate then return false 
	public Boolean getWeatherForecastDate() throws Exception{
	
			if(getCurrentDateorTime("date").equalsIgnoreCase(driver.findElement(By.
					xpath("//*[@id='root']/div/div[1]/div[1]/span[1]/span[2]")).getText())){
				return true;
			}
			
			return false;	
	}
	
	
	//This function will check if all the 5 days weather details are returned
	public void getAllWeatherDaysCount() throws Exception{
		List<WebElement> values = driver.findElements(By.xpath("//*[@id='root']/div/div/div[1]/span[1]/span[2]"));
		if(values.size() == 5){
			System.out.println("All 5 days are returned");
		}else
			throw new Exception("Not all the 5 days are fetched");
	}

	
	public void waituntillElementVisible(String xpathvalue){
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));
	}
	
	public void waituntillElementPresent(String xpathvalue){
		waitTime.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathvalue)));
	}
	
	
	public static void main(String[] args) throws Exception {
		HomePageObjects hPG = new HomePageObjects();
		hPG.createDriver(hPG.baseURL);
		Boolean val = hPG.ishomepageDisplayed("5 Weather Forecast");
		System.out.println(val);
		hPG.inputCityName("Edinburgh");
		hPG.getCurrentDateorTime("date");
		//val = hPG.getWeatherForecastDate("day1");
		System.out.println(val);
		//hPG.getAllWeatherDays();
	}
}
