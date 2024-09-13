package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRuntimemavenParameterTest {
	@Test
	public void runtimeparameterTest() {
		String URL=System.getProperty("url");
		String BROWSER =System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		System.out.println("Env Data==>URL==>"+URL);
		System.out.println("Browser Data==>==>"+BROWSER);
		System.out.println("username Data==>==>"+USERNAME);
		System.out.println("Password Data==>==>"+PASSWORD);
	}
}
