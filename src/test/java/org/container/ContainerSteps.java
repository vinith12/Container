package org.container;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContainerSteps {
	
	public static WebDriver driver;
	
	@Given("The user should be in Container Store home page")
	public void the_user_should_be_in_Container_Store_home_page() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.containerstore.com/welcome.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    
	}

	@Given("The user should enter the product name")
	public void the_user_should_enter_the_product_name() {
		driver.findElement(By.name("q")).sendKeys("10074713");
	   
	}

	@When("The user should click the enter buttons")
	public void the_user_should_click_the_enter_buttons() {
	 driver.findElement(By.id("nav-search-form-submit")).click();	    
	}

	@When("The user in product pages")
	public void the_user_in_product_pages() {
		WebElement aa = driver.findElement(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1 css-1mxp830']"));
		String tt = aa.getText();
		WebElement bb = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-c5iitu']"));
		String ee = bb.getText();
		Assert.assertEquals(tt, ee);
		
//		String com = driver.getTitle();
//		System.out.println(com);
//		boolean ee = com.contains("InterMetro");
//		Assert.assertTrue(ee);	
//		Assert.assertTrue("hhh", driver.getCurrentUrl().equals(com));
		
	    
	}

	@When("yet another action")
	public void yet_another_action() {
		driver.quit();
	    
	}

}
