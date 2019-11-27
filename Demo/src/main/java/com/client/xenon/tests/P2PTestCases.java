package com.client.xenon.tests;

import java.util.LinkedHashMap;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.client.fusion.generic.GenericDeclarations;

public class P2PTestCases implements GenericDeclarations {
	
	LinkedHashMap<String, String> usernamePassword = new LinkedHashMap<String, String>();
	public String PRNumber = "";
	public String PONumber = "";
	public String invoiceGroup = "";
	public String invoiceNumberGenrated = "";
	 String processID = "";

	Object[][] loginData;

	@BeforeClass
	public void getLogininfo() {
		try {
			loginData = excel.getExcelData(P2PExcel, "Invoice_Login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(testName = "TCX-4", priority = 5, description = "create Noncatalog Requisition")
	public void createNoncatalogRequisition() throws Exception {

		Object[][] porequisitionData = excel.getExcelData(P2PExcel, "TC-19");

		String itemDescription = porequisitionData[0][0].toString();
		String Quantity = porequisitionData[0][1].toString();
		String price = porequisitionData[0][2].toString();
		String supplier = porequisitionData[0][3].toString();
		String suggBuyer = porequisitionData[0][4].toString();

		login.login(loginData[3][1].toString(), loginData[3][2].toString());
		//login.login("casey.brown", "WRs87857");
		navigate.purchaseRequisition();
		PRNumber = PROperations.createNoncatalogRequisition(itemDescription, Quantity, price, supplier, suggBuyer);
		login.logOutOfApplication(loginData[3][1].toString());
		System.out.println("Requisition number" + PRNumber);
	}

	@Test(testName = "TCX-5", priority = 6, description = "PR Request Approval")
	public void requestPRApproval() throws Exception {
		Object[][] approvalHierarchyData = excel.getExcelData(P2PExcel, "TC-20");

		usernamePassword.clear();
		for (int valCount = 0; valCount < approvalHierarchyData.length; valCount++) {
			usernamePassword.put(approvalHierarchyData[valCount][0].toString(),
					approvalHierarchyData[valCount][1].toString());
		}
		PROperations.initiateApprovalOfInvoiceWithoutNotiification(usernamePassword, PRNumber);

	}

	@Test(testName = "TCX-6", priority = 7, description = "Process Requisition")
	public void processRequisition() throws Exception {
		final String userName = loginData[2][1].toString();
		final String password = loginData[2][2].toString();
		login.login(userName, password);
		login.login(userName, password);
		navigate.processRequisition();
		PONumber = PROperations.processRequisition(PRNumber, userName, password);
		System.out.println("PO number created :"+PONumber);
		login.logOutOfApplication(userName);
	}

	@Test(testName = "TC-23", priority = 9, description = "Receive Items")
	public void receiveItems() throws Exception {
		login.login(loginData[3][1].toString(), loginData[3][2].toString());
		PROperations.receiveItems(PONumber);
		login.logOutOfApplication(loginData[3][1].toString());
	}

	@Test(testName = "TC-24", priority = 10, description = "Create invoice from requisition")
	public void createInvoice() throws Exception {
		login.login(loginData[2][1].toString(),loginData[2][2].toString());
		invoiceGroup = PROperations.createInvoiceFromRequisition(PONumber);
		System.out.println(invoiceGroup);
		login.logOutOfApplication(loginData[2][1].toString());
	}
	
	@Test(testName = "TC-25", priority = 59, description = "Validate Accounting on a non-PO Invoice")
	public void validateAccountingNonPOInvoice() throws Exception {

		final String userName = loginData[2][1].toString();
		final String password = loginData[2][2].toString();

		login.login(userName, password);
		navigate.navigateToManageInvoicePage();
		PROperations.validateReceiptAccounting(invoiceGroup);
		login.logOutOfApplication(userName);
	}
	
	
	@Test(testName = "TC-26", priority = 12, description = "Create batch payment")
	public void createBatchPaymentForInvoice() throws Exception {

		Object[][] createBatchPaymentsData = excel.getExcelData(P2PExcel, "TC-26");

		// added to excel
		String paymentType = createBatchPaymentsData[0][0].toString();
		String disbursementBackAccount = createBatchPaymentsData[0][1].toString();
		String paymentDocumentType = createBatchPaymentsData[0][2].toString();
		String paymentAndProcessProfileValue = createBatchPaymentsData[0][3].toString();
		//String invoiceGroupName = "test-" + (new Random()).nextInt(900000) + 100000;;

		login.login(loginData[2][1].toString(), loginData[2][2].toString());

		navigate.navigateToPayablesPage();
		PROperations.createPaymentBatch(paymentType, disbursementBackAccount, paymentDocumentType,
				paymentAndProcessProfileValue, "test-496452");

		login.logOutOfApplication(loginData[2][1].toString());
	}

	
	
	 @Test(testName = "TC-27", priority = 101, description = "Invoice - Create Accounting (Invoice Workbench) through Scheduled process")
		public void createAccounting() throws Exception {
			String UserName = loginData[2][1].toString();
			String Password = loginData[2][2].toString();
			login.login(UserName, Password);

			navigate.navigateToCreateAccountingPage();

			processID = PROperations.createAccounting();
			navigate.navigateToScheduledProcesses();
			PROperations.verifyStatusOfNewProcessOnScheduledProcessesPage(processID, 15);
			login.logOutOfApplication(UserName);

		}
}
