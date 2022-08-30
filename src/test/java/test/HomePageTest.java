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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchingBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;
@Listeners(utility.Listeners.class)
public class HomePageTest extends BaseTest {
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void addReport()
	{
		report=Reports.generateReports();
	}
	
	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, IOException
	{
		 driver=LaunchingBrowser.chromeBrowser();
		 ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
			
			String user=Parametrization.Getdata("Crendential", 0, 1);
			String pass=Parametrization.Getdata("Crendential", 1, 1);
			String pin=Parametrization.Getdata("Crendential", 2, 1);
			
			zerodhaLoginPage.enterUserName(user);
			zerodhaLoginPage.enterPassWord(pass);
			zerodhaLoginPage.clickOnSubmit();
			
			zerodhaLoginPage.enterPin(pin, driver);
			zerodhaLoginPage.clickOnContinue();
			
	}
	
	@Test
	public void SearchStockTest()
	{
		 test= report.createTest("SearchStockTest");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.searchStock("tata", driver);
		zerodhHomePage.searchAndSelectDesiredStock(driver, "TATAELXSI");
		int number=zerodhHomePage.getSearchResultnumber();
		System.out.println(number);
		Assert.assertTrue(number>0);
	}
	
	@Test
	public void ClickonBuyButton()
	{
		test=report.createTest("ClickonBuyButton");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.searchStock("adani", driver);
		zerodhHomePage.searchAndSelectDesiredStock(driver, "ADANIPOWER");
		zerodhHomePage.ClickOnSearchResultBuy();
				
	}
	
	@Test
	public void ClickOnSellButton()
	{
		test=report.createTest("ClickOnSellButton");
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("adani", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "ADANIPOWER");
		zerodhaHomePage.ClickOnSell();
	}

	@Test
	public void ClickonChart()
	{
		test=report.createTest("ClickonChart");
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("tata", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhaHomePage.ClickOnChart(driver);	
	}
	
	@Test
	public void ClickonMarketDepth()
	{
		test=report.createTest("ClickonMarketDepth");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.searchStock("tata", driver);
		zerodhHomePage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhHomePage.ClickOnMarketDepth();	
		
	}
	
	@Test
	public void ClickOnWatchList()
	{
		test=report.createTest("ClickOnWatchList");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.searchStock("bajaj", driver);
		zerodhHomePage.searchAndSelectDesiredStock(driver, "BAJAJ-AUTO");
		zerodhHomePage.ClickOnWatchList(driver);
		
	}
	
	@Test
	public void ClickOnOrders()
	{
		test=report.createTest("ClickOnOrders");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.ClickOnOrders(driver);
		zerodhHomePage.ClickOnOrderGTT();
	}
	
	@Test
	public void ClickOnHoldding()
	{
		test=report.createTest("ClickOnHoldding");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.ClickOnHolding(driver);
	}
	
	@Test
	public void ClickOnPositions()
	{
		test=report.createTest("ClickOnPositions");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.ClickOnPosition(driver);	
	}
	
	@Test
	public void ClickOnFunds()
	{
		test=report.createTest("ClickOnFunds");
		ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
		zerodhHomePage.ClickOnFunds(driver);
	}
	
	@Test
	public void ClickOnApp()
	{
		test=report.createTest("ClickOnApp");
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.ClickOnApp(driver);		
	}
	
	@Test
	public void ClickOnDashboard()
	{
		test=report.createTest("ClickOnDashboard");
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.ClickOnDashBoard(driver);
		WebElement page=driver.findElement(By.xpath("//span[text()='Dashboard']"));
		boolean a=page.isDisplayed();
	
		Assert.assertTrue(a, "true");
	}
	
	@Test
	public void ClickOnAdd()
	{
		test=report.createTest("ClickOnAdd");
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("divi", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "DIVISLAB");
		zerodhaHomePage.ClickOnAddButton();
				
	}
	
	
	@Test
	public void DeleteStock()
	{
		test=report.createTest("DeleteStock");
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		zerodhaHomePage.AddStockList(driver, "ADANIGREEN");
		zerodhaHomePage.ClickOndelete(driver);
	}
	
	@AfterMethod
	public void postTest(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE )
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
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
		report.flush();
	}
}
