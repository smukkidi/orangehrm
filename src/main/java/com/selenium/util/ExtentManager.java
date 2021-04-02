package com.selenium.util;


import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports createInstance() {
		
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/HRMExtentReports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		
	//	htmlReporter = new ExtentHtmlReporter("Reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("HRM Automation Reports");
		htmlReporter.config().setReportName("HRM Test Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.setSystemInfo("Executed on Environment: ","HRM");
		extent.setSystemInfo("Executed on Browser: ", "Chrome");
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		extent.attachReporter(htmlReporter);
		
		return extent;
		
	}
	
	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_")+".html";
		
		return fileName;
	}
	
}
