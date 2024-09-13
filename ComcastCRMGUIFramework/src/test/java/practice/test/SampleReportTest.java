package practice.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
@Test
public void createContactTest() {
	//Spark report config
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
	spark.config().setDocumentTitle("CRM Test Suite Results");
	spark.config().setReporter(spark);
	spark.config().setTheme(Theme.DARK);
	
	//add Env information & create test
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","windows-11");
	report.setSystemInfo("BROWSER","CHROME-100");
	ExtentTest test = report.createTest("createContactTest");
	
	test.log(Status.INFO,"Login to App");
	test.log(Status.INFO,"Navigate to Contact Page");
	test.log(Status.INFO,"Create contact");
    if("HDFC".equals("HDFC")) {
    	test.log(Status.PASS,"contact is created");
    }else {
    	test.log(Status.FAIL,"contact is not created");
    }
    report.flush();
}
}
