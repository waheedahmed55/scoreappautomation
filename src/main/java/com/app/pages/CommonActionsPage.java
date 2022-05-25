package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonActionsPage {

    public CommonActionsPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
    private WebElement NavigateBack;

    @AndroidFindBy(id="com.fivemobile.thescore:id/search_src_text")
    private WebElement SearchBoxText;

    @AndroidFindBy(id="com.fivemobile.thescore:id/btn_primary")
    private WebElement SelectionDone;

    @AndroidFindBy(xpath="//android.view.ViewGroup")
    private WebElement TeamSelect;


    public void clickOnNavigateBack(){
        NavigateBack.click();
    }

    public void typeInSearchBoxText(String text){
        SearchBoxText.sendKeys(text);
    }

    public void clickOnSelectionDone(){
        SelectionDone.click();
    }

    public void clickOnTeamSelect(){
        TeamSelect.click();
    }
}
