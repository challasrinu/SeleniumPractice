package practice.test;

import java.util.Date;

import org.testng.annotations.Test;

public class CaptureTimeStamp {
@Test
public void timeStamp() {
	String time = new Date().toString().replace(" ","_").replace(":","_");
	System.out.println(time);
}
}
