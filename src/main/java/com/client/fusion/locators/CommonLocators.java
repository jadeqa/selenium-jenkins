package com.client.fusion.locators;

import org.openqa.selenium.By;

public interface CommonLocators {

	By notificationsIcon = By.xpath("//a[contains(.,'Notifications')]");
	By searchBoxInNotification = By.xpath("//input[contains(@placeholder,'Enter search terms')]");
	By searchButtonInNotification = By.xpath("//button[contains(@title,'Search')]");
	By approveButtonInNotification = By.xpath("//a[text()='Approve']");
	By rejectButtonInNotification = By.xpath("//a[text()='Reject']");

}
