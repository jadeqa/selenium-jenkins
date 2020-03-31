package com.client.xenon.operations;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.xenon.core.framework.Xenon;

public class PageObjects extends Xenon {

	public void login(String username, String password) {

		// setting timeout to check if already logged in
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {

			driver.get("https://login.salesforce.com/");

			timer.pageLoad();

			// resetting timeout to check
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Xenon.configProperties.get("DEFAULTTIME")),
					TimeUnit.SECONDS);

			element.visibilityOfElementLocated(By.name("username"));
			textbox.setValue(By.name("username"), username);
			report.logs("Enter username", username, "PASS", "Username field", screenShotType.BROWSER);
			textbox.setValue(By.name("pw"), password);
			report.logs("Enter password", password, "PASS", "Password field", screenShotType.BROWSER);
			driver.findElement(By.name("pw")).sendKeys(Keys.ENTER);
			report.logs("Clicked on Login button", password, "PASS", "Login button", screenShotType.BROWSER);
			timer.pageLoad();
			// element.click(signInButton);
			/*
			 * if (element.isDisplayed(By.xpath("(//span[contains(text(),'Home')])[1]"))) {
			 * Assert.assertTrue(true, "Logged in Successfully"); } else {
			 * Assert.assertFalse(false,
			 * "Not logged in successfully / Welcome text is changed"); }
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * public void scheduledMaintenance() { report.logs("scheduledMaintenance",
	 * "Click", "PASS", "Select template", screenShotType.BROWSER);
	 * element.fluentWaitForElement(By.xpath("//*[@id=\"header\"]/span"));
	 * element.click(By.xpath("//a[contains(text(),'Got it')]"));
	 * report.logs("scheduledMaintenance", "Click", "PASS", "Select template",
	 * screenShotType.BROWSER); timer.pageLoad(); }
	 */

	public void navigateToSales() {
		/*
		 * report.logs("Clicked on sales launcher", "Click", "PASS", "Select template",
		 * screenShotType.BROWSER); element.fluentWaitForElement(By.xpath(
		 * "//button[contains(@class,'salesforceIdentityAppLauncherHeader')]"));
		 * element.click(By.xpath(
		 * "//button[contains(@class,'salesforceIdentityAppLauncherHeader')]"));
		 * element.elementToBeClickable(By.xpath("//a[text()='Sales']"));
		 * element.click(By.xpath("//a[text()='Sales']"));
		 * report.logs("Clicked on sales", "Click", "PASS", "Select template",
		 * screenShotType.BROWSER); timer.pageLoad();
		 */
	}

	public void gotoAccounts() {
		driver.navigate().to("https://ap4.lightning.force.com/lightning/o/Account/list?filterName=Recent");
		timer.pageLoad();
	}

