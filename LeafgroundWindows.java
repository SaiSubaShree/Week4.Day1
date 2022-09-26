package week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.leafground.com/window.xhtml");

//Click and Confirm new Window Opens
driver.findElement(By.xpath("//span[text()='Open']")).click();
Set<String> windowHandles = driver.getWindowHandles();
List <String> window= new ArrayList<String>(windowHandles);
driver.switchTo().window(window.get(1));
Thread.sleep(4000);
driver.close();
driver.switchTo().window(window.get(0));

//Find the number of opened tabs

driver.findElement(By.xpath("//h5[text()='Find the number of opened tabs']/following-sibling::button")).click();
Set<String> windowHandles1 = driver.getWindowHandles();
List <String> window1= new ArrayList<String>(windowHandles1);

int size = window1.size();
System.out.println("The size of the window" +size);
driver.switchTo().window(window.get(0));

//Close all windows except Primary
String windowHandle3 = driver.getWindowHandle();
driver.findElement(By.xpath("//h5[text()='Close all windows except Primary']/following-sibling::button")).click();
Set<String> windowHandles2 = driver.getWindowHandles();
List <String> window2= new ArrayList<String>(windowHandles2);
int size2 = window2.size();
System.out.println("The size of multiple window "+size2);
for(int i=5;i<window2.size();i--)
{
	if(i==0)
	{
		driver.switchTo().window(window.get(i));
		break;
	}
	driver.switchTo().window(window2.get(i));
	driver.close();
	Thread.sleep(1000);
	
}

//Wait for 2 new tabs to open
driver.findElement(By.xpath("//h5[text()='Wait for 2 new tabs to open']/following-sibling::button")).click();
Thread.sleep(5000);
Set<String> windowHandles3 = driver.getWindowHandles();
List <String> window3= new ArrayList<String>(windowHandles3);
for(int i=0;i<window3.size();i++)
{
driver.switchTo().window(window3.get(i));
String title = driver.getTitle();
System.out.println(title);
}






	}

}
