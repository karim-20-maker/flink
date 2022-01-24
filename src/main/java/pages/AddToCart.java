package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart extends BasePage {

	public AddToCart(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}
	//locators 

	  By payWithCardBtn =By.xpath("//span[normalize-space()='Pay with Card']");
	  By totalPrice = By.xpath("//*[@id=\"total\"]");
	  
	// methods 
	  public void proceed() {
		  click(Driver.findElement(payWithCardBtn));
	  }
	  

	  
	  
	  public int gettotalPrice() {
		  String total = getText(Driver.findElement(totalPrice));
		  return Integer.parseInt(total);
		  
	  }

}
