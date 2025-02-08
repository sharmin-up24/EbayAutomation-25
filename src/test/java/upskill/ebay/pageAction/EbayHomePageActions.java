package upskill.ebay.pageAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import upskill.ebay.pageElements.EbayHomePageLocators;
import upskill.utilities.SetupDrivers;

public class EbayHomePageActions {
	
	EbayHomePageLocators EbayHomePageLocatorsObj;
	
	public EbayHomePageActions(){
		EbayHomePageLocatorsObj = new EbayHomePageLocators();
		PageFactory.initElements(SetupDrivers.driver, EbayHomePageLocatorsObj);
	}

	public void searchShoes(){
		EbayHomePageLocatorsObj.txtbxSearch.sendKeys("Shoes");
		
		//Explicit Wait
		WebDriverWait explicitWait = new WebDriverWait(SetupDrivers.driver, 10);
		explicitWait.until(ExpectedConditions.elementToBeClickable(EbayHomePageLocatorsObj.btnSearch));
		
		EbayHomePageLocatorsObj.btnSearch.click();
	}
	
	public void searchPants(){
		EbayHomePageLocatorsObj.txtbxSearch.sendKeys("Pants");
		EbayHomePageLocatorsObj.btnSearch.click();
	}
	
	public void searchShirts(){
		EbayHomePageLocatorsObj.txtbxSearch.sendKeys("Shirts");
		EbayHomePageLocatorsObj.btnSearch.click();
	}
	
	public void searchItems(String items){
		EbayHomePageLocatorsObj.txtbxSearch.sendKeys(items);
		EbayHomePageLocatorsObj.btnSearch.click();
	}
	
	public void synchronization(){
		/*	Selenium Wait : 
				1. Implicit wait(Global), 
				2. Explicit wait(Conditional), 
				3. Fluent wait(intermittent) */
			
		//Implicit Wait
		SetupDrivers.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Explicit Wait
		WebDriverWait explicitWait = new WebDriverWait(SetupDrivers.driver, 10);
		explicitWait.until(ExpectedConditions.elementToBeClickable(EbayHomePageLocatorsObj.btnSearch));
		
		//Fluent Wait
		FluentWait fluentWait = new FluentWait(SetupDrivers.driver);								
		fluentWait.withTimeout(10, TimeUnit.SECONDS);
		fluentWait.pollingEvery(2, TimeUnit.SECONDS);
	}
}