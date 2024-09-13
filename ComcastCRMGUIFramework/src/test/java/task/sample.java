package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.mysql.cj.jdbc.Driver;

public class sample {
@Test
public void sample() throws SQLException {
	WebDriver driver=new ChromeDriver();
    Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	//Step2:Connect to database
	Connection Conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
	//Step3:Create Sql Statement
	Statement state = Conn.createStatement();
	//step4://execute the query
	int result = state.executeUpdate("insert into project values('TS_Proj_123568','venkata','08/28/2024','Facebook_123','On Fire','120');");
	Conn.close();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	driver.get("http://106.51.90.215:8084/");
    driver.findElement(By.id("username")).sendKeys("rmgyantra");
    driver.findElement(By.name("password")).sendKeys("rmgy@9999");
    driver.findElement(By.xpath("//button[@type='submit']")).submit();
    driver.findElement(By.xpath("//a[text()='Projects']")).click();
    List<WebElement> table = driver.findElements(By.xpath("//table/tbody"));
    for (WebElement data : table) {
		String projectname = data.getText();
		System.out.println(projectname);
	}
                                          
}
}

