package Task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question1 {

	public static void main(String[] args) {
		// Task 21 , Q.1
		//There is no access to edit anything inside the frame as the page has 
		//only Read-only access
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		
		driver.findElement(By.xpath("//iframe[@class='tox-edit-area__iframe']")).sendKeys("Hello people");

	}

}
