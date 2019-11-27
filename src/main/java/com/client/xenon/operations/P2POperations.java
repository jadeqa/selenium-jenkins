package com.client.xenon.operations;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.client.fusion.generic.GenericDeclarations;
import com.client.fusion.locators.PurchaseRequisitionLocators;
import com.client.xenon.framework.DemoAutomation;
import com.xenon.core.framework.Xenon;
import action.core.ActionPerformer;



public class P2POperations extends DemoAutomation implements GenericDeclarations, PurchaseRequisitionLocators {
	LinkedHashMap<String, String> usernamePassword = new LinkedHashMap<String, String>();
	
	ActionPerformer actions = new ActionPerformer(driver);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	int invoiceGroup = (new Random()).nextInt(900000) + 100000;
	int invoiceNumber = (new Random()).nextInt(9000000) + 1000000;
	private String PRNumber = "";
	private String PONumber = "";
	String randomPaymentName = "Batch Payment" + (new Random()).nextInt(9000000) + 1000000;
	String generatedProcessNumber = "";
	
	public String createNoncatalogRequisition(String itemDescription, String quantityToEnter, String priceToEnter,
			String supplierToEnter, String suggBuyer) throws Exception {
		//usernamePassword.put("casey.brown", "Zwn34478");

		
		element.visibilityOfElementLocated(moreTask);
		driver.findElement(moreTask).click();
		report.logs("Click on moreTask", "Click", "Pass", "moreTask", screenShotType.BROWSER);
		timer.pause(2);

		element.visibilityOfElementLocated(requestNonCatItem);
		driver.findElement(requestNonCatItem).click();
		report.logs("Click on requestNonCatItem", "Click", "Pass", "requestNonCatItem", screenShotType.BROWSER);
		timer.pause(2);
		timer.pageLoad();

		element.visibilityOfElementLocated(itemDesc);
		driver.findElement(itemDesc).click();
		report.logs("Click on itemDesc", "Click", "Pass", "itemDesc", screenShotType.BROWSER);
		driver.findElement(itemDesc).clear();
		driver.findElement(itemDesc).sendKeys(itemDescription);
		report.logs("Entered furniture", "furniture", "Pass", "itemDesc", screenShotType.BROWSER);
		driver.findElement(categoryName).click();
		report.logs("Click on categoryName", "Click", "Pass", "categoryName", screenShotType.BROWSER);
		timer.pause(5);
		element.elementToBeClickable(searchBtn);
		js.click(searchBtn);
		//button.click(searchBtn);
		element.visibilityOfElementLocated(corp);
		driver.findElement(corp).click();
		report.logs("Click on corp", "Click", "Pass", "corp", screenShotType.BROWSER);
		driver.findElement(OKbtn).click();
		report.logs("Click on OKbtn", "Click", "Pass", "OKbtn", screenShotType.BROWSER);
		timer.pause(5);

		driver.findElement(Quantity).click();
		timer.pause(2);
		report.logs("Click on Quantity", "Click", "Pass", "Quantity", screenShotType.BROWSER);
		driver.findElement(Quantity).clear();
		timer.pause(2);
		driver.findElement(Quantity).sendKeys(quantityToEnter);
		driver.findElement(Quantity).sendKeys(Keys.TAB);
		timer.pause(2);
		report.logs("Entered 10", "10", "Pass", "Quantity", screenShotType.BROWSER);

		driver.findElement(UOM).click();
		report.logs("Click on UOM", "Click", "Pass", "UOM", screenShotType.BROWSER);
		timer.pause(2);

		driver.findElement(day).click();
		report.logs("Click on daily", "Click", "Pass", "daily", screenShotType.BROWSER);
		timer.pause(3);

		driver.findElement(price).click();
		report.logs("Click on price", "Click", "Pass", "price", screenShotType.BROWSER);
		driver.findElement(price).clear();
		driver.findElement(price).sendKeys(priceToEnter);
		report.logs("Entered 1000000", priceToEnter, "Pass", "price", screenShotType.BROWSER);

		By liTxtChampoin = By.xpath(".//li[contains(text(),'"+supplierToEnter +"')]");
        timer.pause(3);
        actions.clearFieldAndEnterText(supplier, supplierToEnter);
        element.click(liTxtChampoin);
        timer.pause(3);

		driver.findElement(addToCart).click();
		report.logs("Click on addToCart", "Click", "Pass", "addToCart", screenShotType.BROWSER);
		
		timer.pause(2);
		//driver.findElement(clickonDone).click();
		js.click(clickonDone);
		report.logs("Click on clickonDone", "Click", "Pass", "clickonDone", screenShotType.BROWSER);
		timer.pause(2);
		element.click(submitButton);           
        timer.pause(1);
        element.visibilityOfElementLocated(confirmationMessage);
        report.logs("Confirmation msg", "---", "Pass", "createNoncatalogRequisition", screenShotType.BROWSER);
        PRNumber = driver.findElement(confirmationMessage).getText().split(" ")[1];
        element.click(confirmationMessageOkButton);
        report.logs("Click on confirmation ok", PRNumber, "Pass", "createNoncatalogRequisition", screenShotType.BROWSER);
        timer.pause(2);
		return PRNumber;

	}

