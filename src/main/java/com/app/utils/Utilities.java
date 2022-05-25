package com.app.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
    public AndroidDriver<AndroidElement> driver;

    public Utilities(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void scrollTo(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }
}
