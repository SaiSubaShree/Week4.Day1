package week4.Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsLeafGround {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
driver.manage().window().maximize();

//Alert (Simple Dialog)
driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following-sibling::button")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
Thread.sleep(2000);

//Alert (Confirm Dialog)
driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button")).click();
Alert alert2 = driver.switchTo().alert();
alert2.dismiss();
Thread.sleep(1000);

//Sweet Alert (Simple Dialog)
driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following-sibling::button")).click();
driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
Thread.sleep(2000);

/*//Sweet Modal Dialog 
driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following-sibling::button")).click();
WebElement ele = driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following-sibling::a"));
Actions builder=new Actions(driver);
builder.moveToElement(ele).click().perform();*/

// Alert (Prompt Dialog)  
driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button")).click();
Alert alert3 = driver.switchTo().alert();
alert3.sendKeys("sai");
alert3.accept();

//Sweet Alert (Confirmation)
driver.findElement(By.xpath("//span[text()='Delete']")).click();
driver.findElement(By.xpath("//span[text()='Yes']")).click();

//minimise and maximise
driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']/following-sibling::button")).click();
driver.findElement(By.xpath("(//span[text()='Min and Max']/following-sibling::a)[3]")).click();



	}

}
