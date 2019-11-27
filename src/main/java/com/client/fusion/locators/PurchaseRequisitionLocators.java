package com.client.fusion.locators;

import org.openqa.selenium.By;

public interface PurchaseRequisitionLocators {

	By moreTask = By.xpath(".//a[contains(text(),'More Tasks')]");
	By myReceiptsLink = By.xpath(".//a[text()='My Receipts']");
	By requestNonCatItem = By.xpath(".//td[contains(text(),'Request Noncatalog Item')]");
	By itemDesc = By.xpath(".//label[contains(text(),'Item Description')]/../..//textarea");
	By categoryName = By.xpath(".//label[contains(text(),'Category Name')]/../../td/a");
	By searchBtn = By.xpath(".//button[contains(text(),'Search')]");
	By corp = By.xpath("(//span[contains(text(),'Laptops')])[1]");
	By OKbtn = By.xpath("(.//button[text()='OK'])[1]");
	By Quantity = By.xpath(".//label[text()='Quantity']/../..//input");
	By UOM = By.xpath("(.//label[text()='UOM Name']/../..//a)[1]");
	By day = By.xpath("(.//span[text()='Each'])[1]");
	By price = By.xpath(".//label[contains(text(),'Price')]/../..//input");
	By supplier = By.xpath(".//label[text()='Supplier']/../..//input");
	// By liTxtChampoin = By.xpath(".//li[contains(text(),'CHAMPION NATIONAL
	// SECURITY')]");
	By liTxtChampoin = By.xpath(".//li[contains(text(),'Advanced Corp')]");
	By addToCart = By.xpath(".//span[text()='Add to Cart']");
	// By clickonDone =
	// By.xpath("(.//span[text()='Done']/../../../following-sibling::td[1]//img)[1]");
	By clickonDone = By.xpath("//img[@title='Shopping Cart']/following-sibling::span");
	By clickonReview = By.xpath(".//button[text()='Review']");
	By clickonSuggBuyer = By.xpath(".//label[text()='Suggested Buyer']/../..//input");
	By clickonSub = By.xpath("//span[text()='Sub']");
	By clickonNotifi = By.xpath("//a[contains(.,'Notifications')]");
	By enterSearchTerm = By.xpath("//input[contains(@placeholder,'Enter search terms')]");
	By search = By.xpath("//button[contains(@title,'Search')]");
	By approve3 = By.xpath("(.//a[contains(.,'Approve')])[3]");
	By requisition = By.xpath(".//label[text()='Requisition']/../..//input");
	By addToDocBuilder = By.xpath(".//button[contains(text(),'Add to Document Builder')]");
	By create = By.xpath("//button[contains(text(),'Create')]");
	By order = By.xpath(".//label[text()='Order']/../..//td[2]");
	By task = By.xpath(".//img[@title='Tasks']");
	By manageOrder = By.xpath(".//a[text()='Manage Orders']");
	By purchaseOrder = By.xpath(".//label[contains(text(),'Purchase Order')]/../..//input");
	By ItemsDue = By.xpath(".//label[contains(text(),'Items Due')]/../..//select");
	By receive = By.xpath(".//button[contains(text(),'Receive')]");
	By quantity = By.xpath(".//label[contains(text(),'Quantity')]/../..//input");
	By waybill = By.xpath(".//label[contains(text(),'Waybill')]/../..//input");
	By submitButton = By.xpath("//*[normalize-space(text())='Submit']");
	By confirmationMessage = By.xpath("(//*[contains(normalize-space(text()),'was submitted')])[1]");
	By confirmationMessageOkButton = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View PDF'])[1]/following::span[1]");
	//
	By expandAdvancedSearch = By.xpath(".//a[@title='Expand Advanced Search']");
	By buyer = By.xpath(".//label[text()='Buyer']/../..//input");
	// invoice frmo requisition
	By numberField = By.xpath(".//label[text()='Number']/../following-sibling::td/input");
	By amountField = By.xpath(".//td/label[contains(text(),'Amount')]/../..//input");
	By selectPO = By.xpath("//label[contains(.,'Identifying PO')]/../following-sibling::td/input");

