package Automation.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/**
 * This is class is provide Implementation to ITestListenser Interface TestNG
 * @author Ramya Venugopal
 *
 */

public class ListenerImplementaions implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
String methodName=result.getMethod().getMethodName();
     test=report.createTest(methodName);
	test.log(Status.INFO,"....>" +methodName+ " execution started<....");
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS,"....>"+methodName+" Test passed<....");	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, "-> "+methodName+" - Test is Failed <-");
		test.log(Status.WARNING, result.getThrowable());
		
		
		String screenshotName=methodName+"-"+ new JavaUtility().getSystemDateinFormat();
		
		WebDriverUtility wUtil=new WebDriverUtility();
		try {
			wUtil.takeScreenShot(BaseClass.sDriver,screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,"....>"+methodName+" Test Skipped<....");
		test.log(Status.WARNING,result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	 ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExternalReport\\Reports" + new JavaUtility().getSystemDateinFormat()+".html");
	htmlreport.config().setDocumentTitle("vTiger Execution Report");	
	htmlreport.config().setReportName("Automation");
	
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("Base browser","Chrome");
	report.setSystemInfo("Base Platform", "Windows 10");
	report.setSystemInfo("Reporter Name", "Ramya V");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(".....>suit execution finished<.....");
		
		/* extend report should be generated */
		report.flush();	
	}
	
 
}
