package com.app.base;

import com.app.base.BaseDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

        public void onTestStart(ITestResult result) {
            System.out.println("Test Started");
        }

        public void onTestSuccess(ITestResult result) {
            System.out.println("Test Passed");
        }

        public void onTestFailure(ITestResult result) {
            System.out.println("Test Failed");
            String name = result.getName();
            try {
                BaseDriver.getScreenshot(name);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public void onTestSkipped(ITestResult result) {
            System.out.println("Test Skipped");
        }

        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            System.out.println("Test Failed but within success percentage");
        }

        public void onStart(ITestContext context) {
            System.out.println("Test Started");
        }

        public void onFinish(ITestContext context) {
            System.out.println("Test Finished");
        }

}
