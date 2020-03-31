package com.client.xenon.tests;

import java.util.Random;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.client.xenon.operations.PageObjects;
import com.xenon.core.framework.Xenon;
import com.xenon.excel.xlsx.ReadExcel;

public class AccountToOpportunityFlow extends Xenon {

	PageObjects sfdcObject = new PageObjects();
	ReadExcel readExcel = new ReadExcel();

	String quoteName="New Quote Nov 2019";
	
	@BeforeSuite
	public void setup() {
		sfdcObject.login("abhijeet.kulkarni@jadeglobal.com", "Jade@1234");
	}

//	@Test(testName = "SFTC-1094", priority = 2, description = "Create Account in Salesforce")
	public void createAccountSalesforce() throws Exception {

		sfdcObject.navigateToSales();
		sfdcObject.gotoAccounts();
		sfdcObject.createAccount();

	}

//	@Test(testName = "SFTC-1095", priority = 2, description = "Create opty in Salesforce")
	public void createOpportunityInSFDC() throws Exception {
		sfdcObject.gotoOpportunity();
		sfdcObject.createOpportunity();
	}

	@Test(testName = "TestApp-1", priority = 1, description = "Create campaign Salesforce")
	public void createCampaign() throws Exception {
		Random random = new Random();
		int randomCampaignNumber = random.nextInt(150000);

		Object[][] data = readExcel.getExcelData("src/main/resources/Excel/SFDC_Data.xlsx", "CreateCampaign");

		String campaignName = data[0][0].toString();
		String type = data[0][1].toString();
		String status = data[0][2].toString();
		String expectedRevenue = data[0][3].toString();
		String budgetedCost = data[0][4].toString();
		String actualRevenue = data[0][5].toString();
		String expectedReturn = data[0][6].toString();

		String randomCampaignName = campaignName + randomCampaignNumber + "";
		sfdcObject.gotoCampaign();
		sfdcObject.createCampaign(randomCampaignName, type, status, expectedRevenue, budgetedCost, actualRevenue,
				expectedReturn);

	}

	@Test(testName = "SFTC-1097", priority = 2, description = "Create lead from campaign in Salesforce")
	public void createLeadFromCampaign() throws Exception {

		Object[][] data = readExcel.getExcelData("src/main/resources/Excel/SFDC_Data.xlsx", "CreateLeadFromCampaign");
		String salutation = data[0][0].toString();
		String firstname = data[0][1].toString();
		String lastname = data[0][2].toString();
		String email = data[0][3].toString();
		String phone = data[0][4].toString();
		String company = data[0][5].toString();

		sfdcObject.createLeadFromCampaign(salutation, firstname, lastname, email, phone, company);
	}

	@Test(testName = "SFTC-1098", priority = 3, description = "Convert a lead to create account,contact,opportunity")
	public void convertLeadtoOpportunity() throws Exception {
		sfdcObject.convertLeadToOpportunity("John Smith");
	}
	
	@Test(testName = "SFTC-1099", priority = 4, description = "Verification check")
	public void verificationCheck() throws Exception {
		sfdcObject.verificationCheck("David Richard");
		sfdcObject.verificationCheck("DavidRichard");
	}

	@Test(testName = "SFTC-1096", priority = 4, description = "Convert a lead to create account,contact,opportunity")
	public void verifyAccountCreation() throws Exception {
		//sfdcObject.verifyAccountCreation();
	}


	@Test(testName = "SFTC-1099", priority = 5, description = "Create a quote from an Opportunity")
	public void createQuoteFromOpportunity() throws Exception {
		
		
		//sfdcObject.createQuoteFromOpportunity(quoteName);
	}

	@Test(testName = "SFTC-1100", priority = 6, description = "Create a quote from an Opportunity")
	public void addLineItemsToQuote() throws Exception {
		
		//sfdcObject.addLineItemsToTheQuote(quoteName);
	}

}
