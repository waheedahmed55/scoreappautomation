package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    public WelcomePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/btn_primary']")
    private WebElement GetStarted;

    public void clickOnGetStarted(){
        GetStarted.click();
    }

}
