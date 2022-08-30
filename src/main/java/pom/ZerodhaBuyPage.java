package pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;

public class ZerodhaBuyPage extends BaseTest  {
	
	@FindBy (xpath="")private WebElement clickonBuy;
	@FindBy (xpath="//input[@id='radio-184']")private WebElement clickOnBse;
	@FindBy (xpath="//input[@value='NSE']")private WebElement clickOnNSE;
	@FindBy (xpath="//label[text()='Regular']")private WebElement clickonRegular;
	@FindBy (xpath="//label[text()='Cover']")private WebElement clickOnCover;
    @FindBy (xpath="//label[text()='AMO']")private WebElement clickOnAMO;
	
	public ZerodhaBuyPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	

	
	public void ClickOnBSERadioButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOnBse));
		clickOnBse.click();
	}
	
	public void ClickOnBSE()
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(clickOnBse);	
	}
	
	public void  ClickOnCover()
	{
		Actions action=new Actions(driver);
		action.moveToElement(clickOnNSE);
		action.click();
		action.perform();
		action.moveToElement(clickOnCover);
		action.click();
		action.perform();		
	}
	
	public void ClickOnNSEwithReqularclick()
	{
		Actions action=new Actions(driver);
		action.moveToElement(clickOnNSE);
		action.click();
		action.perform();
		action.moveToElement(clickonRegular);
		action.click();
		action.perform();		
	}
	
	public void ClickOnNseWithAMO()
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
		//wait.until(ExpectedConditions.visibilityOf(clickOnNSE));
		Actions act=new Actions(driver);
		act.moveToElement(clickOnNSE);
		act.click();
		act.perform();
		act.moveToElement(clickOnAMO);
		act.click();
		act.perform();
		
	}
}
