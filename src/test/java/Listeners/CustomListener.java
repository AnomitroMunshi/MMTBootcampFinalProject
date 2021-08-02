package Listeners;

import Utils.Screenshot;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    Logger logger= LogManager.getLogger(CustomListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        String testcaseName=result.getName();
        MDC.put("testcaseName","TC:"+result.getName());
        logger.info("Strating testcase:"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.info("Testcase failed:: "+result.getName());
        Screenshot.capture(result.getName()+"FAILED");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Testcase executed successfully:: "+result.getName());
    }
}
