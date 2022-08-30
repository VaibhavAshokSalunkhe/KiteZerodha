package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

import pojo.LaunchingBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;
@Listeners(utility.Listeners.class)
public class LoginPageTest extends BaseTest {
    ExtentReports reports;
	ExtentTest test;
    
	@BeforeTest
	public void addReport()
	{
		reports=Reports.generateReports();
	}
	
	@BeforeMethod
	public void lanuchBrowser()
	{
	   driver=LaunchingBrowser.chromeBrowser();
	}
	
	
	@Test
	public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test=reports.createTest("ZerodhaLoginTest");
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		String user=Parametrization.Getdata("Crendential", 0, 1);
		String pass=Parametrization.Getdata("Crendential", 1, 1);
		String pin=Parametrization.Getdata("Crendential", 2, 1);
		
		zerodhaLoginPage.enterUserName(user);
		zerodhaLoginPage.enterPassWord(pass);
		zerodhaLoginPage.clickOnSubmit();
		
		zerodhaLoginPage.enterPin(pin, driver);
		zerodhaLoginPage.clickOnContinue();
		Assert.assertTrue(true);
		
	}
	
	@DataProvider (name="DataForTest")
	public Object [] [] data() {
	return new Object[][]  {{5,10,"velocity"},{10,5,"katraj"},{45,50,"pune"}};
	}
	
	@Test (dataProvider = "DataForTest")
	public void data (int a,int b,String c)
	{
		test=reports.createTest("data");
		System.out.println(a+b);
		System.out.println(c);
	}
	
	@Test
	public void forgotlink()
	{
		test=reports.createTest("forgotlink");
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		
		zerodhaLoginPage.clickOnForgot();
		
		zerodhaLoginPage.clickOnforgotmyuserID();
		zerodhaLoginPage.EnterPAN("skp45678g");
		zerodhaLoginPage.clickSMS();
		zerodhaLoginPage.EnterMobileno("9874562158");
		zerodhaLoginPage.EnterCaptcha("85648");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Forgot password / Kite");
	}
	
	@Test
	public void ForgotLinkByRememberUserID()
	{
		test=reports.createTest("ForgotLinkByRememberUserID");
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgot();
		
		zerodhaLoginPage.clickrememberuserID();
		zerodhaLoginPage.EnterUserID("5879dfr");
		zerodhaLoginPage.EnterPAN("dsg4567k");
		zerodhaLoginPage.ClickOnRadioButtonEmail();
		zerodhaLoginPage.EnterEmailID("xyz@gmail.com");
		zerodhaLoginPage.EnterCaptcha("4569875");
		zerodhaLoginPage.backToLogin();
		
	}
	
	@Test
	public void SignUplink()
	{
		test=reports.createTest("SignUplink");
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignup();
		
		zerodhaLoginPage.swithToSignupPage(driver);
		WebElement check=driver.findElement(By.xpath("//ul[@class='navbar-links']"));
		boolean page=check.isDisplayed();
		Assert.assertEquals(page, true);
	}
	
	@AfterMethod
	public void postTest(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
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
