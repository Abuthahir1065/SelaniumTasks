package selenium.automationSite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
	Properties Locators;
	Properties Data;

	@BeforeMethod
	public void properties() throws IOException {
		String chromePath = System.getProperty("user.dir") + "\\chromedriver.exe";
		FileInputStream locator = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//java//SeleniumProject//Project//siteLocators.properties");
		Locators = new Properties();
		Locators.load(locator);
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//SeleniumProject//Project//siteData.properties");
		Data = new Properties();
		Data.load(data);
		
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void fillform() throws InterruptedException {
		WebElement f_name = driver.findElement(By.xpath(Locators.getProperty("FirstNameXpath")));
		f_name.sendKeys(Data.getProperty("FirstName"));
		WebElement s_name = driver.findElement(By.xpath(Locators.getProperty("LastNameXpath")));
		s_name.sendKeys(Data.getProperty("LastName"));
		WebElement address = driver.findElement(By.xpath(Locators.getProperty("TextAreaXpath")));
		address.sendKeys(Data.getProperty("Address"));
		WebElement mail = driver.findElement(By.xpath(Locators.getProperty("MailXpath")));
		mail.sendKeys(Data.getProperty("Email"));
		WebElement phone = driver.findElement(By.xpath(Locators.getProperty("PhoneNoXpath")));
		phone.sendKeys(Data.getProperty("PhoneNo"));
		WebElement radio = driver.findElement(By.xpath(Locators.getProperty("GenderXpath")));
		radio.click();
		WebElement hobbies = driver.findElement(By.id(Locators.getProperty("HobbiesId")));
		hobbies.click();

		WebElement language = driver.findElement(By.xpath(Locators.getProperty("LanguageXpath")));
		language.click();
		driver.findElement(By.xpath(Locators.getProperty("ArabicXpath"))).click();
		driver.findElement(By.xpath(Locators.getProperty("EnglisgXpath"))).click();
		WebElement skills = driver.findElement(By.xpath(Locators.getProperty("SkillsXpath")));

		Select dropdown = new Select(skills);
		dropdown.selectByValue(Locators.getProperty("SkillsValue"));

		WebElement country = driver.findElement(By.xpath(Locators.getProperty("CountryXpath")));

		Select option = new Select(country);
		option.selectByValue(Locators.getProperty("CountryValue"));

		WebElement countryCombobox = driver.findElement(By.xpath(Locators.getProperty("CountryComboBoxXpath")));
		countryCombobox.click();

		WebElement selectValue = driver.findElement(By.xpath(Locators.getProperty("SelectValueXpath")));
		selectValue.sendKeys(Locators.getProperty("SelectedValue"));
		driver.findElement(By.xpath(Locators.getProperty("ValueXpath"))).click();

		Actions click = new Actions(driver);

		click.sendKeys(Keys.ENTER).perform();

		WebElement year = driver.findElement(By.xpath(Locators.getProperty("YearXpath")));

		Select selectYear = new Select(year);
		selectYear.selectByValue(Locators.getProperty("SelectedYear"));

		WebElement month = driver.findElement(By.xpath(Locators.getProperty("MonthXpath")));

		Select selectMonth = new Select(month);
		selectMonth.selectByValue(Locators.getProperty("SelectedMonth"));

		WebElement day = driver.findElement(By.xpath(Locators.getProperty("DayXpath")));

		Select selectDay = new Select(day);
		selectDay.selectByValue(Locators.getProperty("SelectedDay"));

		Thread.sleep(3000);

		WebElement password = driver.findElement(By.xpath(Locators.getProperty("PasswordXpath")));
		password.sendKeys("Abu@123");

		WebElement confirm = driver.findElement(By.xpath(Locators.getProperty("PasswordConfirmXpath")));
		confirm.sendKeys("Abu@123");
		WebElement submit = driver.findElement(By.xpath(Locators.getProperty("SubmitButton")));
		submit.click();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
