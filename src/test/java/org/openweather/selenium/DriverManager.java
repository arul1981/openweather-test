package org.openweather.selenium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

		public static WebDriver driver;
		public static WebDriverWait waitTime;
		
		public String baseURL = "http://localhost:3000/";
		
	public void createDriver(String url) throws Exception {
			createDriver();
			driver.get(url);
			waitTime = new WebDriverWait(driver, 15);
	 }

	public void createDriver() throws MalformedURLException, InterruptedException {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
	}
	

	public void getHomepageURL(String url){
		driver.get(url);
	}

	public void teardown() {
			driver.quit();
	}

}