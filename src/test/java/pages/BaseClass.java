package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public String readPropertyFile(String value) throws IOException {
		Properties prop = new Properties();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\configuration\\Config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}

	public void loginToApplication() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String URL = readPropertyFile("URL");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
