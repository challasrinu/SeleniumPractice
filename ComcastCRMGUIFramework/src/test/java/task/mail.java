package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class mail {
@Test
public void mail() {
	WebDriver driver=new EdgeDriver();
	driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fhl%3Den%2F&emr=1&hl=en%2F&ifkv=Ab5oB3pa1Bn7tSqbwRYJQF952N9JdxHkOSuQaJ60enstQQYoaKXGV-Un30aVLmp0Iv9ED_ik7QOxcQ&ltmpl=default&ltmplcache=2&osid=1&passive=true&rm=false&scc=1&service=mail&ss=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S118225456%3A1724826095265991&ddm=0");
	driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]")).sendKeys("challasrinivasclass30@gmail.com");
	driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
}
}
