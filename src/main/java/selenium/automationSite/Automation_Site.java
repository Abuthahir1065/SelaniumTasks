package selenium.automationSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class Automation_Site {
	WebDriver driver;

	@BeforeMethod
	public void properties() {
		String chromePath = System.getProperty("user.dir") + "\\chromedriver.exe";
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void fillform() throws InterruptedException {
		WebElement f_name = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
		f_name.sendKeys("Abuthahir");
		WebElement s_name = driver.findElement(By.xpath("//input[@ng-model='LastName']"));
		s_name.sendKeys("Musthafa");
		WebElement address = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		address.sendKeys("31,Rajiv nagar 5th street\nSamundipuram\nTirupur-641603");
		WebElement mail = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
		mail.sendKeys("musthafaabuthahir24@gmail.com");
		WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
		phone.sendKeys("9390025185");
		WebElement radio = driver.findElement(By.xpath("//input[@value='Male']"));
		radio.click();
		WebElement checkbox = driver.findElement(By.id("checkbox2"));
		checkbox.click();

		WebElement language = driver.findElement(By.xpath("//div[@id='msdd']"));
		language.click();
		driver.findElement(By.xpath("//a[contains(text(),'Arabic')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
		WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));

		Select dropdown = new Select(skills);
		dropdown.selectByValue("CSS");

		WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));

		Select option = new Select(country);
		option.selectByValue("India");

		WebElement combobox = driver.findElement(By.xpath("//span[@role='combobox']"));
		combobox.click();

		WebElement selectValue = driver.findElement(By.xpath("//input[@type='search']"));
		selectValue.sendKeys("India");
		driver.findElement(By.xpath("//input[@type='search']")).click();

		Actions click = new Actions(driver);

		click.sendKeys(Keys.ENTER).perform();

		WebElement year = driver.findElement(By.xpath("//select[@id='yearbox']"));

		Select selectYear = new Select(year);
		selectYear.selectByValue("2015");

		WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));

		Select selectMonth = new Select(month);
		selectMonth.selectByValue("October");

		WebElement day = driver.findElement(By.xpath("//select[@id='daybox']"));

		Select selectDay = new Select(day);
		selectDay.selectByValue("15");

		Thread.sleep(3000);

		WebElement password = driver.findElement(By.xpath("//input[@id='firstpassword']"));
		password.sendKeys("Abu@123");

		WebElement confirm = driver.findElement(By.xpath("//input[@id='secondpassword']"));
		confirm.sendKeys("Abu@123");
		WebElement submit = driver.findElement(By.xpath("//button[@id='submitbtn']"));
		submit.click();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
