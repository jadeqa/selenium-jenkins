package com.client.fusion.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.client.fusion.generic.GenericDeclarations;
import com.client.xenon.framework.DemoAutomation;
import com.xenon.core.framework.Xenon;

import action.core.ActionPerformer;

public class ApplicationNavigations extends DemoAutomation implements GenericDeclarations {

	private By homePageIcon = By.xpath(".//div/a[@title='Home']");
	private By payablesLink = By.xpath(".//a[text()='Payables']");
	private By invoiceLink = By.xpath("//div[contains(@group,'payables')]//a[text()='Invoices']");
	private By paymentsLink = By.xpath(".//a[text()='Payments']");
	private By taskIcon = By.xpath(".//img[@title='Tasks']");
	private By createInvoiceLink = By.xpath(".//a[text()='Create Invoice']");
	private By submitPaymentProcessRequest = By.xpath(".//a[text()='Submit Payment Process Request']");
	private By manageInvoicePage = By.xpath(".//a[text()='Manage Invoices']");
	private By managePaymentsPage = By.xpath(".//a[text()='Manage Payments']");
	private By auditing = By.xpath("(//a[contains(text(),'Auditing')])[1]");
	private By manageExpenseReports = By.xpath("(//a[contains(text(),'Manage Expense Reports')])[1]");
	private By procurementLink = By.xpath(".//a[text()='Procurement']");
	private By suppliersLink = By.xpath(".//a[text()='Suppliers']");
	private By registerSupplier = By.xpath(".//a[text()='Register Supplier']");
	private By manageSupplierRequest = By.xpath(".//a[text()='Manage Supplier Registration Requests']");
	private By purchaseRequisitionLink = By.xpath(".//a[text()='Purchase Requisitions']");
	private By purchaseOrderLink = By.xpath(".//a[text()='Purchase Orders']");
	private By processRequisitionLink = By.xpath(".//a[text()='Process Requisitions']");
	private By myReceiptsLink = By.xpath(".//a[text()='My Receipts']");
	private By toolsLink = By.xpath(".//a[normalize-space(text())='Tools']");
	private By scheduledProcessesLink = By.xpath(".//a[normalize-space(text())='Scheduled Processes']");
	private By accountReceivablesLink = By.xpath("//a[normalize-space(text())='Accounts Receivable']");
	private By createReceiptLink = By.xpath("//a[normalize-space(text())='Create Receipt']");
	private By receivablesLink = By.xpath("//a[contains(text(),'Receivables')]");
	private By billingLink = By.xpath("//a[contains(text(),'Billing')]");
	private By manageReceiptsLink = By.xpath("//a[normalize-space(text())='Manage Receipts']");

	private By setupAndMaintenanceLink = By.xpath("//a[normalize-space(text())='Setup and Maintenance']");
	private By dropButton = By.xpath("//a[contains(@id,'drop')]/..");
	private By projectFinancialManagementLink = By
			.xpath("//li[normalize-space(text())='Project Financial Management']");
	private By enterpriseProfileRow = By.xpath("//td[normalize-space(text())='Enterprise Profile']");
	private By manageLocationsLink = By.xpath("//a[normalize-space(text())='Manage Locations']");

	private By reportandAnalytics = By.xpath("//a[contains(text(),'Reports and Analytics')]");

	private By reportsAndAnalyticsLink = By.xpath(".//a[normalize-space(text())='Reports and Analytics']");
	private By FinancialsLink = By.xpath("//li[contains(text(),'Financials')]");
	private By SearchTasksInput = By.xpath("(//*[contains(text(),'Search Tasks')]//following::input)[1]");
	private By SearchIcon = By.xpath("(//*[contains(text(),'Search Tasks')]//following::a)[1]");
	private By ManageAccountCombinationsLink = By
			.xpath("//tbody//tr//td//a[contains(text(),'Manage Account Combinations')]");
	private By ManageChartOfAccountsLink = By		
			.xpath("//*[normalize-space(text())='Task']//following::*[normalize-space(text())='Manage Chart of Accounts Value Sets']");
	private By ManageCrossValidationRuleSelect = By
			.xpath("//a[normalize-space(text())='Manage Cross-Validation Rules']");
	private By ManageCrossValidationRulesSelectFromTasks = By
			.xpath("//table[@summary='Tasks']//a[contains(text(),'Manage Cross-Validation Rules')]");
	private By journals = By.xpath("//a[normalize-space(text())='Journals']");
	//private By journals = By.xpath("//a[normalize-space(text())='Journals']");
	private By tasks = By.xpath("//div[@title='Tasks']");
	private By createJournal = By.xpath("//a[normalize-space(text())='Create Journal']");
	private By manageJournal = By.xpath("//a[normalize-space(text())='Manage Journals']");
	private By notifications = By.xpath("//a[contains(@title,'Notifications')]");
	private By generalAccounting=By.xpath("//a[normalize-space(text())='General Accounting']");
	