	By saveButton = By.xpath(".//*[text()='Save']");
	By invoiceAction = By.partialLinkText("Invoice Actions");
	By validateOption = By.xpath(".//*[contains(text(),'Validate')]");
	By procurmentBU = By.xpath("//*[contains(text(),'Procurement BU')]/ancestor::h1/..//select");
	By requisitionBU = By.xpath(
			"//label[contains(text(),'Requisitioning BU')]/ancestor::tr[contains(@id,'procurement_Purchase')]//select");
	By procurmentBU1 = By.xpath(
			"//label[contains(text(),'Procurement BU')]/ancestor::tr[contains(@id,'procurement_Purchase')]//select");
	By okButtonDocBuilder = By.xpath("//button[contains(text(),'O') ]//span[contains(text(),'K')]");
	By matchInvoiceLine = By.xpath(
			"//h1[contains(text(),'Lines')]/../../following-sibling::td//select[contains(@id,'payables_payables_invoices')]");
	By matchLineIcon = By.xpath("//h1[contains(text(),'Lines')]/../../following-sibling::td//a");
	By lineCheckbox = By.xpath("(//input[contains(@type,'checkbox')]/following-sibling::label)[2]");
	By okButton = By.xpath("(.//span[text()='K'])[1]");
	By applyButton = By.xpath("(.//span[text()='l'])[1]");
	


	By businessUnitDropDown = By.xpath(".//*[text()='Business Unit']/../..//span/a");
	By supplierText = By.xpath(".//*[text()='Supplier']/../..//input");
	//By numberField = By.xpath(".//label[text()='Number']/../following-sibling::td/input");
	//By amountField = By.xpath(".//td/label[contains(text(),'Amount')]/../..//input");
	By clickTypeField = By.xpath(".//td/label[contains(text(),'Type')]/../..//select");
	By clickDistributionCombinationIcon = By.xpath("//a[contains(@title,'Search: Distribution Set')]");
	By projectInvoiceDisSet = By.xpath("//td[contains(text(),'Project Invoice Distribution Set')]");
	By OkButtonOnCombinationID = By.xpath(".//button/span[contains(text(),'K')]");
	By validatedSuccessfully = By.xpath(".//span[text()='Validated']");
	By canceledInvoiceStatus = By.xpath(".//*[text()='Validation']/../..//span[text()='Canceled']");
	By invoiceNumberTextBox = By.xpath(".//label[text()=' Invoice Number']/../..//input");
	By searchButton = By.xpath(".//button[text()='Search']");
	By cancelInvoice = By.xpath(".//*[text()='Cancel Invoice']");
	By editInvoiceIcon = By.xpath(".//img[@title='Edit']");
	By selectInvoiceGroup = By.xpath("//label[contains(text(),'Invoice Group')]/../following-sibling::td//input");
	By taskIcon = By.xpath(".//img[@title='Tasks']");
	By manageInstallment = By.xpath(".//td[contains(text(),'Manage Installments')]");
	By selectPaymentMethod = By.xpath("//label[contains(text(),'Payment Method')]/../input");
	By paymentMethod = By.xpath("//li[contains(text(),'Check')]");
	By saveAndCloseButton = By.xpath("//button[contains(text(),'ave and Close')]");

	//By saveButton = By.xpath(".//*[text()='Save']");
	//By invoiceAction = By.partialLinkText("Invoice Actions");
	By action = By.partialLinkText("Actions");
	//By validateOption = By.xpath(".//*[contains(text(),'Validate')]");
	By selectValidate = By.xpath(".//td[contains(text(),'Validate')]");

