package selaniumsecondprogram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoBlaze {

	static String chromePath, site;
	static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		chromePath= System.getProperty("user.dir")+"\\chromedriver.exe";

		
		driver = new ChromeDriver();
		driver.navigate().to("https://www.demoblaze.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {

		driver.findElement(By.id("signin2")).click();
		driver.findElement(By.cssSelector("input[id=sign-username]")).sendKeys("AbuthahirM");
		driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys("AbuthahirM@123");
		
		driver.findElement(By.xpath("//button[@onclick='register()']")).click();
     
        
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.cssSelector("input[id=loginusername]")).sendKeys("AbuthahirM");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("AbuthahirM@123");
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();

	}

	@Test(priority = 3)
	public void contact() throws InterruptedException {

		driver.findElement(By.xpath("//a[@data-target='#exampleModal']")).click();
		driver.findElement(By.cssSelector("input[id=recipient-email]")).sendKeys("abu@gmail.com");
		driver.findElement(By.cssSelector("input[id=recipient-name]")).sendKeys("Abuthahir");
		driver.findElement(By.id("message-text")).sendKeys("Query raising");
		driver.findElement(By.xpath("//button[@onclick='send()']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}

	@Test(priority = 4)
	public void addCart() throws InterruptedException {
		driver.findElement(By.className("nav-link")).click();
		driver.findElement(By.xpath("//img[@src='imgs/Lumia_1520.jpg']")).click();
		driver.findElement(By.xpath("//a[@onclick='addToCart(2)']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[@id='cartur']")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//button[@data-target='#orderModal']")).click();
		driver.findElement(By.id("name")).sendKeys("Abuthahir");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Bengaluru");
		driver.findElement(By.id("card")).sendKeys("Master");
		driver.findElement(By.id("month")).sendKeys("October");
		driver.findElement(By.id("year")).sendKeys("2020");
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();

		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		driver.close();
	}
}
