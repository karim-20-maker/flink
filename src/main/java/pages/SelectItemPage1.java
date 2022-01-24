package pages;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectItemPage1 extends BasePage {
//	By list_of_items = By.cssSelector("p.font-weight-bold.top-space-10"); 
//	By list_of_items_price = By.cssSelector("p.font-weight-bold.top-space-10~p");
	By buttons = By.cssSelector("p.font-weight-bold.top-space-10~p~button");
	String path;
	int price ;
	int i;
    ArrayList<Integer> prices =new ArrayList<Integer>() ;
    
    
	public SelectItemPage1(WebDriver Driver) {
		super(Driver);
	
	}

		public  void  selectItems(String item){
		  for ( i= 0 ; i < 6; i++ ) {
			  String text = Driver.findElements(buttons).get(i).getAttribute("onclick"); // onclick as it contains the price and the item name
			  if(text.contains(item) ) {
				 StringUtils.substringBetween(text, ",", ")"); // substring price from onclick locator
				 int priceInt =  Integer.parseInt(StringUtils.substringBetween(text, ",", ")"));
				 prices.add(priceInt); // insert all required items' prices into prices array
				 Collections.sort(prices); // sort prices descending
				 price = prices.get(0);  //get the least price
				
				 
                 
			  }

		  }
		  
		  try {
				 path = "//p[contains(text()," + '"' + + price+'"'+ ")]/following-sibling::button";
				 By collection = By.xpath(path) ;
				 click(Driver.findElement(collection));
				 System.out.println("here is the locator of Element ---> " + path);
				 
			 
			} catch (Exception e) {
				 System.out.println("here is the path ---> " + path + "from exception" );
			}
		  
	  }
	

}
