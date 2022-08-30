package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {
	
	public static WebDriver chromeBrowser()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vaibhav Salunkhe\\Documents\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.navigate().to("https://kite.zerodha.com/");
		
		return driver;
				
	}

}
