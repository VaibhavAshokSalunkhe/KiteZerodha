package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;

public class ZerodhaFunds extends BaseTest {
	
	@FindBy (xpath="//a[text()='Withdraw']")private WebElement clickOnWithdraw;
	@FindBy (xpath="//span[text()='View statement']")private WebElement clickOnViewStatement;
	@FindBy (xpath="(//a[@target='_blank'])[3]") private WebElement clickOnHelp;
	@FindBy (xpath="//a[@href='https://console.zerodha.com/account/segment-activation']")private WebElement clickOnActivate;
	@FindBy(xpath="//span[text()='Funds']")private WebElement clickOnFunds;
	
	
	public ZerodhaFunds()
	{
		PageFactory.initElements(driver,this);
	}

	public void ClickOnWithDraw() throws InterruptedException
	{
		
		clickOnWithdraw.click();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String>i=handles.iterator();
		
		while(i.hasNext())
		{
			String s=i.next();
			driver.switchTo().window(s);
			String title=driver.getTitle();
			
			if(title.equals("Funds / Console"))
			{
				
				WebElement amount=driver.findElement(By.xpath("//input[@placeholder='Amount to withdraw']"));
				amount.sendKeys("5000");
			}
		}
	}
	public void ClickOnViewStatement() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnViewStatement.click();
		Set<String>handle=driver.getWindowHandles();
		Iterator<String>i=handle.iterator();
		
		while(i.hasNext())
		{
			String hand=i.next();
			driver.switchTo().window(hand);
			String title=driver.getTitle();
			
			
			if(title.equals("Statement / Console"))
			{
				
				//WebElement co=driver.findElement(By.xpath("//form//select//option"));
				//Select s=new Select(co);
				//s.selectByVisibleText("Commodity");
				
				Thread.sleep(2000);
				WebElement a=driver.findElement(By.xpath("//input[@placeholder='Date']"));
				a.click();
				
				
				
				
				//WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
			   // submit.click();
						
				
			}
			
		}
	}
	
	public void ClickOnHelp()
	{
		clickOnHelp.click();
	}
	
	public void ClickOnFunds()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOnFunds));
		clickOnFunds.click();
	}
	
}
