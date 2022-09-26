package week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssingment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	//search oneplus 9 pro 
	WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	search.sendKeys("oneplus 9 pro ");
	search.sendKeys(Keys.CONTROL.ENTER);
	
	// Get the price of the first product
	String price = driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']//span ")).getText();
System.out.println("The price of first result is " +price);

//. Print the number of customer ratings for the first displayed product
String CustRating = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro']//a/span")).getText();
System.out.println("The customer rating of this product "+CustRating);

Thread.sleep(2000);
//Click the first text link of the first image
driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a")).click();

//Take a screen shot of the product displayed
Set<String> windowHandles = driver.getWindowHandles();
List<String> window= new ArrayList<String>(windowHandles);
driver.switchTo().window(window.get(1));
File Source = driver.getScreenshotAs(OutputType.FILE);
File Destination= new File("./snaps/SC1.png");
FileUtils.copyFile(Source, Destination);

//Click 'Add to Cart' button
driver.findElement(By.id("add-to-cart-button")).click();
Thread.sleep(3000);

//Get the cart subtotal and verify if it is correct.
String cartTotal = driver.findElement(By.xpath("((//div[@class='a-column a-span11 a-text-left a-spacing-top-large']/span)[2])/span")).getText();
Thread.sleep(2000);
System.out.println("The total amt in the cart is " +cartTotal);

if(price.equalsIgnoreCase(cartTotal))
{
	System.out.println("Verified");
}
else
{
	System.out.println("Not verified");
}

//close the browser
driver.close();
	}

}
