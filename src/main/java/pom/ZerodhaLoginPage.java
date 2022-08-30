package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {

	
	@FindBy (xpath="//input[@id='userid']")private WebElement userName;
	@FindBy (xpath="//input[@id='password']")private WebElement password;
	@FindBy (xpath="//button[@type='submit']")private WebElement submit;
	@FindBy (xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy (xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;
	@FindBy (xpath="//input[@id='pin']")private WebElement pin;
	@FindBy (xpath="//button[@type='submit']")private WebElement pinsubmit;
	@FindBy (xpath="(//form//label)[1]")private WebElement radioButtonrememberuserID;
	@FindBy (xpath="(//form//label)[2]")private WebElement radioButtonforgotmyuserID;
	@FindBy (xpath="//label[contains(text(),'SMS')]")private WebElement radioButtonSMS;
	@FindBy (xpath="//input[@placeholder='User ID']")private WebElement forgotonUserID;
	@FindBy (xpath="//input[@placeholder='PAN']")private WebElement forgotPAN;
	@FindBy (xpath="(//form//label)[5]")private WebElement  RadioButtonEmail;
	@FindBy (xpath="//input[@placeholder='Mobile number (as on account)']")private WebElement Mobileno;
	@FindBy (xpath="//input[@placeholder='E-mail (as on account)']")private WebElement Emailid;
	@FindBy (xpath="//input[@placeholder='Captcha']")private WebElement captch;
	@FindBy (xpath="//button[@type='submit']")private WebElement reset;
	@FindBy (xpath="//a[@class='text-xsmall text-light reset-account-button']")private WebElement backToLogin;
	
	
	public ZerodhaLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name)
	{
		userName.sendKeys(name);
	}
	
	public void enterPassWord(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	
	public void clickOnForgot()
	{
		forgot.click();
	}
	
	public void clickOnSignup()
	{
		signUp.click();
	}
	
	public void enterPin(String pincode,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait( driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pincode);
	}
	
	public void clickOnContinue()
	{
		pinsubmit.click();
	}
	
	public void clickrememberuserID()
	{
		radioButtonrememberuserID.click();
	}
	
	public void clickOnforgotmyuserID()
	{
		radioButtonforgotmyuserID.click();
	}
	
	public void clickSMS()
	{
		radioButtonSMS.click();
	}
	
	public void EnterUserID(String userid)
	{
		forgotonUserID.sendKeys(userid);
	}
	
	public void EnterPAN(String pan)
	{
	   forgotPAN.sendKeys(pan);
	}

	
	public void ClickOnRadioButtonEmail()
	{
		RadioButtonEmail.click();
	}
	
	
	public void EnterMobileno(String mobile)
	{
		Mobileno.sendKeys(mobile);
	}
	
	public void EnterEmailID(String email)
	{
		Emailid.sendKeys(email);
	}
	
	
	public void EnterCaptcha(String cap)
	{
		captch.sendKeys(cap);
	}
	
	public void backToLogin()
	{
		backToLogin.click();
	}
	
	
	public void swithToSignupPage(WebDriver driver)
	{
		Set<String>handle=driver.getWindowHandles();
		
		Iterator<String>i=handle.iterator();
		
		while(i.hasNext())
		{
			String Popups=i.next();
			driver.switchTo().window(Popups);
			String Title=driver.getTitle();
			
			if(Title.equals("Signup and open a Zerodha trading and demat account online and start investing – Zerodha"))
			{
				WebElement add=driver.findElement(By.xpath("(//a[text()='About'])[1]"));
				add.click();
			}
		}
	}
	
}