	private By workforceStructuresRow = By.xpath("//div[@title='Workforce Structures']");
	private By manageDepartmentLink = By.xpath("//a[normalize-space(text())='Manage Departments']");
	private By projectOrganizationRow = By.xpath("//div[@title='Project Organizations']");
	private By manageProjectOrgClasificationLink = By
			.xpath("//a[normalize-space(text())='Manage Project Organization Classifications']");
	private By manageOrgTreesLink = By.xpath("//a[normalize-space(text())='Manage Organization Trees']");
	private By projectLink = By.xpath("//*[normalize-space(text())='Projects']");
	private By projectFinancialManageLink = By.xpath("//*[normalize-space(text())='Project Financial Management']");
	private By createProjectTemplateLink = By.xpath("//*[normalize-space(text())='Create Project from Template']");
	private By productInformationManagementLink = By
			.xpath("//*[normalize-space(text())='Product Information Management']");
	private By supplyChainExecutionLink = By.xpath("//*[normalize-space(text())='Supply Chain Execution']");
	private By inventoryManagementLink = By.xpath("//*[normalize-space(text())='Inventory Management']");

	private By projects = By.xpath("//a[normalize-space(text())='Projects']");
	private By costs = By.xpath("//a[normalize-space(text())='Costs']");
	private By manageUnprocessedCosts = By.xpath("//a[normalize-space(text())='Manage Unprocessed Costs']");

	private By createInvoice = By.xpath("//a[normalize-space(text())='Create Invoice']");

	private By manageProjectCosts = By.xpath("//a[normalize-space(text())='Manage Project Costs']");
	private By manageUnrealeasedCosts = By.xpath("//a[normalize-space(text())='Manage Unreleased Costs']");
	private By projectFinancialManagement = By.xpath("//a[normalize-space(text())='Project Financial Management']");
	private By expensesLinkIcon = By.xpath("(//a[contains(text(),'Expenses')])[1]");
	private By expensesLink = By.xpath("(//a[normalize-space(text())='Expenses'])[2]");
	private By meLinkHomePage = By.xpath("//a[contains(.,'Me')]");
	

	private By fixedAsset= By.xpath("//a[text()='Fixed Assets']");
	private By assetLink= By.xpath("//a[text()='Assets']");
	
	ActionPerformer actions = new ActionPerformer(driver);
	
	public void navigateToCreateInvoiceLink() {
		try {
			timer.pause(3);
			element.visibilityOfElementLocated(homePageIcon);
			element.click(homePageIcon);
			timer.pageLoad();
			timer.pause(3);
			element.visibilityOfElementLocated(payablesLink);
			report.logs("payableLink", "---", "PASS", "CreateInvoiceLink",screenShotType.BROWSER);
			element.click(payablesLink);
			element.visibilityOfElementLocated(invoiceLink);
			element.click(invoiceLink);
			timer.pageLoad();
			timer.pause(5);
			element.visibilityOfElementLocated(taskIcon);
			element.click(taskIcon);
			element.visibilityOfElementLocated(createInvoiceLink);
			report.logs("createInvoiceLink", "---", "PASS", "CreateInvoiceLink",screenShotType.BROWSER);
			element.click(createInvoiceLink);
			timer.pageLoad();
			timer.pause(5);
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation");
		}
	}

	public void navigateToManageInvoicePage() {
		try {
			timer.pause(3);
			element.visibilityOfElementLocated(homePageIcon);
			element.click(homePageIcon);
			timer.pageLoad();
			timer.pause(3);
			element.visibilityOfElementLocated(payablesLink);
			element.click(payablesLink);
			element.visibilityOfElementLocated(invoiceLink);
			element.click(invoiceLink);
			timer.pageLoad();
			timer.pause(5);
			element.visibilityOfElementLocated(taskIcon);
			element.click(taskIcon);
			element.visibilityOfElementLocated(manageInvoicePage);
			report.logs("manage invoice page", "---", "PASS", "navigateToManageInvoicePage", screenShotType.BROWSER);
			element.click(manageInvoicePage);
			timer.pageLoad();
			timer.pause(5);
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation");
		}
	}

