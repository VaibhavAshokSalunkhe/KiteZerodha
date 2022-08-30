package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchingBrowser;
import pom.ZerodhaBuyPage;
import pom.ZerodhaFunds;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;

public class BuyPage extends BaseTest{
	
	@BeforeMethod
	public void launchingBrowser() throws EncryptedDocumentException, IOException
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
			ZerodhaHomePage zerodhHomePage=new ZerodhaHomePage(driver);
			zerodhHomePage.searchStock("adani", driver);
			zerodhHomePage.searchAndSelectDesiredStock(driver, "ADANIPOWER");
			zerodhHomePage.ClickOnSearchResultBuy();
	}

	
	@Test
	public void ClickOnBSERadioButton()
	{
		ZerodhaBuyPage zerodhaBuyPage=new ZerodhaBuyPage();
		zerodhaBuyPage.ClickOnBSE();
	}
	
	@Test
	public void ClickOnCoverButton()
	{
		ZerodhaBuyPage zerodhaBuyPage=new ZerodhaBuyPage();
		zerodhaBuyPage.ClickOnCover();
	}
	
	@Test
	public void ClickOnNSEwithReqularclickButtons()
	{
		ZerodhaBuyPage zerodhaBuyPage=new ZerodhaBuyPage();
		zerodhaBuyPage.ClickOnNSEwithReqularclick();
		WebElement click=driver.findElement(By.xpath("//input[@value='NSE']"));
		boolean result=click.isSelected();
		Assert.assertEquals(result, false);
	}
	
	@Test
	public void ClickOnNSEwithAMObutton()
	{
		ZerodhaBuyPage zerodhaBuyPage=new ZerodhaBuyPage();
		zerodhaBuyPage.ClickOnNseWithAMO();
		WebElement click=driver.findElement(By.xpath("//label[text()='AMO']"));
		boolean result=click.isEnabled();
		Assert.assertEquals(result, true);
	}
	
	
	
}