	By paymentName = By.xpath("//label[contains(text(),'Name')]/../following-sibling::td/input");
	By selectTemplate = By.xpath("//label[contains(text(),'Template')]/../following-sibling::td//input");
	By paymentAndProcessingOptions = By.xpath("(//a[contains(text(),'Payment and Processing Options')])[1]");
	By disbursementBankAccount = By
			.xpath("//label[contains(text(),'Disbursement Bank Account')]/../following-sibling::td//input");
	By paymentDocument = By.xpath("//label[contains(text(),'Payment Document')]/../following-sibling::td//select");
	By paymentAndProcessProfile = By
			.xpath("//label[contains(text(),'Payment Process Profile')]/../following-sibling::td//input");

	By invoiceGroupTextBox = By.xpath("//label[contains(.,'Invoice Group')]/../following-sibling::td/input");
	By paymentTermsTextBox = By.xpath("//label[contains(text(),'Payment Terms')]/../following-sibling::td/span/input");
	By selectEffectiveFrom = By.xpath("//li[contains(text(),'Immediate')]");
	By selectRequesterTextbox = By.xpath("//label[contains(text(),'Requester')]/../following-sibling::td/input");
	By expandLines = By.xpath("//a[contains(@title,'Expand Lines')]");
	By collapseLines = By.xpath("//a[contains(@title,'Collapse Lines')]");
	By amountTextbox = By.xpath("(.//label[text()='Amount']/../input)[2]");
	By distributionSetTextbox = By.xpath("//label[contains(text(),'Distribution Set')]/preceding-sibling::input");
	By okButtonOnDialogBox = By.xpath("//td[contains(@id,'d1::msgDlg::_fcc')]//button[contains(text(),'OK')]");
	By approval = By.xpath(".//td[(text()='Approval')]");
	By initiateLink = By.xpath(".//td[(text()='Initiate')]");

	// initiateApprovalOfInvoice
	// verifyInvoiceStatus
	By invoiceNumberTextboxOnManageInvoice = By
			.xpath("//label[contains(.,'Invoice Number')]/../following-sibling::td//input");
	By searchButtonOnManageInvoice = By.xpath("//button[contains(text(),'Search')]");
	By noResultsFoundMessage = By.xpath("//div[contains(text(),'No results found.')]");
	By searchResultTable = By.xpath("(//table[contains(@summary,'Search Results')]//td)[22]");

	//
	By selectionCriteria = By.xpath("(//a[contains(text(),'Selection Criteria')])[1]");
	By invoiceGroupTextboxPayment = By.xpath("//label[text()='Invoice Group']/../following-sibling::td//input");
	By disbursementAccountTextfield = By
			.xpath("//label[contains(.,'Disbursement Bank Account')]/../following-sibling::td//input");

	By submitButtonPaymentPage = By.xpath("//span[contains(text(),'Sub')]/..");
	By refreshButton = By.xpath("(//a[contains(@title,'Refresh')])[1]");
	By resumePaymentProcessButton = By.xpath("//button[contains(text(),'Resume Payment Process')]");
	By expandButtonPaymentPage = By.xpath("(//a[contains(@title,'Expand')])[last()]");
	By printPaymentDocumentButton = By.xpath("(//a[contains(@title,'Print payment documents')])[last()]");
	By printButtonPayment = By.xpath("(//button[contains(text(),'Print')])[1]");
	By paymentFileDetails = By.xpath("(//a[contains(@title,'Payment file details')])[last()]");
	By recordPrintStatusButton = By.xpath("(//button[contains(text(),'Record Print Status')])[1]");
	By createPositiveFileCheckbox = By.xpath("//label[contains(text(),'Create positive pay file immediately')]");
	By submitButtonRecordPrintStatus = By.xpath("(//button[contains(text(),'Submit')])[1]");
	By recordthePrintStatusButton = By.xpath("(//button[contains(text(),'Record the Print Status')])[1]");
	By okButtonRecordPrintStatus = By.xpath("//button[contains(@id,'commandButton1')]");

	// create payment for expenses
	By partyNameID = By.xpath("//input[contains(@id,'partyNameId')]");
	By reviewProposedPayments = By.xpath("//img[contains(@title,'Review proposed payments')]/..");

