package week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactsWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		Thread.sleep(1000);
		
		//4.Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//5.Click on contacts Button
		driver.findElement(By.partialLinkText("Contacts")).click();
		Thread.sleep(1000);
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[4]")).click();
		
		String intialTitle = driver.getTitle();
		System.out.println(intialTitle);
		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		// window handles
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window= new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		Thread.sleep(3000);
		
		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		driver.switchTo().window(windowHandle);//moving to parent page
		
		//8. Click on Widget of To Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		//window handles
		String windowHandle1 = driver.getWindowHandle();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> window1= new ArrayList<String>(windowHandles1);
		driver.switchTo().window(window1.get(1));
		Thread.sleep(3000);
		
		//10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(windowHandle1);//moving to parernt handle
		
		Thread.sleep(2000);
		//  11. Click on Merge button using Xpath Locator
		//driver.findElement(By.partialLinkText("Merge")).click();
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(6000);
		
		//13. Verify the title of the page
			String Finaltitle = driver.getTitle();
			System.out.println(Finaltitle);
			/*if(Finaltitle.contains(intialTitle))
			{
				System.out.println("the title is validated");
			}
			else
			{
				System.out.println("The title is not validated");
			}*/
			
			
	}

}
