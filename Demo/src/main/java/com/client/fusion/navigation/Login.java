package com.client.fusion.navigation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.client.fusion.generic.GenericDeclarations;
import com.client.xenon.framework.Constants;
import com.client.xenon.framework.DemoAutomation;
import com.xenon.core.framework.Xenon;

/**
 * 
 * @author abhijeet.kulkarni
 * @purpose Login test case
 *
 */
public class Login extends DemoAutomation implements GenericDeclarations {

	private By userIDField = By.id("userid");
	private By passwordField = By.id("password");
	private By oracleHomeIcon = By.xpath("(//a[@title='Home'])[1]");
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public void login(String username, String password) {

		// setting timeout to check if already logged in
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//System.getProperties()
		try {

			driver.get(Constants.ApplicationURL);

			timer.pageLoad();

			try {
				if (driver.findElements(By.xpath("//div[@id='pt1:_UISpb2::content']")).size() > 0) {
					logOutOfApplication("abhijeet kulkarni");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// resetting timeout to check
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Xenon.configProperties.get("DEFAULTTIME")),
					TimeUnit.SECONDS);

			element.visibilityOfElementLocated(userIDField);
			textbox.setValue(userIDField, username);
			report.logs("Enter username", username, "PASS", "Username field", screenShotType.BROWSER);
			textbox.setValue(passwordField, password);
			report.logs("Enter password", password, "PASS", "Password field", screenShotType.BROWSER);
			driver.findElement(passwordField).sendKeys(Keys.ENTER);
			report.logs("Clicked on Login button", password, "PASS", "Login button", screenShotType.BROWSER);
			timer.pageLoad();

			if (element.isDisplayed(oracleHomeIcon)) {
				Assert.assertTrue(true, "Logged in Successfully");
			} else {
				Assert.assertFalse(false, "Not logged in successfully / Welcome text is changed");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void login(WebDriver driver, String username, String password) {
		try {
			driver.get(Constants.ApplicationURL);
			timer.pageLoad();
			driver.findElement(userIDField).sendKeys(username);

			report.logs("Enter username", username, "PASS", "Username field", screenShotType.BROWSER);
			driver.findElement(passwordField).sendKeys(password);
			report.logs("Enter password", password, "PASS", "Password field", screenShotType.BROWSER);
			driver.findElement(passwordField).sendKeys(Keys.ENTER);
			report.logs("Clicked on Login button", password, "PASS", "Login button", screenShotType.BROWSER);

			timer.pageLoad();
			if (driver.findElement(oracleHomeIcon).isDisplayed()) {
				Assert.assertTrue(true, "Logged in Successfully");
			} else {
				Assert.assertFalse(false, "Not logged in successfully / Welcome text is changed");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void logOutOfApplication(String username) {
		try {

			driver.get(Constants.ApplicationURL);
			timer.pageLoad();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='pt1:_UISpb2::content']")));
			genMethods.waitForElementTobeClickable(By.xpath("//div[@id='pt1:_UISpb2::content']"));
			driver.findElement(By.xpath("//div[@id='pt1:_UISpb2::content']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Sign Out')]")));
			element.fluentWaitForElement(By.xpath("//a[contains(.,'Sign Out')]"));
			element.elementToBeClickable(By.xpath("//a[contains(.,'Sign Out')]"));
			driver.findElement(By.xpath("//a[contains(.,'Sign Out')]")).click();
			timer.pageLoad();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,' Confirm')]")));
			driver.findElement(By.xpath("//button[contains(.,' Confirm')]")).click();
			timer.pageLoad();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logOutOfApplication(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.get(Constants.ApplicationURL);
			timer.pageLoad();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@id,'_UIScmil2u')]/..")));
			genMethods.waitForElementTobeClickable(driver, By.xpath("//img[contains(@id,'_UIScmil2u')]/.."));
			driver.findElement(By.xpath("//img[contains(@id,'_UIScmil2u')]/..")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Sign Out')]")));
			genMethods.waitForElementTobeClickable(driver, By.xpath("//a[contains(.,'Sign Out')]"));
			driver.findElement(By.xpath("//a[contains(.,'Sign Out')]")).click();
			timer.pageLoad();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,' Confirm')]")));
			genMethods.waitForElementTobeClickable(driver, By.xpath("//button[contains(.,' Confirm')]"));
			driver.findElement(By.xpath("//button[contains(.,' Confirm')]")).click();
			timer.pageLoad();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}