	// schedulesprocesses
	By processSubmittedMessage = By.xpath("//div[contains(text(),'Your process')]");
	By okButtonOnProcessesMessage = By.xpath("(//button[contains(text(),'OK')])[1]");
	By scheduledProcessesLabel = By.xpath("//h2[contains(.,'Schedule Requests')]");
	By selectTimeRange = By.xpath("//label[contains(text(),'Time Range')]/../following-sibling::td//select");
	By refreshOnScheduledProcesses = By.xpath("(//div[contains(@title,'Refresh')]/a)[2]");
	By supplierSiteOnPaymentHold = By.xpath("//h2[contains(text(),'Supplier Sites on Payment Hold')]");

	// createAccountingAfterPayment

	By selectAccontingType = By.xpath("//select[contains(@id,'SubledgerApplicationAttr')]");
	By selectLedgerType = By.xpath("//label[text()='Ledger']/../following-sibling::td//input");
	By selectPostinLedger = By.xpath("//label[text()='Post in General Ledger']/../following-sibling::td//select");
	By endDateForAccounting = By.xpath("(//label[contains(text(),'End Date')]/../following-sibling::td/input)[1]");
	By submittedSucessfullyMessage = By.xpath("//*[contains(text(),'was submitted')]");
	By cancelButtonOnAccountingPage = By.xpath("//span[contains(.,'ancel')]/parent::a");
	By accountingLastProcessStatusIsSucceeded = By.xpath(
			"(//table[contains(@summary,'List of Processes Meeting Search Criteria')]/tbody/tr[1]//td[contains(.,'Maintain Payables Trial Balance Report')])[2]/following-sibling::td[contains(.,'Succeeded')]");

	// payInvoiceInFull

	By invoiceDetailsLabel = By.xpath("//h1[contains(text(),'Invoice Details')]");
	// changeAmountOfExistingExpense
	By inProgressLink = By.xpath("//a[contains(text(),'Requires Action')]");
	By receiptAmountTextbox = By.xpath("(//input[contains(@id,'ReceiptAmount')])[1]");
	By closeButton = By.xpath("//span[contains(text(),'Close')]/..");
	By checkBoxOnSelectInvoice = By.xpath("//input[contains(@type,'checkbox')]/following-sibling::label");
	By releaseNameDropdown = By.xpath("//span[@class='x1z']//select[contains(@id,'payables_invoices')]");
	By selectAmountApproved = By.xpath("//option[@title='Amount approved']");
	By recentlyCompleted = By.xpath("(//a[contains(text(),'Recently Completed')])[1]");
	By paymentFileName = By.xpath("//img[@title='Name']//parent::span/a[2]");
	
	By paymentMethodWire = By.xpath("//li[contains(text(),'Wire')]");
	By approveLink = By.xpath(".//td[contains(text(),'Approve')]");
	By actionsLink1 = By.xpath("//a[contains(text(),'Actions')]/../..//div");
	By moreDetailsLink = By.xpath("//a[contains(text(),'More Details')]");
	By selectProcessType = By.xpath("//label[contains(text(),'Process Category')]/../following-sibling::td//select");
	By homePageIcon = By.xpath(".//div/a[@title='Home']");
	By scheduleProcessRefreshButton = By.xpath("//a[./img[@title='Refresh']]");
	By doneButton = By.xpath("//button[contains(.,'ne')]");
	By paymentDateOnManagementPayment = By.xpath("(//label[text()='Payment Date']/../following-sibling::td//input)[1]");
	By viewAccounting = By.xpath("//td[contains(text(),'View Accounting')]");
	By accountDraft = By.xpath("//*[normalize-space(text())='Account in Draft']");
	By viewAccountingButton = By.xpath("//*[normalize-space(text())='View Accounting']");
	By doneButton1 = By.xpath("//button[normalize-space(text())='D']");
}
