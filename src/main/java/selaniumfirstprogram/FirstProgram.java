package selaniumfirstprogram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class FirstProgram {

	static String chromePath, url;
	static WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("FirstProgram Class is ready to test...");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("FirstProgram Class is tested..!");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Testing begins......");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Testing ends......!");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("gurutest method is executing....");
		chromePath= System.getProperty("user.dir")+"\\chromedriver.exe";
		
		url = "http://demo.guru99.com/test/login.html";

	}

	@Test
	public void guruTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("email")).sendKeys("abu@gmail.com");
	
		driver.findElement(By.cssSelector("input[id=passwd]"));
		driver.findElement(By.name("SubmitLogin")).click();

		Thread.sleep(3000);

	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("gurutest method execution Completed..!");
		driver.close();
	}

}
