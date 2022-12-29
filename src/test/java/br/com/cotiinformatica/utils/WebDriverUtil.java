package br.com.cotiinformatica.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {

	private static WebDriver driver;
	
	public static WebDriver getInstance() {
		
		System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
		
		if(driver == null)
			driver = new ChromeDriver();
		
		return driver;
	}
}