	public void navigateToPayablesPage() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(homePageIcon));

		element.click(homePageIcon);
		timer.pageLoad();
		element.visibilityOfElementLocated(payablesLink);
		element.click(payablesLink);
		timer.pageLoad();
		element.visibilityOfElementLocated(paymentsLink);
		element.click(paymentsLink);
		timer.pageLoad();
		element.visibilityOfElementLocated(taskIcon);
		element.elementToBeClickable(taskIcon);
		element.click(taskIcon);
		timer.pause(2);
		element.visibilityOfElementLocated(submitPaymentProcessRequest);
		genMethods.waitForElementTobeClickable(submitPaymentProcessRequest);
		element.click(submitPaymentProcessRequest);
		timer.pageLoad();
		timer.pause(6);

	}

	public void navigateToCreateAccountingPage() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(homePageIcon));

		try {
			element.click(homePageIcon);
			timer.pageLoad();
			element.visibilityOfElementLocated(payablesLink);
			element.click(payablesLink);
			timer.pageLoad();
			timer.pause(3);
			element.visibilityOfElementLocated(paymentsLink);
			element.click(paymentsLink);
			timer.pageLoad();
			timer.pause(5);
			element.visibilityOfElementLocated(taskIcon);
			element.click(taskIcon);
			timer.pause(5);
			genMethods.waitForElementTobeClickable(By.xpath("//a[contains(text(),'Create Accounting')]"));
			element.elementToBeClickable(By.xpath("//a[contains(text(),'Create Accounting')]"));
			timer.pause(4);
			driver.findElement(By.xpath("//a[contains(text(),'Create Accounting')]")).click();
			timer.pageLoad();
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation");
		}
	}

	public void navigateToManagePaymentsPage() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(homePageIcon));

		element.click(homePageIcon);
		timer.pageLoad();
		element.click(payablesLink);
		timer.pageLoad();
		element.click(paymentsLink);
		timer.pageLoad();

		element.click(taskIcon);
		element.click(managePaymentsPage);
		timer.pageLoad();

	}

	public void navigateToAuditing() {
		element.click(homePageIcon);
		timer.pageLoad();
		element.elementToBeClickable(expensesLinkIcon);
		element.click(expensesLinkIcon);
		element.elementToBeClickable(auditing);
		element.click(auditing);
		timer.pageLoad();

		element.click(taskIcon);
		element.elementToBeClickable(manageExpenseReports);
		element.click(manageExpenseReports);
		timer.pageLoad();
	}

	public void navigateToExpenses() {
		element.click(homePageIcon);
		timer.pageLoad();
		genMethods.waitForElementTobeClickable(meLinkHomePage);
		timer.pause(3);
		driver.findElement(meLinkHomePage).click();
		timer.pageLoad();
		genMethods.waitForElementTobeClickable(expensesLink);
		timer.pause(3);
		driver.findElement(expensesLink).click();
		timer.pageLoad();
	}

	public void navigateToResisterSupplireLink() {
		element.click(homePageIcon);
		timer.pageLoad();
	
		element.click(procurementLink);
		element.click(suppliersLink);
		timer.pageLoad();

		element.click(taskIcon);
		genMethods.waitForElementTobeClickable(registerSupplier);
		element.click(registerSupplier);
		timer.pageLoad();
	}

	public void navigateToManageSupplierResistration() {

		element.click(homePageIcon);
		timer.pageLoad();
		element.click(procurementLink);
		element.click(suppliersLink);
		timer.pageLoad();

		element.click(taskIcon);
		genMethods.waitForElementTobeClickable(manageSupplierRequest);
		element.click(manageSupplierRequest);
		timer.pageLoad();

	}

	public void purchaseRequisition() {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(4);
			element.click(homePageIcon);
			timer.pageLoad();
			try {
				element.click(procurementLink);
			} catch (Exception e) {
				System.out.println("not available");
			}
			genMethods.waitForElementTobeClickable(purchaseRequisitionLink);
			report.logs("click on purchase requistion link", "---", "PASS", "purchaseRequistionLink",screenShotType.BROWSER);
			element.click(purchaseRequisitionLink);
			timer.pageLoad();
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in create requision navigation");
		}
	}
	
	public void openNavigator() {
		element.visibilityOfElementLocated(By.xpath("//a[contains(@class,'TabletNavigatorIcon')]"));
		element.elementToBeClickable(By.xpath("//a[contains(@class,'TabletNavigatorIcon')]"));
		element.click(By.xpath("//a[contains(@class,'TabletNavigatorIcon')]"));
		timer.pause(2);
	}

	public void navigateToPurchaseRequisitionFromNavigator() {
		element.elementToBeClickable(By.xpath("//a[contains(@id,'nv_itemNode_my_information_purchase_requisitions')]"));
		timer.pause(2);
		element.click(By.xpath("//a[contains(@id,'nv_itemNode_my_information_purchase_requisitions')]"));
		timer.pageLoad();
		timer.pause(2);
	}
	public void navigateToPurchaseOrdersFromNavigator() {
		element.elementToBeClickable(By.xpath("//a[@id='pt1:nv_itemNode_procurement_PurchaseOrders']"));
		timer.pause(2);
		element.click(By.xpath("//a[@id='pt1:nv_itemNode_procurement_PurchaseOrders']"));
		timer.pageLoad();
		timer.pause(2);
		element.visibilityOfElementLocated(taskIcon);
		element.click(taskIcon);
		element.visibilityOfElementLocated(processRequisitionLink);
		element.click(processRequisitionLink);
		timer.pageLoad();
	
	}
	
	public void navigateToManagePurchaseOrder()
	{
		element.elementToBeClickable(By.xpath("//a[@id='pt1:nv_itemNode_procurement_PurchaseOrders']"));
		timer.pause(2);
		element.click(By.xpath("//a[@id='pt1:nv_itemNode_procurement_PurchaseOrders']"));
		timer.pageLoad();
	
		
		timer.pause(2);
		element.visibilityOfElementLocated(taskIcon);
		element.elementToBeClickable(taskIcon);
		element.click(taskIcon);
		element.elementToBeClickable(By.xpath("//a[contains(text(),'Manage Orders')]"));
		element.click(By.xpath("//a[contains(text(),'Manage Orders')]"));
		
		
		
	}
	
	
	public void processRequisition() {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			try {
				element.click(procurementLink);
			} catch (Exception e) {
				System.out.println("procurmnt link is not present for this user");
			}
			element.visibilityOfElementLocated(purchaseOrderLink);
			element.click(purchaseOrderLink);
			timer.pageLoad();
			timer.pause(10);
			element.visibilityOfElementLocated(taskIcon);
			element.click(taskIcon);
			element.visibilityOfElementLocated(processRequisitionLink);
			report.logs("process requisition link", "---", "PASS", "purchaseRequistionLink",screenShotType.BROWSER);
			element.click(processRequisitionLink);
			timer.pageLoad();
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation");
		}
	}

	public void navigateToMyReceipts() {
		element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(procurementLink);
		element.click(myReceiptsLink);
		timer.pageLoad();

	}

	public void navigateToScheduledProcesses() {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(toolsLink);
			timer.pause(3);
			element.visibilityOfElementLocated(scheduledProcessesLink);
			element.click(scheduledProcessesLink);
			timer.pageLoad();
			timer.pause(10);
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation");
		}
	}

	public void navigateToScheduledProcesses(WebDriver driver) {
		genMethods.waitForElementTobeClickable(driver, homePageIcon);
		driver.findElement(homePageIcon).click();
		timer.pageLoad();
		genMethods.waitForElementTobeClickable(driver, toolsLink);
		driver.findElement(toolsLink).click();
		genMethods.waitForElementTobeClickable(driver, scheduledProcessesLink);
		driver.findElement(scheduledProcessesLink).click();
		;
	}

	public void navigateToBilling() {
		element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(receivablesLink);
		element.click(billingLink);

	}

