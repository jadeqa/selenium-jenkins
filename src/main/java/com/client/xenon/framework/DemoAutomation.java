package com.client.xenon.framework;

import com.xenon.core.framework.Xenon;

/**
 * @author priyanka.mane
 * @purpose Automation will trigger form this main file
 */

public class DemoAutomation extends Xenon {

	public static void main(String[] args) throws Exception {
		Xenon xenon = Xenon.getXenonInstance();
		initiateData();
		xenon.excute("xml/testng.xml");
//		driver.quit();
	}

	
	private static void initiateData() {
		Constants.ApplicationURL = configProperties.get("ApplicationUrl");
	}
}