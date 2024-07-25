package Task21;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question3 {

	public static void main(String[] args) throws InterruptedException, Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		//switching to frame
		
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
				Thread.sleep(300);
				
				// Find all frames within the top frame
		        List<WebElement> topFrames = driver.findElements(By.tagName("frame"));

		        // Verify the number of frames in the top frame
		        if (topFrames.size() == 3) {
		            System.out.println("There are 3 frames in the top frame.");
		        } else {
		            System.out.println("There are not 3 frames in the top frame. Found: " + topFrames.size());
		        }
				
				//finding element in that frame(left)
				driver.switchTo().frame("frame-left");
				
				// Get the text from the left frame
				WebElement leftFrameBody = driver.findElement(By.tagName("body"));
		        System.out.println("Left frame text: " + leftFrameBody.getText());
				
		        //switching back to top frame
		        driver.switchTo().parentFrame();
		        
				
		       //finding element in that frame(middle)
		        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		        
		       // Get the text from the middle frame
				WebElement middleFrameBody = driver.findElement(By.id("content"));
		        System.out.println("Middle frame text: " + middleFrameBody.getText());
		        
		      //switching back to top frame
		        driver.switchTo().parentFrame();
		        
		        //finding element of right frame
		        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']"))); 
		        
		        //Get text from right frame body and print
		        WebElement rightFrameBody = driver.findElement(By.tagName("body"));
		        System.out.println("Right frame text: " + rightFrameBody.getText());
		        
		        //Switching back to top frame
		        driver.switchTo().defaultContent();
		        
		        //finding element of bottom frame
		        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
		        
		        //Get text of bottom frame and printing it
		        WebElement bottomFrameBody = driver.findElement(By.tagName("body"));
		        System.out.println("Bottom frame text: " + bottomFrameBody.getText());
		       
		        driver.switchTo().defaultContent();
		        
		        String Title = driver.getCurrentUrl();
		        
		        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        File destinationFile = new File("./screenshot3/img.png");
				
				FileHandler.copy(screenshot, destinationFile);
		        
		       if (Title.equals("https://the-internet.herokuapp.com/nested_frames")) {
		    	   System.out.println("Page Title is Frames");
		       } else {
		    	   System.out.println("Page Title is not Frames" + ",It is: "+ Title);
		       }
		        
		        driver.quit();
		        
	}

}
