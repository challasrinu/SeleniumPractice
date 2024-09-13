package practice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SampleTestWithPOM {
@FindBy(name="user_name")
WebElement ele1;
@FindBy(name="user_password")
WebElement ele2;
@FindAll({@FindBy(id="suutton"),@FindBy(xpath="//input[@type='submit']")})
private WebElement ele3;
 @Test
 public void sampleTest() {
	 
	 WebDriver driver=new ChromeDriver();
	 SampleTestWithPOM s = PageFactory.initElements(driver,SampleTestWithPOM.class);
	 driver.get("http://localhost:8888");
	 
	 s.ele1.sendKeys("admin");
	 s.ele2.sendKeys("admin");
	 s.ele3.click();
 }
}
