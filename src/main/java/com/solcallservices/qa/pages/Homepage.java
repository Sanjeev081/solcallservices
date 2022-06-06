package com.solcallservices.qa.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.solcallservices.qa.Base.TestBase;

public class Homepage extends TestBase{
	@FindBy(xpath="//*[@id=\"logo\"]/img")
	WebElement solcallservicelogo;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li/div[3]/div/p/a")
	WebElement Getintouchbtn;
	
	@FindBy(xpath="/html/body/div[2]/section/div[3]/section/div/div/div/div/div/div/div/div[1]/div/div/div/span/button")
	WebElement Readmorebtn;
	@FindBy(xpath="//*[@id=\"main-nav\"]/ul/li[1]/a")
	WebElement HomeText;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/ul/li[2]/a")
	WebElement Aboutnetusitelik;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/ul/li[3]/a")
	WebElement NetsuiteserviceslinkText;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/ul/li[4]/a")
	WebElement Integratedproductslink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/ul/li[5]/a")
	WebElement serviceslik;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/ul/li[6]/a")
	WebElement contactlink;
	
	@FindBy(xpath="//*[@id=\"firstName\"]")
	WebElement namefield;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement Emailfield;
	
	@FindBy(xpath="//*[@id=\"message\"]")
	WebElement Messagefield;
	
	@FindBy(xpath="//*[@id=\"contactusform\"]/input[3]")
	WebElement sendmailbtn;


	//@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[1]/span/span")
	//WebElement loginimage;
	//initializing the page objects

	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	public String validatehomepageTitle() {
		return driver.getTitle();

	}
	public boolean solcallserviceslogo() {
		return solcallservicelogo.isDisplayed();
	
	}
	public  void scrollpagedown(WebDriver driver) {
    	JavascriptExecutor js=((JavascriptExecutor)driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  
    	
    }
	public String getpageInnerText(WebDriver driver) {
    	JavascriptExecutor js=((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText ;").toString();
		return  pageText;    

}
	public void validateGettochbtn() {
		Getintouchbtn.click();
		
	}
	public void validdatereadmorebtn() {
		Readmorebtn.click();
		
	}
	public boolean validateHomeText() {
		return HomeText.isDisplayed();
		
	}
	public void validateAboutnetsuite() {
		Aboutnetusitelik.click();
		
	}
	public void validateNetsuiteservices() {
		NetsuiteserviceslinkText.click();
		
	}
	public void validateIntegratedproductlink() {
		Integratedproductslink.click();
		
	}
	public void validateservicelink() {
		serviceslik.click();
	}
	public void validatecontactlink(String name,String Email,String Message) {
		contactlink.click();
		namefield.sendKeys(name);
		Emailfield.sendKeys(Email);
		Messagefield.sendKeys(Message);
		sendmailbtn.click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		String text=alert.getText();
		if(text.equals("please enter a valid user name")) {
			System.out.println("Please select the check-box to verify your-self.");
			
		}else {
			System.out.println("incorrect alert message");
		}
		alert.accept();
			
	}
	
	public void validateNumberoflink() {
		List<WebElement> Linklist=driver.findElements(By.tagName("a"));
		Linklist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("size of full links and images--->"+Linklist.size());
	}
}


