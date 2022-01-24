package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class sunScreenPage extends SelectItemPage1 {
//	selectItemPage1 select ; 
	public sunScreenPage(WebDriver Driver) {
		super(Driver);
		
	
	}
	

	
	
	//locators
	By card = By.xpath("//*[@id=\"cart\"]");
	
	//metods
	

	 
	

			public void selectSpf30 () {
				selectItems("SPF-30");
				}
			public void selectSpf50 () {
				selectItems("SPF-50");
				}
			
			 public void cardItems() throws InterruptedException {
				  click(Driver.findElement(card));
				  System.out.println("catched...");
//				 Thread.sleep(5000);
			  
			 }


		  

		  
		  
		
		 
	}

