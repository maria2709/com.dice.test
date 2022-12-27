package com.dice.base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test Success");
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test started");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test finished");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult tr) {
        super.onTestFailedWithTimeout(tr);
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName()+" Test Failed");

    }
}
