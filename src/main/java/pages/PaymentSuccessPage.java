package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentSuccessPage extends BasePage {

	public PaymentSuccessPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}


	//locators 
	 By msg = By.xpath("//h2[normalize-space()='PAYMENT SUCCESS']");
	 
	 
	 //Methods
	  public String getSuccessMsg() {
		  String MSg = getText(Driver.findElement(msg));
		  return MSg;
		  
	  }
	
		
}
