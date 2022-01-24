package pages;

//import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemperaturePage extends BasePage {

	public TemperaturePage(WebDriver Driver) {
		super(Driver);
	
	}
	// locators 
	  By temperature =By.id("temperature");
	  By sunscreen = By.xpath("//button[contains(text(),'Buy sunscreens')]");
	  By moisturizer = By.xpath("//button[contains(text(),'Buy moisturizers')]");
	  
	// methods 
	  public void selectSunscreen() {
		  click(Driver.findElement(sunscreen));
	  }
	  
	  public void selectMoisturizers() {
		  click(Driver.findElement(moisturizer));
	  }
	  public void normal() {
		  System.out.println("Temperature is normal. Stay hydrated.");
	  }
	  
	  
	  public int getTemp() {
		  String[] split = getText(Driver.findElement(temperature)).split("[\\s\u00A0]+");
		  System.out.println(Integer.parseInt(split[0]));
		  return Integer.parseInt(split[0]);
		  
	  }

	  
}
