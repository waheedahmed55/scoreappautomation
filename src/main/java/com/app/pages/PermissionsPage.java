package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PermissionsPage {
    public PermissionsPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.fivemobile.thescore:id/btn_allow")
    private WebElement AllowLocation;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement AllowWhileUsingApp;

    public void clickOnAllowLocation(){
        AllowLocation.click();
    }

    public void clickOnAllowWhileUsingApp(){
        AllowWhileUsingApp.click();
    }
}