	public void gotoOpportunity() {

		element.fluentWaitForElement(By.xpath("//*[text()='Opportunities']"));
		element.elementToBeClickable(By.xpath("//*[text()='Opportunities']"));

		driver.navigate().to("https://ap4.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
		report.logs("Clicked on Opportunity", "Click", "PASS", "Select template", screenShotType.BROWSER);

		timer.pageLoad();

	}

	public void gotoCampaign() {
		driver.navigate().to("https://ap4.lightning.force.com/lightning/o/Campaign/list?filterName=Recent");
		timer.pageLoad();
	}

	public void createAccount() {
		try {

			Random random = new Random();
			int randomAccountNumber = random.nextInt(150000);
			timer.pause(5);
			element.fluentWaitForElement(By.xpath("//div[text()='New']/.."));
			element.elementToBeClickable(By.xpath("//div[text()='New']/.."));
			element.click(By.xpath("//div[text()='New']/.."));
			report.logs("Clicked on New", "Click", "PASS", "Select template", screenShotType.BROWSER);
			timer.pageLoad();
			String accountNumber = "New Account " + randomAccountNumber + "";
			textbox.setValue(By.xpath("//span[text()='Account Name']/../following-sibling::input"), accountNumber);
			report.logs("Entered Account", accountNumber, "PASS", "Select template", screenShotType.BROWSER);
			textbox.setValue(By.xpath("//span[text()='Account Number']/../following-sibling::input"),
					"76876876786876876");
			textbox.setValue(By.xpath("//span[text()='Account Site']/../following-sibling::input"), "San Jose");
			textbox.setValue(By.xpath("//span[text()='Employees']/../following-sibling::input"), "500");
			report.logs("Entered Empolyees", "500", "PASS", "Select template", screenShotType.BROWSER);
			element.click(By.xpath("(//span[text()='Save']/..)[2]"));
			timer.pause(4);
			// element.invisibilityOfElementLocated(By.xpath("(//span[text()='Save']/..)[2]"));
			report.logs("Clicked on save button", "save", "PASS", "Select template", screenShotType.BROWSER);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void createOpportunity() {
		try {

			Random random = new Random();
			int randomOpportunityNumber = random.nextInt(150000);

			element.elementToBeClickable(By.xpath("//div[text()='New']/.."));
			element.click(By.xpath("//div[text()='New']/.."));
			report.logs("Clicked on New", "Click", "PASS", "Select template", screenShotType.BROWSER);
			timer.pageLoad();
			String optyNumber = "New opportunity " + randomOpportunityNumber + "";
			textbox.setValue(By.xpath("//span[text()='Opportunity Name']/../following-sibling::input"), optyNumber);
			report.logs("Enterd opportunity value", "New opportunity_0909", "PASS", "Select template",
					screenShotType.BROWSER);
			textbox.setValue(By.xpath("//span[text()='Amount']/../following-sibling::input"), "76876876786876876");
			element.click(By.xpath("//span[contains(text(),'Date Picker')]/.."));
			element.elementToBeClickable(By.xpath("//span[text()='Today']"));
			element.click(By.xpath("//span[text()='Today']"));
			report.logs("Enterd date", "New opportunity_0909", "PASS", "Select template", screenShotType.BROWSER);
			driver.findElement(By.xpath("//span[text()='Stage']/../following-sibling::div//a")).click();

			timer.pause(4);
			driver.findElement(By.xpath("//a[contains(text(),'Prospecting')]")).click();
			report.logs("Select won typee", "Prospecting", "PASS", "Select template", screenShotType.BROWSER);
			element.click(By.xpath("(//span[text()='Save']/..)[2]"));
			element.invisibilityOfElementLocated(By.xpath("(//span[text()='Save']/..)[2]"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void createCampaign(String campaignName, String confType, String status, String expectedRevenue,
			String budgetedCost, String actualCost, String expectedReturn) {

		element.elementToBeClickable(By.xpath("//div[text()='New']/.."));
		element.click(By.xpath("//div[text()='New']/.."));
		report.logs("Clicked on New", "Click", "PASS", "Select template", screenShotType.BROWSER);
		timer.pageLoad();

		textbox.setValue(By.xpath("//span[contains(text(),'Campaign Name')]/parent::label/following-sibling::input"),
				campaignName);
		report.logs("Entered campaign name", campaignName, "PASS", "Select template", screenShotType.BROWSER);

		driver.findElement(By.xpath("//span[contains(text(),'Active')]/parent::label/following-sibling::input"))
				.click();
		report.logs("Selected campaign status", "Active", "PASS", "Select template", screenShotType.BROWSER);

		driver.findElement(By.xpath("//span[contains(text(),'Type')]/../following-sibling::div//a")).click();
		report.logs("Selecting conference type", "Active", "PASS", "Select template", screenShotType.BROWSER);

		driver.findElement(By.xpath("//a[contains(text(),'" + confType + "')]")).click();
		report.logs("Selecting conference type", confType, "PASS", "Select template", screenShotType.BROWSER);

		driver.findElement(By.xpath("//span[contains(text(),'Status')]/../following-sibling::div//a")).click();
		report.logs("Selecting status", "In Progress", "PASS", "Select template", screenShotType.BROWSER);

		driver.findElement(By.xpath("//a[contains(text(),'" + status + "')]")).click();

		// setting start date
		element.elementToBeClickable(
				By.xpath("//span[contains(text(),'Start Date')]/parent::label/following-sibling::div//a"));
		element.click(By.xpath("//span[contains(text(),'Start Date')]/parent::label/following-sibling::div//a"));
		element.elementToBeClickable(By.xpath("//button[contains(text(),'Today')]"));
		element.click(By.xpath("//button[contains(text(),'Today')]"));

		// setting end date
		element.elementToBeClickable(
				By.xpath("//span[contains(text(),'End Date')]/parent::label/following-sibling::div//a"));
		element.click(By.xpath("//span[contains(text(),'End Date')]/parent::label/following-sibling::div//a"));
		element.elementToBeClickable(By.xpath("//button[contains(text(),'Today')]"));
		element.click(By.xpath("//button[contains(text(),'Today')]"));

		textbox.setValue(By.xpath(
				"//span[contains(text(),'Expected Revenue in Campaign')]/parent::label/following-sibling::input"),
				expectedRevenue);
		report.logs("Entered expected revenue", expectedRevenue, "PASS", "Select template", screenShotType.BROWSER);

		textbox.setValue(
				By.xpath("//span[contains(text(),'Budgeted Cost in Campaign')]/parent::label/following-sibling::input"),
				budgetedCost);
		report.logs("Entered Budgeted Cost in Campaign", budgetedCost, "PASS", "Select template",
				screenShotType.BROWSER);

		textbox.setValue(
				By.xpath("//span[contains(text(),'Actual Cost in Campaign')]/parent::label/following-sibling::input"),
				actualCost);
		report.logs("Entered Actual Cost in Campaign", "3500", "PASS", "Select template", screenShotType.BROWSER);

		textbox.setValue(
				By.xpath("//span[contains(text(),'Expected Response')]/parent::label/following-sibling::input"),
				expectedReturn);
		report.logs("Entered Expected Response", "90", "PASS", "Select template", screenShotType.BROWSER);

		element.click(By.xpath("(//span[text()='Save']/..)[2]"));
		// element.invisibilityOfElementLocated(By.xpath("(//span[text()='Save']/..)[2]"));

	}

	public void createLeadFromCampaign(String salutation, String firstname, String lastname, String email,
			String mobile, String companyName) {
		timer.pause(5);

		element.elementToBeClickable(By.xpath("//a[contains(@title,'Show 8 more actions')]"));
		element.click(By.xpath("//a[contains(@title,'Show 8 more actions')]"));
		report.logs("Entered Actual Cost in Campaign", "3500", "PASS", "Select template", screenShotType.BROWSER);

		element.elementToBeClickable(By.xpath("//a[contains(@title,'New Lead')]"));
		element.click(By.xpath("//a[contains(@title,'New Lead')]"));

		element.elementToBeClickable(By.xpath("//a[contains(text(),'--None--')]"));
		element.click(By.xpath("//a[contains(text(),'--None--')]"));

		element.elementToBeClickable(By.xpath("//a[contains(@title,'" + salutation + "')]"));
		element.click(By.xpath("//a[contains(@title,'" + salutation + "')]"));

		element.elementToBeClickable(By.xpath("//span[contains(text(),'First Name')]/../following-sibling::input"));
		driver.findElement(By.xpath("//span[contains(text(),'First Name')]/../following-sibling::input"))
				.sendKeys(firstname);

		element.elementToBeClickable(By.xpath("//span[contains(text(),'Last Name')]/../following-sibling::input"));
		driver.findElement(By.xpath("//span[contains(text(),'Last Name')]/../following-sibling::input"))
				.sendKeys(lastname);

		element.elementToBeClickable(By.xpath("//span[contains(text(),'Email')]/../following-sibling::input"));
		driver.findElement(By.xpath("//span[contains(text(),'Email')]/../following-sibling::input")).sendKeys(email);

		element.elementToBeClickable(By.xpath("//span[contains(text(),'Phone')]/../following-sibling::input"));
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]/../following-sibling::input")).sendKeys(mobile);

		element.elementToBeClickable(By.xpath("//span[contains(text(),'Company')]/../following-sibling::input"));
		driver.findElement(By.xpath("//span[contains(text(),'Company')]/../following-sibling::input"))
				.sendKeys(companyName);

		element.click(
				By.xpath("//div[contains(@class,'modal-footer slds-modal__footer')]//span[contains(text(),'Save')]"));
		// element.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'modal-footer
		// slds-modal__footer')]//span[contains(text(),'Save')]"));
		timer.pause(3);

	}

	public void convertLeadToOpportunity(String leadName) {
		
		element.elementToBeClickable(By.xpath("//div[contains(text(),'" + leadName + "')]/.."));
		element.click(By.xpath("//div[contains(text(),'" + leadName + "')]/.."));

		element.elementToBeClickable(By.xpath("//div[contains(text(),'Convert')]/.."));
		element.click(By.xpath("//div[contains(text(),'Convert')]/.."));

		element.elementToBeClickable(By
				.xpath("//div[contains(@class,'modal-footer slds-modal__footer')]//span[contains(text(),'Convert')]"));
		element.click(By
				.xpath("//div[contains(@class,'modal-footer slds-modal__footer')]//span[contains(text(),'Convert')]"));

		if (element.isDisplayed(By.xpath("//*[contains(text(),'Your lead has been converted')]"))) {
			report.logs("Lead successfully converted to opportunity", "3500", "PASS", "Select template",
					screenShotType.BROWSER);
		}

		if (element.isDisplayed(By.xpath("(//div[contains(@class,'containerConvertedItem')])[1]"))
				&& element.isDisplayed(By.xpath("(//div[contains(@class,'containerConvertedItem')])[2]"))
				&& element.isDisplayed(By.xpath("(//div[contains(@class,'containerConvertedItem')])[3]"))) {
			report.logs("Lead successfully converted to opportunity", "Verification complete", "PASS",
					"Select template", screenShotType.BROWSER);
		}

	}
	
	public void verifyAccountCreation()
	{

		if (element.isDisplayed(By.xpath("(//div[contains(@class,'containerConvertedItem')])[1]"))
				&& element.isDisplayed(By.xpath("(//div[contains(@class,'containerConvertedItem')])[2]"))
				&& element.isDisplayed(By.xpath("(//div[contains(@class,'containerConvertedItem')])[3]"))) {
			report.logs("Lead successfully converted to opportunity", "Verification complete", "PASS",
					"Select template", screenShotType.BROWSER);
		}

	}
	
	
	public void createQuoteFromOpportunity(String quoteName)
	{
	
		element.click(By.xpath("//a[contains(text(),'Jade Global Softwares Pvt. Ltd.-')]"));
		report.logs("Open opportunity", "Jade Global Softwares Pvt. Ltd.-", "PASS", "Create Quote From Opportunity", screenShotType.BROWSER);
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		timer.pause(4);
		
		js.click(By.xpath("//a[contains(@href,'/related/Quotes/view')]"));
	
		timer.pageLoad();
		element.elementToBeClickable(By.xpath("(//a[contains(@title,'New Quote')])[1]"));
		report.logs("Click on New Quote", "-", "PASS", "Create Quote From Opportunity", screenShotType.BROWSER);
		element.click(By.xpath("(//a[contains(@title,'New Quote')])[1]"));

		textbox.setValue(By.xpath("//span[contains(text(),'Quote Name')]/../following-sibling::input"),
				quoteName);
		report.logs("Entered name for New Quote",quoteName, "PASS", "Create Quote From Opportunity", screenShotType.BROWSER);
	}
	
	public void addLineItemsToTheQuote(String quoteName)
	{

		element.click(By.xpath("(//span[text()='Save'])[3]"));
		timer.pageLoad();
		report.logs("Clicked on Save button","Click", "PASS", "Add Line Items To The Quote", screenShotType.BROWSER);
		timer.pause(3);

		element.elementToBeClickable(By.xpath("//div[contains(text(),'" + quoteName + "')]/.."));
		report.logs("Opened quote","Click", "PASS", "Add Line Items To The Quote", screenShotType.BROWSER);
		element.click(By.xpath("//div[contains(text(),'" + quoteName + "')]/.."));
		timer.pause(4);
		
		element.elementToBeClickable(By.xpath("((//div[(text()='Add Products')]))[1]/.."));
		report.logs("Clicked on Add product","Click", "PASS", "Add Line Items To The Quote", screenShotType.BROWSER);
		element.click(By.xpath("((//div[(text()='Add Products')]))[1]/.."));
		element.elementToBeClickable(By.xpath("//tr[contains(.,'SLA: Platinum')]//label"));
		element.click(By.xpath("//tr[contains(.,'SLA: Platinum')]//label"));
		report.logs("Selected product","SLA: Platinum", "PASS", "Add Line Items To The Quote", screenShotType.BROWSER);
		element.click(By.xpath("//span[contains(text(),'Next')]"));

		element.click(By.xpath("(//span[contains(text(),'Edit Quantity: Item 1')])[1]/.."));
		element.elementToBeClickable(By.xpath("//input[contains(@class,'slds-grow input uiInputSmartNumber')]"));

		textbox.setValue(By.xpath("//input[contains(@class,'slds-grow input uiInputSmartNumber')]"), "5");
		report.logs("Entered quantity","5", "PASS", "Add Line Items To The Quote", screenShotType.BROWSER);

		element.click(By.xpath("(//span[contains(text(),'Save')])[2]"));
		report.logs("Added products to the Quote","", "PASS", "Add Line Items To The Quote", screenShotType.BROWSER);
		
	}

}
