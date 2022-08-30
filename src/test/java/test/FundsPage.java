package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchingBrowser;
import pom.ZerodhaFunds;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;
@Listeners(utility.Listeners.class)
public class FundsPage extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	@BeforeMethod
	public void addReport()
	{
		reports=Reports.generateReports();
	}
	
	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, IOException
	{
		
		driver=LaunchingBrowser.chromeBrowser();
		ZerodhaLoginPage zerodhalogin=new ZerodhaLoginPage(driver);
		String user=Parametrization.Getdata("Crendential", 0, 1);
		String pass=Parametrization.Getdata("Crendential", 1, 1);
		String pin=Parametrization.Getdata("Crendential", 2, 1);
		zerodhalogin.enterUserName(user);
		zerodhalogin.enterPassWord(pass);
		zerodhalogin.clickOnSubmit();
		
		zerodhalogin.enterPin(pin, driver);
		zerodhalogin.clickOnContinue();
		ZerodhaFunds zerodhafunds=new ZerodhaFunds();
		zerodhafunds.ClickOnFunds();
	}
	
	

	@Test
	public void ClickOnWithdrawButton() throws InterruptedException
	{
		test=reports.createTest("ClickOnWithdrawButton");
		ZerodhaFunds zerodhafunds=new ZerodhaFunds();
		zerodhafunds.ClickOnWithDraw();
	}
	
	@DataProvider (name="DataForTest1")
	public Object [] [] data(){
		return new Object [] [] {{5,10},{5,8},{40,5}};
	
		}
	
	@Test (dataProvider="DataForTest1")
	public void data(int a,int b)
	{
		test=reports.createTest("data");
		System.out.println(a+b);
	}
	
	
	
	
	@Test
	public void ClickOnViewstatementbutton() throws InterruptedException
	{
		test=reports.createTest("ClickOnViewstatementbutton");
		ZerodhaFunds zerodhafunds=new ZerodhaFunds();
		zerodhafunds.ClickOnViewStatement();
		
	}
	
	@AfterMethod
	public void PostTest(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterTest
	public void flushReport()
	{
		reports.flush();
	}
}