	public void trackLifeCycle(String PRNumber3)
	{
		element.visibilityOfElementLocated(requisition);
		driver.findElement(requisition).click();
		report.logs("Clicked on requisition", "Click", "PASS", "requisition", screenShotType.BROWSER);

		driver.findElement(requisition).clear();
		driver.findElement(requisition).sendKeys(PRNumber3);
		report.logs("Entered PRNumber3", PRNumber3, "PASS", "requisition", screenShotType.BROWSER);

		driver.findElement(searchBtn).click();
		timer.pause(6);

		element.click(By.xpath("//a[contains(text(),'" + PRNumber3 + "')]"));

		element.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Requisition: ')]"));
		timer.pause(3);

		report.logs("Tracked successfully", "Click", "PASS", "requisition", screenShotType.BROWSER);
	}
	
	
	public void trackLifeCyleOfPO(String PO)
	{
		element.visibilityOfElementLocated(By.xpath("//img[contains(@title,'Search')]/.."));
		element.click(By.xpath("//img[contains(@title,'Search')]/.."));

		report.logs("Clicked on search", "Click", "PASS", "PO", screenShotType.BROWSER);
		new Select(driver.findElement(By.xpath("//select[contains(@title,'Requisitions')]"))).selectByValue("1");

		timer.pause(3);

		element.elementToBeClickable(By.xpath("//input[contains(@type,'search')]"));

		driver.findElement(By.xpath("//input[contains(@type,'search')]")).sendKeys(PO);
		report.logs("Entered PO", PO, "PASS", "requisition", screenShotType.BROWSER);

		element.elementToBeClickable(By.xpath("(//img[contains(@title,'Search')]/..)[2]"));

		element.click(By.xpath("(//img[contains(@title,'Search')]/..)[2]"));

		element.elementToBeClickable(By.xpath("//button[contains(text(),'View Details')]"));
		element.click(By.xpath("//button[contains(text(),'View Details')]"));
		timer.pause(4);
		report.logs("Tracked lifecycle", PO, "PASS", "requisition", screenShotType.BROWSER);

	}
	public String processRequisition(String PRNumber3) {
		try {
			navigate.processRequisition();
			element.visibilityOfElementLocated(requisition);
			driver.findElement(requisition).click();
			report.logs("Clicked on requisition", "Click", "PASS", "requisition", screenShotType.BROWSER);
			driver.findElement(requisition).clear();
			driver.findElement(requisition).sendKeys(PRNumber3);
			report.logs("Entered PRNumber3", "PRNumber3", "PASS", "requisition", screenShotType.BROWSER);
			actions.clearFieldAndEnterText(buyer, "");
			timer.pause(2);
			driver.findElement(buyer).sendKeys(Keys.TAB);
			timer.pause(6);
			driver.findElement(searchBtn).click();
			timer.pause(6);
			element.visibilityOfElementLocated(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Currency'])[2]/following::td[1]"));
			element.elementToBeClickable(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Currency'])[2]/following::td[1]"));
			driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Currency'])[2]/following::td[1]"))
					.click();
			timer.pause(6);

			element.visibilityOfElementLocated(addToDocBuilder);
			driver.findElement(addToDocBuilder).click();
			timer.pause(3);

			element.visibilityOfElementLocated(By.xpath(
					"//span[text()='K']"));
			element.elementToBeClickable(By.xpath(
					"//span[text()='K']"));
			timer.pause(4);
			// js.scrollToElement(By.xpath("(.//*[normalize-space(text()) and
			// normalize-space(.)='Bolivar Soberano'])[2]/following::span[1]"));
			driver.findElement(By
					.xpath("//span[text()='K']"))
					.click();
			timer.pause(4);

			driver.findElement(create).click();
			report.logs("Entered create", "click", "PASS", "create", screenShotType.BROWSER);
			timer.pause(4);

			element.visibilityOfElementLocated(By.id("d1::msgDlg::cancel"));
			element.elementToBeClickable(By.id("d1::msgDlg::cancel"));
			PONumber = driver.findElement(order).getText();
			driver.findElement(By.id("d1::msgDlg::cancel")).click();

			element.visibilityOfElementLocated(By.xpath(
					"//*[normalize-space(text())='Sub']"));
			driver.findElement(By
					.xpath("//*[normalize-space(text())='Sub']"))
					.click();
			timer.pause(2);
			element.visibilityOfElementLocated(By.id("d1::msgDlg::cancel"));
			driver.findElement(By.id("d1::msgDlg::cancel")).click();
			// driver.findElement(By.id("pt1:_UISatr:0:ot3")).click();
			timer.pause(3);
			element.visibilityOfElementLocated(task);
			driver.findElement(task).click();
			element.visibilityOfElementLocated(manageOrder);
			driver.findElement(manageOrder).click();
			timer.pause(2);
			// driver.findElement(requisition).click();
			report.logs("Entered requisition", "click", "PASS", "requisition", screenShotType.BROWSER);
			driver.findElement(requisition).clear();
			driver.findElement(requisition).sendKeys(PRNumber3);
			report.logs("Entered PRNumber", "PRNumber", "PASS", "requisition", screenShotType.BROWSER);
			driver.findElement(searchBtn).click();
			timer.pause(2);
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
			ex.printStackTrace();
		}
		// driver.findElement(By.id("d1::msgDlg::cancel")).click();
		return PONumber;
	}

	public void receiveItems(String PONumber3) {
		try
		{
		element.click(myReceiptsLink);
		element.visibilityOfElementLocated(purchaseOrder);
		driver.findElement(purchaseOrder).click();
		report.logs("Entered purchaseOrder", "click", "PASS", "purchaseOrder", screenShotType.BROWSER);
		driver.findElement(purchaseOrder).clear();
		driver.findElement(purchaseOrder).sendKeys(PONumber3);
		report.logs("Entered PONumber3", "PONumber3", "PASS", "purchaseOrder", screenShotType.BROWSER);
		driver.findElement(searchBtn).click();
		timer.pause(3);
		
		if(element.isDisplayed(expandAdvancedSearch))
		{
			element.click(expandAdvancedSearch);
			element.visibilityOfElementLocated(ItemsDue);
		}
		
		element.visibilityOfElementLocated(ItemsDue);
		driver.findElement(ItemsDue).click();
		timer.pause(3);
		report.logs("Entered ItemsDue", "click", "PASS", "ItemsDue", screenShotType.BROWSER);
		new Select(driver.findElement(ItemsDue)).selectByVisibleText("Any time");
		report.logs("Entered Any time", "Any time", "PASS", "ItemsDue", screenShotType.BROWSER);
		element.visibilityOfElementLocated(ItemsDue);
		driver.findElement(ItemsDue).click();
		timer.pause(3);
		driver.findElement(searchBtn).click();
		timer.pause(8);

		element.visibilityOfElementLocated(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Currency'])[2]/following::td[1]"));
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Currency'])[2]/following::td[1]"))
				.click();
		timer.pause(3);
		driver.findElement(receive).click();
		report.logs("Entered receive", "click", "PASS", "receive", screenShotType.BROWSER);
		timer.pause(8);

		element.visibilityOfElementLocated(quantity);
		timer.pause(3);
		// driver.findElement(quantity).click();
		// report.logs("Entered quantity", "click", "PASS", "quantity",
		// screenShotType.BROWSER);
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("10");
		report.logs("Entered 10", "10", "PASS", "quantity", screenShotType.BROWSER);

		element.visibilityOfElementLocated(waybill);
		//driver.findElement(waybill).click();
		timer.pause(3);
		driver.findElement(clickonSub)
				.click();
		timer.pause(3);
		element.visibilityOfElementLocated(By.xpath(
				"(.//span[contains(text(),'You created the following receipt numbers:')])[1]/following::span[1]"));
		driver.findElement(By
				.xpath("(.//span[contains(text(),'You created the following receipt numbers:')])[1]/following::span[1]"))
				.click();
		timer.pause(3);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	public String createInvoiceFromRequisition(String requisitionNumber) throws Exception {

		navigate.navigateToCreateInvoiceLink();

		element.fluentWaitForElement(selectPO);

		if (element.isDisplayed(selectPO)) {

			element.elementToBeClickable(selectPO);
			driver.findElement(selectPO).sendKeys(requisitionNumber);
			timer.pause(8);
			element.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'" + requisitionNumber + "')]"));
			driver.findElement(By.xpath(".//*[contains(text(),'" + requisitionNumber + "')]")).click();
			timer.pause(10);
			report.logs("Selected business unit value", requisitionNumber, "PASS", "editProfile",
					screenShotType.BROWSER);

			element.elementToBeClickable(
					By.xpath("//label[contains(.,'Invoice Group')]/../following-sibling::td/input"));
			driver.findElement(By.xpath("//label[contains(.,'Invoice Group')]/../following-sibling::td/input"))
					.sendKeys("test-" + invoiceGroup + "");
			report.logs("Select invoice group", "test-" + invoiceGroup + "", "PASS", "editProfile",
					screenShotType.BROWSER);

			textbox.setValue(numberField, invoiceNumber + "");
			report.logs("Enter invoice number", invoiceNumber + "", "PASS", "editProfile", screenShotType.BROWSER);

			if (element.isDisplayed(amountField)) {
				textbox.setValue(amountField, "20900");

				timer.pageLoad();

				driver.findElement(
						By.xpath("//label[contains(text(),'Payment Terms')]/../following-sibling::td/span/input"))
						.clear();

				driver.findElement(
						By.xpath("//label[contains(text(),'Payment Terms')]/../following-sibling::td/span/input"))
						.sendKeys("Immediate");
				report.logs("set payment terms", "Immediate", "PASS", "editProfile", screenShotType.BROWSER);

				timer.pause(3);
				element.elementToBeClickable(By.xpath("//li[contains(text(),'Immediate')]"));
				driver.findElement(By.xpath("//li[contains(text(),'Immediate')]")).click();
				timer.pause(2);

				new Select(driver.findElement(By
						.xpath("//h1[contains(text(),'Lines')]/../../following-sibling::td//select")))
								.selectByVisibleText("Match Invoice Lines");

				timer.pause(3);

				driver.findElement(By.xpath("//h1[contains(text(),'Lines')]/../../following-sibling::td//a")).click();

				element.visibilityOfElementLocated(
						By.xpath("(//input[contains(@type,'checkbox')]/following-sibling::label)[1]"));
				timer.pause(5);

				driver.findElement(By.xpath("(//input[contains(@type,'checkbox')]/following-sibling::label)[1]"))
						.click();
				timer.pause(8);

				/*element.visibilityOfElementLocated(By.xpath(
						"//li[contains(text(),'The payment terms for this invoice')]/../../../../following-sibling::tr//button"));
				driver.findElement(By
						.xpath("//li[contains(text(),'The payment terms for this invoice')]/../../../../following-sibling::tr//button"))
						.click();
				timer.pause(5);*/

				element.visibilityOfElementLocated(
						By.xpath("//button[contains(@accesskey,'l')]/following-sibling::button[1]"));
				driver.findElement(By.xpath("//button[contains(@accesskey,'l')]/following-sibling::button[1]")).click();
				timer.pause(5);
				actions.clearFieldAndEnterText(amountField, "1000");

				if (element.isDisplayed(saveButton)) {
					element.click(saveButton);
					report.logs("Click on save button", "---", "PASS", "save button", screenShotType.BROWSER);
					timer.pageLoad();
					
					if (element.isDisplayed(invoiceAction)) {
						try {
							element.elementToBeClickable(invoiceAction);
							link.click(invoiceAction);
							report.logs("Click on invoice action", "---", "PASS", "invoice action",
									screenShotType.BROWSER);
							element.elementToBeClickable(manageInstallment);
							element.click(manageInstallment);
							timer.pause(3);
							element.fluentWaitForElement(selectPaymentMethod);
							element.elementToBeClickable(selectPaymentMethod);
							driver.findElement(selectPaymentMethod).clear();
							driver.findElement(selectPaymentMethod).sendKeys("Check");
							timer.pause(3);
							element.elementToBeClickable(paymentMethod);
							driver.findElement(paymentMethod).click();
							timer.pause(3);
							report.logs("Select Payment Method", "Check", "PASS", "Manage Installment",
									screenShotType.BROWSER);
							element.elementToBeClickable(saveAndCloseButton);
							driver.findElement(saveAndCloseButton).click();
							timer.pause(3);
							
							if (element.isDisplayed(okButtonOnDialogBox)) {
								element.elementToBeClickable(okButtonOnDialogBox);
								driver.findElement(okButtonOnDialogBox).click();
							}
							timer.pause(3);
							
							element.elementToBeClickable(invoiceAction);
							link.click(invoiceAction);
							element.click(validateOption);
							report.logs("Click on validate action", "---", "PASS", "validate action",
									screenShotType.BROWSER);
							timer.pageLoad();
							timer.pause(7);

							if (element.isDisplayed(By
									.xpath("//td[contains(@id,'d1::msgDlg::_fcc')]//button[contains(text(),'OK')]"))) {
								element.elementToBeClickable(By.xpath(
										"//td[contains(@id,'d1::msgDlg::_fcc')]//button[contains(text(),'OK')]"));
								driver.findElement(By
										.xpath("//td[contains(@id,'d1::msgDlg::_fcc')]//button[contains(text(),'OK')]"))
										.click();
							}
							timer.pause(3);
							element.elementToBeClickable(invoiceAction);
							link.click(invoiceAction);

							timer.pause(3);
							element.elementToBeClickable(By.xpath(".//td[(text()='Approval')]"));
							driver.findElement(By.xpath(".//td[(text()='Approval')]")).click();
							timer.pause(3);
							element.elementToBeClickable(By.xpath(".//td[(text()='Initiate')]"));
							driver.findElement(By.xpath(".//td[(text()='Initiate')]")).click();
							timer.pause(8);
							/*driver.findElement(
									By.xpath("//td[contains(@id,'d1::msgDlg::_fcc')]//button[contains(text(),'OK')]"))
									.click();*/
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}

			}
		}
		return "test-" + invoiceGroup + "";
	}
	
	public String processRequisition(String PRNumber3, String userName, String password) {
		try {
			element.visibilityOfElementLocated(requisition);
			element.visibilityOfElementLocated(procurmentBU);
			actions.selectOption(procurmentBU, "Anchorfree Inc");// add time
			timer.pageLoad();
			timer.pause(10);
			element.visibilityOfElementLocated(requisitionBU);
			actions.selectOption(requisitionBU, "Anchorfree Inc");
			actions.clearFieldAndEnterText(requisition, PRNumber3);
			actions.clearFieldAndEnterText(buyer, "");
			report.logs("Entered PRNumber3", "PRNumber3", "PASS", "processRequisition", screenShotType.BROWSER);
			element.click(searchBtn);
			timer.pause(6);
			By PRNumberSearched = By.xpath("(//a[contains(text(),'" + PRNumber3
					+ "')]/ancestor::tbody//span[contains(text(),'Anchorfree')])[1]");
			timer.pause(6);
			element.visibilityOfElementLocated(PRNumberSearched);
			element.click(PRNumberSearched);
			element.visibilityOfElementLocated(addToDocBuilder);
			report.logs("Document Builder clicke", "PRNumber3", "PASS", "requisition", screenShotType.BROWSER);
			element.click(addToDocBuilder);
			timer.pause(3);
			element.visibilityOfElementLocated(okButtonDocBuilder);
			element.click(okButtonDocBuilder);

			js.scrollToElement(create);
			element.visibilityOfElementLocated(create);
			report.logs("Entered create", "click", "PASS", "create", screenShotType.BROWSER);
			element.click(create);
			timer.pause(4);

			element.visibilityOfElementLocated(okButtonOnProcessesMessage);
			report.logs("Ok button confirm", "PRNumber3", "PASS", "processRequisition", screenShotType.BROWSER);
			element.click(okButtonOnProcessesMessage);
			PONumber = driver.findElement(order).getText();
			element.visibilityOfElementLocated(clickonSub);
			element.click(clickonSub);
			timer.pause(2);
			element.visibilityOfElementLocated(okButtonOnDialogBox);
			report.logs("ok button after submit", "PRNumber3", "PASS", "processRequisition", screenShotType.BROWSER);
			element.click(okButtonOnDialogBox);
			timer.pause(20);
			element.visibilityOfElementLocated(task);
			driver.findElement(task).click();
			element.visibilityOfElementLocated(manageOrder);
			driver.findElement(manageOrder).click();
			timer.pause(2);
			report.logs("Entered requisition", "click", "PASS", "processRequisition", screenShotType.BROWSER);
			element.visibilityOfElementLocated(procurmentBU1);
			actions.selectOption(procurmentBU1, "Anchorfree Inc");
			actions.clearFieldAndEnterText(requisition, PRNumber3);
			actions.clearFieldAndEnterText(buyer, "");
			report.logs("Entered PRNumber", "PRNumber", "PASS", "processRequisition", screenShotType.BROWSER);
			driver.findElement(searchBtn).click();
			By status;
			String statusOpen;
			try {
				status = By
						.xpath("//*[contains(text(),'" + PONumber + "')]/ancestor::tbody//span[contains(text(),'Open')]");
				element.visibilityOfElementLocated(status);
				report.logs("Status visibility", "PRNumber", "PASS", "processRequisition", screenShotType.BROWSER);
				statusOpen = element.getText(status);
				System.out.println("Status is in open status :"+statusOpen);
			} catch (Exception e) {

				login.logOutOfApplication(userName);
				login.login(userName, password);
				navigate.processRequisition();
				element.visibilityOfElementLocated(task);
				driver.findElement(task).click();
				element.visibilityOfElementLocated(manageOrder);
				driver.findElement(manageOrder).click();
				timer.pause(2);
				report.logs("Entered requisition", "click", "PASS", "requisition", screenShotType.BROWSER);
				element.visibilityOfElementLocated(requisitionBU);
				actions.selectOption(procurmentBU1, "Anchorfree Inc");
				actions.clearFieldAndEnterText(requisition, PRNumber3);
				actions.clearFieldAndEnterText(buyer, "");
				report.logs("Entered PRNumber", "PRNumber", "PASS", "requisition", screenShotType.BROWSER);
				driver.findElement(searchBtn).click();
				By status1 = By.xpath(
						"//*[contains(text(),'\"+ PONumber +\"')]/ancestor::tbody//span[contains(text(),'Open')]");
				element.visibilityOfElementLocated(status1);
				report.logs("Status visibility", "PRNumber", "PASS", "processRequisition", screenShotType.BROWSER);
			
			}
			
			/*if (element.isDisplayed(status)) {
				System.out.println("Status is in open status, Ready to create invoice, Value :"+statusOpen);
			} else {}*/
			timer.pause(2);
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
			ex.printStackTrace();
		}
		return PONumber;
	}
	public String createInvoiceFromRequisition(String requisitionNumber, String BUname,String supplier,String paymentProcessProfileName,String bankName1) throws Exception {
		String invoiceNumberGenerated = Integer.toString(invoiceNumber);
		try {
			element.visibilityOfElementLocated(selectPO);

			if (element.isDisplayed(selectPO)) {

				element.elementToBeClickable(selectPO);
				By option = By.xpath(".//*[contains(text(),'" + requisitionNumber + "')]");
				actions.clearFieldAndEnterText(selectPO, requisitionNumber);
				element.visibilityOfElementLocated(option);
				actions.click(option);
				actions.clearFieldAndEnterText(numberField, invoiceNumberGenerated);

				if (element.isDisplayed(amountField)) {
					actions.clearFieldAndEnterText(amountField, "1000");
					timer.pageLoad();
					report.logs("Select the required value", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
					
					element.visibilityOfElementLocated(matchInvoiceLine);
					actions.selectOption(matchInvoiceLine, "Match Invoice Lines");
					report.logs("Matching the link", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
					timer.pause(3);
					
					element.visibilityOfElementLocated(matchLineIcon);
					actions.click(matchLineIcon);
					element.visibilityOfElementLocated(lineCheckbox);
					timer.pause(5);
					report.logs("Click the required matched checkbox", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
					actions.click(lineCheckbox);

					
					element.visibilityOfElementLocated(applyButton);
					actions.click(applyButton);
					element.visibilityOfElementLocated(okButton);
					report.logs("click on apply and ok button", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
					actions.click(okButton);timer.pause(5);
					if(element.isDisplayed(invoiceAction)) {
						element.elementToBeClickable(invoiceAction);
						link.click(invoiceAction);
						report.logs("Click on validate action", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
						element.click(validateOption);
						timer.pageLoad();
						timer.pause(7);
						
					}else {
						Assert.assertFalse(false, "Error in validating Invoice");
					}
					
					
					if (element.isDisplayed(saveButton)) {
						element.click(saveButton);
						report.logs("Click on save button", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
						timer.pageLoad();
						element.visibilityOfElementLocated(saveAndCloseButton);
						actions.click(saveAndCloseButton);
						report.logs("Save and close", "---", "PASS", "createInvoiceFromRequisition", screenShotType.BROWSER);
					
					}
					else {
						Assert.assertFalse(false, "Error in generating Invoice number");
					}
				}
			}
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in creating invoice"+e);
		}
		return invoiceNumberGenerated;
	}
	
	public String createPaymentBatch(String paymentType, String disbursementBackAccount, String paymentDocumentType,
			String paymentAndProcessProfileValue, String invoiceGroupName) {

		String randomPaymentName = "Batch Payment" + (new Random()).nextInt(9000000) + 1000000;
	
		String paymentfileNumber = "";
		try {

			element.elementToBeClickable(selectionCriteria);
			driver.findElement(selectionCriteria).click();
			timer.pageLoad();

			textbox.setValue(paymentName, randomPaymentName);

			textbox.setValue(selectTemplate, paymentType);
			report.logs("Select template", paymentType, "PASS", "Select template", screenShotType.BROWSER);
			genMethods.waitForElementTobeClickable(By.xpath("//*[contains(text(),'" + paymentType + "')]"));
			driver.findElement(By.xpath("//*[contains(text(),'" + paymentType + "')]")).click();
			timer.pageLoad();
			timer.pause(4);
			driver.findElement(invoiceGroupTextboxPayment).sendKeys(invoiceGroupName);
			timer.pause(4);
			driver.findElement(invoiceGroupTextboxPayment).sendKeys(Keys.TAB);
			timer.pause(4);
			report.logs("Enter invoice group name", invoiceGroupName, "PASS", "Invoice group name",
					screenShotType.BROWSER);

			driver.findElement(paymentAndProcessingOptions).click();

			timer.pageLoad();
			/*textbox.setValue(disbursementBankAccount, disbursementBackAccount);
			timer.pause(3);
			report.logs("Select disbursement bank account", disbursementBackAccount, "PASS", "bank account",
					screenShotType.BROWSER);
			element.elementToBeClickable(By.xpath("//*[contains(text(),'" + disbursementBackAccount + "')]"));
			driver.findElement(By.xpath("//*[contains(text(),'" + disbursementBackAccount + "')]")).click();
			timer.pageLoad();
			new Select(driver.findElement(paymentDocument)).selectByVisibleText(paymentDocumentType);
			report.logs("Select payment document", paymentDocumentType, "PASS", "Payment document",
					screenShotType.BROWSER);
			textbox.setValue(paymentAndProcessProfile, paymentAndProcessProfileValue);
			driver.findElement(paymentAndProcessProfile).sendKeys(Keys.TAB);*/
			timer.pause(3);

			timer.pageLoad();
			driver.findElement(submitButtonPaymentPage).click();
			timer.pageLoad();

			checkScheduledRequestsForStatus(1);

			driver.navigate().refresh();
			
			iterateClickTillElementsVisibility(refreshButton,
					By.xpath("//a[contains(text(),'" + randomPaymentName + "')]"));
			
			timer.pageLoad();
			timer.pause(3);

			driver.findElement(
					By.xpath("(//*[contains(text(),'Payment Process Requests')]/following::a[contains(text(),'"
							+ randomPaymentName + "')]/following::a[./img])[1]"))
					.click();
			timer.pageLoad();

			/*
			 * driver.findElement(By.
			 * xpath("//span[contains(text(),'Add Installments')]/..")).click();
			 * element.elementToBeClickable(By.
			 * xpath("//label[text()='Supplier or Party']/../following-sibling::td//input"
			 * )); textbox.setValue(By.
			 * xpath("//label[text()='Supplier or Party']/../following-sibling::td//input"
			 * ), "CHAMPION NATIONAL SECURITY"); driver.findElement(By.
			 * xpath("//label[text()='Supplier or Party']/../following-sibling::td//input"
			 * )) .sendKeys(Keys.TAB); timer.pause(2);
			 * element.click(By.xpath("//button[contains(text(),'Search')]"));
			 * timer.pageLoad(); timer.pause(5); element.elementToBeClickable( By.xpath(
			 * "(//table[contains(@summary,'Summary')])[3]/tbody/tr[1]/td[contains(.,'SAL')]"
			 * )); driver.findElement(By.xpath(
			 * "(//table[contains(@summary,'Summary')])[3]/tbody/tr[1]/td[contains(.,'SAL')]"
			 * )) .click(); timer.pageLoad(); timer.pause(5); element.click(By.
			 * xpath("//span[contains(text(),'Add to Payment Process Request')]/.." ) );
			 * timer.pageLoad();
			 * driver.findElement(By.xpath("//a[contains(@id,'dialog3::clos')]") ). click();
			 */

			timer.pageLoad();
			timer.pause(3);
			element.elementToBeClickable(submitButtonPaymentPage);
			driver.findElement(submitButtonPaymentPage).click();
			timer.pageLoad();

			checkScheduledRequestsForStatus(3);
			driver.navigate().refresh();
			timer.pageLoad();

			driver.findElement(refreshButton).click();
			timer.pause(5);

			driver.findElement(
					By.xpath("(//*[contains(text(),'Payment Process Requests')]/following::a[contains(text(),'"
							+ randomPaymentName + "')]/following::a[./img])[1]"))
					.click();
			timer.pageLoad();

			timer.pause(3);

			genMethods.waitForElementTobeClickable(resumePaymentProcessButton);
			driver.findElement(resumePaymentProcessButton).click();
			report.logs("Click on Resume payment process", "Click", "PASS", "Resume Payment Process",
					screenShotType.BROWSER);
			timer.pageLoad();
			checkScheduledRequestsForStatus(2);
			timer.pause(5);

			driver.navigate().refresh();
			timer.pageLoad();

			driver.findElement(refreshButton).click();
			timer.pageLoad();
			timer.pause(5);
			
			genMethods.waitForElementTobeClickable(recentlyCompleted);
			driver.findElement(recentlyCompleted).click();
			
			if (!element.isDisplayed(By.xpath("//a[contains(text(),'" + randomPaymentName + "')]"))) {
				driver.findElement(refreshButton).click();
				timer.pageLoad();
				timer.pause(5);
			}

			genMethods.waitForElementTobeClickable(By.xpath("//a[contains(text(),'" + randomPaymentName + "')]//parent::span//parent::span//parent::div//a[contains(@title,'Expand')]"));

			if (element.isDisplayed(By.xpath("//a[contains(text(),'" + randomPaymentName + "')]"))) {

				driver.findElement(By.xpath("//a[contains(text(),'" + randomPaymentName + "')]//parent::span//parent::span//parent::div//a[contains(@title,'Expand')]")).click();
				genMethods.waitForElementTobeClickable(paymentFileName);

				driver.findElement(paymentFileName).click();
				report.logs("Click on Print payment documents", "Click", "PASS", "Print payment documents",
						screenShotType.BROWSER);
				timer.pageLoad();

				System.out.println("Checking if print button is visible or not..if not then click");

				/*if (!element.isDisplayed(printButtonPayment)) {

					driver.findElement(refreshButton).click();
					timer.pageLoad();
					timer.pause(5);
					driver.findElement(printPaymentDocumentButton).click();
					timer.pageLoad();
				}
				paymentfileNumber = driver.findElement(By.xpath("//h1[contains(text(),'Print Payment Documents:')]"))
						.getText().split("1")[0];*/
				timer.pause(5);
				element.elementToBeClickable(doneButton);

				report.logs("Payment File processed", "click", "PASS", "done button", screenShotType.BROWSER);
				driver.findElement(doneButton).click();
				timer.pause(5);
				/*genMethods.waitForElementTobeClickable(doneButton);
				driver.findElement(printButtonPayment).click();
				timer.pageLoad();

				checkScheduledRequestsForStatus(0);

				driver.navigate().refresh();
				timer.pageLoad();

				driver.findElement(refreshButton).click();
				timer.pageLoad();
				timer.pause(5);

				driver.findElement(paymentFileDetails).click();
				timer.pageLoad();

				genMethods.waitForElementTobeClickable(recordPrintStatusButton);
				driver.findElement(recordPrintStatusButton).click();
				timer.pageLoad();
				report.logs("Click on Record Print Status", "Click", "PASS", "Record Print Status",
						screenShotType.BROWSER);

				genMethods.waitForElementTobeClickable(createPositiveFileCheckbox);
				driver.findElement(createPositiveFileCheckbox).click();
				timer.pause(4);

				driver.findElement(submitButtonRecordPrintStatus).click();
				timer.pageLoad();

				genMethods.waitForElementTobeClickable(recordthePrintStatusButton);

				timer.pause(3);
				driver.findElement(recordthePrintStatusButton).click();
				report.logs("Click on Record Print Status", "Click", "PASS", "Record Print Status",
						screenShotType.BROWSER);
				timer.pageLoad();

				driver.findElement(okButtonRecordPrintStatus).click();
				timer.pageLoad();*/

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}

		return paymentfileNumber;
	}

	
	private boolean checkIfElementExists(By locator) {

		boolean flag = false;

		try {

			if (driver.findElements(locator).size() > 0) {
				flag = true;
			}

		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	private void checkScheduledRequestsForStatus(int processesExpected) {

	//	genMethods.waitForElementTobeClickable(processSubmittedMessage);
	//	element.fluentWaitForElement(processSubmittedMessage);

		js.scrollToElement(scheduledProcessesLabel);
		new Select(driver.findElement(selectTimeRange)).selectByVisibleText("Last hour");
		timer.pause(3);
		element.elementToBeClickable(refreshOnScheduledProcesses);
		js.scrollToElement(supplierSiteOnPaymentHold);
		driver.findElement(refreshOnScheduledProcesses).click();
		js.scrollToElement(scheduledProcessesLabel);

		
		//String textFromMessage = driver.findElement(By.xpath("(//*[contains(text(),'Initiate Payment Process Request')])[last()-(last()-1)]/../following-sibling::td[1]/span")).getText();

		//report.logs("Process sybmitted", textFromMessage, "PASS", "process number", screenShotType.BROWSER);
	
		String processNumber = driver.findElement(By.xpath("(//*[contains(text(),'Initiate Payment Process Request')])[last()-(last()-1)]/../following-sibling::td[1]/span")).getText();
		System.out.println("Process found"+processNumber);
		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'OK')])[1]")));
//		driver.findElement(okButtonOnProcessesMessage).click();
		System.out.println("------------" + processNumber);

		js.scrollToElement(scheduledProcessesLabel);
		new Select(driver.findElement(selectTimeRange)).selectByVisibleText("Last hour");
		timer.pause(3);
		element.elementToBeClickable(refreshOnScheduledProcesses);
		js.scrollToElement(supplierSiteOnPaymentHold);
		driver.findElement(refreshOnScheduledProcesses).click();
		js.scrollToElement(scheduledProcessesLabel);

		int count = 0;

		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		do {
			js.scrollToElement(supplierSiteOnPaymentHold);
			driver.findElement(refreshOnScheduledProcesses).click();
			js.scrollToElement(scheduledProcessesLabel);
			timer.pause(2);
			count++;
			if (count > 5)
				break;

		} while (checkIfElementExists(
				By.xpath("//span[contains(text(),'" + ((Integer.parseInt(processNumber)) + processesExpected)
						+ "')]/../following-sibling::td//a[contains(text(),'Succeeded')]")) != true);

		// resetting timeout to check
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Xenon.configProperties.get("DEFAULTTIME")),
				TimeUnit.SECONDS);

		System.out.println("Process number " + processNumber + " successfully generated");
	}

	
	
	
	
	public void initiateApprovalOfInvoiceWithoutNotiification(LinkedHashMap<String, String> crendentialsPairs, String invoiceNumber) {
		By selectCretedPR = By.xpath("//a[contains(text(), '"+invoiceNumber+"')]//ancestor::tr[2]/td[2]");
		for (Map.Entry<String, String> entry : crendentialsPairs.entrySet()) {

			try {
				String username = entry.getKey();
				String password = entry.getValue();
				login.login(username, password);
				report.logs("logged in with the user", username, "PASS", "initiateApprovalOfInvoiceWithoutNotiification", screenShotType.BROWSER);
				genMethods.openNotificationIcon();
				actions.click(moreDetailsLink);
				timer.pause(10);
				String parent = driver.getWindowHandle();
				Set<String> s1 = driver.getWindowHandles();
				timer.pageLoad(10);
				Iterator<String> I1 = s1.iterator();
				timer.pageLoad(10);
				while (I1.hasNext()) {
					String child_window = I1.next();
					if (!parent.equals(child_window)) {
						driver.switchTo().window(child_window);
						System.out.println("Child Window is : " + driver.switchTo().window(child_window).getTitle());
						wait.until(ExpectedConditions.visibilityOfElementLocated(selectCretedPR));
						timer.pause(5);
						driver.manage().window().maximize();
						System.out.println("Switched on child window");
						timer.pause(5);
						element.visibilityOfElementLocated(selectCretedPR);
						report.logs("Recent created PR selected", "---", "PASS",
								"initiateApprovalOfInvoiceWithoutNotiification", screenShotType.BROWSER);
						timer.pause(2);
						element.click(selectCretedPR);
						timer.pause(3);
						if (element.isDisplayed(actionsLink1)) {
							timer.pause(5);
							System.out.println("click on action link");
							actions.click(actionsLink1);
							System.out.println("action link clicked");
							timer.pause(5);
							element.visibilityOfElementLocated(approveLink);
							report.logs("Click on actions and then Click on approve", "---", "PASS",
									"initiateApprovalOfInvoiceWithoutNotiification", screenShotType.BROWSER);
							element.click(approveLink);
							timer.pause(5);
							report.logs("approve link clicked", "---", "PASS",
									"initiateApprovalOfInvoiceWithoutNotiification", screenShotType.BROWSER);

						} else {
							Assert.assertFalse(false, "Approval issue found");
						}
						driver.close();
					}
				}
				driver.switchTo().window(parent);
				System.out.println("Parent window is : " + driver.switchTo().window(parent).getTitle());
				report.logs("Parent window switched", "---", "PASS",
						"initiateApprovalOfInvoiceWithoutNotiification", screenShotType.BROWSER);
				login.logOutOfApplication(username);
			} catch (Exception e) {
				Assert.assertFalse(false, "Error in approving PR");
			}
		}
	}
	
	public String createAccounting()
	{
		try {
			String accountingType = "Payables";
			String selectLedgeType = "AnchorFree US";
			String processCategory = "Invoices";

			if (element.isDisplayed(selectAccontingType)) {
				element.visibilityOfElementLocated(selectAccontingType);
				actions.click(selectAccontingType).selectOption(selectAccontingType, accountingType);
				timer.pause(4);
			} else {
				Assert.assertFalse(false, "Accounting type field is not displayed");
			}
			actions.clearFieldAndEnterText(selectLedgerType, selectLedgeType);
			report.logs("Select ledger", selectLedgeType, "PASS", "createAccounting", screenShotType.BROWSER);
			timer.pause(4);
			if (element.isDisplayed(selectProcessType)) {
				actions.click(selectProcessType);
				actions.selectOption(selectProcessType, processCategory);
				timer.pause(4);
			} else {
				Assert.assertFalse(false, "Process type field is not displayed");
			}
			element.visibilityOfElementLocated(submitButtonPaymentPage);
			report.logs("All details entered", selectLedgeType, "PASS", "createAccounting", screenShotType.BROWSER);
			actions.click(submitButtonPaymentPage);
			timer.pause(3);
			report.logs("Submit button clicked", selectLedgeType, "PASS", "createAccounting", screenShotType.BROWSER);
			String textFromMessage = driver.findElement(submittedSucessfullyMessage).getText();
			System.out.println(textFromMessage);

			generatedProcessNumber = textFromMessage.split(" ")[1];
			System.out.println("Process Number :" + generatedProcessNumber);

			element.visibilityOfElementLocated(okButtonOnProcessesMessage);
			report.logs("click on ok btn", selectLedgeType, "PASS", "createAccounting", screenShotType.BROWSER);
			actions.click(okButtonOnProcessesMessage);
			timer.pause(2);
			driver.findElement(homePageIcon).click();
			timer.pause(5);
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in creating accounting" + e);
		}
		return generatedProcessNumber;

	}
	public void verifyStatusOfNewProcessOnScheduledProcessesPage(String processID,
			final int maxAttempts) throws Exception {
		By statusMessageByProcessID = By.xpath("//span[contains(text(), '"+processID+"')]//following::td[1]//a[contains(text(),'Succeeded')]");
		int attempt = 1;
		boolean elementFound = false;

		do {
			try {
				driver
				.manage()
				.timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
				timer.pause(3);
				actions.click(scheduleProcessRefreshButton);
				System.out.println("Refreshed...");
				timer.pause(3);
				//actions.getVisibleElement(statusMessageByProcessID);
				new ActionPerformer(actions.getDriver(),5).getVisibleElement(statusMessageByProcessID);
				//Assert.assertTrue(driver.findElement(statusMessageByProcessID).getText().matches("Succeeded"));
				elementFound = true;
				break;
			} catch (TimeoutException tx) {
				//tx.printStackTrace();
				System.out.println("Transaction not successful yet...");
				System.out.println("Retrying..."+attempt);
			} finally {
				attempt++;
				driver
				.manage()
				.timeouts()
				.implicitlyWait(Long.parseLong(Xenon.configProperties.get("DEFAULTTIME")), TimeUnit.SECONDS);
			}
		} while (attempt <= maxAttempts);
		timer.pause(3);
		if (elementFound != true) {
			throw new Exception("Process is not successful");
		} else {
			System.out.println("Process successful");
		}
	}
	private void iterateClickTillElementsVisibility(By refreshButtonXpath, By elementToCheck) {
		int count = 0;

		// setting timeout to check if already logged in
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		do {
			js.click(refreshButtonXpath);
			driver.findElement(refreshButtonXpath).click();
			timer.pause(2);
			count++;
			if (count > 7)
				break;

		} while (checkIfElementExists(elementToCheck) != true);

		// resetting timeout to check
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Xenon.configProperties.get("DEFAULTTIME")),
				TimeUnit.SECONDS);

	}
	public void validateReceiptAccounting(String invoiceNumber) {
		try {
			element.elementToBeClickable(invoiceNumberTextboxOnManageInvoice);
			driver.findElement(invoiceNumberTextboxOnManageInvoice).sendKeys(invoiceNumber);
			driver.findElement(searchButtonOnManageInvoice).click();
			timer.pause(3);
			By searchResult = By.xpath("(//table[contains(@summary,'Search Results')]//a[contains(.,'" + invoiceNumber + "')])");
			element.visibilityOfElementLocated(searchResult);
			report.logs("Search Result", "---", "PASS", "validateReceiptAccounting", screenShotType.BROWSER);
			if (!element.isDisplayed(searchResult)) {
				Assert.fail("Could not find invoice '" + invoiceNumber + "'  ");
			} else {
				actions.click(searchResult);
				timer.pageLoad();
				timer.pause(5);
			}
			element.visibilityOfElementLocated(actionsLink1);
			if (element.isDisplayed(actionsLink1)) {
				try {
					element.elementToBeClickable(actionsLink1);
					actions.click(actionsLink1);
					report.logs("Click on actions", "---", "PASS", "validateReceiptAccounting", screenShotType.BROWSER);
					element.visibilityOfElementLocated(accountDraft);
					element.click(accountDraft);
					report.logs("Click on Account in Draft", "---", "PASS", "validateReceiptAccounting", screenShotType.BROWSER);
					timer.pause(10);
					element.visibilityOfElementLocated(viewAccountingButton);
					element.click(viewAccountingButton);
					timer.pause(5);
					element.visibilityOfElementLocated(doneButton1);
					report.logs("Click on View Accounting, Done button available", "---", "PASS", "validateReceiptAccounting", screenShotType.BROWSER);
					element.click(doneButton1);
					report.logs("Click on Done", "---", "PASS", "validateReceiptAccounting", screenShotType.BROWSER);
				} catch (Exception e) {
					Assert.assertFalse(false, "Error in validating the validate option");
				}
			} else {
				Assert.assertFalse(false, "Invoice Action field is not present");
			}
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in validating account"+e);
		}
	}
	
}
