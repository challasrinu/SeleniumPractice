package practise.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest{
	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test start");
		String expectedPage="Home Page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String ActTitle = driver.findElement(By.xpath("//a[contains(.,'Home')]")).getText();
		//Hard Assert
		Assert.assertEquals(ActTitle, expectedPage);
				driver.close();
		System.out.println(mtd.getName()+"Test End");
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test start");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
       boolean status = driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isEnabled();
   	//Hard Assert
  // Assert.assertEquals(true,status);
   Assert.assertTrue(status);
   	driver.close();
	System.out.println(mtd.getName()+"Test start");
	}
	
}
