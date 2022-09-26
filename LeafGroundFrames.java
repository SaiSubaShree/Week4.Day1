package week4.Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
driver.get("https://www.leafground.com/frame.xhtml");


				//click on clickme frame
    WebElement frame = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("(//button[@id='Click'])[1]")).click();
	driver.switchTo().defaultContent();
	
				// To Get the count of frame
     List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
	int size = frame1.size();
	System.out.println("The number of frames is " +size);
	
		
				//nested frame
	WebElement frame3 = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe"));
	driver.switchTo().frame(frame3);
	driver.switchTo().frame("frame2");
	driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	
	
	}

}