//	

	public void navigateToAccountReceivables() {

		element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(receivablesLink);
		element.click(accountReceivablesLink);
		timer.pageLoad();
	}

	public void navigateToCreateReceipt() throws Exception {
		element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(receivablesLink);
		element.click(accountReceivablesLink);
		element.elementToBeClickable(taskIcon);
		new ActionPerformer(driver, 5).clickVerifyRepeat(taskIcon, createReceiptLink, 20, 5,
				Long.parseLong(Xenon.configProperties.get("DEFAULTTIME")));
		element.visibilityOfElementLocated(createReceiptLink);
		element.click(createReceiptLink);
		timer.pageLoad();
	}

	public void navigateToManageReceipts() {
		element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(receivablesLink);
		element.click(accountReceivablesLink);
		timer.pageLoad();
		element.visibilityOfElementLocated(taskIcon);
		// Added hard wait
		// Even if taskIcon is visible, sometime the javascript does not get loaded
		// immediately
		// Hence even if script clicks on the taskIcon, the task bar does not expand
		// To handle this hard wait is added
		timer.pause(5);
		element.click(taskIcon);
		element.visibilityOfElementLocated(manageReceiptsLink);
		element.click(manageReceiptsLink);
		timer.pageLoad();
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToManageLocations(ActionPerformer action) {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(setupAndMaintenanceLink);
			timer.pageLoad();
			// Added hard wait
			// Even if taskIcon is visible, sometime the javascript does not get loaded
			// immediately
			// Hence even if script clicks on the taskIcon, the task bar does not expand
			// To handle this hard wait is added
			timer.pause(5);
			action.click(dropButton);
			element.visibilityOfElementLocated(projectFinancialManagementLink);
			report.logs("project financial link", "---", "PASS", "ManageLocations", screenShotType.BROWSER);
			action.click(projectFinancialManagementLink).waitTime(2);
			element.visibilityOfElementLocated(enterpriseProfileRow);
			report.logs("enterprise profile row", "---", "PASS", "ManageLocations", screenShotType.BROWSER);
			action.click(enterpriseProfileRow);
			element.visibilityOfElementLocated(manageLocationsLink);
			report.logs("manage location link click", "---", "PASS", "ManageLocations", screenShotType.BROWSER);
			action.click(manageLocationsLink).waitTime(10);
			timer.pageLoad();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @author prajakta.patil
	 * @throws Exception 
	 */
	public void navigateToReportAnalytics() throws Exception {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(5);
			actions.click(homePageIcon);
			timer.pageLoad();
			timer.pause(2);
			element.visibilityOfElementLocated(toolsLink);
			report.logs("tools icon", "---", "PASS", "report Analytics", screenShotType.BROWSER);
			element.click(toolsLink);
			timer.pause(2);
			element.visibilityOfElementLocated(reportandAnalytics);
			report.logs("click on report analytics", "---", "PASS", "report Analytics", screenShotType.BROWSER);
			element.click(reportandAnalytics);
			timer.pageLoad();
		} catch (Exception e) {
			Assert.assertFalse(false, "error in navigating to report analytics");
		}

	}

	/**
	 * @author Prajakta.Patil
	 */
	public void navigateToManageAccountCombinations() {
		ActionPerformer action = new ActionPerformer(driver);

		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(7);
			report.logs("Click on set up maintenance link ", "---", "PASS", "disableCCID", screenShotType.BROWSER);
			action.click(setupAndMaintenanceLink);
			timer.pageLoad();
			element.visibilityOfElementLocated(dropButton);
			report.logs("Drop down button", "---", "PASS", "disableCCID", screenShotType.BROWSER);
			timer.pause(5);
			action.click(dropButton);
			action.click(FinancialsLink).waitTime(2);
			element.visibilityOfElementLocated(SearchTasksInput);
			report.logs("Search task input", "---", "PASS", "disableCCID", screenShotType.BROWSER);
			driver.findElement(SearchTasksInput).sendKeys("Manage Account Combinations");
			element.visibilityOfElementLocated(SearchIcon);
			action.click(SearchIcon);
			element.visibilityOfElementLocated(ManageAccountCombinationsLink);
			report.logs("Manage account combination link click", "---", "PASS", "disableCCID", screenShotType.BROWSER);
			action.click(ManageAccountCombinationsLink);
			timer.pageLoad();

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating to manage accounts");
		}
	}

	/**
	 * @author Prajakta.Patil
	 */
	public void navigateToReportsAndAnalytics() {
		ActionPerformer action = new ActionPerformer(driver);
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(10);
			element.visibilityOfElementLocated(toolsLink);
			action.click(toolsLink).waitTime(5);
			element.visibilityOfElementLocated(reportsAndAnalyticsLink);
			report.logs("reportsAndAnalytics link", "---", "PASS", "reportsAndAnalytics", screenShotType.BROWSER);
			action.click(reportsAndAnalyticsLink);
			timer.pageLoad();

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating to report analytics");
		}
	}

	/**
	 * @author Prajakta.Patil
	 */
	public void navigateToManageCrossValidationRules() {
		ActionPerformer action = new ActionPerformer(driver);
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(10);
			element.visibilityOfElementLocated(setupAndMaintenanceLink);
			report.logs("setUp and maintenance link", "--", "PASS", "manageCrossRuleValidation", screenShotType.BROWSER);
			action.click(setupAndMaintenanceLink);
			timer.pageLoad();
			element.visibilityOfElementLocated(dropButton);
			report.logs("Dropdown button", "--", "PASS", "manageCrossRuleValidation", screenShotType.BROWSER);
			timer.pause(5);
			action.click(dropButton);
			action.click(FinancialsLink).waitTime(2);
			element.visibilityOfElementLocated(SearchTasksInput);
			report.logs("search task input", "--", "PASS", "manageCrossRuleValidation", screenShotType.BROWSER);
			driver.findElement(SearchTasksInput).sendKeys("Manage Cross");
			element.visibilityOfElementLocated(SearchIcon);
			action.click(SearchIcon);
			element.visibilityOfElementLocated(ManageCrossValidationRuleSelect);
			action.click(ManageCrossValidationRuleSelect);
			element.visibilityOfElementLocated(ManageCrossValidationRulesSelectFromTasks);
			report.logs("Manage cross rule validation", "--", "PASS", "manageCrossRuleValidation", screenShotType.BROWSER);
			action.click(ManageCrossValidationRulesSelectFromTasks);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating to manage cross validation");
		}

	}

	/**
	 * @author Prajakta.Patil
	 */
	public void navigateToJournals() {
		ActionPerformer action = new ActionPerformer(driver);
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(7);
			element.visibilityOfElementLocated(generalAccounting);
			action.click(generalAccounting);
			timer.pause(5);
			element.visibilityOfElementLocated(journals);
			action.click(journals).waitTime(10);
			//element.visibilityOfElementLocated(journals);
			//action.click(journals).waitTime(10);
			element.visibilityOfElementLocated(tasks);
			action.click(tasks).waitTime(5);
			element.visibilityOfElementLocated(createJournal);
			action.click(createJournal);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating to journals page");
		}

	}

	/**
	 * @author Prajakta.Patil
	 */
	public void manageJournals() {
		ActionPerformer action = new ActionPerformer(driver);
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(10);
			element.visibilityOfElementLocated(generalAccounting);
			report.logs("General Accounting", "---", "PASS", "viewJournalsToApprove", screenShotType.BROWSER);
			action.click(generalAccounting).waitTime(5);
			element.visibilityOfElementLocated(journals);
			report.logs("Journals", "---", "PASS", "viewJournalsToApprove", screenShotType.BROWSER);
			action.click(journals).waitTime(10);
			element.visibilityOfElementLocated(tasks);
			action.click(tasks).waitTime(3);
			element.visibilityOfElementLocated(manageJournal);
			report.logs("Manage Journal", "---", "PASS", "viewJournalsToApprove", screenShotType.BROWSER);
			action.click(manageJournal).waitTime(5);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating to manage journals page");
		}

	}

	/**
	 * @author Prajakta.Patil
	 */
	public void navigateToNotifications() {
		ActionPerformer action = new ActionPerformer(driver);
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(10);
			element.visibilityOfElementLocated(notifications);
			report.logs("Notification icon", "---", "PASS", "approveJournalEntry", screenShotType.BROWSER);
			action.click(notifications);
			report.logs("Notification expanded", "---", "PASS", "approveJournalEntry", screenShotType.BROWSER);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating to notification");
		}

	}


	/**
	 * @author Uday.Shankar
	 */
	public void navigateToManageDepartment(ActionPerformer action) {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(setupAndMaintenanceLink);
			timer.pageLoad();
			// Added hard wait
			// Even if taskIcon is visible, sometime the javascript does not get loaded
			// immediately
			// Hence even if script clicks on the taskIcon, the task bar does not expand
			// To handle this hard wait is added
			timer.pause(5);
			action.click(dropButton);
			element.visibilityOfElementLocated(projectFinancialManagementLink);
			action.click(projectFinancialManagementLink).waitTime(2);
			element.visibilityOfElementLocated(workforceStructuresRow);
			action.click(workforceStructuresRow);
			element.visibilityOfElementLocated(manageDepartmentLink);
			action.click(manageDepartmentLink);
			timer.pageLoad();
			timer.pause(10);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToManageProjectOrganizationClassification(ActionPerformer action) {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(setupAndMaintenanceLink);
			timer.pageLoad();
			// Added hard wait
			// Even if taskIcon is visible, sometime the javascript does not get loaded
			// immediately
			// Hence even if script clicks on the taskIcon, the task bar does not expand
			// To handle this hard wait is added
			timer.pause(5);
			action.click(dropButton);
			element.visibilityOfElementLocated(projectFinancialManagementLink);
			report.logs("projectFinancialLink", "---", "PASS", "ProjectOrganizationClassification", screenShotType.BROWSER);
			action.click(projectFinancialManagementLink).waitTime(2);
			element.visibilityOfElementLocated(projectOrganizationRow);
			report.logs("projetOrganizationRow", "---", "PASS", "ProjectOrganizationClassification", screenShotType.BROWSER);
			action.click(projectOrganizationRow);
			element.visibilityOfElementLocated(manageProjectOrgClasificationLink);
			report.logs("click on manage project organisation", "---", "PASS", "ProjectOrganizationClassification", screenShotType.BROWSER);
			action.click(manageProjectOrgClasificationLink);
			timer.pause(10);
			timer.pageLoad();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToManageOrganizationTrees(ActionPerformer action) {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(setupAndMaintenanceLink);
			timer.pageLoad();
			// Added hard wait
			// Even if taskIcon is visible, sometime the javascript does not get loaded
			// immediately
			// Hence even if script clicks on the taskIcon, the task bar does not expand
			// To handle this hard wait is added
			timer.pause(5);
			action.click(dropButton);
			element.visibilityOfElementLocated(projectFinancialManagementLink);
			action.click(projectFinancialManagementLink).waitTime(2);
			element.visibilityOfElementLocated(workforceStructuresRow);
			report.logs("workForceStructure", "---", "PASS", "manageOrganizationTree", screenShotType.BROWSER);
			action.click(workforceStructuresRow);
			element.visibilityOfElementLocated(manageOrgTreesLink);
			report.logs("manageOrgTreesLink", "---", "PASS", "manageOrganizationTree", screenShotType.BROWSER);
			action.click(manageOrgTreesLink).waitTime(10);
			timer.pageLoad();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToSetupAndMaintenance() {
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(setupAndMaintenanceLink);
			report.logs("maintennce link is clicked", "---", "PASS", "setUPAndMaintence",screenShotType.BROWSER);
			timer.pageLoad();
			// Added hard wait
			// Even if taskIcon is visible, sometime the javascript does not get loaded
			// immediately
			// Hence even if script clicks on the taskIcon, the task bar does not expand
			// To handle this hard wait is added
			timer.pause(10);
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation issue");
		}
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToCreateProjectFromTemplate() {
		timer.pause(3);
		element.visibilityOfElementLocated(homePageIcon);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(projectLink);
		element.click(projectFinancialManageLink);
		timer.pageLoad();
		timer.pause(5);
		element.visibilityOfElementLocated(taskIcon);
		element.click(taskIcon);
		genMethods.waitForElementTobeClickable(createProjectTemplateLink);
		element.click(createProjectTemplateLink);
		timer.pageLoad();
		timer.pause(10);
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToMyProjects() {
		timer.pause(3);
		element.visibilityOfElementLocated(homePageIcon);
		element.click(homePageIcon);
		timer.pageLoad();
		element.click(projectLink);
		element.click(projectFinancialManageLink);
		timer.pageLoad();
		timer.pause(10);
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToProductInformationManagement() {
		try {
			timer.pause(3);
			element.visibilityOfElementLocated(homePageIcon);
			element.click(homePageIcon);
			timer.pageLoad();
			element.click(productInformationManagementLink);
			timer.pageLoad();
			timer.pause(10);
		} catch (Exception e) {
			Assert.assertFalse(false, "Erro in navigation ");
		}
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToInventoryManagement() {
		try {
			timer.pause(3);
			element.visibilityOfElementLocated(homePageIcon);
			element.click(homePageIcon);
			timer.pageLoad();
			timer.pause(3);
			element.elementToBeClickable(supplyChainExecutionLink);
			element.click(supplyChainExecutionLink);
			timer.pause(3);
			element.visibilityOfElementLocated(inventoryManagementLink);
			report.logs("inventoryManagent link", "---", "PASS", "inventoryManagemnt",screenShotType.BROWSER);
			element.click(inventoryManagementLink);
			timer.pageLoad();
			timer.pause(10);
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in navigation");
		}
	}

	/**
	 * @author Uday.Shankar
	 */
	public void navigateToPurchaseOrder() {
		element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		element.click(homePageIcon);
		timer.pageLoad();
		element.elementToBeClickable(procurementLink);
		element.click(procurementLink);
		element.visibilityOfElementLocated(purchaseOrderLink);
		element.elementToBeClickable(purchaseOrderLink);
		element.click(purchaseOrderLink);
		timer.pageLoad();
		timer.pause(10);
	}

	/*

	 * @author Prajakta.Patil
	 */
	public void navigateToManageUnprocessedCosts() {
		ActionPerformer action = new ActionPerformer(driver);
		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(10);
			// element.visibilityOfElementLocated(projects);
			action.click(projects);
			// element.visibilityOfElementLocated(costs);
			report.logs("Cost option click", "---", "PASS", "Manage unprocessed", screenShotType.BROWSER);
			action.click(costs);
			timer.pause(10);
			// element.visibilityOfElementLocated(taskIcon);
			action.click(taskIcon);
			report.logs("Manage unprocess cost link click", "---", "PASS", "Manage unprocssed", screenShotType.BROWSER);		   
			timer.pause(5);
			action.click(manageUnprocessedCosts);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in manage unprocessed navigation");
		}
	}

    
    /**
     * @author Prajakta.Patil
     */
    public void navigateToCreateInvoice()
    {
    	ActionPerformer action=new ActionPerformer(driver);
    	try
    	{
    		element.visibilityOfElementLocated(homePageIcon);
    		timer.pause(3);
    		action.click(homePageIcon);
    		timer.pageLoad();
    		timer.pause(10);
    		element.visibilityOfElementLocated(payablesLink);
    		action.click(payablesLink);
    		element.visibilityOfElementLocated(invoiceLink);
    		action.click(invoiceLink);
    		timer.pause(15);
    		action.click(taskIcon);
    		element.visibilityOfElementLocated(createInvoice);
    		action.click(createInvoice);
	
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
	
    /**
     * @author Prajakta.Patil
     */
    public void navigateToManageProjectCosts()
    {
    	ActionPerformer action=new ActionPerformer(driver);
    	try
    	{
    		element.visibilityOfElementLocated(homePageIcon);
    		timer.pause(3);
    		action.click(homePageIcon);
    		timer.pageLoad();
    		timer.pause(10);
    		action.click(projects);
    		report.logs("Click on costs","---", "PASS", "ManageProjectNavigation", screenShotType.BROWSER);
    		action.click(costs);
    		timer.pause(20);
    		action.click(taskIcon);
    		report.logs("Click on manage project costs","---", "PASS", "ManageProjectNavigation", screenShotType.BROWSER);
    		action.click(manageProjectCosts);
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    		Assert.assertFalse(false, "Error in manage project cost navigation");
    	}
    }
    
    /**
     * @author Prajakta.Patil
     */
    public void navigateToManageUnrealeasedCosts()
    {
    	ActionPerformer action=new ActionPerformer(driver);
    	try
    	{
    		element.visibilityOfElementLocated(homePageIcon);
    		timer.pause(3);
    		action.click(homePageIcon);
    		timer.pageLoad();
    		timer.pause(10);
    		action.click(projects);
    		action.click(costs);
    		timer.pause(20);
    		action.click(taskIcon);
    		action.click(manageUnrealeasedCosts);
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    		Assert.assertFalse(false, "");
    	}
    }

    /**
     * @author Prajakta.Patil
     */
    public void navigateToProjectFinancialManagement()
    {
    	ActionPerformer action=new ActionPerformer(driver);
    	try
    	{
    		element.visibilityOfElementLocated(homePageIcon);
    		timer.pause(3);
    		action.click(homePageIcon);
    		timer.pageLoad();
    		timer.pause(10);
    		report.logs("click on project option", "---", "PASS", "projectFinancialManageent", screenShotType.BROWSER);
    		action.click(projects);
    		report.logs("click on projectFinancial option", "---", "PASS", "projectFinancialManageent", screenShotType.BROWSER);
    		action.click(projectFinancialManagement);
    		timer.pause(5);
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    		Assert.assertFalse(false, "Errorn in project financial managment navigation");
    	}
    }
    
    /**
     * @author Prajakta.Patil
     * 
     */
    public void navigateToProjectCosts()
    {
    	ActionPerformer action=new ActionPerformer(driver);
    	try
    	{
    		element.visibilityOfElementLocated(homePageIcon);
    		timer.pause(3);
    		action.click(homePageIcon);
    		timer.pageLoad();
    		timer.pause(10);
    		report.logs("Click on projects", "---", "PASS", "navigateToProjectCosts", screenShotType.BROWSER);
    		action.click(projects);
    		report.logs("Click on cost", "---", "PASS", "navigateToProjectCosts", screenShotType.BROWSER);
    		action.click(costs);
    		timer.pause(5);
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    		Assert.assertFalse(false, "Error in navigating to project cost");
    	}
    }
    
	public void navigateToManageChartOfAccounts() {
		ActionPerformer action = new ActionPerformer(driver);

		try {
			element.visibilityOfElementLocated(homePageIcon);
			timer.pause(3);
			action.click(homePageIcon);
			timer.pageLoad();
			timer.pause(7);
			action.click(setupAndMaintenanceLink);
			timer.pageLoad();
			element.visibilityOfElementLocated(dropButton);
			report.logs("Dropdown icon", "---","PASS", "navigateToManageChartOfAccounts", screenShotType.BROWSER);
			timer.pause(5);
			action.click(dropButton);
			action.click(FinancialsLink).waitTime(2);
			element.visibilityOfElementLocated(SearchTasksInput);
			report.logs("Search input", "---","PASS", "navigateToManageChartOfAccounts", screenShotType.BROWSER);
			driver.findElement(SearchTasksInput).sendKeys("Manage Chart of Accounts Value Sets");
			element.visibilityOfElementLocated(SearchIcon);
			report.logs("Search icon", "---","PASS", "navigateToManageChartOfAccounts", screenShotType.BROWSER);
			action.click(SearchIcon);
			element.visibilityOfElementLocated(ManageChartOfAccountsLink);
			report.logs("ManageChartOfAccounts link", "---","PASS", "navigateToManageChartOfAccounts", screenShotType.BROWSER);
			action.click(ManageChartOfAccountsLink);
			timer.pageLoad();

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertFalse(false, "Error in navigating ManageChartOfAccountsLink");
		}
	}

    public void navigateToAsset() 
    {
	ActionPerformer action = new ActionPerformer(driver);
    try
	 {
    	element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		action.click(homePageIcon);
		timer.pause(5);
		action.click(fixedAsset);
		report.logs("fixed asset link clicked", "---","PASS", "navigateToAsset", screenShotType.BROWSER);
		timer.pause(4);
		action.click(assetLink);
		report.logs("Asset link clicked", "---","PASS", "navigateToAsset", screenShotType.BROWSER);
		timer.pageLoad();
	 }
    catch (Exception ex) {
		ex.printStackTrace();
		Assert.assertFalse(false, "Error in navigation");
	}
}
    
	public void navigateTosetupAndMaintenance() throws Exception
	{
		ActionPerformer action = new ActionPerformer(driver);
	    try
		 {
	    element.visibilityOfElementLocated(homePageIcon);
		timer.pause(3);
		action.click(homePageIcon);
		timer.pause(5);
		element.click(setupAndMaintenanceLink);
		timer.pageLoad();
		 }
	    catch (Exception ex) {
			ex.printStackTrace();
		}
		
	 }
}

    	



	

