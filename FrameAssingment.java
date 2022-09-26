package week4.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssingment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
// gettingnin to frame 1

driver.switchTo().frame("frame1");
driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Finance");
	
	//getting in to inner frame
driver.switchTo().frame("frame3");
driver.findElement(By.xpath("//input[@id='a']")).click();

//to come out from inner frame
driver.switchTo().defaultContent();

// to move to another frame
driver.switchTo().frame("frame2");
WebElement ele = driver.findElement(By.id("animals"));
Select s= new Select(ele);
s.selectByVisibleText("Baby Cat");



	
	
	}

}

