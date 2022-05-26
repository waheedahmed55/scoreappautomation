package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TeamHomePage {

    public TeamHomePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.fivemobile.thescore:id/team_name")
    private WebElement TeamNameDisplayed;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Team Stats']")
    private WebElement TeamStatsTab;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/header_text")
    private WebElement TeamStatsHeaderText;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/txt_name")
    private WebElement TeamSearchSelect;

    public void clickOnTeamStatsTab(){
        TeamStatsTab.click();
    }

    public boolean isTeamNameDisplayed(){
        return TeamNameDisplayed.isDisplayed();
    }

    public boolean isTeamStatsHeaderTextDisplayed(){
        return TeamStatsHeaderText.isDisplayed();
    }

    public void clickOnTeamSearchSelect(){
        TeamSearchSelect.click();
    }

}
