package pages;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver Driver ; 
	//Class Overloaded Constructor
	public BasePage(WebDriver Driver){
        this.Driver= Driver;
    }
	
	/**
	 * This method is for setting text in an element
	 * @param element to enter the text in it
	 * @param value to be entered as a text
	 */
	public void setText(WebElement element , String value) {
		element.sendKeys(value);
	}
	
	//get text 
	public String getText(WebElement element ) {
		return element.getText();
	}
	
	/**
	 * This method is to clear value from an element
	 * @param element to clear the value from
	 */
	public void clearText(WebElement element) {
		element.clear();
	}
	
	/**
	 * This method is to click on an element
	 * @param element to be clicked
	 */
	public void click(WebElement element) {
		element.click();
	}
	
	/**
	 * This method is to select a value from dropDownMenu 
	 * @param dropDownMenu the dropDownMenue to select a value from it 
	 * @param value to be selected 
	 */
	public void selectFromDropDown(WebElement dropDownMenu,String value ) {
    
        Select dropDown = new Select(dropDownMenu);
        dropDown.selectByValue(value);
    }
	
	/** 
	 * This method is to hover on an element 
	 * @param element to be hovered on
	 */
	public void hoverOnElement(WebElement element) {
		Actions actions = new Actions(Driver);
    	actions.moveToElement(element).perform();
	}
	
	 /**
	 * This method is to explicitly wait for an element to be visible
	 * @param by locator of the element that we're waiting to be visible
	 */
	public void waitUntilElementIsVisabile(By by) {
	        WebDriverWait wait = new WebDriverWait(Driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    }
	 
	 /**
	 * This method is for scrolling to an element  
	 * @param element to scroll to it
	 */
	public void scrollToElement(WebElement element) {
		 
		 ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 
	 }
	
	public void sendKeysInSequence(WebElement element ,String text) {
	    Random r = new Random();
	    for(int i = 0; i < text.length(); i++) {
	        try {
	            Thread.sleep((int)(r.nextGaussian() * 15 + 100));
	        } catch(InterruptedException e) {}
	        String s = new StringBuilder().append(text.charAt(i)).toString();
	        element.sendKeys(s);
	    }
	}
	

}
