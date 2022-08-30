package pom;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ZerodhaHomePage {
	
	@FindBy(xpath="//input[@type='text']")private WebElement search;
	@FindBy(xpath="//span[@class='tradingsymbol']")private List<WebElement> searchResult;
	@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement searchBuy;
	@FindBy(xpath="//button[@data-balloon='Sell']")private WebElement searchSell;
	@FindBy(xpath="//button[@data-balloon='Chart']")private WebElement clickOnChart;
	@FindBy(xpath="//button[@data-balloon='Market depth widget']")private WebElement clickOnMarketDepth;
	@FindBy(xpath="//span[@class='icon icon-plus']")private WebElement addToWatchList;
	@FindBy(xpath="//span[text()='Orders']")private WebElement clickOrders;
	@FindBy(xpath="//span[text()='GTT']")private WebElement clickOnOrderGTT;
	@FindBy(xpath="//span[text()='Holdings']")private WebElement clickOnHoldings;
	@FindBy(xpath="//span[text()='Positions']")private WebElement clickOnPosition;
	@FindBy(xpath="//span[text()='Funds']") private WebElement clickOnFunds;
	@FindBy(xpath="//span[text()='Apps']")private WebElement clickOnApp;
	@FindBy(xpath="//span[text()='Dashboard']")private WebElement clickOnDashboard;
	@FindBy(xpath="//button[@data-balloon='Add']")private WebElement clickOnAdd;
	@FindBy (xpath="(//button[@class='button-outline'])[3]")private WebElement clickOndelete;
	@FindBy (xpath="//span[@class='nice-name']")private List<WebElement> addStocklist;
	
	public ZerodhaHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchStock(String stock,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stock);
	}
	
	public int getSearchResultnumber()
	{
		int listSize=searchResult.size();
		return listSize;
	}

	public void searchAndSelectDesiredStock(WebDriver driver ,String RequiredStock)
	{
		for(int a=0; a<searchResult.size();a++ )
		{
			WebElement s=searchResult.get(a);
			String StockName=s.getText();
			if(StockName.equals(RequiredStock))
			{
				Actions action=new Actions(driver);
				action.moveToElement(s);
				action.perform();
				break;
			}
		}
	}
	
	public void ClickOnSearchResultBuy()
	{
		searchBuy.click();
	}
	
	public void ClickOnSell()
	{
		searchSell.click();
	}
	
    public void ClickOnChart(WebDriver driver)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
    	wait.until(ExpectedConditions.visibilityOf(clickOnChart));
    	clickOnChart.click();
    }
    
    public void ClickOnMarketDepth()
    {
    	clickOnMarketDepth.click();
    }
	
    public void ClickOnWatchList(WebDriver driver)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(addToWatchList));
    	addToWatchList.click();
    }
	
	public void ClickOnOrders(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOrders));
		clickOrders.click();
	}
	
	public void ClickOnOrderGTT()
	{
		clickOnOrderGTT.click();
	}
	
	public void ClickOnHolding(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(clickOnHoldings));
				
		clickOnHoldings.click();
	}
	
	public void ClickOnPosition(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOnPosition));
		clickOnPosition.click();
	}
	
	public void ClickOnFunds(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOnFunds));	
		clickOnFunds.click();
	}
	
	public void ClickOnApp(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOnApp));
		clickOnApp.click();
	}
	public void ClickOnDashBoard(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(clickOnDashboard));
		clickOnDashboard.click();
	
	}
	public void ClickOnAddButton()
	{
		clickOnAdd.click();
	}
	public void ClickOndelete(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2500));
		wait.until(ExpectedConditions.visibilityOf(clickOndelete));
		clickOndelete.click();
	}
	
	public void AddStockList(WebDriver driver,String requiredstockname)
	{
		for(int i=0;i<addStocklist.size();i++)
		{
			WebElement stockname=addStocklist.get(i);
			String s=stockname.getText();
			if(s.equals(requiredstockname))
			{
				Actions action=new Actions(driver);
				action.moveToElement(stockname);
				action.perform();
			}
		}
	}
}
