package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static void TakesScreenshot(WebDriver driver ,String name) throws IOException
	{
		TakesScreenshot sc =((TakesScreenshot)driver);
		String date =Screenshot.dateTime();
		
		File sources=sc.getScreenshotAs(OutputType.FILE);
		
		File destination=new File("C:\\Users\\Vaibhav Salunkhe\\eclipse-workspace\\KiteZerodha\\screenShot\\"+name+""+date+".jpg");
		
		FileHandler.copy(sources, destination);
		
	}
	
	
	public static String dateTime()
	{
	 DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	 
	 LocalDateTime local=LocalDateTime.now();
	 
	   String s= dt.format(local);
	   
	   return s;
	}

}
