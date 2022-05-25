package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AppHomePage {

    public AppHomePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.fivemobile.thescore:id/search_bar_text_view")
    private WebElement SearchTextView;

    @AndroidFindBy(id="com.fivemobile.thescore:id/horizontal_recycler_view")
    private WebElement TeamViewDisplayed;

    public void clickOnSearchTextView(){
        SearchTextView.click();
    }

    public boolean verifyTeamViewDisplayed(){
        return TeamViewDisplayed.isDisplayed();
    }
}
