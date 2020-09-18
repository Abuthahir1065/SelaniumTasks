package selenium.goibibo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
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
import org.w3c.dom.Document;

public class GoIbibo {

	WebDriver driver;
	Properties prop;
	Properties data;

	@BeforeMethod
	public void site() throws IOException {
		String chromeDriverPath = System.getProperty("user.dir") + "\\chromedriver.exe";
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\SeleniumProject\\Project\\locators.properties");
		prop = new Properties();
		prop.load(file);
		FileInputStream dataFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\SeleniumProject\\Project\\data.properties");

		data = new Properties();
		data.load(dataFile);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement signin = driver.findElement(By.xpath(prop.getProperty("XpathSignIn")));
		signin.click();

		driver.switchTo().frame("authiframe");
		WebElement facebook = driver.findElement(By.xpath(prop.getProperty("XpathfbSignIn")));

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
				driver.findElement(By.xpath(prop.getProperty("XpathEmail"))).sendKeys(data.getProperty("Email"));

				driver.findElement(By.xpath(prop.getProperty("Xpathpassword"))).sendKeys(data.getProperty("Password"));
				driver.findElement(By.xpath(prop.getProperty("emailLoginXpath"))).click();
				driver.close();

			}

		}
		driver.switchTo().window(parent);

	}

	@Test(priority = 2)
	public void book() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id(prop.getProperty("RoundTrip_Id"))).click();

		WebElement from = driver.findElement(By.xpath(prop.getProperty("FromXpath")));
		from.sendKeys(data.getProperty("From"));

		from.sendKeys(Keys.ARROW_DOWN);

		from.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.xpath(prop.getProperty("ToXpath")));
		to.sendKeys(data.getProperty("To"));
		to.sendKeys(Keys.ARROW_DOWN);

		to.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath(prop.getProperty("XpathDepart"))).sendKeys(data.getProperty("Departure"));

		driver.findElement(By.xpath(prop.getProperty("XpathReturn"))).sendKeys(data.getProperty("Return"));

		driver.findElement(By.xpath(prop.getProperty("TravellerXpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("QuantityXpath"))).click();

		WebElement travel = driver.findElement(By.xpath(prop.getProperty("TravelSelectXpath")));
		Select dropdown = new Select(travel);
		dropdown.selectByValue("F");
		driver.findElement(By.xpath(prop.getProperty("SearchXpath"))).click();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
