package Task21;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question2 {

	public static void main(String[] args) throws Exception {
		// Task21, Q.2
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		String Actualtext = "New Window";
		Thread.sleep(300);
		
		WebElement expectedtext = driver.findElement(By.className("example"));
		
		if(Actualtext.equals(expectedtext)) {
			System.out.println("failed: New Window not opened");
		} else {
			System.out.println("passed: New window opened");
		}    
		 // Get all the window handles
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		// Switch to the second tab
		driver.switchTo().window(tabs.get(1));
        
       // Close the second tab
        driver.close();
        
        //switch back to first tab
        driver.switchTo().window(tabs.get(0));
        
        String expectedActiveWindow = "https://the-internet.herokuapp.com/windows" ;
        
        String actualActiveWindow = driver.getCurrentUrl();
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("./screenshot2/img.png");
		
		FileHandler.copy(screenshot, destinationFile);
        
        if(expectedActiveWindow.equals(actualActiveWindow)) {
        	System.out.println("Orginal window is active");
        } else {
        		System.out.println("Orginal window is not active");
        	}
        
        driver.close();

	}

}
