package stepDefination;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BaseClass;

public class HomePage extends BaseClass {

	@Given("navigate to home page")
	public void navigate_to_home_page() throws Exception {

		loginToApplication();

	}

	@When("user logged in application using username as {string} and password as {string}")
	public void user_logged_in_application_using_username_as_and_password_as(String UserName, String Password)
			throws IOException {

		driver.findElement(By.xpath(readPropertyFile("userNameField"))).sendKeys(UserName);
		driver.findElement(By.xpath(readPropertyFile("passwordField"))).sendKeys(Password);
		driver.findElement(By.xpath(readPropertyFile("loginButon"))).click();

	}

	@Then("validate amount values sort")
	public void validate_amount_values_sort() throws IOException {

		driver.findElement(By.xpath(readPropertyFile("amountHeader"))).click();
		List<WebElement> tdList = driver.findElements(By.xpath(readPropertyFile("amountValues")));
		String strArry[] = new String[tdList.size()];
		for (int i = 0; i < tdList.size(); i++) {
			strArry[i] = tdList.get(i).getText();
		}

		boolean sortFunctionality = true;
		outer: for (int i = 0; i < strArry.length; i++) {
			for (int j = i + 1; j < i; j++) {
				int result = strArry[j].compareTo(strArry[i]);
				if (!(result > 0)) {
					System.out.println("Data in the Table is not SORTED::" + strArry[j] + ":::" + strArry[i]);
					sortFunctionality = false;
					break outer;
				} else {
					System.out.println("Data in the Table is SORTED::" + strArry[j] + ":::" + strArry[i]);
				}
			}
		}

		if (sortFunctionality) {
			System.out.println("SORT Functionality is working");
		} else {
			System.out.println("SORT Functionality is not working");
		}
		driver.quit();

	}

}
