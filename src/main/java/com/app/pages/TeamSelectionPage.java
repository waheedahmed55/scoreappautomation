package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TeamSelectionPage {

    public TeamSelectionPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.fivemobile.thescore:id/search_bar_placeholder")
    private WebElement TeamSearchBox;

    @AndroidFindBy(id="com.fivemobile.thescore:id/action_button_text")
    private WebElement TeamSelectContinue;

    public void clickOnTeamSearchBox(){
        TeamSearchBox.click();
    }

    public void clickOnTeamSelectContinue(){
        TeamSelectContinue.click();
    }

}
