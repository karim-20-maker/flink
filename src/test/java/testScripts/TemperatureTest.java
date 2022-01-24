package testScripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.AddToCart;
import pages.MoisturizerPage;
import pages.PaymentPage;
import pages.PaymentSuccessPage;
import pages.TemperaturePage;
import pages.sunScreenPage;

public class TemperatureTest  extends BaseTest{
	TemperaturePage tempPage ;
	sunScreenPage sunscreen;
	MoisturizerPage moisturizer;
	AddToCart addtocart ;
	PaymentPage payment;
	PaymentSuccessPage paymentSuccess;
	

	
	
	
	
	@BeforeClass
	public void calling () {
		tempPage = new TemperaturePage(Driver);
		sunscreen = new sunScreenPage(Driver);
		moisturizer = new MoisturizerPage(Driver);
		addtocart = new AddToCart(Driver);
		payment = new PaymentPage(Driver);
		paymentSuccess = new PaymentSuccessPage(Driver);

	
		
		
		
				}
	
	 
	@Test 
	public void temperature() throws InterruptedException {
		
			
//			Driver.manage().deleteAllCookies();
			Driver.get("http://weathershopper.pythonanywhere.com/");
//			tempPage.selectDestenation(tempPage.getTemp());
			
                  int numb = tempPage.getTemp(); 
				  if (numb > 34) {		
						System.out.println("delivered to sunscreen.");//instructions
						tempPage.selectSunscreen();	
						sunscreen.selectSpf50();
						sunscreen.selectSpf30();


						
					} else if (numb < 19) {								
						System.out.println("delivered to moisturizer.");//instructions
						tempPage.selectMoisturizers();
						moisturizer.selectAloe();
						moisturizer.selectAlmond();


						

						
					} else {
						System.out.println("Temperature is normal. Stay hydrated.");
					}
					sunscreen.cardItems();
					addtocart.proceed();
					payment.switchToFrame();
					Thread.sleep(5000);
					payment.enterCardNumber("4242424242424242");
					payment.entermonthYear("03/26");
					payment.enterEmail("test@test.com");
					payment.enterCvc("123");
					payment.enterZIPcode("21927");
					payment.submitButton();
					Thread.sleep(5000);
					paymentSuccess.getSuccessMsg();
					assertTrue(paymentSuccess.getSuccessMsg().contains("SUCCESS"));
				  
	}
	
	
		
		 
	}
	
		
	
	


