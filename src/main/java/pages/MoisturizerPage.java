package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MoisturizerPage extends SelectItemPage1 {
	public MoisturizerPage(WebDriver Driver) {
		super(Driver);
	
	}
	
	
	//locators
	By card = By.xpath("//*[@id=\"cart\"]");
	
	//metods
	
 	public void selectAloe () {
		selectItems("Aloe");
		}
	public void selectAlmond () {
		selectItems("Almond");
		} 
	
	 public void cardItems() throws InterruptedException {
		  click(Driver.findElement(card));
		  System.out.println("catched...");
//		  Thread.sleep(5000);
	  
	 }
		  

		  
		  
		
		 
	}

