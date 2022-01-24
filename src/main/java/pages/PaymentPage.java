package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage  extends BasePage{
	

	public PaymentPage(WebDriver Driver) {
		super(Driver);
	}
	//locators 
	By screen = By.cssSelector("div.Codebox.can-setfocus.Section-child");
	
	By cardNumber = By.xpath("//input[@id='card_number']");
	
	By monthYear = By.xpath("//input[@id='cc-exp']");
	
	By CVC = By.xpath("//input[@id='cc-csc']");
	
	By ZIPcode = By.xpath("//input[@placeholder='ZIP Code']");
	
	By submit = By.xpath("//button[@type='submit']");
	
	By email = By.xpath("//*[@id=\"email\"]");
	
	//Methods

    		

	public void switchToFrame() {
		Driver.switchTo().frame("stripe_checkout_app");	
		System.out.println("hey am after the frame");
	}
	 public void enterCardNumber(String cardNum){
		 sendKeysInSequence( Driver.findElement(cardNumber),cardNum);
	   }
	 public void enterEmail(String mail){
	       setText(Driver.findElement(email),mail );
	   }
	 public void entermonthYear(String monthYr){
		 sendKeysInSequence(Driver.findElement(monthYear),monthYr );
	   }
	 public void enterZIPcode(String ZIPcod){
	       setText(Driver.findElement(ZIPcode),ZIPcod );
	   }
	 public void enterCvc(String cvc){
	       setText(Driver.findElement(CVC),cvc );
	   }
	 
	  public void submitButton() {
		  click(Driver.findElement(submit));
	  }

}
