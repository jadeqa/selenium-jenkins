package com.client.fusion.generic;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.client.fusion.locators.CommonLocators;
import com.client.fusion.locators.PurchaseRequisitionLocators;
import com.client.xenon.framework.DemoAutomation;
import com.xenon.core.framework.Xenon;

import action.core.ActionPerformer;

public class GenericMethods extends DemoAutomation implements CommonLocators, PurchaseRequisitionLocators {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	public void openNotificationIcon() {
		element.elementToBeClickable(notificationsIcon);
		driver.findElement(notificationsIcon).click();
		timer.pause(3);
		report.logs("Clicked on Notifications icon", "Click", "PASS", "Notification icon", screenShotType.BROWSER);
		element.elementToBeClickable(searchBoxInNotification);

	}

	public void searchForValueInNotifications(String value) {
		waitForElementTobeClickable(searchBoxInNotification);
		driver.findElement(searchBoxInNotification).clear();
		driver.findElement(searchBoxInNotification).sendKeys(value);
		report.logs("Entered invoice number to search", value + "", "PASS", "Search box", screenShotType.BROWSER);
		driver.findElement(searchButtonInNotification).click();
		timer.pause(3);
		report.logs("Requisition status", value + "", "PASS", "Search box", screenShotType.BROWSER);

	}

	public void clickOnApproveInNotifications() {
		element.elementToBeClickable(approveButtonInNotification);
		waitForElementTobeClickable(approveButtonInNotification);
		timer.pause(3);
		driver.findElement(approveButtonInNotification).click();
		report.logs("Clicked on Approve button", "Click", "PASS", "Approve button", screenShotType.BROWSER);
		timer.pause(3);
		report.logs("Approved Successfully", "Click", "PASS", "Approve button", screenShotType.BROWSER);
	//	element.invisibilityOfElementLocated(approveButtonInNotification);
	}
	
	public void clickOnRejectInNotifications() {
		element.elementToBeClickable(rejectButtonInNotification);
		waitForElementTobeClickable(rejectButtonInNotification);
		timer.pause(3);
		driver.findElement(rejectButtonInNotification).click();
		report.logs("Clicked on Reject button", "Click", "PASS", "Reject button", screenShotType.BROWSER);
		element.invisibilityOfElementLocated(rejectButtonInNotification);
	}

	/**
	 * Searches a string in Search and Select form The method assumes application is
	 * already navigated to Search and Select form
	 * 
	 * @param searchFormTitle    Title of the Search and Select form ex. "Search and
	 *                           Select: Receipt Method"
	 * @param searchFormInputBy  Input box on the form
	 * @param searchString       Item to search
	 * @param itemStringToSelect Item to select (usually same as searchString)
	 * @throws Exception
	 */
	public static void searchForAnItemInSearchAndSelectForm(final String searchFormTitle, final By searchFormInputBy,
			final String searchString, final String itemStringToSelect) throws Exception {

		// Locators in Search form for Search button, OK button and Option in table to
		// select
		final By searchFormSearchButton = By.xpath(MessageFormat.format(
				"//*[normalize-space(text())=''{0}'']/following::button[normalize-space(text())=''Search'']",
				searchFormTitle));
		final By searchFormOKButton = By.xpath(MessageFormat.format(
				"//*[normalize-space(text())=''{0}'']/following::button[normalize-space(text())=''OK'']",
				searchFormTitle));
		final By searchFormOptionToSelect = By.xpath(MessageFormat.format(
				"//*[normalize-space(text())=''{0}'']/following::*[normalize-space(text())=''{1}'']", searchFormTitle,
				itemStringToSelect));

		// Perform sequence of actions to Search an item in search form
		new ActionPerformer(driver).waitTime(1).clearFieldAndEnterText(searchFormInputBy, searchString).waitTime(1)
				.click(searchFormSearchButton).waitTime(1).click(searchFormOptionToSelect).waitTime(1)
				.click(searchFormOKButton).waitTime(1);

	}

	/**
	 * Resets driver's implicit timeout to the default time specified in
	 * configurations
	 */
	public static void resetDriverTimeout() {
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Xenon.configProperties.get("DEFAULTTIME")),
				TimeUnit.SECONDS);
	}

	/**
	 * Sets driver's implicit timeout
	 * @param timeout timeout value in seconds
	 */
	public static void setDriverTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void waitForElementTobeClickable(By element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void waitForElementTobeClickable(WebDriver ffDriver, By element) {

		WebDriverWait newwait = new WebDriverWait(ffDriver, 30);
		try {
			newwait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
