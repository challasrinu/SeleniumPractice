package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
public int getRandonNum() {
	Random random=new Random();
	int randomNumber = random.nextInt(5000);
	return randomNumber;
}
public String getSystemdateYYYYDDMM() {
	Date dateObj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(dateObj);
	return date;
}
public String getRequiredDateYYYYDDMM(int days) {
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	//Calendar cal = sim.getCalendar();
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String reqDate = sim.format(cal.getTime());
	return reqDate;
}
}

