package Log4j;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_launched2 {
	
public static  WebDriver driver;
public static Logger log= LogManager.getLogger(Browser_launched2.class);

	public static void main(String[] args) throws InterruptedException  {

		log.info("execution is being started");
		WebDriverManager.chromedriver().setup();
		log.info("launched driver");
		
		driver= new ChromeDriver();
		log.info("calling chrome browser");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.myntra.com/");
		
		
		try {
			driver.findElement(By.linkText("Women")).isDisplayed();
			driver.findElement(By.linkText("Women")).click();
			log.info("women is clicked");
			
		} catch (Exception e) {
			log.error("exception is found", new Exception("element is not found"));
			
		}
		finally {
			Thread.sleep(3000);
			driver.close();
		}
	}

}
