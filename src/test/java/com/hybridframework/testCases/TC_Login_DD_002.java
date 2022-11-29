package com.hybridframework.testCases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.pageObjects.LoginPage;
import com.hybridframework.utilities.XLUtils;

public class TC_Login_DD_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.submit();
	}
	
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "/src/test/java/com/hybridframework/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Steet1", i, j);   //1 0	
			}
		}
		return logindata;
	}

}
