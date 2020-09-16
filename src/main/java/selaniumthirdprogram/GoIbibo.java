package selaniumthirdprogram;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoIbibo {

	WebDriver driver;

	@BeforeMethod
	public void site() {
		String chromeDriverPath = System.getProperty("user.dir") + "\\chromedriver.exe";

		driver = new ChromeDriver();
		driver.navigate().to("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement signin = driver.findElement(By.xpath("//a[@id='get_sign_in']"));
		signin.click();

		driver.switchTo().frame("authiframe");
		WebElement facebook = driver.findElement(By.xpath("//button[@id='authFBSignInBtn']"));

		facebook.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("musthafaabuthahir24@gmail.com");

				driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Allahuakbar@786");
				driver.findElement(By.xpath("//input[@name='login']")).click();
				driver.close();

			}

		}
		driver.switchTo().window(parent);

	}

	@Test(priority = 2)
	public void book() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("roundTrip")).click();

		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("Chennai");

		from.sendKeys(Keys.ARROW_DOWN);

		from.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.xpath("//input[@placeholder='Destination']"));
		to.sendKeys("Mumbai");
		to.sendKeys(Keys.ARROW_DOWN);

		to.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@id='departureCalendar']")).sendKeys("09172020");

		driver.findElement(By.xpath("//input[@id='returnCalendar']")).sendKeys("09202020");

		driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();
		driver.findElement(By.xpath("//button[@id='adultPaxPlus']")).click();

		WebElement travel = driver.findElement(By.xpath("//select[@id='gi_class']"));
		Select dropdown = new Select(travel);
		dropdown.selectByValue("F");
		driver.findElement(By.xpath("//button[@value='Search']")).click();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
