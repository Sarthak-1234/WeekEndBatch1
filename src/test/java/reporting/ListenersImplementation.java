package reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import initiateTests.initClass;
import pages.RedBusHomePage;

public class ListenersImplementation implements ITestListener{
	//private static final Logger LOGGER = LoggerFactory.getLogger(ListenersImplementation.class);

	@Override
	public void onTestStart(ITestResult result) {
		
		//System.out.println(result.getName() +" TestCase started");
		
		
		ReportingClass.initReports(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println(result.getName() +"TestCase Success");
		
		ReportingClass.infoLogPass("---------------------> Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println(result.getName() +"TestCase Failure");
		
		
		try {
			ReportingClass.reportFailure("--------------------> Fail", initClass.driver);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//System.out.println(result.getName() +"TestCase Skipped");
		
		ReportingClass.infoLogSkip("--------------------------------> Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
