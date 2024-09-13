package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
@Test
public void amazonTest() throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://amazon.com");
	//Step1:create an object to EventFiring webdriver
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	//Step2:Use getScreenShotAs method to get file type of screenshot
	File srcFile = edriver.getScreenshotAs(OutputType.FILE);
	//step3:store screen on local driver

	FileUtils.copyFile(srcFile,new File("./screenshot/test.png"));
	
	
}
}
