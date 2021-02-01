package com.client.xenon.tests;

import java.util.Random;

import org.testng.annotations.AfterSuite;
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
		sfdcObject.login("abhijeet.kulkarni@jadeglobal.com", "Abhijeet@123");
	}

	@Test(testName = "SFTC-1100", priority = 1, description = "Create campaign Salesforce")
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

	@Test(testName = "SFTC-1101", priority = 2, description = "Create lead from campaign in Salesforce")
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

	@Test(testName = "SFTC-1102", priority = 3, description = "Convert a lead to create account,contact,opportunity")
	public void convertLeadtoOpportunity() throws Exception {
		sfdcObject.convertLeadToOpportunity("John Smith");
	}
	
	@Test(testName = "SFTC-1103", priority = 4, description = "Verification check")
	public void verificationCheck() throws Exception {
//		sfdcObject.verificationCheck("LastNamen6r1lMgfo3Dch");
//		sfdcObject.verificationCheck("LastNamen6r1lMgfo3Dch12");
//		sfdcObject.logOutOfApplication(driver);
		
		
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
		sfdcObject.createCampaign("", type, status, expectedRevenue, budgetedCost, actualRevenue,
				expectedReturn);


	}
	@AfterSuite
	public void cleanup() {
//		driver.quit();
	}

	
}
