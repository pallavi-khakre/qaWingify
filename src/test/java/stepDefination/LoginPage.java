package stepDefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BaseClass;

public class LoginPage extends BaseClass {

	@Given("navigate to login page")
	public void navigate_to_login_page() throws Exception {

		loginToApplication();

	}

	@When("user logged in using username as {string} and password as {string}")
	public void user_logged_in_using_username_as_and_password_as(String UserName, String Password) throws IOException {

		driver.findElement(By.xpath(readPropertyFile("userNameField"))).sendKeys(UserName);
		driver.findElement(By.xpath(readPropertyFile("passwordField"))).sendKeys(Password);
		driver.findElement(By.xpath(readPropertyFile("loginButon"))).click();

	}

	@Then("home page should be displayed")
	public void home_page_should_be_displayed() throws IOException {

		String exprectedResult = "DEMO";
		String actualResult = driver.findElement(By.xpath(readPropertyFile("homePageText"))).getText();
		Assert.assertEquals(exprectedResult, actualResult);
		driver.quit();
	}

	@Then("verify error message")
	public void verify_error_message() throws IOException {

		String exprectedResult = "Both Username and Password must be present";
		String actualResult = driver.findElement(By.xpath(readPropertyFile("errorBannerBlankValues"))).getText();
		Assert.assertEquals(exprectedResult, actualResult);
		driver.quit();

	}

	@When("user click on Remember Me checkbox")
	public void user_click_on_remember_me_checkbox() throws IOException {

		driver.findElement(By.xpath(readPropertyFile("checkBox"))).click();
	}

	@Then("validate checkbox")
	public void validate_checkbox() throws IOException {

		boolean checkbox = driver.findElement(By.xpath(readPropertyFile("checkBox"))).isSelected();
		Assert.assertTrue(checkbox);
		driver.quit();

	}

	@Then("verify error message if UserName is blank")
	public void verify_error_message_if_UserName_is_blank() throws IOException {

		String exprectedResult = "Username must be present";
		String actualResult = driver.findElement(By.xpath(readPropertyFile("errorBannerBlankValues"))).getText();
		Assert.assertEquals(exprectedResult, actualResult);
		driver.quit();

	}

	@Then("verify error message if Password is blank")
	public void verify_error_message_if_Password_is_blank() throws IOException {

		String exprectedResult = "Password must be present";
		String actualResult = driver.findElement(By.xpath(readPropertyFile("errorBannerBlankValues"))).getText();
		Assert.assertEquals(exprectedResult, actualResult);
		driver.quit();

	}

}
