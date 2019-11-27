package com.client.fusion.generic;


import com.xenon.excel.xlsx.ReadExcel;
import com.client.fusion.navigation.ApplicationNavigations;
import com.client.fusion.navigation.Login;
import com.client.xenon.operations.P2POperations;

public interface GenericDeclarations {

	P2POperations PROperations = new P2POperations();
	ApplicationNavigations navigate = new ApplicationNavigations();
	Login login = new Login();
	GenericMethods genMethods = new GenericMethods();
	ReadExcel excel = new ReadExcel();
	
	public String P2PExcel = "src/main/resources/Excel/P2PExcel.xlsx";
	public String SFDCExcel = "src/main/resources/Excel/SFDCExcel.xlsx";
   

}


