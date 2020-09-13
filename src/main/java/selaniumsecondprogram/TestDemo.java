/*package selaniumsecondprogram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo {
	
    static WebDriver driver;
	@BeforeClass
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.demoblaze.com");
		driver.manage().window().maximize();

	}
	   @Test(priority=1)
		public void addCart() throws InterruptedException
		{
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.className("nav-link")).click();
		    driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		    driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/a")).click();
		  
			Thread.sleep(2000);
			 driver.switchTo().alert().accept();
			 Thread.sleep(2000);
			
			
		}
	   @Test(priority=2)
	   public void validate() throws InterruptedException
	   {
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.findElement(By.id("cartur")).click();
			 Thread.sleep(10000);
			 driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
			 driver.findElement(By.id("name")).sendKeys("Abuthahir");
			 driver.findElement(By.id("country")).sendKeys("India");
			 driver.findElement(By.id("city")).sendKeys("Bengaluru");
			 driver.findElement(By.id("card")).sendKeys("Master");
			 driver.findElement(By.id("month")).sendKeys("October");
			 driver.findElement(By.id("year")).sendKeys("2020");
			 driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
			 Thread.sleep(2000);
			
			 driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
			 Thread.sleep(2000);
	   }

	   @AfterClass
		public void afterMethod() throws InterruptedException {

			driver.close();
		}
	}
*/
